package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 保险公司查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topInsuranceCompany")
public class InsuranceCompanyController {
	private static Logger logger = LoggerFactory
			.getLogger(InsuranceCompanyController.class);
	
	@RequestMapping("/turnToInsuranceCompanyInfo.do")
	public String turnToInsuranceCompanyInfo() {
		logger.info("跳转到保险公司查询页面");
		return "query/InsuranceCompanyInfo";
	}
}