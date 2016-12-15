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
<script src="${ctx }/js/module/basedata/templateInfo.js"></script>
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

					</div>
					</div>
				</div><!-- /#ace-settings-container -->

		</div><!-- /.main-container -->

		<table style="height: 100%;" id="grid-table"></table>

		<div id="grid-pager"></div>
		<div id="footer">
			Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
		</div>	
		
		
			<!-- 新增界面 -->
	<div id="dialog-form" style="display: none;overflow-x: hidden">
		<form class="form-horizontal" id="validation-form" method="post">
			<table align="center">
				<tr>
					<td>产品库编号：</td>
					<td>
						<input type="text" name="templateId" id="templateId" width="200px" maxlength="10"/><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>产品库名称：</td>
					<td>
						<input type="text" name="templateName" id="templateName"  width="200px" maxlength="60"/><font color="red">*</font>
					</td>
				</tr>
			</table>
		</form>

	</div>
	
	<div id="dialogForm" style="display: none;overflow-x: hidden">
		<div class="page-content">
						<form class="form-horizontal" role="form" name='form' method="post" action="">
						<div>产品库编号：<span id="tempId"></span>&nbsp;&nbsp;&nbsp;&nbsp;产品库名称：<span id="tempName"></span></div>
						<br>
								<div class="row">
									<div class="col-sm-6">
										<div class="widget-box">
											<div class="widget-header header-color-blue2">
												<h4 class="lighter smaller">保险公司</h4>
											</div>

											<div class="widget-body">
												<div id="tree1Div" class="widget-main padding-8">
													<div id="tree1" class="tree"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="col-sm-6">
										<div class="widget-box">
											<div class="widget-header header-color-green2">
												<h4 class="lighter smaller">保险产品</h4>
											</div>

											<div class="widget-body">
												<div id="test" class="widget-main padding-8">
													<div id="tree2" class="tree"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
						</form>
				</div>
	</div>
	
</body>
</html>