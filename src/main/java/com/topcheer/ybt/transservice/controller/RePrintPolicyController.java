package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 单日保单补打
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topRePrintPolicy")
public class RePrintPolicyController {
	private static Logger logger = LoggerFactory
			.getLogger(RePrintPolicyController.class);
	
	@RequestMapping("/turnToRePrintPolicyInfo.do")
	public String turnToRePrintPolicyInfo() {
		return "transservice/rePrintPolicyInfo";
	}
}