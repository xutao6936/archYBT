package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 当日撤单
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topCancelInsurance")
public class CancelInsuranceController {
	private static Logger logger = LoggerFactory
			.getLogger(CancelInsuranceController.class);
	
	@RequestMapping("/turnToCancelInsuranceInfo.do")
	public String turnToCancelInsuranceInfo() {
		return "transservice/cancelInsuranceInfo";
	}
}