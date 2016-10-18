package com.topcheer.ybt.basedata.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopPayperiod;
import com.topcheer.ybt.basedata.service.ITopPayperiodService;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;

 
/** 
* @ClassName: TopPayperiodController 
* @Description: 缴费年期controller
* @author 周宣
* @date 2016年10月12日
*  
*/
@Controller
@RequestMapping("/topPayperiod")
public class TopPayperiodController {
	private static Logger logger = LoggerFactory.getLogger(TopPayperiodController.class);
	@Resource(name="topPayperiodService")
	private ITopPayperiodService topPayperiodService;
	
	@RequestMapping("/getTopPayperiodList.do")
	@ResponseBody
	public PageInfo<TopPayperiod> getTopPayperiodList(String rows,String page, TopPayperiod topPayperiod) {
		logger.info("查询缴费年期……");
		Map<String, Object> map = Maps.newHashMap();
		map.put("topPayperiod", topPayperiod);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopPayperiod> searchTopPayperiod = topPayperiodService.searchTopPayperiod(map);
		return searchTopPayperiod;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopPayperiod topPayperiod,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topPayperiodService.insert(topPayperiod);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopPayperiod topPayperiod,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topPayperiodService.update(topPayperiod);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topPayperiodService.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}

	@RequestMapping(value="/oper.do")
	@ResponseBody
	public Map<String,Object> oper(@Valid TopPayperiod topPayperiod,BindingResult result,HttpServletRequest request){
		String oper = request.getParameter("oper");
		if("add".equals(oper)){
			return this.insert(topPayperiod, result, request);
		}else if("edit".equals(oper)){
			return this.update(topPayperiod, result,request);
		}else if("del".equals(oper)){
			return this.delete(request);
		}
		return null;
	}

}
