package test.proxyTest;

public class HelloImpl implements Hello {

	@Override
	public void say() {
		System.out.println("Hello Proxy");

	}

	@Override
	public void goodbye() {
		System.out.println("good bye");
	}

}
