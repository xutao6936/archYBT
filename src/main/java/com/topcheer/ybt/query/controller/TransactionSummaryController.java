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
@RequestMapping("/topTransactionSummary")
public class TransactionSummaryController {
	private static Logger logger = LoggerFactory
			.getLogger(TransactionSummaryController.class);
	
	@RequestMapping("/turnToTransactionSummaryInfo.do")
	public String turnToTransactionSummaryInfo() {
		logger.info("跳转到交易汇总查询页面");
		return "query/transactionSummaryInfo";
	}
}
