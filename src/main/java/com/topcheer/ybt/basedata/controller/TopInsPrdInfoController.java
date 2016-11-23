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
import com.google.common.collect.Maps;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topInsprdInfo")
public class TopInsPrdInfoController {
	private static Logger log = LoggerFactory.getLogger(TopInsPrdInfoController.class);

	@Resource(name = "topInsPrdInfoBizImpl")
	private ITopInsPrdInfoBiz topInsPrdInfoBiz;
	
	@RequestMapping("/insPrdInfo.do")
	public String turnToJsp() {
		return "basedata/insPrdInfo";
	}
	
	/**
	 * 查询保险产品信息
	 * 
	 * @return
	 */
	@RequestMapping("getTopInsPrdInfoList.do")
	@ResponseBody
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoList(String rows, String page,TopInsprdInfo topInsprdInfo) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topInsprdInfo", topInsprdInfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopInsprdInfo> topInsprdInfoList = topInsPrdInfoBiz.getTopInsPrdInfoList(map);
		return topInsprdInfoList;
	}
	
	/**
	 * 根据条件查询保险产品信息
	 * 
	 * @return
	 */
	@RequestMapping("/getTopInsPrdInfoListByParams.do")
	@ResponseBody
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoListByParams(String rows, String page,HttpServletRequest request) {

		log.info("进入 getTopInsPrdInfoListByParams");
		Map<String, String> map = Maps.newHashMap();
		log.info("insPrdCode:"+request.getParameter("insPrdCode"));
		map.put("insPrdCode", request.getParameter("insPrdCode"));
		map.put("insPrdTrueCode", request.getParameter("insPrdTrueCode"));
		map.put("insCorpCode", request.getParameter("insCorpCode"));
		map.put("insPrdCnName", request.getParameter("insPrdCnName"));
		map.put("insPrdSimName", request.getParameter("insPrdSimName"));
		map.put("insPrdType", request.getParameter("insPrdType"));
		map.put("assuranceType", request.getParameter("assuranceType"));
		map.put("buyUnit", request.getParameter("buyUnit"));
		map.put("status", request.getParameter("status"));
		map.put("insBeginDate", request.getParameter("insBeginDate"));
		map.put("insEndDate", request.getParameter("insEndDate"));
		map.put("impawnFlag", request.getParameter("impawnFlag"));
		map.put("transType", request.getParameter("transType"));
		map.put("channelFlag", request.getParameter("channelFlag"));
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopInsprdInfo> searchTopInsCorpInfo = topInsPrdInfoBiz.getTopInsPrdInfoListByParams(map);
		return searchTopInsCorpInfo;
	}

	/**
	 * 根据保险产品编码查询相关信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("getInsprdByInsPrdCode.do")
	@ResponseBody
	public PageInfo<TopInsprdInfo> getTopinsPrdInfoByInsPrdCode(HttpServletRequest request) {
		String insPrdCode = request.getParameter("insPrdCode");
		PageInfo<TopInsprdInfo> topInsprdInfoList = topInsPrdInfoBiz.getTopInsPrdInfoByInsPrdCode(insPrdCode);
		return topInsprdInfoList;
	}

	/**
	 * 判断新增或编辑功能
	 * 
	 * @param TopInsprdInfo
	 * @param result
	 * @param request
	 * @return
	 */
	//@RequestMapping("oper.do")
//	@ResponseBody
/*	public Map<String, Object> oper(@Valid TopInsprdInfo TopInsprdInfo, BindingResult result, HttpServletRequest request) {
		String oper = request.getParameter("oper");
		if ("add".equals(oper)) {
			return this.insertTopInsPrdInfoList(TopInsprdInfo, result, request);
		} else if ("edit".equals(oper)) {
			return this.updateTopInsPrdInfoList(TopInsprdInfo, result, request);
		}
		return null;
	}*/
	
	@RequestMapping(value = "/insertTopInsPrdInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertTopInsPrdInfoList(@Valid TopInsprdInfo topInsprdInfo, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		log.info("进入insertTopInsprdInfo");
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topInsprdInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		topInsprdInfo.setOperator(userinfo.getLoginAccount());
		topInsprdInfo.setCreateDate(DateUtil.getCurrentDate());
		try {
			topInsPrdInfoBiz.insertTopInsPrdInfo(topInsprdInfo);
			return ResultHelper.getResultMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("插入保险产品错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "插入保险产品信息错误");
			return resultMap;
		}
	}
	@RequestMapping(value = "/updateTopInsPrdInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTopInsPrdInfoList(@Valid TopInsprdInfo topInsprdInfo, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		log.info("进入insertTopInsprdInfo"+topInsprdInfo.getInsCorpCode()+"**********"+topInsprdInfo.getId());
		TopUserinfo userinfo = (TopUserinfo) request.getSession().getAttribute("userinfo");
		topInsprdInfo.setOperator(userinfo.getLoginAccount());
		topInsprdInfo.setUpdateTime(DateUtil.getCurrentTime());
		topInsprdInfo.setUpdateDate(DateUtil.getCurrentDate());
		try {
			topInsPrdInfoBiz.updateTopInsPrdInfo(topInsprdInfo);
			return ResultHelper.getResultMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("更新保险产品错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "更新保险产品信息错误");
			return resultMap;
		}
	}

	@RequestMapping("deleteTopInsPrdInfo.do")
	@ResponseBody
	public Map<String, Object> deleteTopInsPrdInf(HttpServletRequest request) {
		log.info("进入 deleteTopInsCorpInfo");
		String[] ids = request.getParameterValues("ids[]");
		log.info("string" + ids);
		if (ids != null) {
			try {
				for (String string : ids) {
					topInsPrdInfoBiz.deleteTopInsPrdInfo(string);
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
				log.error("删除保险产品信息错误", e);
				Map<String, Object> resultMap = ResultHelper.getErrResultMap();
				resultMap.put(ResultHelper.ERR_INFO, "删除保险产品信息错误");
				return resultMap;

			}
		}
		return ResultHelper.getResultMap();

	}

	@RequestMapping(value = "/download.do")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		request.setCharacterEncoding("UTF-8");
		String rootpath = request.getSession().getServletContext().getRealPath("/");
		try {
			File f = new File(rootpath + "template/" + ResultHelper.INSPRD_TEMPLATE);
			response.setContentType("application/x-msdownload;charset=UTF-8");
			String s = "attachment; filename=" + ResultHelper.INSPRD_TEMPLATE;
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
