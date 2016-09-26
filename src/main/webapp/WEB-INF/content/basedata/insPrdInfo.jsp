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
<script src="${ctx }/js/module/basedata/insPrdInfo.js"></script>
</head>

<body>
<div class="main-container" id="main-container">
		<div class="main-container-inner">
	<div class="page-content">
				<div class="rows" id='mysearch'>
					<label>保险产品编码：</label> <input type="text"
						class="search-query input-medium" placeholder="Search"
						id="insPrdCode" name="insPrdCode" value="" />
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

	<div id="userFile-dialog" style="display: none">
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
	</div>


</body>
</html>