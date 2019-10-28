import org.apache.commons.jexl3.*;

public class Main {

	public static void main(String[] args) {

		JexlEngine engine = new JexlBuilder().create();
		String expression = "Hello, ${SOME_VAR}!\nMy name is ${person.name}."
				+ " I used to live in ${person.address.building} and then now "
				+ "${person.address.setBuilding(33234)}, I live in "
				+ "${person.address.building}, ${person.address.street}";
		expression += "\n${person.age >= 21 ? 'Person is adult':"
				+ "'You are minor, the person age is ' + person.age}";
		JxltEngine jexlExpression = engine.createJxltEngine();

		// Create a context and add data
		JexlContext context = new MapContext();
		Person somePerson = new Person("123", "Adrian", new Address("Slipi", "Jakarta", 6), 12);
		context.set("SOME_VAR", "Jexl Video Demo");
		context.set("person", somePerson);

		Object value = jexlExpression.createExpression(expression).evaluate(context);
		System.out.println(value);
	}

}
