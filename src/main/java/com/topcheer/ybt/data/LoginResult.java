package com.topcheer.ybt.data;

/**
 * @ClassName: LoginResult
 * @Description: 登录返回DTO
 * @author XUTAO
 * @date 2016-6-29 上午11:48:33
 * 
 */
public class LoginResult {

	private String result;
	private String userDept;
	private String filePath;
	private String userName;
	// private List<TopMenuinfo> menus;
	private String sex;
	private String deptName;

	public LoginResult(String result) {
		super();
		this.result = result;
	}

	public LoginResult(String result, String userDept, String filePath, String userName, String sex, String deptName) {
		super();
		this.result = result;
		this.userDept = userDept;
		this.filePath = filePath;
		this.userName = userName;
		this.sex = sex;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "LoginResult [result=" + result + ", userDept=" + userDept + ", filePath=" + filePath + ", userName="
				+ userName + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
