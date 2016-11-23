package com.topcheer.ybt.blank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 特殊凭证作废
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCredenceCancel")
public class CredenceCancelController {
	private static Logger logger = LoggerFactory
			.getLogger(CredenceCancelController.class);
	
	@RequestMapping("/turnToCredenceCancelInfo.do")
	public String turnToCredenceCancelInfo() {
		return "blank/credenceCancelInfo";
	}
}