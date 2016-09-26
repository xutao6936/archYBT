package com.topcheer.ybt.system.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopUserinfoService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.PropertyConfig;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping(value = "/user")
public class TopUserController {
	private static Logger logger = LoggerFactory.getLogger(TopUserController.class);

	@Resource(name = "topUserinfoService")
	private ITopUserinfoService iTopUserinfoService;

	@RequestMapping("/turnToUserList")
	public String userList() {
		return "system/userList";
	}

	@ResponseBody
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
	public String deleteUser(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		for (String string : ids) {
			iTopUserinfoService.delete(string);
		}
		return ResultHelper.RESULT_SUCC;
	}

	@ResponseBody
	@RequestMapping(value = "/getUserList.do")
	public PageInfo<TopUserinfo> getUserList(HttpServletRequest request, String rows, String page, TopUserinfo userInfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("userInfo", userInfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopUserinfo> searchTopUserinfo = iTopUserinfoService.searchTopUserinfo(map);
		return searchTopUserinfo;
	}

	@ResponseBody
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(@Valid TopUserinfo topUserinfo, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			StringBuffer sb = new StringBuffer();
			for (ObjectError objectError : allErrors) {
				sb.append(objectError.getDefaultMessage() + "\n");
			}
			return sb.toString();
		}

		topUserinfo.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		topUserinfo.setCreateDate(DateUtil.getCurrentDate());
		topUserinfo.setUpdateDate(DateUtil.getCurrentDate());
		topUserinfo.setUpdateTime(DateUtil.getCurrentTime());
		topUserinfo.setUserStatus(ResultHelper.YES);
		topUserinfo.setUserStatus(ResultHelper.YES);
		iTopUserinfoService.insert(topUserinfo);
		return ResultHelper.RESULT_SUCC;
	}

	@ResponseBody
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public Map<String, Object> upload(@RequestParam("filePath") CommonsMultipartFile[] files, HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String realPath = PropertyConfig.getContextProperty("user.path");
		String filePath = "";
		String dbfilepath = null;
		for (MultipartFile myfile : files) {
			if (myfile.isEmpty()) {
				logger.info("没有上传的文件");
			} else {
				try {
					System.out.println(request.getSession().getServletContext().getRealPath(File.separator));
					String filedir = request.getSession().getServletContext().getRealPath(File.separator) + realPath;// 文件夹路径
					File fileDir = new File(filedir);
					if (!fileDir.exists()) {
						fileDir.mkdirs();
					}
					filePath = filedir + myfile.getOriginalFilename();
					dbfilepath = realPath + myfile.getOriginalFilename();
					myfile.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// FileUtils.copyInputStreamToFile(myfile.getInputStream(), new
				// File(realPath, myfile.getOriginalFilename()));
			}
		}
		TopUserinfo topUserinfo = new TopUserinfo();
		topUserinfo.setUserId(userId);
		topUserinfo.setFilePath(dbfilepath);
		try {
			iTopUserinfoService.uploadPath(topUserinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> result = Maps.newHashMap();
		result.put("flag", ResultHelper.RESULT_SUCC);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@Valid TopUserinfo topUserinfo, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			StringBuffer sb = new StringBuffer();
			for (ObjectError objectError : allErrors) {
				sb.append(objectError);
			}
			return sb.toString();
		}
		topUserinfo.setUpdateDate(DateUtil.getCurrentDate());
		topUserinfo.setUpdateTime(DateUtil.getCurrentTime());
		topUserinfo.setUserStatus(ResultHelper.YES);
		topUserinfo.setUserStatus(ResultHelper.YES);
		iTopUserinfoService.update(topUserinfo);
		return ResultHelper.RESULT_SUCC;
	}

}
