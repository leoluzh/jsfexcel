package org.jboss.jsf.excel.util;

import java.lang.annotation.Annotation;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CdiUtil {

	private CdiUtil() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T getObject(String name, Class<T> clazz) {
		final BeanManager beanManager = getBeanManager();
		final Bean<?> bean = beanManager.getBeans(name).iterator().next();  // 1-elementiges Set<Bean<?>>
		final CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, bean.getClass(), ctx);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String name) {
		final BeanManager beanManager = getBeanManager();
		final Bean<?> bean = beanManager.getBeans(name).iterator().next();  // 1-elementiges Set<Bean<?>>
		final CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, bean.getClass(), ctx);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class clazz) {
		final BeanManager beanManager = getBeanManager();
		final Bean<?> bean = beanManager.getBeans(clazz).iterator().next();  // 1-elementiges Set<Bean<?>>
		final CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, bean.getClass(), ctx);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class clazz , Annotation annotation) {
		final BeanManager beanManager = getBeanManager();
		final Bean<?> bean = beanManager.getBeans(clazz,annotation).iterator().next();  // 1-elementiges Set<Bean<?>>
		final CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, bean.getClass(), ctx);
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getSingleton(Class<T> clazz) {
		final BeanManager beanManager = getBeanManager();
		final Bean<?> bean = beanManager.getBeans(clazz).iterator().next();  // 1-elementiges Set<Bean<?>>
		final CreationalContext<?> ctx = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, bean.getClass(), ctx);
	}
	
	private static BeanManager getBeanManager() {
		// BeanManager aus JNDI ermitteln
		Context jndiCtx = null;
		BeanManager beanManager = null;
		try {
			jndiCtx = new InitialContext();
			beanManager = (BeanManager) jndiCtx.lookup("java:comp/BeanManager");
		}
		catch (NamingException e) {
			;
		}
		finally {
			if (jndiCtx != null) {
				try {
					jndiCtx.close();
				}
				catch (NamingException e) {
				}
			}
		}
		
		return beanManager;
	}	
	
	
}
