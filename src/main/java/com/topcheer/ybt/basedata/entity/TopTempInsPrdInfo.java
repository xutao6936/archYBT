package com.topcheer.ybt.basedata.entity;
/**
 * 产品库绑定保险产品
 * @author liuc5
 *
 */
public class TopTempInsPrdInfo {
	private    String   id;
	
	private    String   templateid ;
	
	private    String   insprdcode ;
	
	private    String   inscorpcode ;
	
	private    String   operatorbankcode;
	
	private    String   operatorcode ;
	
	private    String   updatedate ;
	
	private    String   updatetime ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getInsprdcode() {
		return insprdcode;
	}

	public void setInsprdcode(String insprdcode) {
		this.insprdcode = insprdcode;
	}

	public String getInscorpcode() {
		return inscorpcode;
	}

	public void setInscorpcode(String inscorpcode) {
		this.inscorpcode = inscorpcode;
	}

	public String getOperatorbankcode() {
		return operatorbankcode;
	}

	public void setOperatorbankcode(String operatorbankcode) {
		this.operatorbankcode = operatorbankcode;
	}

	public String getOperatorcode() {
		return operatorcode;
	}

	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "TopTempInsPrdInfo [id=" + id + ", templateid=" + templateid
				+ ", insprdcode=" + insprdcode + ", inscorpcode=" + inscorpcode
				+ ", operatorbankcode=" + operatorbankcode + ", operatorcode="
				+ operatorcode + ", updatedate=" + updatedate + ", updatetime="
				+ updatetime + "]";
	}
	
}
