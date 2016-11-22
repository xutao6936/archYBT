package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 营销人员绩效查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topMarketerPerformance")
public class MarketerPerformanceController {
	private static Logger logger = LoggerFactory
			.getLogger(MarketerPerformanceController.class);
	
	@RequestMapping("/turnToMarketerPerformanceInfo.do")
	public String turnToMarketerPerformanceInfo() {
		logger.info("跳转到营销人员绩效查询页面");
		return "query/marketerPerformanceInfo";
	}
}