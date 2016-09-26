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
<script src="${ctx }/js/module/system/roleinfo.js"></script>
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

	<!-- 菜单管理 -->
	<div id="menu-dialog" style="display: none">
		<input type="hidden" name="roleId" id="roleId" />
		<div id="menuTree" class="tree"></div>
	</div>

</body>
</html>
