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
</head>
<script type="text/javascript">
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
</script>
<style>
.div{ margin:10 auto; width:400px; height:100px;} 
</style>
	<body>
	
	三号文监管报表：根据选择的月份或季度，统计各种类型的保险产品在该时间段中的销售总额，并按照模板下载Excel表格，被统计的机构包括此时登陆用户对应的机构及该机构下属机构 <br/>
	三号文监管报表2：根据选择的机构以及起止日期，统计各种类型的保险产品在该时间段中的销售总额，并按照模板下载Excel表格，被统计的机构包括选择的机构<br/>
	三号文监管报表3：根据选择的机构以及起止日期，统计各种类型的保险产品在该时间段中的销售总额，并按照模板下载Excel表格，被统计的机构包括此时登陆用户对应的机构及该机构下属机构
	 
</body>
</html>
<script>var _hmt = _hmt || [];(function(){var hm=document.createElement("script");hm.src = "//hm.baidu.com/hm.js?a43c39da34531f4da694d4499c5614d4";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm, s);})();</script>