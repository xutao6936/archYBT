package com.topcheer.ybt.operation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 开启日终
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topDayEnd")
public class DayEndController {
	private static Logger logger = LoggerFactory
			.getLogger(DayEndController.class);
	
	@RequestMapping("/turnToDayEndInfo.do")
	public String turnToDayEndInfo() {
		logger.info("跳转到开启日终页面");
		return "operation/dayEndInfo";
	}
}