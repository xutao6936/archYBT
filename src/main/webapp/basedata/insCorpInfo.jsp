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
<jsp:include page="../common.jsp"></jsp:include>
<script src="${ctx }/js/basedata/insCorpInfo.js"></script>
</head>

<body>
<div class="main-container" id="main-container">
		<div class="main-container-inner">
	<div class="page-content">
				<div class="rows" id='mysearch'>
					<label>保险公司编码：</label> <input type="text"  class="search-query input-medium" placeholder="Search"  id="insCorpInfoCode" name="insCorpInfoCode" value="" />
					<button id="searchFilter" class="btn btn-primary btn-xs">查询</button>
				</div>
					<!-- /.page-header -->

				<table style="height: 100%;" id="grid-table"></table>

				<div id="grid-pager"></div>
				<div id="footer">
					Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-content -->
	
	<!-- 新增界面 -->
	<div id="dialog-form" style="display: none">
		<form class="form-horizontal" id="validation-form" method="post"
			action="${ctx }/topInsCorpInfo/insertTopInsCorpInfo.do">
			<input type="hidden" name="id"  id="id"> 
			
			<div class="form-group">
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpCode" >保险公司编码:</label>
				   <div class="col-xs-12 col-sm-3" style="float:left">	
				  	 <input type="text" name="insCorpCode" id="insCorpCode"  class="col-xs-12 col-sm-10" />
				   </div>
				   
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpName">保险公司名称:</label>
					<div class="col-xs-12 col-sm-3" style="float:left">	
						<input type="text" name="insCorpName" id="insCorpName"  class="col-xs-12 col-sm-10" />
					</div>
					<div class="space-2"></div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insSimpName">简称:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" name="insSimpName" 	id="insSimpName" class="col-xs-12 col-sm-10" />
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpLevel">保险公司等级:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">	
					<select id="insCorpLevel" name="insCorpLevel" class="select2"  data-placeholder="Click to Choose...">
						<option value="0">总公司</option>
						<option value="1">分公司</option>
					</select>
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
				<select id="status" name=status class="select2"  data-placeholder="Click to Choose...">
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
					<select id="commonCountFlag" name=commonCountFlag class="select2"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</div>
				
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="commonNetFlag">统一网销接口:</label>
			    <div class="col-xs-12 col-sm-3" style="float:left">
					<select id="commonNetFlag" name=commonNetFlag class="select2"  data-placeholder="Click to Choose...">
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
					<select id="commonCheckFlag" name=commonCheckFlag class="select2"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
			</div>
			
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="commonNossdcheckFlag">统一非实时对账接口:</label>
			<div class="col-xs-12 col-sm-3" style="float:left">	
				<select id="commonNossdcheckFlag" name=commonNossdcheckFlag class="select2"  data-placeholder="Click to Choose...">
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
				<select id="commonSystbFlag" name=commonSystbFlag class="select2"  data-placeholder="Click to Choose...">
					<option value="">&nbsp;</option>
					<option value="0">是</option>
					<option value="1">否</option>
				</select>
			</div>
			
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="channelFlag">开通渠道：</label>
			<div class="col-xs-12 col-sm-3" style="float:left">
				<select id="channelFlag" name=channelFlag class="select2"  data-placeholder="Click to Choose...">
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

		<div class="form-group">
			
			</div>
			<div class="space-8"></div>

		</form>

	</div>

	<%-- <div id="userFile-dialog" style="display: none">
		<form method="post" id="upload-form" action="${ctx }/user/upload.do"
			enctype="multipart/form-data">
			<input type="hidden" name="userId" value="">
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="comment">用户头像：</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="file" name="filePath" id="filePath"
							class="col-xs-12 col-sm-4" />
					</div>
				</div>
			</div>
		</form>
	</div> --%>


</body>
</html>