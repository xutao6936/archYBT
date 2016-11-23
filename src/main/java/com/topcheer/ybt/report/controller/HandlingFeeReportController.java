package com.topcheer.ybt.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 手续费统计报表
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topHandlingFeeReport")
public class HandlingFeeReportController {
	private static Logger logger = LoggerFactory
			.getLogger(HandlingFeeReportController.class);
	
	@RequestMapping("/turnToHandlingFeeReportInfo.do")
	public String turnToHandlingFeeReportInfo() {
		logger.info("跳转到手续费统计报表页面");
		return "report/handlingFeeReportInfo";
	}
}