<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap 实例 - 模态框（Modal）插件</title>
	<jsp:include page="../common.jsp"></jsp:include>
	<script type="text/javascript" src="${ctx }/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/sidebar-menu.js"></script>
	<script type="text/javascript" src="${ctx }/js/bootstrap-tab.js"></script>
</head>
<body>
 <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">演示</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>