package com.topcheer.ybt.basedata.controller;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.topcheer.ybt.basedata.biz.ITopInsPrdPeriodInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.util.ResultHelper;

@Controller
@RequestMapping("/topInsPrdPeriodInfo")
public class TopInsPrdPeriodInfoController {
	private static Logger log = LoggerFactory.getLogger(TopInsPrdPeriodInfoController.class);

	@Resource(name = "topInsPeriodInfoBizImpl")
	private ITopInsPrdPeriodInfoBiz topInsPrdPeriodInfoBiz;
	
	/**
	 * 查询保障年期
	 * @return
	 */
	@RequestMapping("getTopInsPrdPeriodInfoList.do")
	@ResponseBody
	public PageInfo<TopInsPrdPeriodInfo> getTopInsPrdPeriodInfoList(String rows, String page,TopInsPrdPeriodInfo topInsPrdPeriodInfo,HttpServletRequest request) {
		//String insprdCode = request.getParameter("insPrdCode");
		Map<String, Object> map = Maps.newHashMap();
		map.put("topInsPrdPeriodInfo", topInsPrdPeriodInfo);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		log.info("进入保障年期基本信息查询");
		PageInfo<TopInsPrdPeriodInfo> topInsPrdPeriodInfoList = topInsPrdPeriodInfoBiz.getInsPrdPeriodAllList(map);
		return topInsPrdPeriodInfoList;
	}
	
	
	/**
	 *新增保障年期信息
	 * @return
	 */
	@RequestMapping("insertTopInsPrdPeriodInfo.do")
	@ResponseBody
	public Map<String, Object>  insertTopInsPrdPeriodInfoList(@Valid TopInsPrdPeriodInfo topInsPrdPeriodInfo, BindingResult result,
			HttpServletRequest request) {
		log.info("进入保障年期基本信息插入");
		topInsPrdPeriodInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		try {
			 topInsPrdPeriodInfoBiz.insertInsPrdPeriod(topInsPrdPeriodInfo);
			return ResultHelper.getResultMap();
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error("插入保障年期信息错误", e);
			Map<String, Object> resultMap = ResultHelper.getErrResultMap();
			resultMap.put(ResultHelper.ERR_INFO, "插入保障年期信息错误");
			return resultMap;
		}
	}
	
		@RequestMapping(value = "/updateTopInsPrdPeriodInfo.do", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> updateTopInsPrdPeriodInfo(@Valid  TopInsPrdPeriodInfo topInsPrdPeriodInfo, BindingResult result,
				HttpServletRequest request) {
			log.info("进入updateTopInsCorpInfo");
			if (result.hasErrors()) {
				return ResultHelper.analyzeError(result);
			}
			try {
				topInsPrdPeriodInfoBiz.updateInsPrdPeriod(topInsPrdPeriodInfo);
				return ResultHelper.getResultMap();
			} catch (DataAccessException e) {
				e.printStackTrace();
				log.error("更新保障年期错误", e);
				Map<String, Object> resultMap = ResultHelper.getErrResultMap();
				resultMap.put(ResultHelper.ERR_INFO, "更新更新保障年期信息错误");
				return resultMap;

			}
		}
		
		@RequestMapping(value = "/deleteTopInsPrdPeriodInfo.do", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> deleteTopInsPrdPeriodInfo(HttpServletRequest request) {
			log.info("进入 deleteTopInsPrdPeriodInfo");
			String[] ids = request.getParameterValues("ids[]");
			log.info("string" + ids);
			if (ids != null) {
				try {
					for (String string : ids) {
						topInsPrdPeriodInfoBiz.deleteInsPrdPeriod(string);
					}
				} catch (DataAccessException e) {
					e.printStackTrace();
					log.error("删除 保障年期错误", e);
					Map<String, Object> resultMap = ResultHelper.getErrResultMap();
					resultMap.put(ResultHelper.ERR_INFO, "删除保障年期错误");
					return resultMap;

				}
			}
			return ResultHelper.getResultMap();
		}

	
}
