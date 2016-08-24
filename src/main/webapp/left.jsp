<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<ul class="nav nav-list">
	<li class="active"><a href="index.html"> <i
			class="icon-dashboard"></i> <span class="menu-text"> 导航菜单 </span>
	</a></li>


	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text"> 业务管理 </span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="${ctx}/user/userList.do"> <i
					class="icon-double-angle-right"></i> 用户信息管理
			</a></li>

			<li>
				<!--  <a href="${ctx}/topRoleinfo/getTopRoleinfoList.do">--> <a
				href="../system/roleinfo.jsp"> <i
					class="icon-double-angle-right"></i> 角色信息管理
			</a>
			</li>

			<li><a href="../system/menuinfo.jsp"> <i
					class="icon-double-angle-right"></i> 菜单信息管理
			</a></li>

			<li><a href="../system/bankinfo.jsp"> <i
					class="icon-double-angle-right"></i> 机构信息管理
			</a></li>

			<li><a href="treeview.html"> <i
					class="icon-double-angle-right"></i> 保险公司管理
			</a></li>

			<li><a href="jquery-ui.html"> <i
					class="icon-double-angle-right"></i> 产品信息管理
			</a></li>

			<li><a href="nestable-list.html"> <i
					class="icon-double-angle-right"></i> 保险产品管理
			</a></li>

			<li><a href="nestable-list.html"> <i
					class="icon-double-angle-right"></i> 保险公司绑定产品库
			</a></li>

			<li><a href="nestable-list.html"> <i
					class="icon-double-angle-right"></i> 产品库绑定保险产品
			</a></li>

			<li><a href="nestable-list.html"> <i
					class="icon-double-angle-right"></i> 产品与渠道关系配置
			</a></li>

			<li><a href="nestable-list.html"> <i
					class="icon-double-angle-right"></i> 手续费设置
			</a></li>

			<li><a href="nestable-list.html"> <i
					class="icon-double-angle-right"></i> 综合查询
			</a></li>

		</ul></li>

	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text">合规管理 </span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 网点资质证书管理
			</a></li>

			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 网点资质证书维护
			</a></li>

			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 网点代销权限维护
			</a></li>

			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 销售人员信息管理
			</a></li>

			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 销售人员信息维护
			</a></li>

			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 网点信息操作日志查询
			</a></li>

			<li><a href="userList.do"> <i
					class="icon-double-angle-right"></i> 销售人员信息操作日志查询
			</a></li>
		</ul></li>

	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text">保险交易</span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 新保承保
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 核心扣款
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 合同打印
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 合同补打
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 退保查询
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 退保申请
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 当日撤单
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 实时扣款
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 当日撤单（实时扣款）
			</a></li>
		</ul></li>

	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text">运营管理 </span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日初开启交易
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日终关闭交易
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日终核心对账
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日终保险公司对账
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日终手续费计算
			</a></li>
			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日终核退保数据同步
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 日终退保对账
			</a></li>
		</ul></li>

	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text">系统管理 </span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 权限信息管理
			</a></li>
			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> 渠道信息管理
			</a></li>
		</ul></li>


	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text">job管理 </span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> job新增交易
			</a></li>

			<li><a href="selectJobResult.do"> <i
					class="icon-double-angle-right"></i> job结果查询
			</a></li>

			<li><a href="toAddJob.do"> <i
					class="icon-double-angle-right"></i> job管理
			</a></li>
		</ul></li>

	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-desktop"></i> <span class="menu-text">系统监控 </span> <b
			class="arrow icon-angle-down"></b>
	</a>

		<ul class="submenu">
			<li><a href="druid"> <i class="icon-double-angle-right"></i>
					druid监控
			</a></li>

		</ul></li>
</ul>