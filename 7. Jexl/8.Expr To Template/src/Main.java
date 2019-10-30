import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JxltEngine;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.JxltEngine.Expression;

public class Main {

	public static void main(String[] args) {

		JexlEngine jexl = new JexlBuilder().create();
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------");
		String storedExpression = "$$ for(var cell : ${var1}) {\n ${cell} \n$$}";

		JxltEngine jexlExpression = jexl.createJxltEngine();

		// TODO Auto-generated method stub
		JexlContext jc = new MapContext();
		jc.set("var1", "cells");

		Expression exp = jexlExpression.createExpression(storedExpression);

		for (List<String> var : exp.getVariables()) {
			String expectedVariable = var.get(0);
			System.out.println("expectedVariable >> " + expectedVariable);
			if (!jc.has(expectedVariable)) {
				jc.set(expectedVariable, "${" + expectedVariable + "}");
			}
		}
		String template = (String) jexlExpression.createExpression(storedExpression).evaluate(jc);
		System.out.println(template);
		JxltEngine.Template t1 = jexl.createJxltEngine().createTemplate(template);

		Writer writer1 = null;
		try {
			JexlContext njc = new MapContext();
			// set variable from rules

			String[] ss = { "Adrian", "Eka" };
			njc.set("cells", ss);
			writer1 = new PrintWriter(System.out);
			t1.evaluate(njc, writer1);
			writer1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
