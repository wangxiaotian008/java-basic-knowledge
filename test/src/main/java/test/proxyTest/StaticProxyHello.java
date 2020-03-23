package test.proxyTest;

/**
 * 静态代理类，一个代理类只能代理一个，把需要代理的对象放到代理类里。
 * @author wangjq
 *
 */
public class StaticProxyHello implements Hello {

	public Hello helloImpl;
	
	public StaticProxyHello(Hello helloImpl) {
		super();
		this.helloImpl = helloImpl;
	}
	
	public void before(){
		System.out.println("被代理对象方法执行前");
	}

	@Override
	public void say() {
		before();
		helloImpl.say();
		after();
	}
	
	public void after(){
		System.out.println("被代理对象方法执行后");
	}

	@Override
	public void goodbye() {
		System.out.println("static good bye");
		
	}

}
