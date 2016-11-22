package com.topcheer.ybt.basedata.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopBasickind;
import com.topcheer.ybt.basedata.service.ITopBasickindService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;


 
@Controller
@RequestMapping("/topBasicKind")
public class TopBasickindController {
	private static Logger logger = LoggerFactory.getLogger(TopBasickindController.class);
	@Autowired
	private ITopBasickindService topBasickindService;
	
	@RequestMapping("/turnToBasicKindInfo.do")
	public String turnToBasicKindInfo() {
		logger.info("跳转到数据字典管理页面");
		return "basedata/basickKindInfo";
	}
	@RequestMapping("/getTopBasickindList.do")
	@ResponseBody
	public PageInfo getTopBasickindList(String rows,
			String page, TopBasickind topBasickind) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topBasickind", topBasickind);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopBasickind> searchTopBasickind = topBasickindService
				.searchTopBasickind(map);
		return searchTopBasickind;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public String insert(@Valid TopBasickind topBasickind,BindingResult result) {
		topBasickind.setId(UUID.randomUUID().toString().replace("-", ""));
		topBasickind.setUpdateDate(DateUtil.getCurrentDate());
		topBasickind.setUpdateTime(DateUtil.getCurrentTime());
		topBasickindService.insert(topBasickind);
		return ResultHelper.RESULT_SUCC;
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public String update(@Valid TopBasickind topBasickind,BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			StringBuffer sb = new StringBuffer();
			for (ObjectError objectError : allErrors) {
				sb.append(objectError);
			}
			return sb.toString();
		}
		topBasickind.setUpdateDate(DateUtil.getCurrentDate());
		topBasickind.setUpdateTime(DateUtil.getCurrentTime());
		topBasickindService.update(topBasickind);
		return ResultHelper.RESULT_SUCC;
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topBasickindService.delete(string);
		  }
		}
		return ResultHelper.RESULT_SUCC;
		  
	}

}
