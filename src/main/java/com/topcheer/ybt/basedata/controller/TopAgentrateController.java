package com.topcheer.ybt.basedata.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopAgentrate;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.service.ITopAgentrateService;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * 手续费设置
 * @author liuc
 *
 */
 
@Controller
@RequestMapping("/topAgentrate")
public class TopAgentrateController {
	private static Logger logger = LoggerFactory.getLogger(TopAgentrateController.class);
	@Autowired
	private ITopAgentrateService topAgentrateService;
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
			list.add(topInsprdInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("insPrdCode", "insPrdCode").replaceAll("insPrdEnName", "insPrdEnName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}
	
	@RequestMapping(value = "/getInsPrdByInsPrdCode", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getInsPrdByInsPrdCode(HttpServletRequest request){
		logger.info("通过保险产品编码查询保险公司产品手续费信息");
		System.out.println(request.getParameter("insPrdCode"));
		String insPrdCode = (String)request.getParameter("insPrdCode");
		List<TopAgentrate> list = new ArrayList<TopAgentrate>();
		List<TopAgentrate> topAgentrateList =  topAgentrateService.getInsPrdByInsPrdCode(insPrdCode);
		for (TopAgentrate topAgentrate : topAgentrateList) {
			list.add(topAgentrate);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("insPrdCode", "insPrdCode").replaceAll("insPrdEnName", "insPrdEnName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}
	
	@RequestMapping("/getTopAgentrateList.do")
	@ResponseBody
	public PageInfo getTopAgentrateList(String rows,
			String page, TopAgentrate topAgentrate) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topAgentrate", topAgentrate);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopAgentrate> searchTopAgentrate = topAgentrateService
				.searchTopAgentrate(map);
		return searchTopAgentrate;
		
	}
	
	@RequestMapping("/getAgentrateByInsPrdCode.do")
	@ResponseBody
	public PageInfo getAgentrateByInsPrdCode(HttpServletRequest request) {
		String insPrdCode = (String)request.getParameter("insPrdCode");
		PageInfo<TopAgentrate> searchTopAgentrate = topAgentrateService
				.getAgentrateByInsPrdCode(insPrdCode);
		return searchTopAgentrate;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopAgentrate topAgentrate,BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topAgentrateService.insert(topAgentrate);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopAgentrate topAgentrate,BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topAgentrateService.update(topAgentrate);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topAgentrateService.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}


}
