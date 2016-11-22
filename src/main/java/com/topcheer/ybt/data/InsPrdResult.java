package com.topcheer.ybt.data;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;
import com.topcheer.ybt.basedata.entity.TopPayperiod;
import com.topcheer.ybt.basedata.entity.TopPaytype;

/**
 * @ClassName: InsPrdResult
 * @Description: 产品详情查询
 * @author XUTAO
 * @date 2016-7-4 下午11:09:41
 * 
 */
public class InsPrdResult {

	private String inscorpCode = ""; //保险公司编号
	private String insPrdCode;       //产品编号
	private String minInsYear;       //最低投保年龄
	private String minInsYearUnit;   //最低投保年龄单位
	private String maxInsYear;       //最高投保年龄
	private String maxInsYearUnit;   //最高投保年龄单位
	private String insPrdSpecial;    //产品特色
	private String insNotice;        //投保提示
	private String url;              //图片路径
	private String pdf1;             
	private String pdf2;             
	private String pdf3;             
	private String pdf4;      
	private List<TopInsPrdPeriodInfo> insprdPeriods;		 //保险年期
	private List<TopPayperiod> payPeriods;		 //缴费年期
	private List<TopPaytype> payTypes;			 //缴费类型
	
	public InsPrdResult() {
		super();
	}

	


	public InsPrdResult(String inscorpCode, String insPrdCode,
			String minInsYear, String minInsYearUnit, String maxInsYear,
			String maxInsYearUnit, String insPrdSpecial, String insNotice,
			String url, String pdf1, String pdf2, String pdf3, String pdf4,
			List<TopInsPrdPeriodInfo> insprdPeriods,
			List<TopPayperiod> payPeriods, List<TopPaytype> payTypes) {
		super();
		this.inscorpCode = inscorpCode;
		this.insPrdCode = insPrdCode;
		this.minInsYear = minInsYear;
		this.minInsYearUnit = minInsYearUnit;
		this.maxInsYear = maxInsYear;
		this.maxInsYearUnit = maxInsYearUnit;
		this.insPrdSpecial = insPrdSpecial;
		this.insNotice = insNotice;
		this.url = url;
		this.pdf1 = pdf1;
		this.pdf2 = pdf2;
		this.pdf3 = pdf3;
		this.pdf4 = pdf4;
		this.insprdPeriods = insprdPeriods;
		this.payPeriods = payPeriods;
		this.payTypes = payTypes;
	}




	public String getInsPrdCode() {
		return insPrdCode;
	}

	public void setInsPrdCode(String insPrdCode) {
		this.insPrdCode = insPrdCode;
	}

	public String getMinInsYear() {
		return minInsYear;
	}

	public void setMinInsYear(String minInsYear) {
		this.minInsYear = minInsYear;
	}

	public String getMinInsYearUnit() {
		return minInsYearUnit;
	}

	public void setMinInsYearUnit(String minInsYearUnit) {
		this.minInsYearUnit = minInsYearUnit;
	}

	public String getMaxInsYear() {
		return maxInsYear;
	}

	public void setMaxInsYear(String maxInsYear) {
		this.maxInsYear = maxInsYear;
	}

	public String getMaxInsYearUnit() {
		return maxInsYearUnit;
	}

	public void setMaxInsYearUnit(String maxInsYearUnit) {
		this.maxInsYearUnit = maxInsYearUnit;
	}

	public String getInsPrdSpecial() {
		return insPrdSpecial;
	}

	public void setInsPrdSpecial(String insPrdSpecial) {
		this.insPrdSpecial = insPrdSpecial;
	}

	public String getInsNotice() {
		return insNotice;
	}

	public void setInsNotice(String insNotice) {
		this.insNotice = insNotice;
	}
	
	public String getInscorpCode() {
		return inscorpCode;
	}

	public void setInscorpCode(String inscorpCode) {
		this.inscorpCode = inscorpCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPdf1() {
		return pdf1;
	}

	public void setPdf1(String pdf1) {
		this.pdf1 = pdf1;
	}

	public String getPdf2() {
		return pdf2;
	}

	public void setPdf2(String pdf2) {
		this.pdf2 = pdf2;
	}

	public String getPdf3() {
		return pdf3;
	}

	public void setPdf3(String pdf3) {
		this.pdf3 = pdf3;
	}

	public String getPdf4() {
		return pdf4;
	}

	public void setPdf4(String pdf4) {
		this.pdf4 = pdf4;
	}




	public List<TopInsPrdPeriodInfo> getInsprdPeriods() {
		return insprdPeriods;
	}




	public void setInsprdPeriods(List<TopInsPrdPeriodInfo> insprdPeriods) {
		this.insprdPeriods = insprdPeriods;
	}




	public List<TopPayperiod> getPayPeriods() {
		return payPeriods;
	}




	public void setPayPeriods(List<TopPayperiod> payPeriods) {
		this.payPeriods = payPeriods;
	}




	public List<TopPaytype> getPayTypes() {
		return payTypes;
	}




	public void setPayTypes(List<TopPaytype> payTypes) {
		this.payTypes = payTypes;
	}


}
