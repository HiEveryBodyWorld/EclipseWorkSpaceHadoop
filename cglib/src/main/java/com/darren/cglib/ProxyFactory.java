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
		//������
		Enhancer en = new Enhancer();
		//���ø���
		en.setSuperclass(target.getClass());
		//���ûص�����
		en.setCallback(this);
		//��������
		return en.create();
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 *
	 *Oject Ϊ��cglib��̬���ɵĴ�����ʵ����MethodΪ������ʵ���������õı�����ķ������ã�Object[]Ϊ�����б� MethodProxyΪ���ɵĴ�����Է����Ĵ������á�
	 */

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("��ʼ����....");
		
		//ִ��Ŀ�귽��
		Object returnValue = method.invoke(target, args);
		
		System.out.println("�ύ����....");
		return returnValue;
	}
	
}
