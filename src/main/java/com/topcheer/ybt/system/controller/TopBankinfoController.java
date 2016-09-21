package com.topcheer.ybt.system.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.topcheer.ybt.system.biz.ITopBankinfoBiz;
import com.topcheer.ybt.system.entity.TopBankinfo;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topBankinfo")
public class TopBankinfoController {
	private static Logger log = LoggerFactory.getLogger(TopBankinfoController.class);
	@Resource(name = "topBankinfoBizImpl")
	private ITopBankinfoBiz topBankinfoBiz;

	@RequestMapping("/turnToJsp.do")
	public String turnToJsp() {
		return "system/bankinfo";
	}

	@RequestMapping("/getTopBankinfoList.do")
	@ResponseBody
	public PageInfo<TopBankinfo> getTopBankinfoList(String rows, String page, TopBankinfo topBankinfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topBankinfo", topBankinfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		log.info("查询参数为:机构类{},pageSize{},pageNo{}", new String[] { topBankinfo.toString(), rows, page });
		PageInfo<TopBankinfo> searchTopBankinfo = topBankinfoBiz.searchTopBankinfo(map);
		return searchTopBankinfo;

	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(@Valid TopBankinfo topBankinfo, BindingResult result, HttpServletRequest request) {
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		log.info("session为：" + userinfo.toString());
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topBankinfo.setBankId(UUID.randomUUID().toString().replace("-", ""));
		topBankinfo.setCreateDate(DateUtil.getCurrentDate());
		topBankinfo.setUpdateDate(DateUtil.getCurrentDate());
		topBankinfo.setUpdateTime(DateUtil.formatTime(new Date()));
		log.info("插入参数为:机构类{}", new String[] { topBankinfo.toString() });
		try {
			topBankinfoBiz.insert(topBankinfo);
			return ResultHelper.getResultMap();
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error("插入机构错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "插入机构错误");
			return resultMap;

		}
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopBankinfo topBankinfo, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topBankinfo.setUpdateDate(DateUtil.getCurrentDate());
		topBankinfo.setUpdateTime(DateUtil.formatTime(new Date()));
		log.info("更新参数为:机构类{}", new String[] { topBankinfo.toString() });
		try {
			topBankinfoBiz.update(topBankinfo);
			return ResultHelper.getResultMap();
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error("更新机构错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "更新机构错误");
			return resultMap;

		}
	}

	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		log.info("删除机构 ids为{}", ids);
		if (ids != null) {
			try {
				for (String string : ids) {
					topBankinfoBiz.delete(string);
				}
				return ResultHelper.getResultMap();
			} catch (DataAccessException e) {
				e.printStackTrace();
				log.error("插入机构错误", e);
				Map<String, Object> resultMap = ResultHelper.getErrResultMap();
				resultMap.put(ResultHelper.ERR_INFO, "插入机构错误");
				return resultMap;

			}
		}
		return ResultHelper.getResultMap();

	}

	@RequestMapping(value = "/oper.do")
	@ResponseBody
	public Map<String, Object> oper(@Valid TopBankinfo topBankinfo, BindingResult result, HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insert(topBankinfo, result, request);
		} else if ("edit".equals(oper)) {
			return this.update(topBankinfo, result, request);
		} else if ("del".equals(oper)) {
			return this.delete(request);
		}
		return null;
	}

	@RequestMapping(value = "/download.do")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		request.setCharacterEncoding("UTF-8");
		String rootpath = request.getSession().getServletContext().getRealPath("/");
		try {
			File f = new File(rootpath + "template/" + ResultHelper.BANK_TEMPLATE);
			response.setContentType("application/x-msdownload;charset=UTF-8");
			String s = "attachment; filename=" + ResultHelper.BANK_TEMPLATE;
			response.setHeader("Content-Disposition", new String(s.getBytes(), "ISO-8859-1"));
			in = new BufferedInputStream(new FileInputStream(f));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] data = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(data, 0, data.length))) {
				out.write(data, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}

}
