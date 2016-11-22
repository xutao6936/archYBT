package com.topcheer.ybt.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 交易明细查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topTransactionDetail")
public class TransactionDetailController {
	private static Logger logger = LoggerFactory
			.getLogger(TransactionDetailController.class);
	
	@RequestMapping("/turnToTransactionDetailInfo.do")
	public String turnToTransactionDetailInfo() {
		logger.info("跳转到交易明细查询页面");
		return "query/transactionDetailInfo";
	}
}