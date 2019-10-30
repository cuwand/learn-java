import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JxltEngine;
import org.apache.commons.jexl3.MapContext;

public class Main {

	public static final int Threshold = 30;
	public static final int DebitThreshold = 5000000;

	public static final String SalaryThresholdFunctions = "$$ var st = function (s, t) { return s * t;}\n";
	public static final String PercentageFunctions = "$$ var pt = function (v) { return v/100; }\n";

	// call from DB or ETC
	public static String generateFunctions() {
		return SalaryThresholdFunctions + PercentageFunctions;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String salaryCondition = "loan > pt(st(salary, threshold))";
		String SalaryRules = "if (" + salaryCondition + ") {return true;} else {return false;}";

		String SalaryRulesAsFunction = "$$ var sr = function (salary, threshold) {" + SalaryRules + "}\n";

		String template = SalaryRulesAsFunction + "${sr(salary, threshold)}\n";

		JexlEngine jexl = new JexlBuilder().create();
		JxltEngine.Template t = jexl.createJxltEngine().createTemplate(generateFunctions() + template);

		Writer writer = null;
		try {
			writer = new PrintWriter(System.out);
			JexlContext jc = new MapContext();

			// Hit API or Something
			jc.set("debitActivity", 0);
			jc.set("loan", 1000000);
			jc.set("salary", 1500000);
			jc.set("threshold", Threshold);

			t.evaluate(jc, writer);
			writer.flush();

			JexlContext legitimateCase = new MapContext();

			// Hit API or Something
			legitimateCase.set("debitActivity", 0);
			legitimateCase.set("loan", 1000000);
			legitimateCase.set("salary", 15000000);
			legitimateCase.set("threshold", Threshold);

			t.evaluate(legitimateCase, writer);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
