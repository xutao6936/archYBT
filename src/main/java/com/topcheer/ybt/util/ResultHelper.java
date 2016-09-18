package com.topcheer.ybt.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.google.common.collect.Maps;

/** 
* @ClassName: ResultHelper 
* @Description: 
* @author XUTAO 
* @date 2016-6-17 上午09:15:37 
*  
*/
public class ResultHelper {
	
	public static String RESULT_SUCC="SUCC";
	public static String RESULT_ERROR="ERROR";
	public final static String RESULT = "result";
	public final static String ERR_INFO = "errInfo";
	public static String LOGIN_ERROR="登录失败,请重试";
	
	public static String FA_MENU_CODE="YBT";
	public static String YD_FA_MENU_CODE="YBT_YD";
	public static String BANK_TEMPLATE="机构导入模板.xls";
	
	public static String YES = "0";
	public static String NO = "1";
	
	public static Map<String,Object> getResultMap(){
		Map<String,Object> result = new HashMap<String, Object>();
		result.put(RESULT, ResultHelper.RESULT_SUCC);
		return result;
	}
	
	public static Map<String,Object> getErrResultMap(){
		Map<String,Object> result = new HashMap<String, Object>();
		result.put(RESULT, ResultHelper.RESULT_ERROR);
		return result;
	}
	
	public static Map<String,Object> analyzeError(BindingResult binding){
		Map<String,Object> result = Maps.newHashMap();
		result.put(RESULT, ResultHelper.RESULT_ERROR);
		List<ObjectError> allErrors = binding.getAllErrors();
		StringBuffer sb = new StringBuffer();
		for (ObjectError objectError : allErrors) {
			sb.append(objectError.getDefaultMessage() + "\n");
		}
		result.put(ERR_INFO, sb.toString());
		return result;
	}
	
}
