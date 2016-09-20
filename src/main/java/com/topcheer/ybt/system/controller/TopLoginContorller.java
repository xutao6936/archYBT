package com.topcheer.ybt.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopUserinfoService;
import com.topcheer.ybt.util.ResultHelper;

/**
 * @ClassName: LoginContorller
 * @Description: 登录专用
 * @author XUTAO
 * @date 2016-6-1 下午08:41:09
 * 
 */
@Controller
@RequestMapping(value = "/login")
public class TopLoginContorller {

	private static Logger log = LoggerFactory.getLogger(TopLoginContorller.class);
	@Resource(name = "topUserinfoService")
	ITopUserinfoService service;

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		log.info("跳转至登录界面");
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginForm(@RequestParam(value = "loginAccount") String loginAccount,
			@RequestParam(value = "pwd") String pwd, Model model, HttpServletRequest request) {
		if (Strings.isNullOrEmpty(loginAccount) || Strings.isNullOrEmpty(pwd)) {
			model.addAttribute("error", ResultHelper.LOGIN_ERROR);
			return "login";
		}
		log.info("用户登录用户名{},密码{}", new String[] { loginAccount, pwd });
		Map<String, Object> map = Maps.newHashMap();
		TopUserinfo userInfo = new TopUserinfo();
		userInfo.setLoginAccount(loginAccount);
		userInfo.setLoginPwd(pwd);
		map.put("userInfo", userInfo);
		List<TopUserinfo> list = service.searchTopUserForLogin(map);
		if ((null != list) && (list.size() > 0)) {
			TopUserinfo userinfo = list.get(0);
			request.getSession().setAttribute("userinfo", userinfo);
			return "index";
		} else {
			model.addAttribute("error", ResultHelper.LOGIN_ERROR);
			return "login";
		}
	}

	@RequestMapping(value = "/logout.do")
	public String loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		log.info("登出系统");
		return "login";
	}

}
