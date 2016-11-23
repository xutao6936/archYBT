package com.topcheer.ybt.operation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日终与保险公司对账
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topInsCorpReconciliation")
public class InsCorpReconciliationController {
	private static Logger logger = LoggerFactory
			.getLogger(InsCorpReconciliationController.class);
	
	@RequestMapping("/turnToInsCorpReconciliationInfo.do")
	public String turnToInsCorpReconciliationInfo() {
		return "operation/insCorpReconciliationInfo";
	}
}