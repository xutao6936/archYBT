<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>银保通</title>
<!-- basic styles -->
<jsp:include page="../common.jsp"></jsp:include>

<!-- 文件上传 -->
<link rel="stylesheet" href="${ctx }/bootstrap-fileinput/css/fileinput.css" />
<script type="text/javascript" src="${ctx }/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="${ctx }/bootstrap-fileinput/js/locales/zh.js"></script>

<script src="${ctx }/js/system/user.js"></script>

</head>

<body>
	<div class="main-container" id="main-container">
		<div class="main-container-inner">


			<div class="page-content">

				<div class="rows" id='mysearch'>
					<label>用户名：</label> 
					<input type="text" class="search-query input-medium" placeholder="Search"
						id="loginAccount" name="loginAccount" value="" />
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
	<div id="dialog-form" style="display: none;overflow-x: hidden">
		<form class="form-horizontal" id="validation-form" method="post">
			<input type="hidden" name="updateOperator" value="${userinfo.loginAccount }"> 
			<input type="hidden" name="userId" value="">
			<input type="hidden" name="createDate" value="">
			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">用户名:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" name="loginAccount" id="loginAccount_userName" width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="password">密码:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="password" name="loginPwd" id="loginPwd" width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="confirm_password">密码确认:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="password" name="confirm_password"
							id="confirm_password" width="200px" />
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">真实姓名:</label>

				<div class="col-xs-12 col-sm-9">
					<div class="clearfix">
						<input type="text" id="userName" name="userName" width="200px" />
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


		</form>

	</div>

	<div id="userFile-dialog" style="display: none;">
		<form method="post" id="upload-form" action="" enctype="multipart/form-data">
			<input type="hidden" name="userId" value="">
			<div class="form-group">
				<label class="control-label">选择头像</label>
				<input type="file" name="filePath" id="img_file" />
			</div>
		</form>
	</div>

	<!-- 菜单管理 -->
	<div id="menu-dialog" style="display: none">
		<input type="hidden" name="userId" id="userId" value="" />
		<div id="menuTree" class="tree"></div>
	</div>

<script type="text/javascript">
initFileInput("img_file",ctx+"/user/upload.do");

//初始化fileinput控件（第一次初始化）
function initFileInput(ctrlName, uploadUrl) {    
    var control = $('#' + ctrlName); 
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
        showUpload: false, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式             
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        uploadExtraData:function () {  
            var obj = {};  
            $("#upload-form").find('input').each(function() {  
                var key = $(this).attr('name'), val = $(this).val();  
                obj[key] = val;  
            });
            return obj;  
        }  
    });
}

</script>

</body>
</html>
