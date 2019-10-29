import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlInfo;
import org.apache.commons.jexl3.JxltEngine;
import org.apache.commons.jexl3.MapContext;

public class Main {

	public static void main(String[] args) {
		JexlEngine engine = new JexlBuilder().create();
		String expression = "Hello, Adrian ${SOME_VAR}!";
		JxltEngine jexlExpression = engine.createJxltEngine();

		// TODO Auto-generated method stub
		JexlContext jc = new MapContext();
		jc.set("SOME_VAR", "Jexl Video Demo");
		jc.set("UNUSED_VAR", "UNUSED_VAR");

		if (jc.has("SOME_VAR")) {
			System.out.println(jexlExpression.createExpression(expression).evaluate(jc));
		}

		System.out.println(jc.get("UNUSED_VAR"));

		Foo foo = new Foo();

		engine.invokeMethod(foo, "bar", null);
	}

}
