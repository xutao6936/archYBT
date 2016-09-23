package com.topcheer.ybt.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.entity.TopMenuRole;
import com.topcheer.ybt.system.entity.TopMenuinfo;
import com.topcheer.ybt.system.service.ITopMenuRoleService;
import com.topcheer.ybt.system.service.ITopMenuinfoService;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;
import com.google.gson.Gson;



 
@Controller
@RequestMapping("/topMenuRole")
public class TopMenuRoleController {
	private static Logger log = LoggerFactory.getLogger(TopMenuRoleController.class);
	@Resource(name="topMenuRoleService")
	private ITopMenuRoleService iTopMenuRoleService;
	
	@Resource(name="topMenuinfoService")
	private ITopMenuinfoService iTopMenuinfoService;
	
	@RequestMapping("/getTopMenuRoleList.do")
	@ResponseBody
	public PageInfo<TopMenuRole> getTopMenuRoleList(String rows,
			String page, TopMenuRole topMenuRole) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topMenuRole", topMenuRole);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopMenuRole> searchTopMenuRole = iTopMenuRoleService.searchTopMenuRole(map);
		return searchTopMenuRole;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopMenuRole topMenuRole,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		iTopMenuRoleService.insert(topMenuRole);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopMenuRole topMenuRole,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		iTopMenuRoleService.update(topMenuRole);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  iTopMenuRoleService.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}

	@RequestMapping(value="/oper.do")
	@ResponseBody
	public Map<String,Object> oper(@Valid TopMenuRole topMenuRole,BindingResult result,HttpServletRequest request){
		String oper = request.getParameter("oper");
		if("add".equals(oper)){
			return this.insert(topMenuRole, result, request);
		}else if("edit".equals(oper)){
			return this.update(topMenuRole, result,request);
		}else if("del".equals(oper)){
			return this.delete(request);
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/menuRole.do", method = RequestMethod.POST)
	public  Map<String, Object> rolemenu(TopMenuRole topMenuRole) {
		
		List<TopMenuinfo> menulist = null;
		try {
			menulist = iTopMenuinfoService.searchAll();//所有菜单
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TopMenuRole> roleMenus = null;
		try {
			roleMenus = iTopMenuRoleService.searchMenuByRoleId(topMenuRole.getRoleId());//当前角色拥有的菜单
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!roleMenus.isEmpty()) {
			for (TopMenuRole rolemenu : roleMenus) {
				for (Iterator<TopMenuinfo> it = menulist.iterator(); it.hasNext();) {
					TopMenuinfo menu = it.next();
					if (rolemenu.getMenuId().equals(menu.getMenuId())) {
						menu.setChecked(true);//如果用户拥有该菜单权限，设置菜单标志为"true"
					}
					
				}
			}
		}
		
		List<TopMenuinfo> list = new ArrayList<TopMenuinfo>();//经过处理后的菜单
		for (TopMenuinfo topMenuinfo : menulist) {
			if ("0".equals(topMenuinfo.getUpMenuCode())) {//一级菜单
				List<TopMenuinfo> lists = iteratorMenus(menulist,topMenuinfo.getMenuCode());
				topMenuinfo.setMenulist(lists);//将子菜单放入到当前的一级菜单中
				list.add(topMenuinfo);
			}
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("menulist", "nodes");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("menulist", jsonString);
		return map;

	}
	
	//递归菜单
	private static List<TopMenuinfo> iteratorMenus(List<TopMenuinfo> menuList,String pid){
		List<TopMenuinfo> result = new ArrayList<TopMenuinfo>();  
        for (TopMenuinfo menuVo : menuList) {  
            String menuid = menuVo.getMenuCode();//获取菜单的id  
            String parentid = menuVo.getUpMenuCode();//获取菜单的父id  
            if(StringUtils.isNotBlank(parentid) && !"0".equals(parentid)){  
                if(parentid.equals(pid)){  
                    List<TopMenuinfo> iterateMenu = iteratorMenus(menuList,menuid);  
                    menuVo.setMenulist(iterateMenu);  
                    result.add(menuVo);  
                }  
            }  
        }  
        return result; 
	}
	
	@ResponseBody
	@RequestMapping(value = "/updaterolemenu.do", method = RequestMethod.POST)
	public Map<String, Object> updaterolemenu(TopMenuRole topMenuRole) {
		try {
			iTopMenuRoleService.updateMenuByRoleId(topMenuRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag","success");
		return map;
	}

}
