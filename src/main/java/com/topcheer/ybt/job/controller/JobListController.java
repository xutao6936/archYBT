package com.topcheer.ybt.job.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JOB查询、管理交易
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topJobList")
public class JobListController {
	private static Logger logger = LoggerFactory
			.getLogger(JobListController.class);
	
	@RequestMapping("/turnToJobListInfo.do")
	public String turnToJobListInfo() {
		return "job/jobListInfo";
	}
}