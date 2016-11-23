package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网点报表查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topDotReport")
public class DotReportController {
	private static Logger logger = LoggerFactory
			.getLogger(DotReportController.class);
	
	@RequestMapping("/turnToDotReportInfo.do")
	public String turnToDotReportInfo() {
		logger.info("跳转到网点报表查询页面");
		return "query/dotReportInfo";
	}
}