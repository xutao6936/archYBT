package com.topcheer.ybt.system.controller;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.topcheer.ybt.system.entity.TopRoleinfo;
import com.topcheer.ybt.system.service.ITopRoleinfoService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topRoleinfo")
public class TopRoleinfoController {
	private static Logger logger = LoggerFactory.getLogger(TopRoleinfoController.class);
	
	@Resource(name = "topRoleinfoService")
	private ITopRoleinfoService topRoleinfoService;
	
	@RequestMapping(value="turnToRoleInfoList",method=RequestMethod.GET)
	public String userList() {
		return "system/roleinfo";
	}

	@RequestMapping("/getTopRoleinfoList.do")
	@ResponseBody
	public PageInfo<TopRoleinfo> getTopRoleinfoList(String rows, String page, TopRoleinfo topRoleinfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topRoleinfo", topRoleinfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopRoleinfo> searchTopRoleinfo = topRoleinfoService.searchTopRoleinfo(map);
		return searchTopRoleinfo;

	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(@Valid TopRoleinfo topRoleinfo, BindingResult binding, HttpServletRequest request) {
		if (binding.hasErrors()) {
			return ResultHelper.analyzeError(binding);
		}
		topRoleinfo.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
		topRoleinfo.setUpdateDate(DateUtil.getCurrentDate());
		topRoleinfo.setUpdateTime(DateUtil.getCurrentTime());
		topRoleinfo.setCreateDate(DateUtil.getCurrentDate());
		topRoleinfo.setStatus("0");
		topRoleinfoService.insert(topRoleinfo);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopRoleinfo topRoleinfo, BindingResult binding, HttpServletRequest request) {
		if (binding.hasErrors()) {
			return ResultHelper.analyzeError(binding);
		}
		topRoleinfo.setUpdateDate(DateUtil.getCurrentDate());
		topRoleinfo.setUpdateTime(DateUtil.getCurrentTime());
		topRoleinfo.setStatus("0");
		topRoleinfoService.update(topRoleinfo);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if (ids != null) {
			for (String string : ids) {
				topRoleinfoService.delete(string);
			}
		}
		return ResultHelper.getResultMap();

	}

	@RequestMapping(value = "/oper.do")
	@ResponseBody
	public Map<String, Object> oper(@Valid TopRoleinfo topRoleinfo, BindingResult result, HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insert(topRoleinfo, result, request);
		} else if ("edit".equals(oper)) {
			return this.update(topRoleinfo, result, request);
		} else if ("del".equals(oper)) {
			return this.delete(request);
		}
		return null;
	}
	
	

}
