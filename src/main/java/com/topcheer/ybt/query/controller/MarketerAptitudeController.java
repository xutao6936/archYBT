package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 营销人员资质查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topMarketerAptitude")
public class MarketerAptitudeController {
	private static Logger logger = LoggerFactory
			.getLogger(MarketerAptitudeController.class);
	
	@RequestMapping("/turnToMarketerAptitudeInfo.do")
	public String turnToMarketerAptitudeInfo() {
		logger.info("跳转到营销人员资质查询页面");
		return "query/marketerAptitudeInfo";
	}
}