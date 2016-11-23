package com.topcheer.ybt.system.controller;

import java.util.Map;

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
import com.google.common.collect.Maps;
import com.topcheer.ybt.annotation.SystemControllerLog;
import com.topcheer.ybt.system.entity.TopLog;
import com.topcheer.ybt.system.service.ITopLogService;
import com.topcheer.ybt.util.ResultHelper;


@Controller
@RequestMapping("/log")
public class TopLogController {
	private static Logger log = LoggerFactory.getLogger(TopLogController.class);
	@Autowired
	private ITopLogService topLogService;

	@RequestMapping("/toSysLog")
	public String toSysLog(HttpServletRequest request) {
		return "/log/SysLogList";
	}
	
	@RequestMapping("/toSysTimeLine")
	public String toSysTimeLine(HttpServletRequest request) {
		return "/log/SysTimeLine";
	}
	
	@SystemControllerLog(description = "查询系统操作日志列表")
	@RequestMapping("/getTopLogList.do")
	@ResponseBody
	public PageInfo getTopLogList(String rows, String page, TopLog topLog) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topLog", topLog);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopLog> searchTopLog = topLogService.searchTopLog(map);
		return searchTopLog;

	}
	
	@SystemControllerLog(description = "查询系统异常日志列表")
	@RequestMapping("/getExcptionLogInfo.do")
	@ResponseBody
	public PageInfo getExcptionLogInfo(String rows, String page, TopLog topLog) {
		log.info("查询系统异常日志列表");
		Map<String, Object> map = Maps.newHashMap();
		map.put("topLog", topLog);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopLog> searchTopLog = topLogService.getExcptionLogInfo(map);
		return searchTopLog;
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(@Valid TopLog topLog, BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topLogService.insert(topLog);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopLog topLog, BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topLogService.update(topLog);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if (ids != null) {
			for (String string : ids) {
				topLogService.delete(string);
			}
		}
		return ResultHelper.getResultMap();

	}

	@RequestMapping(value = "/oper.do")
	@ResponseBody
	public Map<String, Object> oper(@Valid TopLog topLog, BindingResult result,
			HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insert(topLog, result);
		} else if ("edit".equals(oper)) {
			return this.update(topLog, result);
		} else if ("del".equals(oper)) {
			return this.delete(request);
		}
		return null;
	}
	
	
	@SystemControllerLog(description = "根据条件查询系统操作日志列表")
	@RequestMapping("/getTopLogListByParams.do")
	@ResponseBody
	public PageInfo getTopLogListByParams(String rows, String page, HttpServletRequest request) {
		Map<String, String> map = Maps.newHashMap();
		String name = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		log.info("name:"+name);
		log.info("startDate:"+startDate);
		log.info("endDate:"+endDate);
		map.put("name", name);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopLog> searchTopLog = topLogService.getTopLogListByParams(map);
		return searchTopLog;
	}
	
	@SystemControllerLog(description = "根据条件查询系统异常日志列表")
	@RequestMapping("/getExcptionLogListByParams.do")
	@ResponseBody
	public PageInfo getExcptionLogListByParams(String rows, String page, HttpServletRequest request) {
		Map<String, String> map = Maps.newHashMap();
		String name = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		log.info("name:"+name);
		log.info("startDate:"+startDate);
		log.info("endDate:"+endDate);
		map.put("name", name);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopLog> searchTopLog = topLogService.getExcptionLogListByParams(map);
		return searchTopLog;
	}
}
