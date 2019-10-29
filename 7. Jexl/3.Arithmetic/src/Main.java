import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jexl3.*;
import org.apache.commons.jexl3.JxltEngine.Expression;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JexlEngine jexl = new JexlBuilder().create();
		JexlExpression func = jexl.createExpression("x1+x2");
		MapContext mc = new MapContext();
		mc.set("x1", 2);
		mc.set("x2", 1);
		System.out.println(func.evaluate(mc)); // prints "3" - GOOD ANSWER!

		JexlArithmetic ja = new JexlArithmetic(true);
		System.out.println(ja.add("x1", "x2"));
		System.out.println(ja.add(9, 10));
		System.out.println(ja.and(9, 10));
		// 9 = 1001
		// 10 = 1010
		// ---- AND
		// 1000 = 8

		JexlArithmetic.ArrayBuilder jexlArray = ja.arrayBuilder(3);

		System.out.println(jexlArray);
		jexlArray.add(10);
		jexlArray.add(20);
		//jexlArray.add("AS"); // run time error while accessing variable
		System.out.println(jexlArray.create(true));
		System.out.println(jexlArray.create(false));

		Object temp = jexlArray.create(true);
		List<Integer> li = new ArrayList<Integer>();
		li = (List<Integer>) temp;

		for (Integer i : li) {
			try {
				System.out.println(i);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		JexlArithmetic.MapBuilder jexlMap = ja.mapBuilder(3);
		jexlMap.put("a", "b");
		System.out.println(jexlMap.create());
		System.out.println("Done");
	}

}
