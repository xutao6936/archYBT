package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 当日投保确认补打
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topRePrintConfirmIns")
public class RePrintConfirmInsController {
	private static Logger logger = LoggerFactory
			.getLogger(RePrintConfirmInsController.class);
	
	@RequestMapping("/turnToRePrintConfirmInsInfo.do")
	public String turnToRePrintConfirmInsInfo() {
		return "transservice/rePrintConfirmInsInfo";
	}
}