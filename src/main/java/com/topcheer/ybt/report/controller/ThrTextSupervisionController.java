package com.topcheer.ybt.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 三号文监管报表
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topThrTextSupervision")
public class ThrTextSupervisionController {
	private static Logger logger = LoggerFactory
			.getLogger(ThrTextSupervisionController.class);
	
	@RequestMapping("/turnToThrTextSupervisionInfo.do")
	public String turnToThrTextSupervisionInfo() {
		logger.info("跳转到三号文监管报表页面");
		return "report/thrTextSupervisionInfo";
	}
}
