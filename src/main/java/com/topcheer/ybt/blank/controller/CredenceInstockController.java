package com.topcheer.ybt.blank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 特殊凭证入库
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCredenceInstock")
public class CredenceInstockController {
	private static Logger logger = LoggerFactory
			.getLogger(CredenceInstockController.class);
	
	@RequestMapping("/turnToCredenceInstockInfo.do")
	public String turnToCredenceInstockInfo() {
		return "blank/credenceInstockInfo";
	}
}
