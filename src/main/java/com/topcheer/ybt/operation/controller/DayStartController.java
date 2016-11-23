package com.topcheer.ybt.operation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 开启日初
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topDayStart")
public class DayStartController {
	private static Logger logger = LoggerFactory
			.getLogger(DayStartController.class);
	
	@RequestMapping("/turnToDayStartInfo.do")
	public String turnToDayStartInfo() {
		logger.info("跳转到开启日初页面");
		return "operation/dayStartInfo";
	}
}