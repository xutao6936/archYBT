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
								<i class="icon-leaf green"></i> 银保通系统
							</h1>
							<div style="margin-top:20px">
								<h4 class="blue">&copy; 天正软件公司</h4>
							</div>
						</div>
			<div class="space"></div>
			<div style="margin-top:20px">
          	  <h1>登录(Login)</h1>
            </div>
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

