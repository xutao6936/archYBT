package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 投保报错查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topInsuredExcep")
public class InsuredExcepController {
	private static Logger logger = LoggerFactory
			.getLogger(InsuredExcepController.class);
	
	@RequestMapping("/turnToInsuredExcepInfo.do")
	public String turnToInsuredExcepInfo() {
		logger.info("跳转到投保报错查询页面");
		return "query/insuredExcepInfo";
	}
}
