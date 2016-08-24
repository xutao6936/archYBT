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
<script src="${ctx }/js/system/roleinfo.js"></script>
</head>

<body>

	<div class="main-container" id="main-container">

		<div class="main-container-inner">




			<div class="page-content">
				<!-- /.page-header -->

				<table style="height: 100%;" id="grid-table"></table>

				<div id="grid-pager"></div>
			</div>
			<!-- /.row -->
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->

		<!-- /#ace-settings-container -->
	</div>
	<!-- /.main-container-inner -->

	<!-- 新增界面 -->
	<div id="dialog-form" style="display: none">
		<form class="form-horizontal" id="validation-form" method="post"
			action="${ctx }/user/insert.do">
			<input type="hidden" name="updateOperator"
				value="${userinfo.loginAccount }"> <input type="hidden"
				name="userId" value=""> <input type="hidden"
				name="createDate" value="">
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="email">用户名:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" name="loginAccount" id="loginAccount"
							class="col-xs-12 col-sm-6" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="password">密码:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="password" name="loginPwd" id="loginPwd"
							class="col-xs-12 col-sm-4" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="confirm_password">密码确认:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="password" name="confirm_password"
							id="confirm_password" class="col-xs-12 col-sm-4" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="name">真实姓名:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" id="userName" name="userName"
							class="col-xs-12 col-sm-5" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>



			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="userDept">部门：</label>

				<div class="col-xs-12 col-sm-9">
					<select id="userDept" name=userDept class="select2"
						data-placeholder="Click to Choose...">
						<option value="">&nbsp;</option>
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>

					</select>
				</div>
			</div>
			<div class="space-2"></div>


			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right"
					for="comment">描述：</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<textarea class="input-xlarge" name="comment" id="comment"></textarea>
					</div>
				</div>
			</div>

			<div class="space-8"></div>

		</form>

	</div>

	<!-- 菜单管理 -->
	<div id="menu-dialog" style="display: none">
		<input type="hidden" name="roleId" id="roleId" />
		<div id="menuTree" class="tree"></div>
	</div>

</body>
</html>
