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
import com.topcheer.ybt.basedata.entity.TopPaytype;
import com.topcheer.ybt.basedata.service.ITopPaytypeService;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;
 
/** 
* @ClassName: TopPaytypeController 
* @Description: 缴费类型controller 
* @author 周宣
* @date 2016年10月12日
*  
*/
@Controller
@RequestMapping("/topPaytype")
public class TopPaytypeController {
	private static Logger logger = LoggerFactory.getLogger(TopPaytypeController.class);
	@Resource(name="topPaytypeService")
	private ITopPaytypeService topPaytypeService;
	
	@RequestMapping("/getTopPaytypeList.do")
	@ResponseBody
	public PageInfo<TopPaytype> getTopPaytypeList(String rows,String page, TopPaytype topPaytype) {
		logger.info("查询缴费类型开始……");
		Map<String, Object> map = Maps.newHashMap();
		map.put("topPaytype", topPaytype);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopPaytype> searchTopPaytype = topPaytypeService.searchTopPaytype(map);
		return searchTopPaytype;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopPaytype topPaytype,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topPaytypeService.insert(topPaytype);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopPaytype topPaytype,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topPaytypeService.update(topPaytype);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topPaytypeService.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}

	@RequestMapping(value="/oper.do")
	@ResponseBody
	public Map<String,Object> oper(@Valid TopPaytype topPaytype,BindingResult result,HttpServletRequest request){
		String oper = request.getParameter("oper");
		if("add".equals(oper)){
			return this.insert(topPaytype, result, request);
		}else if("edit".equals(oper)){
			return this.update(topPaytype, result,request);
		}else if("del".equals(oper)){
			return this.delete(request);
		}
		return null;
	}

}
