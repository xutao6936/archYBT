package com.topcheer.ybt.blank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 特殊凭证出库
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCredenceOutstock")
public class CredenceOutstockController {
	private static Logger logger = LoggerFactory
			.getLogger(CredenceOutstockController.class);
	
	@RequestMapping("/turnToCredenceOutstockInfo.do")
	public String turnToCredenceOutstockInfo() {
		return "blank/credenceOutstockInfo";
	}
}
