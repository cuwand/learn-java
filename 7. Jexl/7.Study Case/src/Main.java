import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.JxltEngine;
import org.apache.commons.jexl3.JxltEngine.Expression;
import org.apache.commons.jexl3.MapContext;

public class Main {
	public static final int Threshold = 30;
	public static final int DebitThreshold = 5000000;
	public static final String LegitimateRule = " else {\n LEGITIMATE \n$$}";

	public static final String SalaryThresholdFunctions = "$$ var st = function (s, t) {s * t}\n";
	public static final String PercentageFunctions = "$$ var pt = function (v) { v/100 }\n";
	// public static final String FalsePercentageFunctions = "$$ var pt = function
	// (v) { v/100000 }\n"; akan ke replace

	public static String extendRules(String rule1, String rule2) {
		rule2 = rule2.replaceFirst("(\\$\\$)", " else ");
		return rule1 + rule2;
	}

	// call from DB or ETC
	public static String generateFunctions() {
		return SalaryThresholdFunctions + PercentageFunctions;
	}

	public static void main(String[] args) {
		// Create or retrieve an engine
		JexlEngine jexl = new JexlBuilder().create();

		// No DEBIT activity at all, however REFLECTING-SALARY
		JexlContext.NamespaceFunctor nf = new JexlContext.NamespaceFunctor() {
			@Override
			public Object createFunctor(JexlContext arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		String salaryCondition = "loan > pt(st(salary, threshold))";
		String SalaryRules = generateFunctions() + "$$ if (" + salaryCondition + ") {\n SUSPICIOUS \n $$ }"
				+ "else {\n LEGITIMATE \n $$}";

		String NoDebitRules = "$$ if (debitActivity == 0) {\n" + SalaryRules + "\n$$ }";

		JxltEngine.Template t = jexl.createJxltEngine().createTemplate(NoDebitRules);

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

		// Low DEBIT activity in the account, however REFLECTING-SALARY. *may need to
		// consider what is the threshold for low DEBIT activity.
		String LowDebitRules = "$$ if (debitActivity < " + DebitThreshold + ") {\n" + SalaryRules + "\n$$ }";

		String extendedRules = extendRules(NoDebitRules, LowDebitRules) + LegitimateRule;
		t = jexl.createJxltEngine().createTemplate(extendedRules);

		for (List<String> var : t.getVariables()) {
			System.out.println(var);
		}
		System.out.println("------------------------------------------------------------------------------");
		try {
			writer = new PrintWriter(System.out);
			JexlContext jc = new MapContext();

			// Hit API or Something
			jc.set("debitActivity", 4000000);
			jc.set("loan", 1000000);
			jc.set("salary", 1500000);
			jc.set("threshold", Threshold);

			t.evaluate(jc, writer);
			writer.flush();

			JexlContext legitimateCase = new MapContext();

			// Hit API or Something
			legitimateCase.set("debitActivity", 4000000);
			legitimateCase.set("loan", 1000000);
			legitimateCase.set("salary", 15000000);
			legitimateCase.set("threshold", Threshold);

			t.evaluate(legitimateCase, writer);
			writer.flush();

			// Hit API or Something
			legitimateCase.set("debitActivity", 8000000);
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
