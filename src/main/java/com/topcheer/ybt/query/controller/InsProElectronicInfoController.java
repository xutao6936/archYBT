package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 保险产品电子资料
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topInsProElectronicInfo")
public class InsProElectronicInfoController {
	private static Logger logger = LoggerFactory
			.getLogger(InsProElectronicInfoController.class);
	
	@RequestMapping("/turnToInsProElectronicInfo.do")
	public String turnToInsProElectronicInfo() {
		logger.info("跳转到保险产品电子资料页面");
		return "query/insProElectronicInfo";
	}
}