package com.topcheer.ybt.job.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JOB增加交易
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topAddJob")
public class AddJobController {
	private static Logger logger = LoggerFactory
			.getLogger(AddJobController.class);
	
	@RequestMapping("/turnToAddJobInfo.do")
	public String turnToAddJobInfo() {
		return "job/addJobInfo";
	}
}