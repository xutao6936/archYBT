<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
		<link href="${ctx }/js/common/bootstrap-fileinput/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx }/assets/css/font-awesome.min.css" />
		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${ctx }/assets/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="${ctx }/assets/css/datepicker.css" />
		<link rel="stylesheet" href="${ctx }/assets/css/ui.jqgrid.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${ctx }/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx }/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${ctx }/assets/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="${ctx }/assets/css/font-awesome-ie7.min.css" />
		<style type="text/css">
		#footer {
			margin-top: 200px;
			padding: 1px 0px 0px 0px;
			font-size: 95%;
			text-align: center;
			border-top: 1px solid #658A16;
		}
		
		#footer a {
			color: #009966;
		}
		</style>
		
		
		<script src="${ctx }/assets/js/jquery-ui-1.10.3.full.min.js"></script>
		<script src="${ctx }/assets/js/ace-extra.min.js"></script>
		<script src="${ctx }/assets/js/bootstrap.min.js"></script>
		<script src="${ctx }/assets/js/typeahead-bs2.min.js"></script>
		<script src="${ctx }/assets/js/bootstrap.autocomplete.js"></script>
		<script src="${ctx }/assets/js/jquery.ui.tabs.js"></script>
		<!-- page specific plugin scripts -->
		
		<!-- ace scripts -->
		
		<script src="${ctx }/assets/js/ace-elements.min.js"></script>
		
		<script type="text/javascript">
			var ctx = "${ctx}";
		</script>
        <!-- CSS -->
        <link rel="stylesheet" href="${ctx }/css/reset.css">
        <link rel="stylesheet" href="${ctx }/css/supersized.css">
        <link rel="stylesheet" href="${ctx }/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
        	<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">银保通系统</span>
							</h1>
							<h4 class="blue">&copy; 天正软件公司</h4>
						</div>
			<div class="space"></div>
            <h1>登录(Login)</h1>
            <form name='form1' method='post' id='validation-form'
											action="${ctx }/login/login.do">
                <input type="text" id="loginAccount" name="loginAccount"  class="form-control" placeholder="请输入您的用户名！" maxlength="8" >
                <input type="password" id="pwd" name="pwd"  class="form-control" placeholder="请输入您的密码！"  maxlength="8">
               
				<div class="space"></div>
				<div>
					<font style="color: red;">${error.msg}</font>
				</div>
                <button type="submit" class="submit_button">登录</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
		<div id="footer">
					<i class="icon-leaf green"></i> <span class="red">	
						Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
					</span>
		</div>
        <!-- Javascript -->
        <script src="${ctx }/js/jquery-1.8.2.min.js" ></script>
        <script src="${ctx }/js/supersized.3.2.7.min.js" ></script>
        <script src="${ctx }/js/supersized-init.js" ></script>
        <script src="${ctx }/js/scripts.js" ></script>

    </body>

	<script type="text/javascript">
		function show_box(id) {
			jQuery('.widget-box.visible').removeClass('visible');
			jQuery('#' + id).addClass('visible');
		}

		$(function() {
			$('#validation-form').validate({
				errorElement : 'div',
				errorClass : 'help-block',
				focusInvalid : false,
				rules : {
					loginAccount : {
						required : true,
						maxlength : 8
					},
					pwd : {
						required : true,
						minlength : 5,
						maxlength : 8
					}

				}
			});
		});
	</script>

</html>

