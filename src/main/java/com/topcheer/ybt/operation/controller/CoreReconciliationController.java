package com.topcheer.ybt.operation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 核心对账
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCoreReconciliation")
public class CoreReconciliationController {
	private static Logger logger = LoggerFactory
			.getLogger(CoreReconciliationController.class);
	
	@RequestMapping("/turnToCoreReconciliationInfo.do")
	public String turnToCoreReconciliationInfo() {
		return "operation/coreReconciliationInfo";
	}
}
