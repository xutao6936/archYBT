<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/common.jsp" %>
<script type="text/javascript">

function test(){
	 $.ajax({
	      type: 'post',
	      url: '${pageContext.request.contextPath}/rest/tranRsService/test',
	      dataType: 'json',
	     /*  contentType:'application/json;charset=utf-8',
	      data:'{"insPrdCode":"123456","insPrdName":"新华人寿","hotType":1}', */
	      data:{"insPrdCode":"123456","insPrdName":"新华人寿","hotType":1},
	      success: function(data) {
	       alert(date);
	      }
	    });
}
</script>
</head>
<body>
<button onclick="test()">test</button>
</body>
</html>