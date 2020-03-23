package test.CGlibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyImpl implements MethodInterceptor {

	private static CglibProxyImpl cglibProxyImpl = new CglibProxyImpl();
	
	private CglibProxyImpl(){
		
	}
	public static CglibProxyImpl getInstance(){
		return cglibProxyImpl;
	}
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		before("a");
		Object obj = arg3.invokeSuper(arg0, arg2);
		after("b");
		return obj;
	}

	public void before(String str){
		System.out.println("cglib动态代理-----前" + str);
	}

	public void after(String str){
		System.out.println("cglib动态代理-----后");
	}
}
