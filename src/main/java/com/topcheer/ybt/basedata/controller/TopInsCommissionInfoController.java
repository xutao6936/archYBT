package com.topcheer.ybt.basedata.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;

@Controller
@RequestMapping("/insCommission")
public class TopInsCommissionInfoController {
	private static Logger logger = LoggerFactory.getLogger(TopInsCommissionInfoController.class);
	private String result;//返回给页面的List
	@Resource(name = "topInsCorpInfoBizImpl")
	private ITopInsCorpInfoBiz topInsCorpInfoBiz;
	@Resource(name = "topInsPrdInfoBizImpl")
	private ITopInsPrdInfoBiz topInsPrdInfoBiz;
	
	@RequestMapping("/turnToInsCommissionInfo.do")
	public String turnToInsCommissionInfo() {
		logger.info("跳转到手续费设置页面");
		return "basedata/commissionInfo";
	}


	@RequestMapping(value = "/getInsCompanyAjax", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getInsCompanyAjax(HttpServletRequest request){
		List<TopInsCorpInfo> insCorpList = topInsCorpInfoBiz.searchAll();
		List<TopInsCorpInfo> list = new ArrayList<TopInsCorpInfo>();
		for (TopInsCorpInfo topInsCorpInfo : insCorpList) {
			list.add(topInsCorpInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("insCorpCode", "insCorpCode").replaceAll("insSimpName", "insSimpName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}
	
	@RequestMapping(value = "/getInsPrdAjax", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getInsPrdAjax(HttpServletRequest request){
		logger.info("通过保险公司编码级联查询保险公司产品 ");
		System.out.println(request.getParameter("insCorpCode"));
		String insCorpCode = (String)request.getParameter("insCorpCode");
		List<TopInsprdInfo> list = new ArrayList<TopInsprdInfo>();
		List<TopInsprdInfo> insCorpPrdList =  topInsPrdInfoBiz.getTopInsPrdInfoListByInsPrdCode(insCorpCode);
		for (TopInsprdInfo topInsprdInfo : insCorpPrdList) {
			System.out.println(topInsprdInfo);
			list.add(topInsprdInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("insPrdCode", "insPrdCode").replaceAll("insPrdEnName", "insPrdEnName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}

}
