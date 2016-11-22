package com.topcheer.ybt.job.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JOB结果查询交易
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topJobResult")
public class JobResultController {
	private static Logger logger = LoggerFactory
			.getLogger(JobResultController.class);
	
	@RequestMapping("/turnToJobResultInfo.do")
	public String turnToJobResuultInfo() {
		return "job/jobResultInfo";
	}
}