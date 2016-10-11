<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${ctx }/assets/css/bootstrap.min.css"/>
<!-- basic styles -->

<link href="${ctx }/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx }/assets/css/font-awesome.min.css" />
<script type="text/javascript"
	src="${ctx }/assets/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${ctx }/assets/js/jquery.validate.min.js"></script>

<script type="text/javascript"
	src="${ctx }/assets/js/validate_messages_cn.js"></script>
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->


<!-- ace styles -->

<link rel="stylesheet" href="${ctx }/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ace-rtl.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">上海银行</span> <span
									class="white">银保通系统</span>
							</h1>
							<h4 class="blue">&copy; 天正软件公司</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 用户信息
										</h4>

										<div class="space-6"></div>

										<form name='form1' method='post' id='validation-form'
											action="${ctx }/login/login.do">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="loginAccount" name="loginAccount" type="text"
														class="form-control" placeholder="请输入柜员号" maxlength="8" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="pwd" name="pwd" type="password" class="form-control"
														placeholder="密码" maxlength="8" /> <i class="icon-lock"></i>
												</span>
												</label>


												<div class="space"></div>
												<div>
													<font style="color: red;">${error}</font>
												</div>
												<div class="clearfix">

													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登&nbsp;录
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>


									</div>
									<!-- /widget-main -->

								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->


						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->


	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->

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


</body>
</html>