<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<%@ include file="/common/common.jsp" %>
		
    <link rel="stylesheet" href="${ctx }/tab/css/bootstrap.addtabs.css" type="text/css" media="screen"/>

	
    <script src="${ctx }/tab/js/bootstrap.addtabs.js"></script>
	<script type="text/javascript" src="${ctx }/js/common/sidebar-menu.js"></script>
    <!--[if lt IE 9]>
    <script src="theme/js/html5shiv.min.js"></script>
    <script src="theme/js/respond.min.js"></script>
    <![endif]-->


    <script type="text/javascript">
        $(function () {
        	 $.ajax({
      		 	url: ctx+"/topMenuinfo/returnTree.do" ,    //请求的url地址
      		    dataType: "json",   //返回格式为json
      		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
      		   // data: { "id": "value" },    //参数值
      		    type: "post",
      		    success: function(req) {
      		        //请求成功时处理
      		    	 $('#menu').sidebarMenu({data:req });
      		    }
      		});
      	  
      	
        	
            $('#tabs').addtabs({contextmenu:true});
            $('#save').click(function () {
                Addtabs.add({
                    id: $(this).attr('addtabs'),
                    title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
                    content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
                    url: $(this).attr('url'),
                    ajax: $(this).attr('ajax') ? true : false
                })
            });
        })
    </script>
</head>
<body>
<header>
   <div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
		<%@ include file="/common/head.jsp" %>

	</div>
</header>
	<div class="sidebar" id="sidebar">
		<ul class="nav nav-list" id="menu">
			<li class="active"><a href="#"> <i class="icon-dashboard"></i>
					<span class="menu-text">导航菜单 </span>
			</a></li>
		</ul>
		<div class="sidebar-collapse" id="sidebar-collapse">

			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
				data-icon2="icon-double-angle-right"></i>
		</div>
	</div>
	 <div class="main-content">
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12" style="padding-left: 5px;">
				 <div id="tabs">
					<ul class="nav nav-tabs" role="tablist">
						<li class="active"><a href="#Index" role="tab"
							data-toggle="tab">首页</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="Index">

							<div id="myCarousel" class="carousel slide">
								<ol class="carousel-indicators">
									<li data-target="#myCarousel" data-slide-to="0" class="active">
									<li data-target="#myCarousel" data-slide-to="1">
									<li data-target="#myCarousel" data-slide-to="2">
								</ol>
								<div class="carousel-inner">
									<div class="item active">
										<img src="../images/banner_about.jpg" alt="First slide">
									</div>
									<div class="item">
										<img src="../images/ReceptionDesk.jpg" alt="Second slide">

									</div>
									<div class="item">
										<img src="../images/293506.jpg" alt="Third slide">
									</div>
								</div>
								<a class="carousel-control left" href="#myCarousel"
									data-slide="prev">&lsaquo;</a> <a
									class="carousel-control right" href="#myCarousel"
									data-slide="next">&rsaquo;</a>
							</div>
						</div>
					</div>
					</div>
				</div>
			</div>
			
			<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; 选择皮肤</span>
						</div>

					</div>
		</div>
	</div>
</div>
</body>


</html>