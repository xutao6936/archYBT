package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 保险产品查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topInsuranceProducts")
public class InsuranceProductsController {
	private static Logger logger = LoggerFactory
			.getLogger(InsuranceProductsController.class);
	
	@RequestMapping("/turnToInsuranceProductsInfo.do")
	public String turnToInsuranceProductsInfo() {
		logger.info("跳转到保险产品查询页面");
		return "query/insuranceProductsInfo";
	}
}