package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 新保承保
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topAuditSafety")
public class AuditSafetyController {
	private static Logger logger = LoggerFactory
			.getLogger(AuditSafetyController.class);
	
	@RequestMapping("/turnToAuditSafetyInfo.do")
	public String turnToAuditSafetyInfo() {
		return "transservice/auditSafetyInfo";
	}
}

