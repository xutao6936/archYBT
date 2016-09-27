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
												<select id="insProducts" name="insProducts" class="select2" data-placeholder="Click to Choose...">
												</select>
											</td>
										</tr>
									</table>
									
									
									

									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="submit">
												<i class="icon-ok bigger-110"></i>
												提交
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												重置
											</button>
										</div>
									</div>
					
								</form>
					</div>
					</div>
				</div><!-- /#ace-settings-container -->

		</div><!-- /.main-container -->

		<!-- basic scripts -->

	
		
		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
		
		
		
		$(function () {
			var title	= ['保险公司' , '保险产品' ];
			$.each(title , function(k , v) {
				title[k]	= '<option value="">'+v+'</option>';
			});	
			$('#insCompany').append(title[0]);
			$('#insProducts').append(title[1]);
			$("#insCompany,#insProducts").select2();
			  $.ajax({
				  	url: ctx+"/insCommission/getInsCompanyAjax.do",    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    placeholder:'请选择',
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
		});
		
		
		function ChangeInsCompany(value){
			alert(value);
			 $.ajax({
				  	url: ctx+"/insCommission/getInsPrdAjax.do?insCorpCode="+value,    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    success: function(req) {
				        //请求成功时处理
				    	 var control = $('#insProducts');
				    	 for(var i=0;i<req.length;i++){
				    		 control.append("<option value='" + req[i].insPrdCode + "'>&nbsp;" +req[i].insPrdCode+'-'+req[i].insPrdEnName + "</option>");
				    	 }
				    },
				    error: function() {
				    }
				});
		}
		
		
		</script>

</body>
</html>
