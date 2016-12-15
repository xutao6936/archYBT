package com.topcheer.ybt.basedata.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.topcheer.ybt.annotation.SystemControllerLog;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.entity.TopInsTemplateInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.entity.TopTempInsPrdInfo;
import com.topcheer.ybt.basedata.entity.TopTemplate;
import com.topcheer.ybt.basedata.service.ITopTemplateService;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

 
@Controller
@RequestMapping("/topTemplate")
public class TopTemplateController {
	private static Logger logger = LoggerFactory.getLogger(TopTemplateController.class);
	@Autowired
	private ITopTemplateService topTemplateService;
	
	@Resource(name = "topInsPrdInfoBizImpl")
	private ITopInsPrdInfoBiz topInsPrdInfoBiz;
	
	@Resource(name = "topInsCorpInfoBizImpl")
	private ITopInsCorpInfoBiz topInsCorpInfoBiz;
	
	private String resultTree;// 我要返回给页面的List
	
	private String result;// 返回给页面的List
	
	@RequestMapping("/turnToTemplateInfo.do")
	public String turnToBasicKindInfo() {
		logger.info("跳转到产品库管理页面");
		return "basedata/templateInfo";
	}
	
	@SystemControllerLog(description = "查询产品库信息列表")
	@RequestMapping("/getTopTemplateList.do")
	@ResponseBody
	public PageInfo getTopTemplateList(String rows,
			String page, TopTemplate topTemplate) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topTemplate", topTemplate);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopTemplate> searchTopTemplate = topTemplateService
				.searchTopTemplate(map);
		return searchTopTemplate;
		
	}
	
	@SystemControllerLog(description = "新增产品库信息")
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public String insert(@Valid TopTemplate topTemplate,BindingResult result,HttpServletRequest request) {
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		TopTemplate topTemplate2 = topTemplateService.getTopTemplate((String)request.getParameter("templateId"));
		if(null !=topTemplate2){
			return "该产品库编号已存在";
		}
		topTemplate.setTemplateid((String)request.getParameter("templateId"));
		topTemplate.setTemplatename((String)request.getParameter("templateName"));
		topTemplate.setOperatorbankcode(userinfo.getUserDept());
		topTemplate.setOperatorcode(userinfo.getLoginAccount());
		topTemplate.setUpdatedate(DateUtil.getCurrentDate());
		topTemplate.setUpdatetime(DateUtil.getCurrentTime());
		topTemplateService.insert(topTemplate);
		return ResultHelper.RESULT_SUCC;
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public String update(@Valid TopTemplate topTemplate,BindingResult result, HttpServletRequest request) {
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topTemplate.setTemplateid((String)request.getParameter("templateId"));
		topTemplate.setTemplatename((String)request.getParameter("templateName"));
		topTemplate.setOperatorbankcode(userinfo.getUserDept());
		topTemplate.setOperatorcode(userinfo.getLoginAccount());
		topTemplate.setUpdatedate(DateUtil.getCurrentDate());
		topTemplate.setUpdatetime(DateUtil.getCurrentTime());
		topTemplateService.update(topTemplate);
		return ResultHelper.RESULT_SUCC;
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topTemplateService.delete(string);
		  }
		}
		  return ResultHelper.RESULT_SUCC;
		  
	}
	
	//通过保险公司获取产品库信息
		@RequestMapping(value = "/getTemplateIdAjax.do", method = {
				RequestMethod.POST, RequestMethod.GET })
		@ResponseBody
		public String getTemplateIdAjax(HttpServletRequest request) {
			String insCorpCode = (String) request.getParameter("insCorpCode");
			logger.info("insCorpCode:"+insCorpCode);
			List<TopTemplate> templateList  = topTemplateService.getTemplateIdAjax(insCorpCode);
			List<TopTemplate> list = new ArrayList<TopTemplate>();
			for (TopTemplate template : templateList) {
				list.add(template);
			}
			Gson gson = new Gson();
			String jsonString = gson.toJson(list)
					.replaceAll("templateid", "templateid")
					.replaceAll("templatename", "templatename");
			result = jsonString;// 给result赋值，传递给页面
			logger.info(result);
			return result;
		}
		
		@RequestMapping(value = "/getTemplateInfoByTempId.do", method = {
				RequestMethod.POST, RequestMethod.GET })
		@ResponseBody
		public String getTemplateInfoByTempId(HttpServletRequest request) {
			String templateId = (String) request.getParameter("templateId");
			logger.info("templateId:"+templateId);
			List<TopTemplate> templateList  = topTemplateService.getTemplateInfoByTempId(templateId);
			List<TopTemplate> list = new ArrayList<TopTemplate>();
			for (TopTemplate template : templateList) {
				list.add(template);
			}
			Gson gson = new Gson();
			String jsonString = gson.toJson(list)
					.replaceAll("templateid", "templateid")
					.replaceAll("templatename", "templatename");
			result = jsonString;// 给result赋值，传递给页面
			logger.info(result);
			return result;
		}
	
	@RequestMapping(value = "/getInsCorpTreeData.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getInsCorpTreeData(HttpServletRequest request) {
		logger.info("tempId="+request.getParameter("tempId"));
		String tempId = request.getParameter("templateId");
		Map<String, Object> map = Maps.newHashMap();
		map.put("templateId", tempId);
		Gson gson = new Gson();
			JsonObject returnData =null;
			if(!"".equals(tempId)){
			StringBuffer strBuff = new StringBuffer();
			
			List<TopInsCorpInfo> topInsCorpInfolist = topInsCorpInfoBiz.searchAll();
			if(topInsCorpInfolist.size()>0){
				strBuff.append("{'保险公司':"
						+ "{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {");
				for (TopInsCorpInfo topInsCorpInfo : topInsCorpInfolist) {
						map.put("insCorpCode", topInsCorpInfo.getInsCorpCode());
						TopInsTemplateInfo topInsTemplateInfo = topTemplateService.getTopInsTemplateInfo(map);
							strBuff.append("'" +topInsCorpInfo.getInsCorpCode()+"-"+topInsCorpInfo.getInsSimpName() + "':"
									+ "{name:'" +topInsCorpInfo.getInsCorpCode()+"-"+topInsCorpInfo.getInsSimpName()
									+ "',type: 'item'");
							if(null != topInsTemplateInfo){
								strBuff.append(",additionalParameters:{id:'" + topInsTemplateInfo.getInscorpcode()
										+ "','item-selected':true}},");
								
							}else{
								strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
										+ "','item-selected':false}},");
							}
				}
				strBuff.deleteCharAt(strBuff.length() - 1);
				strBuff.append("}}}}");
				 logger.info(strBuff.toString());
				 returnData = new JsonParser().parse(strBuff.toString())
							.getAsJsonObject();
				 String jsonString = gson.toJson(returnData);
					resultTree = jsonString;
					
				}else{
					resultTree="{}";
				}
			
			}
			logger.info(resultTree);
			return resultTree;
	}
	@RequestMapping(value = "/getInsPrdInfoByInsCorpCode.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getInsPrdInfoByInsCorpCode(HttpServletRequest request) {
		logger.info("insCorpCode="+request.getParameter("insCorpCode"));
		logger.info("tempId="+request.getParameter("tempId"));
		String insCorpCode = request.getParameter("insCorpCode");
		String tempId = request.getParameter("tempId");
		Map<String, Object> map = Maps.newHashMap();
		map.put("insCorpCode", insCorpCode);
		map.put("templateId", tempId);
		Gson gson = new Gson();
			JsonObject returnData =null;
			if(!"".equals(insCorpCode)){
			StringBuffer strBuff = new StringBuffer();
			
			List<TopInsprdInfo> insPrdInfoList = topInsPrdInfoBiz
					.getInsPrdInfoByInsCorpCode(insCorpCode);
			if(insPrdInfoList.size()>0){
				strBuff.append("{'保险产品':"
						+ "{name:'保险产品',type: 'folder', 'additionalParameters': {'id': '0','children': {");
				for (TopInsprdInfo topInsprdInfo : insPrdInfoList) {
					if(null !=topInsprdInfo){
						map.put("insPrdCode", topInsprdInfo.getInsPrdCode());
						TopTempInsPrdInfo topTempInsPrdInfo =topTemplateService.getTopTempInsPrdInfoByInsPrdCode(map);
							strBuff.append("'" +topInsprdInfo.getInsPrdCode()+"-"+ topInsprdInfo.getInsPrdCnName() + "':"
									+ "{name:'" +topInsprdInfo.getInsPrdCode()+"-"+ topInsprdInfo.getInsPrdCnName()
									+ "',type: 'item'");
							if(null != topTempInsPrdInfo){
								strBuff.append(",additionalParameters:{id:'" + topInsprdInfo.getInsPrdCode()
										+ "','item-selected':true}},");
							}else{
								strBuff.append(",additionalParameters:{id:'" + topInsprdInfo.getInsPrdCode()
										+ "','item-selected':false}},");
							}
							
					}
				}
				strBuff.deleteCharAt(strBuff.length() - 1);
				strBuff.append("}}}}");
				 logger.info(strBuff.toString());
				 returnData = new JsonParser().parse(strBuff.toString())
							.getAsJsonObject();
				 String jsonString = gson.toJson(returnData);
					resultTree = jsonString;
					
				}else{
					resultTree="{}";
				}
			
			}else{
				resultTree="{}";
			}
			logger.info(resultTree);
			return resultTree;
	}
	
	

	@SystemControllerLog(description = "产品库绑定保险公司及保险产品信息")
	@RequestMapping(value="/insertTempInsPrd.do",method = RequestMethod.POST)
	@ResponseBody
	public String insertTempInsPrd(@Valid TopTemplate topTemplate,BindingResult result,HttpServletRequest request) {
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		String templateId = request.getParameter("templateId");
		String insCorpCode = request.getParameter("insCorpCode");
		String insPrds = request.getParameter("insPrds");
		logger.info("templateId:"+templateId);
		logger.info("insCorpCode:"+insCorpCode);
		logger.info("insPrds:"+insPrds);
		TopTempInsPrdInfo topTempInsPrdInfo = new TopTempInsPrdInfo();
		String [] insPrdCodes = insPrds.split(",");
		logger.info("insPrdCodes.length"+insPrdCodes.length);
		if("".equals(insCorpCode)){
			topTemplateService.deleteInsTemplateByTempId(templateId);
		}else{
			topTemplateService.deleteInsTemplateByTempId(templateId);
			TopInsTemplateInfo topInsTemplateInfo = new TopInsTemplateInfo();
			String id =UUID.randomUUID().toString().replace("-", "");
			topInsTemplateInfo.setId(id);
			topInsTemplateInfo.setInscorpcode(insCorpCode);
			topInsTemplateInfo.setTemplateid(templateId);
			topInsTemplateInfo.setOperatorbankcode(userinfo.getUserDept());
			topInsTemplateInfo.setOperatorcode(userinfo.getLoginAccount());
			topInsTemplateInfo.setUpdatedate(DateUtil.getCurrentDate());
			topInsTemplateInfo.setUpdatetime(DateUtil.getCurrentTime());
			topTemplateService.insertInsTemplate(topInsTemplateInfo);
		}
		if(insPrdCodes.length==0){
			topTemplateService.deleteTempInsPrdByTempId(templateId);
		}else if(insPrdCodes.length==1&&"".equals(insPrdCodes[0])){
			topTemplateService.deleteTempInsPrdByTempId(templateId);
		}else{
			//1.先解除产品库与保险产品绑定的关系
			topTemplateService.deleteTempInsPrdByTempId(templateId);
			for (int i = 0; i < insPrdCodes.length; i++) {
				String id =UUID.randomUUID().toString().replace("-", "");
				topTempInsPrdInfo.setId(id);
				topTempInsPrdInfo.setTemplateid(templateId);
				topTempInsPrdInfo.setInscorpcode(insCorpCode);
				topTempInsPrdInfo.setInsprdcode(insPrdCodes[i]);
				topTempInsPrdInfo.setOperatorbankcode(userinfo.getUserDept());
				topTempInsPrdInfo.setOperatorcode(userinfo.getLoginAccount());
				topTempInsPrdInfo.setUpdatedate(DateUtil.getCurrentDate());
				topTempInsPrdInfo.setUpdatetime(DateUtil.getCurrentTime());
				//2.将产品库与保险产品进行绑定
				topTemplateService.insertTempInsPrd(topTempInsPrdInfo);
			}
		}
		return ResultHelper.RESULT_SUCC;
	}
	
}
