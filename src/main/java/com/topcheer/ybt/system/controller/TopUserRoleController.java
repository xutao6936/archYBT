package com.topcheer.ybt.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.topcheer.ybt.system.entity.TopRoleinfo;
import com.topcheer.ybt.system.entity.TopUserRole;
import com.topcheer.ybt.system.service.ITopRoleinfoService;
import com.topcheer.ybt.system.service.ITopUserRoleService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topUserRole")
public class TopUserRoleController {
	private static Logger logger = LoggerFactory.getLogger(TopUserRoleController.class);
	@Resource(name = "topUserRoleService")
	private ITopUserRoleService topUserRoleService;

	@Resource(name = "topRoleinfoService")
	private ITopRoleinfoService topRoleService;

	@RequestMapping("/getTopUserRoleList.do")
	@ResponseBody
	public PageInfo<TopUserRole> getTopUserRoleList(String rows, String page, TopUserRole topUserRole) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topUserRole", topUserRole);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopUserRole> searchTopUserRole = topUserRoleService.searchTopUserRole(map);
		return searchTopUserRole;

	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(@Valid TopUserRole topUserRole, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topUserRoleService.insert(topUserRole);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopUserRole topUserRole, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topUserRoleService.update(topUserRole);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if (ids != null) {
			for (String string : ids) {
				topUserRoleService.delete(string);
			}
		}
		return ResultHelper.getResultMap();

	}

	@RequestMapping(value = "/oper.do")
	@ResponseBody
	public Map<String, Object> oper(@Valid TopUserRole topUserRole, BindingResult result, HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insert(topUserRole, result, request);
		} else if ("edit".equals(oper)) {
			return this.update(topUserRole, result, request);
		} else if ("del".equals(oper)) {
			return this.delete(request);
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/userRole", method = RequestMethod.POST)
	public Map<String, Object> initUserRole(String userId) {

		List<TopRoleinfo> roleList = topRoleService.searchAll();// 所有角色
		List<TopUserRole> userRoles = topUserRoleService.getTopUserRoleList(userId);// 当前用户拥有的角色
		for (TopUserRole userRole : userRoles) {
			for (TopRoleinfo role : roleList) {
				if (userRole.getRoleId().equals(role.getRoleId())) {
					role.setChecked(true);// 如果用户拥有该菜单权限，设置菜单标志为"true"
				}

			}
		}

		Gson gson = new Gson();
		String jsonString = gson.toJson(roleList).replaceAll("roleId", "id").replaceAll("roleName", "name");
		System.out.println(jsonString);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menulist", jsonString);
		return map;

		// return ResultHelper.RESULT_SUCC;
	}

	@Transactional
	@ResponseBody
	@RequestMapping(value = "/updateUserRole.do", method = RequestMethod.POST)
	public Map<String, Object> updateUserRole(TopUserRole topUserRole) {
		
		String userId = topUserRole.getUserId();// 用户编码
		try {
			topUserRoleService.deleteByUserId(userId);
			String ids = "".equals(topUserRole.getRoleId())?null:topUserRole.getRoleId();// 菜单id
			if (null != ids) {
				String[] strs = ids.split("\\,");
				for (String str : strs) {
					TopUserRole userRole = new TopUserRole();
					userRole.setId(UUID.randomUUID().toString().replaceAll("-", ""));
					userRole.setRoleId(str);
					userRole.setUserId(userId);
					userRole.setCreateDate(DateUtil.getCurrentDate());// 创建时间
					userRole.setUpdateDate(DateUtil.getCurrentDate());// 更新时间
					topUserRoleService.insert(userRole);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException("执行菜单更新操作出现异常");
		}
		return ResultHelper.getResultMap();
	}

}
