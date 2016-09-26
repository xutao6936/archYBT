<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="navbar-container" id="navbar-container">
	<div class="navbar-header pull-left">
		<a href="#" class="navbar-brand"> <small> <i
				class="icon-leaf"></i> 银保通系统
		</small>
		</a>
		<!-- /.brand -->
	</div>
	<!-- /.navbar-header -->

	<div class="navbar-header pull-right" role="navigation">
		<ul class="nav ace-nav">


			<li class="light-blue"><a data-toggle="dropdown" href="#"
				class="dropdown-toggle"> <img class="nav-user-photo"
					src="${ctx }/assets/avatars/user.jpg" alt="Jason's Photo" /> <span
					class="user-info"> <small>欢迎光临,</small>
						${userinfo.loginAccount }
				</span> <i class="icon-caret-down"></i>
			</a>

				<ul
					class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
					<li><a href="#"> <i class="icon-cog"></i> 设置
					</a></li>

					<li><a href="#"> <i class="icon-user"></i> 个人资料
					</a></li>

					<li class="divider"></li>

					<li><a href="${ctx}/login/logout.do "> <i class="icon-off"></i>
							退出
					</a></li>
				</ul></li>
		</ul>
		<!-- /.ace-nav -->
	</div>
	<!-- /.navbar-header -->
</div>
<!-- /.container -->