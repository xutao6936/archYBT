package com.topcheer.ybt.basedata.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.topcheer.ybt.basedata.biz.ITopBankAndCorpInfoBiz;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.entity.TopBankAndCorp;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.system.biz.ITopBankinfoBiz;
import com.topcheer.ybt.system.entity.TopBankinfo;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.ResultHelper;

/**
 * 机构绑定保险公司
 * 
 * @author liuc
 * 
 */
@Controller
@RequestMapping("/topBankAndCrop")
public class TopBankAndCropController {
	private static Logger logger = LoggerFactory
			.getLogger(TopBankAndCropController.class);
	@Resource(name = "topBankinfoBizImpl")
	private ITopBankinfoBiz topBankinfoBiz;
	
	@Resource(name = "topInsCorpInfoBizImpl")
	private ITopInsCorpInfoBiz topInsCorpInfoBiz;
	
	@Resource(name = "topBankAndCorpInfoBizImpl")
	private ITopBankAndCorpInfoBiz topBankAndCorpInfoBiz;

	@RequestMapping("/turnToTopBankAndCropInfo.do")
	public String turnToTopBankAndCropInfo() {
		logger.info("跳转到机构绑定保险公司页面");
		return "basedata/bankAndCropInfo";
	}

	private String resultTree;// 我要返回给页面的List

