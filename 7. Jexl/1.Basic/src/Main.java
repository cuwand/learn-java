import org.apache.commons.jexl3.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Object Access / Function Call");
		// Create or retrieve an engine
		JexlEngine jexl = new JexlBuilder().create();

		// Create an expression
		String jexlExp = "foo.innerFoo.bar()";
		JexlExpression e = jexl.createExpression(jexlExp);

		// Create a context and add data
		JexlContext jc = new MapContext();
		jc.set("foo", new Foo());

		Foo foo = new Foo();
		foo.innerFoo.bar();

		// Now evaluate the expression, getting the result
		Object o = e.evaluate(jc);
	}
}
