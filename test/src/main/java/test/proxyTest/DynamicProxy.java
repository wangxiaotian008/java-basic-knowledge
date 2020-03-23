package test.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现接口的代理类
 * @author wangjq
 *
 */
public class DynamicProxy implements InvocationHandler {

	// 被代理的对象
	public Object object;
	
	public DynamicProxy(Object object) {
		super();
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object o =method.invoke(object, args);
		after();
		return o;
	}

	public void before(){
		System.out.println("被代理对象方法执行前-动态");
	}

	public void after(){
		System.out.println("被代理对象方法执行后-动态");
	}
}
