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
<script type="text/javascript">
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
</script>

<body>  
<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<div class="page-content">
				<div class="rows" id='mysearch'>
					<form id="searchForm" name="searchForm" method="post" action="">
						<table align="center" >
										<tr>
											<td style="text-align:right;">保险公司编码：</td>
											<td>
												<div class="col-sm-10 input-group date">
													<input type="text" name="insCorpCode" id="insCorpCode" class="col-xs-12 col-sm-10 form-control" />
												</div>
											</td>
											<td style="text-align:right;">保险公司名称：</td>
											<td>
												<div class="col-sm-10 input-group date">
													<input type="text" name="insCorpName" id="insCorpName"  class="col-xs-12 col-sm-10 form-control"  />
												</div>
											</td>
											<td style="text-align:right;">上级公司代码：</td>
											<td>
												<div class="col-sm-10 input-group date">
													<input type="text"  class="col-xs-12 col-sm-10 form-control" id="upCorpCode" name="upCorpCode" value="" />
												</div>
											</td>	
										</tr>
										<tr>
											<td style="text-align:right;">保险公司公司等级：</td>
											<td>
												<select id="insCorpLevel" name="insCorpLevel"   class="select2" data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">总公司</option>
													<option value="1">分公司</option>
												</select>
											</td>				
											<td style="text-align:right;">状态：</td>
											<td>
												<select id="status" name="status"  class="select2" data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">有效</option>
													<option value="1">无效</option>
												</select>
											</td>
											<td style="text-align:right;">统一柜面接口：</td>
											<td>
												<select id="commonCountFlag" name="commonCountFlag" class="select2"  data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">是</option>
													<option value="1">否</option>
												</select>
											</td>
											
										</tr>
										<tr>
											<td style="text-align:right;">统一网销接口：</td>
											<td>
												<select id="commonNetFlag" name="commonNetFlag" class="select2"  data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">是</option>
													<option value="1">否</option>
												</select>
											</td>
											
											<td style="text-align:right;">统一对账接口：</td>
											<td>
												<select id="commonCheckFlag" name="commonCheckFlag" class="select2"  data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">是</option>
													<option value="1">否</option>
												</select>
											</td>
											<td style="text-align:right;">统一非实时对账接口：</td>
											<td>
												<select id="commonNossdcheckFlag" name="commonNossdcheckFlag" class="select2"  data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">是</option>
													<option value="1">否</option>
												</select>
											</td>
										</tr>
										<tr>
											<td style="text-align:right;">统一退保接口：</td>
											<td>
												<select id="commonSystbFlag" name="commonSystbFlag" class="select2"  data-placeholder="Click to Choose...">
													<option value="">请选择</option>
													<option value="0">是</option>
													<option value="1">否</option>
												</select>
											</td>
											<td style="text-align:right;">开通渠道：</td>
											<td>
												<select id="channelFlag" name="channelFlag" class="select2"   data-placeholder="Click to Choose...">
														<option value="">请选择</option>
														<option value="01">柜面</option>
														<option value="02">网上银行</option>
														<option value="03">手机银行</option>
														<option value="04">直销银行</option>
														<option value="05">自助终端</option>
													</select>
											</td>
											<td align="center">
												<button type="button" class="btn btn-primary  btn-xs" id="searchBtn">查询</button>
												<button id="resetFilter"  class="btn btn-primary  btn-xs"  onclick="resetSearchForm()">重置</button>
											</td>
										</tr>
									</table>
					</form>

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

<!--  <input id="insBeginDate1" name="insBeginDate1"  type="text"  placeholder="请选择日期"> -->

	<!-- 新增界面    action="${ctx }/topInsPrdInfo/insertTopInsPrdInfo.do"-->
		<div id="dialog-form" style="display: none">
		<form class="form-horizontal" id="validation-form" method="post" >
			<input type="hidden" name="id"  id="id"> 
				<table align="center">
				<tr>
					<td>保险公司编码：</td>
					<td>
					  	 <input type="text" name="insCorpCode" id="insCorpCode"  class="col-xs-12 col-sm-10" />
					  	 <font color="red">*</font>
					</td>
					<td>保险公司名称：</td>
					<td>
						<input type="text" name="insCorpName" id="insCorpName"  class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>简称：</td>
					<td>
						<input type="text" name="insSimpName" 	id="insSimpName" class="col-xs-12 col-sm-10" />
						<font color="red">*</font>
					</td>
					<td>保险公司等级：</td>
					<td>
						<select id="insCorpLevel" name="insCorpLevel" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">总公司</option>
							<option value="1">分公司</option>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>上级公司代码：</td>
					<td>
						<input type="text" id="upCorpCode" name="upCorpCode"  class="col-xs-12 col-sm-10" />
					</td>
					<td>保险公司英文名称：</td>
					<td>
						<input type="text" id="insCorpEnName" name="insCorpEnName"  class="col-xs-12 col-sm-10" />
					</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td>
						<input type="text" id="address" name="address"  class="col-xs-12 col-sm-10" />
					</td>
					<td>邮编：</td>
					<td>
						<input type="text" id="postCode" name="postCode" class="col-xs-12 col-sm-10" />
					</td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td>
						<input type="text" id="phone" name="phone"  class="col-xs-12 col-sm-10" />
					</td>
					<td>传真：</td>
					<td>
						<input type="text" id="fax" name="fax"  class="col-xs-12 col-sm-10" />
					</td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td>
						<input type="text" id="email" name="email" class="col-xs-12 col-sm-10" />
					</td>
					<td>状态：</td>
					<td>
						<select id="status" name="status" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">有效</option>
							<option value="1">无效</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>统一柜面接口：</td>
					<td>
						<select id="commonCountFlag" name="commonCountFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
					<td>统一网销接口：</td>
					<td>
						<select id="commonNetFlag" name="commonNetFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>统一对账接口：</td>
					<td>
						<select id="commonCheckFlag" name="commonCheckFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
					<td>统一非实时对账接口：</td>
					<td>
						<select id="commonNossdcheckFlag" name="commonNossdcheckFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>统一退保接口：</td>
					<td>
						<select id="commonSystbFlag" name="commonSystbFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</td>
					<td>开通渠道：</td>
					<td>
						<select id="channelFlag" name="channelFlag" class="select2"  data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="01">柜面</option>
							<option value="02">网上银行</option>
							<option value="03">手机银行</option>
							<option value="04">直销银行</option>
							<option value="05">自助终端</option>
						</select>
					</td>
				</tr>
				
			</table>
		</form>
	</div>

<script type="text/javascript">
$(".select2").css('width','200px').select2({allowClear:true})
.on('change', function(){
	$(this).closest('form').validate().element($(this));
}); 
$("#searchBtn").unbind('click').click(function(){
	var data = $('#searchForm').serializeArray();
	var param = {};
	$.each(data,function(i,v){
		param[v.name] = v.value;
	});
	 jQuery("#grid-table").jqGrid('setGridParam', {
		   url:ctx+'/topInsCorpinfo/getTopInsCorpInfoListByParams.do',
		   type: "POST",
		   postData:param
	 }).trigger("reloadGrid");
});	

</script>
</body>  
</html> 
