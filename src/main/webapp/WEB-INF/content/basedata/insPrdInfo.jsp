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
<script src="${ctx }/js/common/datepicker/css/datepicker.css"></script>
<script src="${ctx }/js/common/datepicker/js/bootstrap-datepicker.js"></script>

</head>

<body>
<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<div class="page-content">
				<div class="rows" id='mysearch'>
					<form id="searchForm" name="searchForm" method="post" action="">
					
					<table align="center">
						<tr>
							<td>产品代码:</td>
							<td><input type="text" name="insPrdCode" id="insPrdCode"  class="col-xs-12 col-sm-10" /></td>
							<td>产品真实代码:</td>
							<td><input type="text" name="insPrdTrueCode" id="insPrdTrueCode"  class="col-xs-12 col-sm-10" /></td>
							<td>公司编码：</td>
							<td>
								<input type="text" name="insCorpCode" id="insCorpCode"  class="col-xs-12 col-sm-10" />
							<td>产品名称：</td>
							<td><input type="text"   class="col-xs-12 col-sm-10"  placeholder="Search"  id="insPrdCnName" name="insPrdCnName" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>产品简称：</td>
							<td>
								<input type="text" name="insPrdSimName" id="insPrdSimName"  class="col-xs-12 col-sm-10" />
							</td>
							<td>主附险标志:</td>
							<td>
								<select id="assuranceType" name="assuranceType" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">主险</option>
									<option value="1">附加险</option>
								</select>
							</td>
							<td>购买单位:</td>
							<td>
								<select id="buyUnit" name="buyUnit" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
									<option value="">&nbsp;</option>
									<option value="0">份数</option>
									<option value="1">保费</option>
									<option value="2">保额</option>
								</select>
							</td>
							
							<td>产品类型：</td>
							<td>
								<input type="text" name="insPrdType" id="insPrdType"  class="col-xs-12 col-sm-10" />
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>代理开始日期：</td>
							<td>
								<input id="insBeginDate" name="insBeginDate"  type="text" class="col-xs-12 col-sm-10"  data-date-format="mm/dd/yyyy"  placeholder="请选择日期">
							</td>
							<td>代理结束日期：</td>
							<td>
								<input id="insEndDate" name="insEndDate"  type="text"  class="col-xs-12 col-sm-10"  data-date-format="mm/dd/yyyy"  placeholder="请选择日期">
							</td>
							<td>状态：</td>
							<td>
								<select id="status" name="status" class="col-xs-12 col-sm-10"   data-placeholder="Click to Choose...">
										<option value="">&nbsp;</option>
										<option value="0">有效</option>
										<option value="1">无效</option>
										
									</select>
							</td>
							<td>是否可质押：</td>
							<td>
								<select id="impawnFlag" name="impawnFlag" class="col-xs-12 col-sm-10"   data-placeholder="Click to Choose...">
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
							
							<td>交易类型：</td>
							<td>
								<select id="transType" name="transType" class="col-xs-12 col-sm-10"   data-placeholder="Click to Choose...">
										<option value="">&nbsp;</option>
										<option value="0">全部</option>
										<option value="1">实时</option>
										<option value="2">非实时</option>
									</select>
							</td>
							<td>交易渠道：</td>
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
							</tr>
							<tr><td>&nbsp;</td></tr>
					</table>
				</form>
				<div align="center">
					<button id="searchFilter"  class="btn btn-primary btn-xs" onclick="submitSearchForm()">查询</button>
					<button id="resetFilter"  class="btn btn-primary  btn-xs"  onclick="resetSearchForm()">重置</button>
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

</div>

