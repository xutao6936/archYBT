package com.topcheer.ybt.query.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户权限查询
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topUserPermission")
public class UserPermissionController {
	private static Logger logger = LoggerFactory
			.getLogger(UserPermissionController.class);
	
	@RequestMapping("/turnToUserPermissionInfo.do")
	public String turnToUserPermissionInfo() {
		logger.info("跳转到用户权限查询页面");
		return "query/userPermissionInfo";
	}
}