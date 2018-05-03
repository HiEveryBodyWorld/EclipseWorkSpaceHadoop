package com.darren.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{

	public Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}

	
	
	public Object getInstance(){
		//工具类
		Enhancer en = new Enhancer();
		//设置父类
		en.setSuperclass(target.getClass());
		//设置回调函数
		en.setCallback(this);
		//创建子类
		return en.create();
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 *
	 *Oject 为由cglib动态生成的代理类实例，Method为上文中实体类所调用的被代理的方法引用，Object[]为参数列表 MethodProxy为生成的代理类对方法的代理引用。
	 */

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("开始事务....");
		
		//执行目标方法
		Object returnValue = method.invoke(target, args);
		
		System.out.println("提交事务....");
		return returnValue;
	}
	
}
