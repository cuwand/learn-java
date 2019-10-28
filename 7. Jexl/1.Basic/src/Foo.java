
public class Foo {
	public class InnerFoo {
		public void bar() {
			System.out.println("Inner Bar is called");
		}
	}

	public InnerFoo innerFoo = new InnerFoo();

	public void bar() {
		System.out.println("Bar is called");
	}
}
