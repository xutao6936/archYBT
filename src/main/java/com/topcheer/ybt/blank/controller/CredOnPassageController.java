package com.topcheer.ybt.blank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 特殊凭证在途查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCredOnPassage")
public class CredOnPassageController {
	private static Logger logger = LoggerFactory
			.getLogger(CredOnPassageController.class);
	
	@RequestMapping("/turnToCredOnPassageInfo.do")
	public String turnToCredOnPassageInfo() {
		return "blank/credOnPassageInfo";
	}
}