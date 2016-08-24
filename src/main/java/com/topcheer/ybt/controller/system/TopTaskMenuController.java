package com.topcheer.ybt.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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
import com.google.gson.Gson;
import com.topcheer.ybt.entity.system.TopMenuinfo;
import com.topcheer.ybt.entity.system.TopTaskMenu;
import com.topcheer.ybt.entity.system.TopUserRole;
import com.topcheer.ybt.service.system.ITopMenuinfoService;
import com.topcheer.ybt.service.system.ITopTaskMenuService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;


 
@Controller
@RequestMapping("/topTaskMenu")
public class TopTaskMenuController {
	private static Logger log = LoggerFactory.getLogger(TopTaskMenuController.class);
	@Autowired
	private ITopTaskMenuService topTaskMenuService;
	
	@Autowired
	private ITopMenuinfoService iTopMenuinfoService;
	
	@RequestMapping("/getTopTaskMenuList.do")
	@ResponseBody
	public PageInfo getTopTaskMenuList(String rows,
			String page, TopTaskMenu topTaskMenu) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topTaskMenu", topTaskMenu);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopTaskMenu> searchTopTaskMenu = topTaskMenuService
				.searchTopTaskMenu(map);
		return searchTopTaskMenu;
		
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopTaskMenu topTaskMenu,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topTaskMenuService.insert(topTaskMenu);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopTaskMenu topTaskMenu,BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topTaskMenuService.update(topTaskMenu);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topTaskMenuService.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}

	@RequestMapping(value="/oper.do")
	@ResponseBody
	public Map<String,Object> oper(@Valid TopTaskMenu topTaskMenu,BindingResult result,HttpServletRequest request){
		String oper = request.getParameter("oper");
		if("add".equals(oper)){
			return this.insert(topTaskMenu, result, request);
		}else if("edit".equals(oper)){
			return this.update(topTaskMenu, result,request);
		}else if("del".equals(oper)){
			return this.delete(request);
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/rolemenu.do", method = RequestMethod.POST)
	public  Map<String, Object> rolemenu(TopUserRole topUserRole) {
		
		List<TopMenuinfo> menulist = iTopMenuinfoService.searchAll();//所有菜单
		List<TopTaskMenu> roleMenus = topTaskMenuService.searchByRoleId(topUserRole.getRoleId());//当前用户拥有的菜单
		for (TopTaskMenu topTaskMenu : roleMenus) {
			for (Iterator<TopMenuinfo> it = menulist.iterator(); it.hasNext();) {
				TopMenuinfo menu = it.next();
				if (topTaskMenu.getMenuId().equals(menu.getMenuCode())) {
					menu.setChecked(true);//如果用户拥有该菜单权限，设置菜单标志为"true"
				}
				
			}
		}
		
		List<TopMenuinfo> list = new ArrayList<TopMenuinfo>();//经过处理后的菜单
		for (TopMenuinfo topMenuinfo : menulist) {
			if ("0".equals(topMenuinfo.getFaMenuCode())) {//一级菜单
				List<TopMenuinfo> lists = iteratorMenus(menulist,topMenuinfo.getMenuCode());
				topMenuinfo.setMenulist(lists);//将子菜单放入到当前的一级菜单中
				list.add(topMenuinfo);
			}
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list).replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("menulist", "nodes");
		System.out.println(jsonString);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("menulist", jsonString);
		return map;
		
		
		//return ResultHelper.RESULT_SUCC;
	}
	
	//递归菜单
	private static List<TopMenuinfo> iteratorMenus(List<TopMenuinfo> menuList,String pid){
		List<TopMenuinfo> result = new ArrayList<TopMenuinfo>();  
        for (TopMenuinfo menuVo : menuList) {  
            String menuid = menuVo.getMenuCode();//获取菜单的id  
            String parentid = menuVo.getFaMenuCode();//获取菜单的父id  
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
	public  Map<String, Object> updaterolemenu(TopTaskMenu topTaskMenu) {
		String roleId = topTaskMenu.getRoleId();//角色编码
		
		int deleteByRoleId = 0;
		try {
			deleteByRoleId = topTaskMenuService.deleteByRoleId(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除菜单出现异常", e);
			throw new RuntimeException();
		}
		log.info("成功删除："+roleId+"角色"+deleteByRoleId+"条菜单");
		String ids = topTaskMenu.getMenuId();//菜单id
		String[] strs = ids.split("\\,");
		int num = 0;
		for (String str : strs) {
			TopTaskMenu taskMenu = new TopTaskMenu();
			taskMenu.setMenuId(str);//菜单编号
			taskMenu.setRoleId(roleId);//角色编号
			taskMenu.setCreateDate(DateUtil.getCurrentDate());//创建时间
			taskMenu.setUpdateOperator(DateUtil.getCurrentDate());//更新时间
			try {
				topTaskMenuService.insert(taskMenu);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("添加菜单出现异常", e);
				throw new RuntimeException();
			}
			num++;
		}
		log.info("成功增加："+roleId+"角色"+num+"条菜单");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag","success");
		return map;
	}
	
}
