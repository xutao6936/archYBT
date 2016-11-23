package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 当日业务受理单补打
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topServAccepForm")
public class ServAccepFormController {
	private static Logger logger = LoggerFactory
			.getLogger(ServAccepFormController.class);
	
	@RequestMapping("/turnToServAccepFormInfo.do")
	public String turnToServAccepFormInfo() {
		return "transservice/servAccepFormInfo";
	}
}