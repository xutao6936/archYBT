package com.topcheer.ybt.basedata.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topInsCorpInfo")
public class TopInsCorpInfoController {
	private static Logger log = LoggerFactory.getLogger(TopInsCorpInfoController.class);
	@Resource(name = "topInsCorpInfoBizImpl")
	private ITopInsCorpInfoBiz topInsCorpInfoBiz;

	@RequestMapping("/turnToJsp.do")
	public String turnToJsp() {
		return "basedata/insCorpInfo";
	}

	/**
	 * 查询保险公司信息
	 * 
	 * @return
	 */
	@RequestMapping("/getTopInsCorpInfoList.do")
	@ResponseBody
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList() {

		log.info("进入 getTopInsCorpInfoList");
		PageInfo<TopInsCorpInfo> searchTopInsCorpInfo = topInsCorpInfoBiz.getTopInsCorpInfoList();
		return searchTopInsCorpInfo;
	}

	/**
	 * 根据保险公司编码查询保险公司信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getInsCorpByInsCorpCode.do")
	@ResponseBody
	public PageInfo<TopInsCorpInfo> getInsCorpByInsCorpCode(@Valid TopInsCorpInfo topInsCorpInfo, BindingResult result,
			HttpServletRequest request) {
		log.info("进入getInsCorpByInsCorpCode " );
		PageInfo<TopInsCorpInfo> pageinfo = topInsCorpInfoBiz.getInsCorpByinsCorpCode(topInsCorpInfo);
		return pageinfo;
	}

	/**
	 * 判断新增还是编辑操作
	 * 
	 * @param topInsCorpInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oper.do")
	@ResponseBody
	public Map<String, Object> oper(@Valid TopInsCorpInfo topInsCorpInfo, BindingResult result,
			HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insert(topInsCorpInfo, result, request);
		} else if ("edit".equals(oper)) {
			return this.update(topInsCorpInfo, result, request);
		}
		return null;
	}

	@RequestMapping(value = "/insertTopInsCorpInfo.do", method = RequestMethod.POST)
	@ResponseBody
	/**
	 * 新增数据
	 * @param topInsCorpInfo
	 * @param result
	 * @param request
	 * @return
	 */
	public Map<String, Object> insert(@Valid TopInsCorpInfo topInsCorpInfo, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		log.info("进入insertTopInsCorpInfo");
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topInsCorpInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		topInsCorpInfo.setOperatorBank(userinfo.getUserDept());
		topInsCorpInfo.setOperatorCode(userinfo.getLoginAccount());
		topInsCorpInfo.setCreateDate(DateUtil.getCurrentDate());
		topInsCorpInfo.setUpdateDate(DateUtil.getCurrentDate());
		topInsCorpInfo.setUpdateTime(DateUtil.getCurrentTime());
		try {
			topInsCorpInfoBiz.insertTopInsCorpInfo(topInsCorpInfo);
			return ResultHelper.getResultMap();
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error("插入保险公司错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "插入保险公司信息错误");
			return resultMap;

		}
	}

	/**
	 * 更新数据
	 * 
	 * @param topInsCorpInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateTopInsCorpInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopInsCorpInfo topInsCorpInfo, BindingResult result,
			HttpServletRequest request) {
		log.info("进入updateTopInsCorpInfo");
		if (result.hasErrors()) {
			log.info("111" + result.getAllErrors());
			return ResultHelper.analyzeError(result);
		}

		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topInsCorpInfo.setOperatorBank(userinfo.getUserDept());
		topInsCorpInfo.setOperatorCode(userinfo.getLoginAccount());
		topInsCorpInfo.setCreateDate(DateUtil.getCurrentDate());
		topInsCorpInfo.setUpdateDate(DateUtil.getCurrentDate());
		topInsCorpInfo.setUpdateTime(DateUtil.getCurrentTime());
		try {
			topInsCorpInfoBiz.updateTopInsCorpInfo(topInsCorpInfo);
			return ResultHelper.getResultMap();
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error("更新保险公司错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "更新保险公司信息错误");
			return resultMap;

		}
	}

	/**
	 * 删除信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteTopInsCorpInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		log.info("进入 deleteTopInsCorpInfo");
		String[] ids = request.getParameterValues("ids[]");
		log.info("string" + ids);
		if (ids != null) {
			try {
				for (String string : ids) {
					topInsCorpInfoBiz.deletetTopInsCorpInfo(string);
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
				log.error("删除保险公司错误", e);
				Map<String, Object> resultMap = ResultHelper.getErrResultMap();
				resultMap.put(ResultHelper.ERR_INFO, "删除保险公司错误");
				return resultMap;

			}
		}
		return ResultHelper.getResultMap();

	}

	/**
	 * 下载模板
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/download.do")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		request.setCharacterEncoding("UTF-8");
		String rootpath = request.getSession().getServletContext().getRealPath("/");
		try {
			File f = new File(rootpath + "template/" + ResultHelper.INSCORP_TEMPLATE);
			response.setContentType("application/x-msdownload;charset=UTF-8");
			String s = "attachment; filename=" + ResultHelper.INSCORP_TEMPLATE;
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