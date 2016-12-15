package com.topcheer.ybt.basedata.entity;

/**
 * 产品库绑定保险公司
 * @author liuc
 *
 */
public class TopInsTemplateInfo {
	private String id;
	
	private String inscorpcode;
	
	private String templateid;
	
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

	public String getInscorpcode() {
		return inscorpcode;
	}

	public void setInscorpcode(String inscorpcode) {
		this.inscorpcode = inscorpcode;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
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
		return "TopInsTemplateInfo [id=" + id + ", inscorpcode=" + inscorpcode
				+ ", templateid=" + templateid + ", operatorbankcode="
				+ operatorbankcode + ", operatorcode=" + operatorcode
				+ ", updatedate=" + updatedate + ", updatetime=" + updatetime
				+ "]";
	}
	
}