<input id="insBeginDate1" name="insBeginDate"  type="text"  placeholder="请选择日期">

	<!-- 新增界面    action="${ctx }/topInsPrdInfo/insertTopInsPrdInfo.do"-->
		<div id="dialog-form" style="display: none">
		<form class="form-horizontal" id="validation-form" method="post" >
			<input type="hidden" name="id"  id="id"> 
			<div class="form-group">
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insPrdCode" >产品代码:</label>
				   <div class="col-xs-12 col-sm-3" style="float:left">	
				  	 <input type="text" name="insPrdCode" id="insPrdCode"  class="col-xs-12 col-sm-10" />
				  	 <font color="red">*</font>
				   </div>
				   
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insPrdTrueCode">产品真实代码:</label>
					<div class="col-xs-12 col-sm-3" style="float:left">	
						<input type="text" name="insPrdTrueCode" id="insPrdTrueCode"  class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</div>
					<div class="space-2"></div>
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insCorpCode">公司编码:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" name="insCorpCode" 	id="insCorpCode" class="col-xs-12 col-sm-10" />
					<font color="red">*</font>
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insPrdCnName">产品名称：</label>
				<div class="col-xs-12 col-sm-3" style="float:left">	
					<input type="text" name="insPrdCnName" 	id="insPrdCnName" class="col-xs-12 col-sm-10" />
					<font color="red">*</font>
				</div>
				<div class="space-2"></div>
			</div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insPrdSimName">产品简称:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="insPrdSimName" name="insPrdSimName"  class="col-xs-12 col-sm-10" />	
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="assuranceType">主附险标志:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="assuranceType" name="assuranceType" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="0">主险</option>
						<option value="1">附加险</option>
					</select>
				</div>
			</div>
		
			<div class="space-2"></div>
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="address">购买单位:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="buyUnit" name="buyUnit" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">份数</option>
						<option value="1">保费</option>
						<option value="2">保额</option>
					</select>
				</div>
				
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="postCode">产品类型:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="insPrdType" name="insPrdType" class="col-xs-12 col-sm-10" />
				</div>
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insBeginDate">代理开始日期:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input id="insBeginDate12" name="insBeginDate"  type="text"  placeholder="请选择日期">
					<!--  <input type="text" id="insBeginDate" name="insBeginDate"  class="col-xs-12 col-sm-10" />-->
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insEndDate">代理结束日期:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input id="insEndDate1" name="insEndDate"  type="text"  class="col-xs-12 col-sm-10" >
				</div>	
				<div class="space-2"></div>
			</div>
		
			<div class="form-group">
			   <label class="control-label col-xs-12 col-sm-2 no-padding-right"	for="startAMT">起购金额/数量:</label>
			   <div class="col-xs-12 col-sm-3" style="float:left">
			     <input type="text" id="startAMT" name="startAMT" class="col-xs-12 col-sm-10" />
			   </div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="entAMT">最高金额/数量:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="entAMT" name="entAMT" class="col-xs-12 col-sm-10" />
				</div>
			</div>
		
			<div class="space-2"></div>
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="inCreaseAMT">递增金额/数量:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" id="inCreaseAMT" name="inCreaseAMT" class="col-xs-12 col-sm-10" />
				</div>
				
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="status">状态:</label>
			    <div class="col-xs-12 col-sm-3" style="float:left">
					<select id="status" name="status" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</div>	
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="impawnFlag">是否可质押:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">	
					<select id="impawnFlag" name="impawnFlag" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
			</div>
			
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="transType">交易类型:</label>
			<div class="col-xs-12 col-sm-3" style="float:left">	
				<select id="transType" name="transType" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
					<option value="">&nbsp;</option>
					<option value="0">全部</option>
					<option value="1">实时</option>
					<option value="2">非实时</option>
				</select>
			</div>
		</div>
		<div class="space-2"></div>
		
		<div class="form-group">
			
			<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="channelType">交易渠道：</label>
			<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="channelType" name="channelType" class="col-xs-12 col-sm-10"  data-placeholder="Click to Choose...">
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
<script src="${ctx }/js/module/basedata/insPrdInfo.js"></script>
</body>
</html>