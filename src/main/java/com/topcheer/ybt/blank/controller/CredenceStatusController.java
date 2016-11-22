package com.topcheer.ybt.blank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 柜员特殊凭证状态查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCredenceStatus")
public class CredenceStatusController {
	private static Logger logger = LoggerFactory
			.getLogger(CredenceStatusController.class);
	
	@RequestMapping("/turnToCredenceStatusInfo.do")
	public String turnToCredenceStatusInfo() {
		return "blank/credenceStatusInfo";
	}
}