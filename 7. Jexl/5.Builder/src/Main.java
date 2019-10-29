import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.introspection.JexlSandbox;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JexlSandbox sb = new JexlSandbox();

		sb.black("Foo"); // Will make class foo cannot execute in this engine

		Log log = LogFactory.getLog(Main.class);

		JexlEngine engine = new JexlBuilder().logger(log).sandbox(sb).cache(10).cacheThreshold(100).create();

		Foo foo = new Foo();

		try {
			engine.invokeMethod(foo, "bar", null);
		} catch (Exception e) {
			System.out.println("Engine Failed to Invoke Method >> " + engine.createInfo());
			// TODO: handle exception
		}
	}

}
