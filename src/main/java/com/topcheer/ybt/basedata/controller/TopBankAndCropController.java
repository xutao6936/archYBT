package com.topcheer.ybt.basedata.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.system.biz.ITopBankinfoBiz;
import com.topcheer.ybt.system.entity.TopBankinfo;

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

//	public String getFourTopBankinfo(String upBankCode) {
//		List list = topBankinfoBiz.getChildrenBankInfo(upBankCode);
//		StringBuffer stringBuffer = new StringBuffer();
//		stringBuffer.append(",children:{");
//		for (int j = 0; j < list.size(); j++) {
//			TopBankinfo childBankinfo = (TopBankinfo) list.get(j);
//			if ("3".equals(childBankinfo.getBankLevel())) {// 四级机构
//
//				stringBuffer.append(childBankinfo.getBankName() + "':{name:'"
//						+ childBankinfo.getBankName()
//						+ "',type: 'item',additionalParameters:{id:'"
//						+ childBankinfo.getBankCode() + "'");
//			}
//
//		}
//		stringBuffer.append("}}}");
//		return stringBuffer.toString();
//	}

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
		List<TopInsCorpInfo> topInsCorpInfolist = topInsCorpInfoBiz.searchAll();

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
		Gson gson = new Gson();

//		 String s =
//		 "{'保险公司':{name:'保险公司',type: 'folder', 'additionalParameters': {'id': '0','children': {'东吴人寿':{name:'东吴人寿',type: 'item',additionalParameters:{id:'5'}},'长城人寿':{name:'长城人寿',type: 'item',additionalParameters:{id:'1992'}},'新华人寿':{name:'新华人寿',type: 'item',additionalParameters:{id:'2800'}},'国华人寿':{name:'国华人寿',type: 'item',additionalParameters:{id:'4200'}},'安邦人寿':{name:'安邦人寿',type: 'item',additionalParameters:{id:'5300'}}}}}}";
//		
		JsonObject returnData = new JsonParser().parse(strBuff.toString())
				.getAsJsonObject();

//		JsonObject returnData = new JsonParser().parse(s)
//				.getAsJsonObject();
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
}
