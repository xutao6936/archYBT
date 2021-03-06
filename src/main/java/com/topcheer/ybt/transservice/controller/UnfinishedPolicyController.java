package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理未完成投保单
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topUnfinishedPolicy")
public class UnfinishedPolicyController {
	private static Logger logger = LoggerFactory
			.getLogger(UnfinishedPolicyController.class);
	
	@RequestMapping("/turnToUnfinishedPolicyInfo.do")
	public String turnToUnfinishedPolicyInfo() {
		return "transservice/unfinishedPolicyInfo";
	}
}