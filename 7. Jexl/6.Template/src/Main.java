import java.io.*;
import java.util.List;

import org.apache.commons.jexl3.*;

public class Main {
	public static void main(String[] args) {
		// Create or retrieve an engine
		JexlEngine jexl = new JexlBuilder().create();

		// Create an expression
		String jexlExp = " $$ for(var x : [1, 3, 5, 42, 169]) {\n" + 
				" $$   if (x == 42) {\n" + 
				" Life, the universe, and everything\n" + 
				" $$   } else if (x > 42) {\n" + 
				" The value ${x} is over fourty-two\n" + 
				" $$   } else {\n" + 
				" The value ${x} is under fourty-two\n"
				+ " $$   }\n"
				+ " $$ }";
		JxltEngine.Template t = jexl.createJxltEngine().createTemplate(jexlExp);

		Writer writer = null;
		try {
			writer = new PrintWriter(System.out);
			t.evaluate(null, writer);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create an expression
		String jexlExp1 = " $$ for(var cell : cells) { $jexl.print(cell); $jexl.println(';') }";
		String[] ss = { "AS", "AS" };
		JxltEngine.Template t1 = jexl.createJxltEngine().createTemplate(jexlExp1);

		Writer writer1 = null;
		try {
			JexlContext jc = new MapContext();
			jc.set("cells", ss);
			writer1 = new PrintWriter(System.out);
			t1.evaluate(jc, writer1);
			writer1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expr = "${EXPECTED_VAR}";
		
		JxltEngine.Template t2 = jexl.createJxltEngine().createTemplate(expr);
		for (List<String> var : t2.getVariables()) {
			System.out.println(var);
		}
		Writer writer2 = null;
		try {
			JexlContext jc = new MapContext();
			jc.set("EXPECTED_VAR", "EXPECTED_VAR is Set");
			writer2 = new PrintWriter(System.out);
			t2.evaluate(jc, writer2);
			writer2.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}