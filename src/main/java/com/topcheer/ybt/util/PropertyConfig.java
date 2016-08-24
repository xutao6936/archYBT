package com.topcheer.ybt.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/** 
* @ClassName: PropertyConfig 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author XUTAO 
* @date 2016-3-15 下午06:59:29 
*  
*/
public class PropertyConfig extends PropertyPlaceholderConfigurer{
	
	public static Map<String,String> properties =  new HashMap<String,String>();

	 @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,  
	            Properties props)throws BeansException {
		 super.processProperties(beanFactory, props);
		 for(Object pro:props.keySet()){
			 properties.put(pro.toString().trim(), props.getProperty(pro.toString().trim()));
		 }
	 }
	 
	 public static String getContextProperty(String key){
		 return properties.get(key);
	 }
	 
	
	

}
