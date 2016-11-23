package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 机构信息查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topBank")
public class BankController {
	private static Logger logger = LoggerFactory
			.getLogger(BankController.class);
	
	@RequestMapping("/turnToBankInfo.do")
	public String turnToDotReportInfo() {
		logger.info("跳转到机构信息查询页面");
		return "query/bankingInfo";
	}
}