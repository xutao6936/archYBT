<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>银保通</title>
<!-- basic styles -->
<%@ include file="/common/common.jsp" %>
<script src="${ctx }/js/module/basedata/insCorpInfo.js"></script>
<script src="${ctx }/js/common/jquery.form.js"></script>
</head>

<body>
		<div class="main-container" id="main-container">
			<div class="main-container-inner">
			<div class="page-content">
				 <div class="rows" id='mysearch'>
					<form id="searchForm" name="searchForm" method="post" action="">
					
					<table align="center">
						<tr>
							<td>保险公司编码:</td>
							<td><input type="text" name="insCorpCode" id="insCorpCode"  class="col-xs-12 col-sm-10" /></td>
							<td>保险公司名称:</td>
							<td><input type="text" name="insCorpName" id="insCorpName"  class="col-xs-12 col-sm-10" /></td>
							<td>保险公司公司等级：</td>
							<td>
								<select id="insCorpLevel" name="insCorpLevel"  class="col-xs-12 col-sm-10" data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">总公司</option>
									<option value="1">分公司</option>
								</select>
							<td>上级公司代码：</td>
							<td><input type="text"   class="col-xs-12 col-sm-10"  placeholder="Search"  id="upCorpCode" name="upCorpCode" value="" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>状态：</td>
							<td>
								<select id="status" name="status" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">有效</option>
									<option value="1">无效</option>
								</select>
							</td>
							<td>统一柜面接口:</td>
							<td>
								<select id="commonCountFlag" name="commonCountFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">是</option>
									<option value="1">否</option>
								</select>
							</td>
							<td>统一网销接口:</td>
							<td>
								<select id="commonNetFlag" name="commonNetFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">是</option>
									<option value="1">否</option>
								</select>
							</td>
							
							<td>统一对账接口：</td>
							<td>
								<select id="commonCheckFlag" name="commonCheckFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">是</option>
									<option value="1">否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>统一非实时对账接口：</td>
							<td>
								<select id="commonNossdcheckFlag" name="commonNossdcheckFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">是</option>
									<option value="1">否</option>
								</select>
							</td>
							<td>统一退保接口：</td>
							<td>
								<select id="commonSystbFlag" name="commonSystbFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">是</option>
									<option value="1">否</option>
								</select>
							</td>
							<td>开通渠道：</td>
							<td>
								<select id="channelFlag" name="channelFlag" class="col-xs-12 col-sm-10"   data-placeholder="Click to Choose...">
										<option value="">&nbsp;</option>
										<option value="01">柜面</option>
										<option value="02">网上银行</option>
										<option value="03">手机银行</option>
										<option value="04">直销银行</option>
										<option value="05">自助终端</option>
									</select>
							</td>
							<td></td>
							</tr>
							<tr>
							<td>&nbsp;</td>
							</tr>
							<tr>
						</tr>
					</table>
				</form>
				<div align="center">
					<button id="searchFilter"  class="btn btn-primary btn-xs" onclick="submitSearchForm()">查询</button>
					<button id="resetFilter"  class="btn btn-primary  btn-xs"  onclick="resetSearchForm()">重置</button>
				</div>
				
				</div>
			
				<table style="height: 100%;" id="grid-table"></table>
						<!-- /.page-header -->
			
			<div id="grid-pager"></div>
				<div id="footer">
					Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
				</div>		
			</div>
				<!-- /.row -->
		</div>
			<!-- /.page-content -->
			<!-- /.main-content -->
		</div>
		<!-- 新增界面    action="${ctx }/topInsCorpInfo/insertTopInsCorpInfo.do"-->
		<div id="dialog-form" style="display: none">
		<form class="form-horizontal" id="validation-form" method="post" >
			<input type="hidden" name="id"  id="id"> 
			<div class="form-group">
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpCode" >保险公司编码:</label>
				   <div class="col-xs-12 col-sm-3" style="float:left">	
				  	 <input type="text" name="insCorpCode" id="insCorpCode"  class="col-xs-12 col-sm-10" />
				  	 <font color="red">*</font>
				   </div>
				   
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpName">保险公司名称:</label>
					<div class="col-xs-12 col-sm-3" style="float:left">	
						<input type="text" name="insCorpName" id="insCorpName"  class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</div>
					<div class="space-2"></div>
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insSimpName">简称:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" name="insSimpName" 	id="insSimpName" class="col-xs-12 col-sm-10" />
					<font color="red">*</font>
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpLevel">保险公司等级:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">	
					<select id="insCorpLevel" name="insCorpLevel" class="select2"  data-placeholder="Click to Choose...">
						<option value="0">总公司</option>
						<option value="1">分公司</option>
					</select>
					<font color="red">*</font>
				</div>
				<div class="space-2"></div>
			</div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="upCorpCode">上级公司代码:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="upCorpCode" name="upCorpCode"  class="col-xs-12 col-sm-10" />	
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="insCorpEnName">保险公司英文名称:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="insCorpEnName" name="insCorpEnName"  class="col-xs-12 col-sm-10" />
				</div>
			</div>
		
			<div class="space-2"></div>
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="address">地址:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="address" name="address"  class="col-xs-12 col-sm-10" />
				</div>
				
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="postCode">邮编:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="postCode" name="postCode" class="col-xs-12 col-sm-10" />
				</div>
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="phone">联系电话:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="phone" name="phone"  class="col-xs-12 col-sm-10" />
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="fax">传真:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="fax" name="fax"  class="col-xs-12 col-sm-10" />
				</div>	
				<div class="space-2"></div>
			</div>
		
			<div class="form-group">
			   <label class="control-label col-xs-12 col-sm-2 no-padding-right"	for="email">邮箱:</label>
			   <div class="col-xs-12 col-sm-3" style="float:left">
			     <input type="text" id="email" name="email" class="col-xs-12 col-sm-10" />
			   </div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="status">状态:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
				<select id="status" name="status" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
					<option value="">&nbsp;</option>
					<option value="0">有效</option>
					<option value="1">无效</option>
				</select>
				</div>
			</div>
		
			<div class="space-2"></div>
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="commonCountFlag">统一柜面接口:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="commonCountFlag" name="commonCountFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</div>
				
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="commonNetFlag">统一网销接口:</label>
			    <div class="col-xs-12 col-sm-3" style="float:left">
					<select id="commonNetFlag" name="commonNetFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</div>	
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="commonCheckFlag">统一对账接口:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">	
					<select id="commonCheckFlag" name="commonCheckFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
			</div>
			
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="commonNossdcheckFlag">统一非实时对账接口:</label>
			<div class="col-xs-12 col-sm-3" style="float:left">	
				<select id="commonNossdcheckFlag" name="commonNossdcheckFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
					<option value="">&nbsp;</option>
					<option value="0">是</option>
					<option value="1">否</option>
				</select>
			</div>
		</div>
		<div class="space-2"></div>
		
		<div class="form-group">
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="commonSystbFlag">统一退保接口:</label>
			<div class="col-xs-12 col-sm-3" style="float:left">	
				<select id="commonSystbFlag" name="commonSystbFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
					<option value="">&nbsp;</option>
					<option value="0">是</option>
					<option value="1">否</option>
				</select>
			</div>
			
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="channelFlag">开通渠道：</label>
			<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="channelFlag" name="channelFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="01">柜面</option>
						<option value="02">网上银行</option>
						<option value="03">手机银行</option>
						<option value="04">直销银行</option>
						<option value="05">自助终端</option>
					</select>
				</div>
			</div>
			<div class="space-2"></div>
			</form>
		</div>
</body>
</html>