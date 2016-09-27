<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- <link href="${ctx }/assets/css/bootstrap.min.css" rel="stylesheet" /> --%>
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
<link rel="stylesheet" href="${ctx }/js/common/zTree/2.6/zTreeStyle.css" />
<style type="text/css">
#footer {
	margin-top: 1px;
	padding: 1px 0px 0px 0px;
	font-size: 95%;
	text-align: center;
	border-top: 1px solid #658A16;
}

#footer a {
	color: #999;
}
</style>

<script src="${ctx }/assets/js/jquery-1.11.3.min.js"></script>
<script src="${ctx }/assets/js/jquery-ui-1.10.3.full.min.js"></script>
<script src="${ctx }/assets/js/ace-extra.min.js"></script>
<script src="${ctx }/assets/js/bootstrap.min.js"></script>
<script src="${ctx }/assets/js/typeahead-bs2.min.js"></script>
<script src="${ctx }/assets/js/bootstrap.autocomplete.js"></script>
<!-- page specific plugin scripts -->

<script src="${ctx }/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${ctx }/assets/js/jqGrid/i18n/grid.locale-en.js"></script>
<script src="${ctx }/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${ctx }/assets/js/jquery-form.js"></script>
<script src="${ctx }/assets/js/layer/layer.js"></script>
<!-- ace scripts -->

<script src="${ctx }/assets/js/ace-elements.min.js"></script>
<script src="${ctx }/assets/js/jquery-form.js"></script>
<script src="${ctx }/js/common/zTree/2.6/jquery.ztree-2.6.min.js"></script>
<script type="text/javascript" src="${ctx }/assets/js/jquery.validate.min.js"></script>

<script type="text/javascript" src="${ctx }/assets/js/validate_messages_cn.js"></script>

<script src="${ctx }/assets/js/ace.min.js"></script>
<script src="${ctx }/assets/js/acedialog.js"></script>
<script src="${ctx }/assets/js/bootbox.min.js"></script>

<script type="text/javascript">
	var ctx = "${ctx}";
</script>
