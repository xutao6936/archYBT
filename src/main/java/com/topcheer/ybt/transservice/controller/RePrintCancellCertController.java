package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 当日撤单凭证补打
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topRePrintCancellCert")
public class RePrintCancellCertController {
	private static Logger logger = LoggerFactory
			.getLogger(RePrintCancellCertController.class);
	
	@RequestMapping("/turnToRePrintCancellCertInfo.do")
	public String turnToRePrintCancellCertInfo() {
		return "transservice/rePrintCancellCertInfo";
	}
}