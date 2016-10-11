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
<script src="${ctx }/js/module/basedata/insCommissionInfo.js"></script>
</head>
<script type="text/javascript">
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
</script>
<style>
.div{ margin:10 auto; width:400px; height:100px;} 
</style>
<body>
	
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form" name='form1' method="post" action="">
									<table >
										<tr>
											<td>保险公司：</td>
											<td>
												<select id="insCompany" name="insCompany" class="select2" data-placeholder="Click to Choose..." 
												 onchange="ChangeInsCompany(this.value)">	
												</select>
											</td>
											<td>&nbsp;</td>
											<td>保险产品：</td>
											<td>
												<select id="insProducts" name="insProducts" class="select2" data-placeholder="Click to Choose..."
												onchange="ChangeInsProducts(this.value)">
												</select>
											</td>
										</tr>
									</table>
									
								
								</form>
					</div>
					</div>
				</div><!-- /#ace-settings-container -->

		</div><!-- /.main-container -->

		<!-- basic scripts -->
	<table style="height: 100%;" id="grid-table"></table>
									<!-- /.page-header -->
						
		<div id="grid-pager"></div>
				<div id="footer">
			Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
		</div>		
					
	
	<!-- 新增界面 -->
		<div id="dialog-form" style="display: none">
		<form class="form-horizontal" id="validation-form" method="post" >
			<input type="hidden" name="id"  id="id"> 
			<div class="form-group">
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="transType">交易类型:</label>
					<div class="col-xs-12 col-sm-3" style="float:left">	
						<select id="transType" name="transType" class="select2" data-placeholder="Click to Choose...">
							<option value="">请选择</option>
							<option value="1">新保承保</option>
							<option value="2">代销保险</option>
						</select>
						<font color="red">*</font>
					</div>
					<div class="space-2"></div>
					<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="numRenewalPeriod" >续缴结算期数:</label>
				   <div class="col-xs-12 col-sm-3" style="float:left">	
				  	 <input type="text" name="numRenewalPeriod" id="numRenewalPeriod"  class="col-xs-12 col-sm-10" />
				   </div>
				   
					
			</div>
		
			<div class="space-2"></div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="insPrdName">保险产品:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<input type="text" name="insPrdName" id="insPrdName" class="col-xs-12 col-sm-10" readOnly="true" />
					<font color="red">*</font>
				</div>
				<div class="space-2"></div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="bankcode">总公司/分行:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">	
					<select id="bankcode" name="bankcode" class="select2" data-placeholder="Click to Choose...">
					</select>
					<font color="red">*</font>
				</div>
			
				
			</div>
		
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right"  for="chargebacks">扣款方式:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="chargebacks" name="chargebacks" class="select2" data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">1-内扣</option>
						<option value="2">2-外扣</option>
					</select>
					<font color="red">*</font>
				</div>
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="rateProperty">费率性质:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="rateProperty" name="rateProperty" class="select2" data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">1-固定</option>
						<option value="2">2-一次性</option>
					</select>
					<font color="red">*</font>
				</div>
			</div>
		
			<div class="space-2"></div>
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-2 no-padding-right" for="postCode">收费方式:</label>
				<div class="col-xs-12 col-sm-3" style="float:left">
					<select id="chargeMethod" name="chargeMethod" class="select2" data-placeholder="Click to Choose...">
						<option value="">请选择</option>
						<option value="1">1-一次性收费</option>
						<option value="2">2-百分比收费</option>
					</select>
					<font color="red">*</font>
				</div>
			</div>
	
			<div class="space-2"></div>
		
			<ul class="nav nav-list"> 
			     <li class="divider"></li>  
			</ul>
			<br>
			<div class="div">
				<table style="height: 100%;" id="gridData" ></table>
			</div>
			
			<div style="margin-left:20px">
			    <table id="jqGrid"></table>
			</div>
			</form>
		</div>
		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
		
		
		
		$(function () {
			var title	= ['请选择' , '请选择' ];
			$.each(title , function(k , v) {
				title[k]	= '<option value="">'+v+'</option>';
			});	
			$('#insCompany').append(title[0]);
			$('#insProducts').append(title[1]);
			$("#insCompany,#insProducts").select2();
			  $.ajax({
				  	url: ctx+"/topAgentrate/getInsCompanyAjax.do",    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    success: function(req) {
				        //请求成功时处理
				    	 var control = $('#insCompany');
				    	 for(var i=0;i<req.length;i++){
				    		 control.append("<option value='" + req[i].insCorpCode + "'>&nbsp;" +req[i].insCorpCode+'-'+req[i].insSimpName + "</option>");
				    	 }
				    },
				    complete: function() {
				        //请求完成的处理
				    },
				    error: function() {
				    	 layer.alert("保险公司数据加载出错",{icon:2});  
				    }
				});
			  getCorpPrdInfoAjax();
			  getBankInfoAjax();
		});
		
		
		function ChangeInsCompany(value){
			$('#insProducts').empty();
			var title	= ['请选择' , '请选择' ];
			$.each(title , function(k , v) {
				title[k]	= '<option value="">'+v+'</option>';
			});	
			$('#insProducts').append(title[1]);
			$("#insProducts").select2();
			 $.ajax({
				  	url: ctx+"/topAgentrate/getInsPrdAjax.do?insCorpCode="+value,    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    success: function(req) {
				        //请求成功时处理
				    	 var control = $('#insProducts');
				    	 for(var i=0;i<req.length;i++){
				    		 control.append("<option value='" + req[i].insPrdCode + "'>&nbsp;" +req[i].insPrdCode+'-'+req[i].insPrdSimName + "</option>");
				    	 }
				    },
				    error: function() {
				    }
				});
		}
		
		function ChangeInsProducts(value){
			 jQuery("#grid-table").jqGrid('setGridParam', {
				   url:ctx+'/topAgentrate/getInsPrdByInsPrdCode.do?insPrdCode='+value,
				   type: "POST",
			}).trigger("reloadGrid");
		}
		
		function getBankInfoAjax(){
			$('#bankcode').empty();
			var title	= ['请选择' , '请选择' ];
			$.each(title , function(k , v) {
				title[k]	= '<option value="">'+v+'</option>';
			});	
			$('#bankcode').append(title[1]);
			$("#bankcode").select2();
			 $.ajax({
				  	url: ctx+"/topAgentrate/getBankInfoAjax.do",    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    success: function(req) {
				        //请求成功时处理
				    	 var control = $('#bankcode');
				    	 for(var i=0;i<req.length;i++){
				    		 control.append("<option value='" + req[i].bankCode + "'>&nbsp;" +req[i].bankCode+'-'+req[i].bankName + "</option>");
				    	 }
				    },
				    error: function() {
				    }
				});
		}
		
		
		function getCorpPrdInfoAjax(){
			 $.ajax({
				  	url: ctx+"/topAgentrate/getCorpPrdInfoAjax.do?insPrdCode="+28000001,    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    success: function(req) {
				        //请求成功时处理
				    	for(var i=0;i<req.length;i++){
				    		$("#insPrdName").val(req[i].insPrdCode+"-"+req[i].insPrdSimName);
				    	 }
				    },
				    error: function() {
				    }
				});
		}
		</script>

</body>
</html>
