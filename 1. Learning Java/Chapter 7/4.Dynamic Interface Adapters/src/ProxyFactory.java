import java.lang.reflect.Proxy;

public class ProxyFactory {
	public static Object newInstance(Object ob) {
		System.out.println("Class Loader : " + ob.getClass().getClassLoader());
		System.out.println("Implemented Interface : ");
		Class[] interfaces = ob.getClass().getInterfaces();
		for (Class iface : interfaces) {
			System.out.println("-> " + iface.getName());
		}
		System.out.println("-------------Preparing Porxy--------------");
		return Proxy.newProxyInstance(ob.getClass().getClassLoader(), ob.getClass().getInterfaces(),
		    new MyInvocationHandler(ob));
	}
}