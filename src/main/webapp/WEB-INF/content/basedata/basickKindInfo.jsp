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
<script src="${ctx }/js/module/basedata/basicKindInfo.js"></script>
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

		<!-- basic scripts -->
	<table style="height: 100%;" id="grid-table"></table>
									<!-- /.page-header -->
						
		<div id="grid-pager"></div>
				<div id="footer">
			Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
		</div>	
		
		
			<!-- 新增界面 -->
	<div id="dialog-form" style="display: none;overflow-x: hidden">
		<form class="form-horizontal" id="validation-form" method="post">
			<input type="hidden" name="id"  id="id">
			<input type="hidden" name="operator" value="${userinfo.loginAccount }"> 
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="code">编号</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" name="code" id="code" width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="value">名称:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" name="value" id="value"  width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="kindCode">父级编号:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" name="kindCode" id="kindCode" width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="kindValue">父级名称:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" id="kindValue" name="kindValue" width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

		</form>

	</div>
		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script src="assets\js\jquery-2.0.3.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets\js\jquery-1.10.2.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	 
</body>
</html>
<script>var _hmt = _hmt || [];(function(){var hm=document.createElement("script");hm.src = "//hm.baidu.com/hm.js?a43c39da34531f4da694d4499c5614d4";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm, s);})();</script>