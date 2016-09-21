package com.topcheer.ybt.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topcheer.ybt.entity.system.TopMenuInfoForSelect2;
import com.topcheer.ybt.service.system.ISelect2Service;

@Controller
@RequestMapping(value = "/select2")
public class Select2Controller {
	private static Logger logger = LoggerFactory.getLogger(Select2Controller.class);
	
	@Autowired
	private ISelect2Service iSelect2Service;

	@ResponseBody
	@RequestMapping(value = "/getMenuListForSelect2.do", method = RequestMethod.POST)
	public List<TopMenuInfoForSelect2> getMenuList() {
		logger.info("getMenuListForSelect2.do  进入getMenuList");
		List<TopMenuInfoForSelect2> searchMenuinfo = iSelect2Service.searchAll();
		return searchMenuinfo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMenuListSelect2ForWhere.do", method = RequestMethod.POST)
	public List<TopMenuInfoForSelect2> getMenuListSelect2ForWhere(TopMenuInfoForSelect2 topMenuInfoForSelect2) {
		logger.info("getMenuListSelect2ForWhere.do  进入getMenuList");
		
		List<TopMenuInfoForSelect2> searchMenuinfo = iSelect2Service.searchWhere(topMenuInfoForSelect2);
		return searchMenuinfo;
	}
}
