package com.topcheer.ybt.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.topcheer.ybt.system.entity.TopMenuinfo;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopMenuinfoService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topMenuinfo")
public class TopMenuinfoController {
	private static Logger log = LoggerFactory.getLogger(TopMenuinfoController.class);
	@Resource(name = "topMenuinfoService")
	private ITopMenuinfoService topMenuinfoService;

	private String resultTree;// 我要返回给页面的List
	
	@RequestMapping("/turnToMenuInfoList")
	public String userList() {
		return "system/menuinfo";
	}

	@RequestMapping("/getTopMenuinfoList.do")
	@ResponseBody
	public PageInfo<TopMenuinfo> getTopMenuinfoList(String rows, String page, TopMenuinfo topMenuinfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topMenuinfo", topMenuinfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopMenuinfo> searchTopMenuinfo = topMenuinfoService.searchTopMenuinfo(map);
		return searchTopMenuinfo;

	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(@Valid TopMenuinfo topMenuinfo, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		//topMenuinfo.setMenuId(UUID.randomUUID().toString().replaceAll("-", ""));
		topMenuinfo.setCreateDate(DateUtil.getCurrentDate());
		topMenuinfo.setUpdateDate(DateUtil.getCurrentDate());
		topMenuinfo.setUpdateTime(DateUtil.getCurrentTime());
		topMenuinfo.setUpdateOperator("0000");
		topMenuinfoService.insert(topMenuinfo);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopMenuinfo topMenuinfo, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topMenuinfo.setUpdateDate(DateUtil.getCurrentDate());
		topMenuinfo.setUpdateTime(DateUtil.getCurrentTime());
		topMenuinfo.setUpdateOperator("0000");
		topMenuinfoService.update(topMenuinfo);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if (ids != null) {
			for (String string : ids) {
				topMenuinfoService.delete(string);
			}
		}
		return ResultHelper.getResultMap();

	}

	@RequestMapping(value = "/oper.do")
	@ResponseBody
	public Map<String, Object> oper(@Valid TopMenuinfo topMenuinfo, BindingResult result, HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insert(topMenuinfo, result, request);
		} else if ("edit".equals(oper)) {
			return this.update(topMenuinfo, result, request);
		} else if ("del".equals(oper)) {
			return this.delete(request);
		}
		return null;
	}

	@RequestMapping(value = "/returnTree", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getMenu(HttpServletRequest request) {

		log.info("自动加载导航菜单。。。");
		TopUserinfo topUserinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		List<TopMenuinfo> menulist = topMenuinfoService.searchMenuByUserId(topUserinfo);// 查询当前用户角色权限下的所有菜单
		// List<TopTaskMenu> roleMenus =
		// topTaskMenuService.searchByRoleId(topUserRole.getRoleId());//当前用户拥有的菜单
		// for (TopTaskMenu topTaskMenu : roleMenus) {
		// for (Iterator<TopMenuinfo> it = menulist.iterator(); it.hasNext();) {
		// TopMenuinfo menu = it.next();
		// if (topTaskMenu.getMenuId().equals(menu.getMenuCode())) {
		// menu.setChecked(true);//如果用户拥有该菜单权限，设置菜单标志为"true"
		// }
		//
		// }
		// }

		List<TopMenuinfo> list = new ArrayList<TopMenuinfo>();// 经过处理后的菜单
		for (TopMenuinfo topMenuinfo : menulist) {
			if ("YBT".equals(topMenuinfo.getUpMenuCode())) {// 一级菜单
				List<TopMenuinfo> lists = iteratorMenus(menulist, topMenuinfo.getMenuCode());
				topMenuinfo.setMenulist(lists);// 将子菜单放入到当前的一级菜单中
				list.add(topMenuinfo);
			}
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("menuCode", "id").replaceAll("menuName", "text")
				.replaceAll("menuUrl", "url").replaceAll("icon", "icon").replaceAll("menulist", "menus");
		resultTree = jsonString;// 给result赋值，传递给页面
		log.info(resultTree);
		return resultTree;
	}

	public String getResultTree() {
		return resultTree;
	}

	public void setResultTree(String resultTree) {
		this.resultTree = resultTree;
	}

	// 递归菜单
	private static List<TopMenuinfo> iteratorMenus(List<TopMenuinfo> menuList, String pid) {
		List<TopMenuinfo> result = new ArrayList<TopMenuinfo>();
		for (TopMenuinfo menuVo : menuList) {
			String menuid = menuVo.getMenuCode();// 获取菜单的id
			String parentid = menuVo.getUpMenuCode();// 获取菜单的父id
			if (StringUtils.isNotBlank(parentid) && !"YBT".equals(parentid)) {
				if (parentid.equals(pid)) {
					List<TopMenuinfo> iterateMenu = iteratorMenus(menuList, menuid);
					menuVo.setMenulist(iterateMenu);
					result.add(menuVo);
				}
			}
		}
		return result;
	}
}
