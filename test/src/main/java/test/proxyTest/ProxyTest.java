package test.proxyTest;

import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import test.CGlibProxy.CglibHello;
import test.CGlibProxy.CglibProxyImpl;

public class ProxyTest {

	public static void main(String[] args) {
		Hello hello = new HelloImpl();
//		StaticProxyHello staticProxyHello = new StaticProxyHello(hello);
//		// 代理对象代理原对象执行。
//		staticProxyHello.say();
		
		// 被代理对象的包装类
		DynamicProxy dynamicProxy= new DynamicProxy(hello);
		// 生成代理对象
		Hello helloProxy = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);
		helloProxy.say();
		helloProxy.goodbye();
//		System.out.println("cglib 动态代理\br");
//		CglibProxyImpl cglibProxyImpl = CglibProxyImpl.getInstance();
//		CglibHello c = cglibProxyImpl.getProxy(CglibHello.class);
//		c.cglibSay();
	}

}
