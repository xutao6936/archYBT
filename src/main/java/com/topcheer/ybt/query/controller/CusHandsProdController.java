package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户持有保险产品查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCusHandsProd")
public class CusHandsProdController {
	private static Logger logger = LoggerFactory
			.getLogger(CusHandsProdController.class);
	
	@RequestMapping("/turnToCusHandsProdInfo.do")
	public String turnToCusHandsProdInfo() {
		logger.info("跳转到客户持有保险产品查询页面");
		return "query/cusHandsProdInfo";
	}
}