package com.topcheer.ybt.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 出单费统计报表
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topSingleFeeReport")
public class SingleFeeReportController {
	private static Logger logger = LoggerFactory
			.getLogger(SingleFeeReportController.class);
	
	@RequestMapping("/turnToSingleFeeReportInfo.do")
	public String turnToSingleFeeReportInfo() {
		logger.info("跳转到网点销售台账页面");
		return "report/singleFeeReportInfo";
	}
}