	@RequestMapping(value = "/getBankInfo", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getBankInfo(HttpServletRequest request) {
		List<TopBankinfo> topBankinfolist = topBankinfoBiz.searchAll();

		List<TopBankinfo> list = new ArrayList<TopBankinfo>();// 经过处理后的菜单
		StringBuffer strBuff = new StringBuffer();
		for (TopBankinfo topBankinfo : topBankinfolist) {
			if ("0".equals(topBankinfo.getBankLevel())) {// 一级菜单
				strBuff.append("{'" + topBankinfo.getBankName() + "':"
						+ "{name:'" + topBankinfo.getBankName()
						+ "',type: 'folder'");
				String str = iteratorTopBankinfo(topBankinfolist,
						topBankinfo.getBankCode());
				strBuff.append(str);
			}
		}
		strBuff.deleteCharAt(strBuff.length() - 1);
		strBuff.append("}");
		logger.info(strBuff.toString());
		Gson gson = new Gson();
//		 String string =
//		 "{'总行':{name:'总行',type: 'folder',additionalParameters:{id:'9901',children:{'上海分行':{name:'上海分行',type: 'folder',additionalParameters:{id:'9804',children:{漕河泾支行':{name:'漕河泾支行',type: 'folder',additionalParameters:{id:'9805',children:{田林路支行':{name:'田林路支行',type: 'item',additionalParameters:{id:'9806'}},宜山路支行':{name:'宜山路支行',type: 'item',additionalParameters:{id:'9807'}}}}}}}},'南京分行':{name:'南京分行',type: 'folder',additionalParameters:{id:'9801',children:{雨花台支行':{name:'雨花台支行',type: 'folder',additionalParameters:{id:'9802',children:{雨花南路支行':{name:'雨花南路支行',type: 'item',additionalParameters:{id:'9803'}}}}}}}}}}}}";
//		 String ss =
//		 "{'总行':{name:'总行',type: 'folder',additionalParameters:{id:'9901',children:{'上海分行':{name:'上海分行',type: 'folder',additionalParameters:{id:'9804',children:{漕河泾支行':{name:'漕河泾支行',type: 'folder',additionalParameters:{id:'9805',children:{漕河泾支行':{name:'漕河泾支行',type: 'item',additionalParameters:{id:'9805'}},田林路支行':{name:'田林路支行',type: 'item',additionalParameters:{id:'9806'}},宜山路支行':{name:'宜山路支行',type: 'item',additionalParameters:{id:'9807'}}}}}}}},'南京分行':{name:'南京分行',type: 'folder',additionalParameters:{id:'9801',children:{雨花台支行':{name:'雨花台支行',type: 'folder',additionalParameters:{id:'9802',children:{雨花台支行':{name:'雨花台支行',type: 'item',additionalParameters:{id:'9802'}},雨花南路支行':{name:'雨花南路支行',type: 'item',additionalParameters:{id:'9803'}}}}}}}},'武汉分行':{name:'武汉分行',type: 'folder',additionalParameters:{id:'9808'}}}}}}";

//		 String s =
//		 "{'总行':{name:'总行',type: 'folder',additionalParameters:{id:'9901',children:{'上海分行':{name:'上海分行',type: 'folder',additionalParameters:{id:'9804',children:{漕河泾支行':{name:'漕河泾支行',type: 'folder',additionalParameters:{id:'9805',children:{漕河泾支行':{name:'漕河泾支行',type: 'item',additionalParameters:{id:'9805'}},田林路支行':{name:'田林路支行',type: 'item',additionalParameters:{id:'9806'}},宜山路支行':{name:'宜山路支行',type: 'item',additionalParameters:{id:'9807'}}}}}}}},'南京分行':{name:'南京分行',type: 'folder',additionalParameters:{id:'9801',children:{雨花台支行':{name:'雨花台支行',type: 'folder',additionalParameters:{id:'9802',children:{雨花台支行':{name:'雨花台支行',type: 'item',additionalParameters:{id:'9802'}},雨花南路支行':{name:'雨花南路支行',type: 'item',additionalParameters:{id:'9803'}}}}}}}},'合肥分行':{name:'合肥分行',type: 'folder',additionalParameters:{id:'9808'}},'武汉分行':{name:'武汉分行',type: 'folder',additionalParameters:{id:'9809',children:{光谷支行':{name:'光谷支行',type: 'folder',additionalParameters:{id:'9810',children:{光谷支行':{name:'光谷支行',type: 'item',additionalParameters:{id:'9810'}}}}}}}}}}}}";
		
//		JsonObject returnData = new JsonParser().parse(s)
//				.getAsJsonObject();

		JsonObject returnData = new JsonParser().parse(strBuff.toString())
				.getAsJsonObject();
		String jsonString = gson.toJson(returnData);
		resultTree = jsonString;
		logger.info(resultTree);
		return resultTree;
	}

	public String iteratorTopBankinfo(List<TopBankinfo> topBankinfolist,
			String upBankCode) {
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		stringBuffer.append(",additionalParameters:{id:'" + upBankCode
				+ "',children:{");
		for (int i = 0; i < topBankinfolist.size(); i++) {
			TopBankinfo topBankinfo = topBankinfolist.get(i);
			if ("1".equals(topBankinfo.getBankLevel())) {// 二级机构
				stringBuffer.append("'" + topBankinfo.getBankName()
						+ "':{name:'" + topBankinfo.getBankName()
						+ "',type: 'folder',additionalParameters:{id:'"
						+ topBankinfo.getBankCode() + "'");
				str = getThTopBankinfo(topBankinfo.getBankCode());
				stringBuffer.append(str);
			}
		}
		stringBuffer.deleteCharAt(stringBuffer.length() - 1);
		stringBuffer.append("}}}},");
		stringBuffer.deleteCharAt(stringBuffer.length() - 1);
		return stringBuffer.toString();
	}

	public String getThTopBankinfo(String upBankCode) {
		List list = topBankinfoBiz.getChildrenBankInfo(upBankCode);
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		
		for (int j = 0; j < list.size(); j++) {
			TopBankinfo childBankinfo = (TopBankinfo) list.get(j);
			if ("2".equals(childBankinfo.getBankLevel())) {// 三级机构
				stringBuffer.append(",children:{"+childBankinfo.getBankName()
						+ "':{name:'" + childBankinfo.getBankName()
						+ "',type: 'folder',additionalParameters:{id:'"
						+ childBankinfo.getBankCode() + "'");
				str = getFourTopBankinfo(childBankinfo.getBankCode());
				if(str.contains("additionalParameters")){
					stringBuffer.append(str);
					stringBuffer.append("}}}");
				}
			}
			
		}
		stringBuffer.append("}},");
		return stringBuffer.toString();
	}


	public String getFourTopBankinfo(String upBankCode) {
		List list = topBankinfoBiz.getChildrenBankInfo(upBankCode);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(",children:{");
		for (int j = 0; j < list.size(); j++) {
			TopBankinfo childBankinfo = (TopBankinfo) list.get(j);
				stringBuffer.append(childBankinfo.getBankName() + "':{name:'"
						+ childBankinfo.getBankName()
						+ "',type: 'item',additionalParameters:{id:'"
						+ childBankinfo.getBankCode() + "'}},");

		}
		stringBuffer.deleteCharAt(stringBuffer.length()-1);
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	
	@RequestMapping(value = "/getCorpInfo", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getCorpInfo(HttpServletRequest request) {
		System.out.println("bankCode="+request.getParameter("bankCode"));
		String bankCode = request.getParameter("bankCode");
		List<TopInsCorpInfo> topInsCorpInfolist = topInsCorpInfoBiz.searchAll();
		
		Gson gson = new Gson();
//String ss="{'保险公司':{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {'东吴人寿':{name:'东吴人寿',type: 'item',additionalParameters:{id:'5'}},'长城人寿':{name:'长城人寿',type: 'item',additionalParameters:{id:'1992'}},'新华人寿':{name:'新华人寿',type: 'item',additionalParameters:{id:'2800','item-selected':true}},'新华人寿':{name:'新华人寿',type: 'item',additionalParameters:{id:'2800'}},'国华人寿':{name:'国华人寿',type: 'item',additionalParameters:{id:'4200','item-selected':true}},'国华人寿':{name:'国华人寿',type: 'item',additionalParameters:{id:'4200'}},'安邦人寿':{name:'安邦人寿',type: 'item',additionalParameters:{id:'5300','item-selected':true}}}}}}";
//		 String s =
//		 "{'保险公司':{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {'东吴人寿':{name:'东吴人寿',type: 'item',additionalParameters:{id:'5','item-selected':true}},'长城人寿':{name:'长城人寿',type: 'item',additionalParameters:{id:'1992'}},'新华人寿':{name:'新华人寿',type: 'item',additionalParameters:{id:'2800'}},'国华人寿':{name:'国华人寿',type: 'item',additionalParameters:{id:'4200'}},'安邦人寿':{name:'安邦人寿',type: 'item',additionalParameters:{id:'5300'}}}}}}";
//		
		JsonObject returnData =null;
		if("".equals(bankCode)||null == bankCode){
			

			List<TopInsCorpInfo> list = new ArrayList<TopInsCorpInfo>();// 经过处理后的菜单
			StringBuffer strBuff = new StringBuffer();
			strBuff.append("{'保险公司':"
					+ "{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {");
			for (TopInsCorpInfo topInsCorpInfo : topInsCorpInfolist) {
					strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
							+ "{name:'" + topInsCorpInfo.getInsSimpName()
							+ "',type: 'item'");
					strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
							+ "'}},");
			}
			strBuff.deleteCharAt(strBuff.length() - 1);
			strBuff.append("}}}}");
			logger.info(strBuff.toString());
			returnData = new JsonParser().parse(strBuff.toString())
					.getAsJsonObject();
		}else{
			StringBuffer strBuff = new StringBuffer();
			strBuff.append("{'保险公司':"
					+ "{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {");
			//List<TopBankAndCorp> list1 = new ArrayList<TopBankAndCorp>();
			List<TopBankAndCorp> bankAndCorpList = topBankAndCorpInfoBiz
					.getCorpByBankCode(bankCode);
		
			List<String> list = new ArrayList<String>();
			for (TopBankAndCorp topBankAndCorpInfo : bankAndCorpList) {
				if(null !=topBankAndCorpInfo){
					if(null !=topBankAndCorpInfo.getCorpCode()){
						TopInsCorpInfo topInsCorpInfo = topInsCorpInfoBiz.getInsCorpByInsCorpCode(topBankAndCorpInfo.getCorpCode());
						strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
								+ "{name:'" + topInsCorpInfo.getInsSimpName()
								+ "',type: 'item'");
						strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
								+ "','item-selected':true}},");
					
						list.add(topBankAndCorpInfo.getCorpCode());
					}
					if(null !=topBankAndCorpInfo.getCorpCode2()){
						TopInsCorpInfo topInsCorpInfo = topInsCorpInfoBiz.getInsCorpByInsCorpCode(topBankAndCorpInfo.getCorpCode2());
						strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
								+ "{name:'" + topInsCorpInfo.getInsSimpName()
								+ "',type: 'item'");
						strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
								+ "','item-selected':true}},");
						list.add(topBankAndCorpInfo.getCorpCode2());
					}
					if(null !=topBankAndCorpInfo.getCorpCode3()){
						TopInsCorpInfo topInsCorpInfo = topInsCorpInfoBiz.getInsCorpByInsCorpCode(topBankAndCorpInfo.getCorpCode3());
						strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
								+ "{name:'" + topInsCorpInfo.getInsSimpName()
								+ "',type: 'item'");
						strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
								+ "','item-selected':true}},");
						list.add(topBankAndCorpInfo.getCorpCode3());
					}
				}
			}
			List<TopInsCorpInfo> InsCorpInfolist = new ArrayList<TopInsCorpInfo>();
			if(list.size()>0){
				InsCorpInfolist = topInsCorpInfoBiz.getInsCorpList(list);
			}else{
				InsCorpInfolist = topInsCorpInfoBiz.searchAll();
			}
			for (TopInsCorpInfo topInsCorpInfo : InsCorpInfolist) {
				strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
						+ "{name:'" + topInsCorpInfo.getInsSimpName()
						+ "',type: 'item'");
				strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
						+ "'}},");
			}
			strBuff.deleteCharAt(strBuff.length() - 1);
			strBuff.append("}}}}");
			logger.info(strBuff.toString());
			 returnData = new JsonParser().parse(strBuff.toString())
					.getAsJsonObject();
		}

		String jsonString = gson.toJson(returnData);
		resultTree = jsonString;
		logger.info(resultTree);
		return resultTree;
	}

	
	@RequestMapping(value = "/getCorpByBankCode", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getCorpByBankCode(HttpServletRequest request) {
		logger.info("通过机构号查询出绑定的保险公司信息");
		System.out.println(request.getParameter("bankCode"));
		String bankCode = (String) request.getParameter("bankCode");
		List<TopBankAndCorp> list = new ArrayList<TopBankAndCorp>();
		List<TopBankAndCorp> bankAndCorpList = topBankAndCorpInfoBiz
				.getCorpByBankCode(bankCode);
		for (TopBankAndCorp topBankAndCorpInfo : bankAndCorpList) {
			list.add(topBankAndCorpInfo);
		}
		List<TopInsCorpInfo> topInsCorpInfolist = topInsCorpInfoBiz.searchAll();
		List<TopInsCorpInfo> list2 = new ArrayList<TopInsCorpInfo>();
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("{'保险公司':"
				+ "{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {");
		for(int i = 0;i< list.size();i++){
			TopBankAndCorp topBankAndCorpInfo = list.get(i);
			for (int j =0;j< topInsCorpInfolist.size();j++) {
				TopInsCorpInfo topInsCorpInfo =topInsCorpInfolist.get(j);
				if(!"".equals(topBankAndCorpInfo.getCorpCode())){
					strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
							+ "{name:'" + topInsCorpInfo.getInsSimpName()
							+ "',type: 'item'");
					strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
							+ "','item-selected':true}},");
				}
				if(!"".equals(topBankAndCorpInfo.getCorpCode2())){
					strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
							+ "{name:'" + topInsCorpInfo.getInsSimpName()
							+ "',type: 'item'");
					strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
							+ "','item-selected':true}},");
				}if(!"".equals(topBankAndCorpInfo.getCorpCode3())){
					strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
							+ "{name:'" + topInsCorpInfo.getInsSimpName()
							+ "',type: 'item'");
					strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
							+ "','item-selected':true}},");
				}else{
					strBuff.append("'" + topInsCorpInfo.getInsSimpName() + "':"
							+ "{name:'" + topInsCorpInfo.getInsSimpName()
							+ "',type: 'item'");
					strBuff.append(",additionalParameters:{id:'" + topInsCorpInfo.getInsCorpCode()
							+ "'}},");
				}	
			}
		}
		
		strBuff.deleteCharAt(strBuff.length() - 1);
		strBuff.append("}}}}");
		logger.info(strBuff.toString());
		Gson gson = new Gson();

		JsonObject returnData = new JsonParser().parse(strBuff.toString())
				.getAsJsonObject();

		String jsonString = gson.toJson(returnData);
		resultTree = jsonString;
		logger.info(resultTree);
		return resultTree;
	}
	
	public String getResultTree() {
		return resultTree;
	}

	public void setResultTree(String resultTree) {
		this.resultTree = resultTree;
	}
	
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insert(@Valid TopBankAndCorp topBankandcorp,BindingResult result,HttpServletRequest request) {
		logger.info("机构绑定保险公司信息");
		String bankCode = request.getParameter("bankCode");
		String corpCodes = request.getParameter("corpCodes");
		logger.info(bankCode);
		logger.info(corpCodes);
		String []corpCode = corpCodes.split(",");
		TopBankinfo topBankinfo = topBankinfoBiz.getTopBankinfo(bankCode);
		topBankandcorp.setBankCode(bankCode);
		topBankandcorp.setBankChName(topBankinfo.getBankName());
		logger.info("机构数组的长度："+corpCode.length);
		if(corpCode.length == 1){
			if("".equals(corpCode[0])){
				topBankandcorp.setCorpCode("");
				topBankandcorp.setCorpCode2("");
				topBankandcorp.setCorpCode3("");
			}else{
				topBankandcorp.setCorpCode(corpCode[0]);
				topBankandcorp.setCorpCode2("");
				topBankandcorp.setCorpCode3("");
			}
			
		}
		if(corpCode.length == 2){
			topBankandcorp.setCorpCode(corpCode[0]);
			topBankandcorp.setCorpCode2(corpCode[1]);
		}
		if(corpCode.length == 3){
			topBankandcorp.setCorpCode(corpCode[0]);
			topBankandcorp.setCorpCode2(corpCode[1]);
			topBankandcorp.setCorpCode3(corpCode[2]);
		}
		topBankandcorp.setFileName("");
		topBankandcorp.setOperatorBankCode("");
		topBankandcorp.setOperatorCode("");
		topBankandcorp.setOperDate(DateUtil.getCurrentDate());
		topBankandcorp.setOperTime(DateUtil.getCurrentTime());
		topBankandcorp.setReviewBankCode("");
		topBankandcorp.setReviewCode("");
		topBankandcorp.setUpdateDate(DateUtil.getCurrentDate());
		topBankandcorp.setUpdateTime(DateUtil.getCurrentTime());
		
		topBankAndCorpInfoBiz.delete(bankCode);
		topBankAndCorpInfoBiz.insert(topBankandcorp);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@Valid TopBankAndCorp topBankandcorp,BindingResult result) {
		if (result.hasErrors()) {
			return ResultHelper.analyzeError(result);
		}
		topBankAndCorpInfoBiz.update(topBankandcorp);
		return ResultHelper.getResultMap();
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request) {
		String[] ids = request.getParameterValues("ids[]");
		if(ids!=null){
		  for (String string : ids) {
			  topBankAndCorpInfoBiz.delete(string);
		  }
		}
		  return ResultHelper.getResultMap();
		  
	}

	
}
