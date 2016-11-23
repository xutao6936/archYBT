package com.topcheer.ybt.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网点销售台账
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topSalesledger")
public class SalesLedgerController {
	private static Logger logger = LoggerFactory
			.getLogger(SalesLedgerController.class);
	
	@RequestMapping("/turnToSalesledgerInfo.do")
	public String turnToSalesledgerInfo() {
		logger.info("跳转到网点销售台账页面");
		return "report/salesledgerInfo";
	}
}