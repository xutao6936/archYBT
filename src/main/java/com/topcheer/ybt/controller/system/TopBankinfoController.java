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
import com.topcheer.ybt.biz.system.ITopBankinfoBiz;
import com.topcheer.ybt.entity.system.TopBankinfo;
import com.topcheer.ybt.util.ResultHelper;


 
@Controller
@RequestMapping("/topBankinfo")
public class TopBankinfoController {
	private static Logger log = LoggerFactory.getLogger(TopBankinfoController.class);
	@Autowired
	private ITopBankinfoBiz topBankinfoBiz;
	
	
	
	@RequestMapping("/getTopBankinfoList.do")
	@ResponseBody
	public PageInfo getTopBankinfoList(String rows,
			String page, TopBankinfo topBankinfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topBankinfo", topBankinfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopBankinfo> searchTopBankinfo = topBankinfoBiz
				.searchTopBankinfo(map);
		return searchTopBankinfo;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopBankinfo topBankinfo,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topBankinfoBiz.insert(topBankinfo);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopBankinfo topBankinfo,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topBankinfoBiz.update(topBankinfo);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topBankinfoBiz.delete(string);
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
