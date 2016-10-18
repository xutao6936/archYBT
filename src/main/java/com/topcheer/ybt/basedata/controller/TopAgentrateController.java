package com.topcheer.ybt.basedata.controller;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopAgentrate;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.service.ITopAgentrateService;
import com.topcheer.ybt.system.biz.ITopBankinfoBiz;
import com.topcheer.ybt.system.entity.TopBankinfo;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * 手续费设置
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topAgentrate")
public class TopAgentrateController {
	private static Logger logger = LoggerFactory
			.getLogger(TopAgentrateController.class);
	@Autowired
	private ITopAgentrateService topAgentrateService;
	private String result;// 返回给页面的List
	@Resource(name = "topInsCorpInfoBizImpl")
	private ITopInsCorpInfoBiz topInsCorpInfoBiz;
	@Resource(name = "topInsPrdInfoBizImpl")
	private ITopInsPrdInfoBiz topInsPrdInfoBiz;
	@Resource(name = "topBankinfoBizImpl")
	private ITopBankinfoBiz topBankinfoBiz;

	@RequestMapping("/turnToInsCommissionInfo.do")
	public String turnToInsCommissionInfo() {
		logger.info("跳转到手续费设置页面");
		return "basedata/commissionInfo";
	}

	@RequestMapping(value = "/getInsCompanyAjax", method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getInsCompanyAjax(HttpServletRequest request) {
		List<TopInsCorpInfo> insCorpList = topInsCorpInfoBiz.searchAll();
		List<TopInsCorpInfo> list = new ArrayList<TopInsCorpInfo>();
		for (TopInsCorpInfo topInsCorpInfo : insCorpList) {
			list.add(topInsCorpInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list)
				.replaceAll("insCorpCode", "insCorpCode")
				.replaceAll("insSimpName", "insSimpName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}

	@RequestMapping(value = "/getInsPrdAjax", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getInsPrdAjax(HttpServletRequest request) {
		logger.info("通过保险公司编码级联查询保险公司产品 ");
		System.out.println(request.getParameter("insCorpCode"));
		String insCorpCode = (String) request.getParameter("insCorpCode");
		List<TopInsprdInfo> list = new ArrayList<TopInsprdInfo>();
		List<TopInsprdInfo> insCorpPrdList = topInsPrdInfoBiz
				.getTopInsPrdInfoListByInsPrdCode(insCorpCode);
		for (TopInsprdInfo topInsprdInfo : insCorpPrdList) {
			list.add(topInsprdInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list)
				.replaceAll("insPrdCode", "insPrdCode")
				.replaceAll("insPrdEnName", "insPrdEnName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}

	@RequestMapping(value = "/getInsPrdByInsPrdCode", method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getInsPrdByInsPrdCode(HttpServletRequest request) {
		logger.info("通过保险产品编码查询保险公司产品手续费信息");
		System.out.println(request.getParameter("insPrdCode"));
		String insPrdCode = (String) request.getParameter("insPrdCode");
		List<TopAgentrate> list = new ArrayList<TopAgentrate>();
		List<TopAgentrate> topAgentrateList = topAgentrateService
				.getInsPrdByInsPrdCode(insPrdCode);
		for (TopAgentrate topAgentrate : topAgentrateList) {
			list.add(topAgentrate);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list)
				.replaceAll("insPrdCode", "insPrdCode")
				.replaceAll("insPrdEnName", "insPrdEnName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}

	@RequestMapping(value = "/getBankInfoAjax.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getBankInfoAjax(HttpServletRequest request) {
		List<TopBankinfo> bankInfoList = topBankinfoBiz.getBankInfoAjax();
		List<TopBankinfo> list = new ArrayList<TopBankinfo>();
		for (TopBankinfo bankInfo : bankInfoList) {
			list.add(bankInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list)
				.replaceAll("bankCode", "bankCode")
				.replaceAll("bankName", "bankName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}

	@RequestMapping(value = "/getCorpPrdInfoAjax.do", method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getCorpPrdInfoAjax(HttpServletRequest request) {
		String insPrdCode = request.getParameter("insPrdCode");
		List<TopInsprdInfo> topInsprdInfoList = topInsPrdInfoBiz
				.getInsPrdInfoByInsPrdCode(insPrdCode);
		List<TopInsprdInfo> list = new ArrayList<TopInsprdInfo>();
		for (TopInsprdInfo topInsprdInfo : topInsprdInfoList) {
			list.add(topInsprdInfo);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list)
				.replaceAll("insPrdCode", "insPrdCode")
				.replaceAll("insPrdEnName", "insPrdEnName");
		result = jsonString;// 给result赋值，传递给页面
		logger.info(result);
		return result;
	}

	@RequestMapping("/getTopAgentrateList.do")
	@ResponseBody
	public PageInfo getTopAgentrateList(String rows, String page,
			TopAgentrate topAgentrate) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("topAgentrate", topAgentrate);
		map.put("pageSize", rows);
		map.put("pageNo", page);
		PageInfo<TopAgentrate> searchTopAgentrate = topAgentrateService
				.searchTopAgentrate(map);
		return searchTopAgentrate;

	}

	@RequestMapping("/getAgentrateByInsPrdCode.do")
	@ResponseBody
	public PageInfo getAgentrateByInsPrdCode(HttpServletRequest request) {
		String insPrdCode = (String) request.getParameter("insPrdCode");
		PageInfo<TopAgentrate> searchTopAgentrate = topAgentrateService
				.getAgentrateByInsPrdCode(insPrdCode);
		return searchTopAgentrate;

	}

	@RequestMapping(value = "/insertTopAgentrate.do", method = RequestMethod.POST)
	@ResponseBody
	public String insertTopAgentrate(HttpServletRequest request) {
		String result;// 我要返回给页面的内容
		String ds = request.getParameter("postData");
		String insPrdName = request.getParameter("insPrdName");
		System.out.println(ds.toString());
		JSONArray json = JSONArray.fromObject(ds); // 使用net.sf.json.JSONObject对象来解析json
		JSONObject jsonOne;
		TopAgentrate topAgentrate = new TopAgentrate();
		String reg1 = ".*年.*"; // 判断字符串中是否含有特定字符串"年"
		String reg2 = ".*周岁.*"; // 判断字符串中是否含有特定字符串"周岁"
		String reg3 = ".*终生.*"; // 判断字符串中是否含有特定字符串"终生"
		String reg4 = ".*趸缴.*"; // 判断字符串中是否含有特定字符串"终生"
		//根据保险产品代码删除费率表中的保险产品费率信息
		topAgentrateService.deleteByInsprdCode(insPrdName.split("-")[0]);
		for (int i = 0; i < json.size(); i++) {
			jsonOne = json.getJSONObject(i);
			// 只保留不为空的
			if ("".equals((String) jsonOne.get("percentAmt"))
					&& "".equals((String) jsonOne.get("onceAmt"))) {
				continue;
			}else{
				topAgentrate.setId(UUID.randomUUID().toString()
						.replace("-", ""));// id
				topAgentrate.setInsprdCode(((String) jsonOne.get("insPrdName"))
						.split("-")[0]);// 产品编码
				topAgentrate.setAdminBank((String) jsonOne.get("bankcode"));// 机构
				topAgentrate.setTransType((String) jsonOne.get("transType"));// 交易类型
			
				String str = (String) jsonOne.get("payPeriod");
				if (str.matches(reg1)) {
					topAgentrate.setPayPeriod(str.split("年")[0]);// 缴费年期
					topAgentrate.setPayPeriodType("0");// 缴费年期单位
					topAgentrate.setPayType("5");// 缴费类型(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)
				}
				if (str.matches(reg2)) {
					topAgentrate.setPayPeriod(str.split("周岁")[0]);// 缴费年期
					topAgentrate.setPayPeriodType("1");// 缴费年期单位
				}
				if (str.matches(reg3)) {
					topAgentrate.setPayPeriod("2");// 缴费年期
					topAgentrate.setPayPeriodType("2");// 缴费年期单位
				}
				if (str.matches(reg4)) {
					topAgentrate.setPayPeriod("");// 缴费年期
					topAgentrate.setPayPeriodType("");// 缴费年期单位
					topAgentrate.setPayType("1");// 缴费类型(1:趸缴    2:月缴  3:季缴  4:半年缴    5:年缴)
				}
				
				topAgentrate.setRateType((String) jsonOne.get("chargeMethod"));// 收费方式
				topAgentrate.setOnceAmt((String) jsonOne.get("onceAmt"));// 一次性收费金额
				topAgentrate.setPercentAmt((String) jsonOne.get("percentAmt"));// 百分比收费比例
				String insPeriod = (String) jsonOne.get("insPeriod");
				if (insPeriod.matches(reg1)) {
					topAgentrate.setInsPeriod(insPeriod.split("年")[0]);// 保障年期
					topAgentrate.setInsPeriodType("0");// 保障年期单位
				}
				if (insPeriod.matches(reg2)) {
					topAgentrate.setInsPeriod(insPeriod.split("周岁")[0]);// 保障年期
					topAgentrate.setInsPeriodType("1");// 保障年期单位
				}
				if (insPeriod.matches(reg3)) {
					topAgentrate.setInsPeriod("2");// 保障年期
					topAgentrate.setInsPeriodType("2");// 保障年期单位
				}
				topAgentrate.setOperator("");
				topAgentrate.setOperatorBank("");
				topAgentrate.setUpdateDate(DateUtil.getCurrentDate());
				topAgentrate.setUpdateTime(DateUtil.getCurrentTime());
				//插入保险产品费率信息
				topAgentrateService.insert(topAgentrate);
			}
		}
		Gson gson = new Gson();
		Map<String, Object> map = Maps.newHashMap();
		map.put("msg", ResultHelper.RESULT_SUCC);
		result = gson.toJson(map);
		return result;
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(@Valid TopAgentrate topAgentrate,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topAgentrateService.insert(topAgentrate);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid TopAgentrate topAgentrate,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topAgentrateService.update(topAgentrate);
		return ResultHelper.getResultMap();
	}

	@RequestMapping(value = "/delete.do")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if (ids != null) {
			for (String string : ids) {
				topAgentrateService.delete(string);
			}
		}
		return ResultHelper.getResultMap();

	}

}
