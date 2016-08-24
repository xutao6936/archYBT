package com.topcheer.ybt.controller.system;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.topcheer.ybt.entity.system.TopBankinfo;
import com.topcheer.ybt.entity.system.TopUserinfo;
import com.topcheer.ybt.service.system.ITopBankinfoService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;


 
@Controller
@RequestMapping("/topBankinfo")
public class TopBankinfoController {
	private static Logger log = LoggerFactory.getLogger(TopBankinfoController.class);
	@Autowired
	private ITopBankinfoService topBankinfoService;
	
	
	
	@RequestMapping("/getTopBankinfoList.do")
	@ResponseBody
	public PageInfo<TopBankinfo> getTopBankinfoList(String rows,
			String page, TopBankinfo topBankinfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topBankinfo", topBankinfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		log.info("map ： {}", map);
		PageInfo<TopBankinfo> searchTopBankinfo = topBankinfoService
				.searchTopBankinfo(map);
		return searchTopBankinfo;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopBankinfo topBankinfo,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topBankinfo.setUpdatedate(DateUtil.getCurrentDate());
		topBankinfo.setUpdatetime(DateUtil.getCurrentTime());
		topBankinfo.setOperatorBankcode(userinfo.getUserDept());
		topBankinfo.setOperatorCode(userinfo.getLoginAccount());
		topBankinfo.setAdminFlag("0");
		topBankinfoService.insert(topBankinfo);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopBankinfo topBankinfo,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topBankinfo.setUpdatedate(DateUtil.getCurrentDate());
		topBankinfo.setUpdatetime(DateUtil.getCurrentTime());
		topBankinfo.setOperatorBankcode(userinfo.getUserDept());
		topBankinfo.setOperatorCode(userinfo.getLoginAccount());
		topBankinfo.setAdminFlag("0");
		topBankinfoService.update(topBankinfo);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topBankinfoService.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}
	
	@RequestMapping(value="/oper.do")
	@ResponseBody
	public Map<String,Object> oper(@Valid TopBankinfo topBankinfo,BindingResult result,HttpServletRequest request){
		String oper = request.getParameter("oper");
		if("add".equals(oper)){
			return this.insert(topBankinfo, result, request);
		}else if("edit".equals(oper)){
			return this.update(topBankinfo, result,request);
		}else if("del".equals(oper)){
			return this.delete(request);
		}
		return null;
	}


}
