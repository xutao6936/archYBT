package com.topcheer.ybt.operation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日终清算报表下载
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topDownloadRefReport")
public class DownloadRefReportController {
	private static Logger logger = LoggerFactory
			.getLogger(DownloadRefReportController.class);
	
	@RequestMapping("/turnToDownloadRefReportInfo.do")
	public String turnToDownloadRefReportInfo() {
		return "operation/downloadRefReportInfo";
	}
}