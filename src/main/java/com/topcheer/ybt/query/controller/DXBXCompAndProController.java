package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 代销保险公司及产品查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topDXBXCompAndPro")
public class DXBXCompAndProController {
	private static Logger logger = LoggerFactory
			.getLogger(DXBXCompAndProController.class);
	
	@RequestMapping("/turnToDXBXCompAndPro.do")
	public String turnToDXBXCompAndPro() {
		logger.info("跳转到代销保险公司及产品查询页面");
		return "query/DXBXCompAndProInfo";
	}
}
