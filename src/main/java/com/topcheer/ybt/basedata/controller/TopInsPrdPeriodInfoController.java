package com.topcheer.ybt.basedata.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsPrdPeriodInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;

@Controller
@RequestMapping("/topInsPrdPeriodInfo")
public class TopInsPrdPeriodInfoController {
	private static Logger log = LoggerFactory.getLogger(TopInsPrdPeriodInfoController.class);

	@Resource(name = "topInsPeriodInfoBizImpl")
	private ITopInsPrdPeriodInfoBiz topInsPrdPeriodInfoBiz;
	
	/**
	 * 查询保障年期
	 * @return
	 */
	@RequestMapping("getTopInsPrdPeriodInfoList.do")
	@ResponseBody
	public PageInfo<TopInsPrdPeriodInfo> getTopInsPrdPeriodInfoList() {
		log.info("进入保障年期基本信息查询");
		PageInfo<TopInsPrdPeriodInfo> topInsPrdPeriodInfoList = topInsPrdPeriodInfoBiz.getInsPrdPeriodAllList();
		return topInsPrdPeriodInfoList;
	}
	
}
