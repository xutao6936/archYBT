package com.topcheer.ybt.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHelper implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHelper.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(Class T) {
//		String[] profiles = applicationContext.getEnvironment().getDefaultProfiles();
		
		return applicationContext.getBean(T);
	}
	
	public static Object getBean(String t){
		return applicationContext.getBean(t);
	}
}
