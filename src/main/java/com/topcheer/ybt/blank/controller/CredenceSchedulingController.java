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
@RequestMapping("/topCredenceScheduling")
public class CredenceSchedulingController {
	private static Logger logger = LoggerFactory
			.getLogger(CredenceSchedulingController.class);
	
	@RequestMapping("/turnToCredenceSchedulingInfo.do")
	public String turnToCredenceSchedulingInfo() {
		return "blank/credenceSchedulingInfo";
	}
}