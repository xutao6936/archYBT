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
<script src="${ctx }/js/module/system/logInfo.js"></script>
</head>
<script type="text/javascript">
		$(".select2").css('width','200px').select2({allowClear:true})
		.on('change', function(){
			$(this).closest('form').validate().element($(this));
		}); 
</script>

<body>  
<ul id="myTab" class="nav nav-tabs">
   <li class="active"><a href="#home" data-toggle="tab" id="getOperationLogInfo">
     系统操作</a>
   </li>
   <li><a href="#ios" data-toggle="tab" id="getExcptionLogInfo">系统异常</a></li>
  
</ul>
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="home">
	<div class="main-container-inner">
		<form class="form-horizontal" id="jqgridForm" role="form" action=""
		        method="post">
	   <div class="page-content">
		         <table>
		         	<tr>
						<td>操作人：</td>
		         		<td>
		         			<div class="col-sm-10 input-group date">
							   <input type="text" name="name" id="name"  class="col-xs-12 col-sm-10 form-control" placeholder="请输入操作人"/>   
							</div>
							 
		         		</td>
						
		         		<td>操作开始日期：</td>
		         		<td>
		         			<div class="col-sm-10 input-group date" data-provide="datepicker">
								 <input class="form-control date-picker input-medium" id="startDate"  name="startDate" type="text" placeholder="请输入开始时间" data-date-format="yyyymmdd" />
								  <div class="input-group-addon">
								      <span class="icon-calendar bigger-110"></span>
								  </div>
							</div> 
		         		</td>
		         		<td>操作结束日期：</td>
		         		<td>
							<div class="col-sm-10 input-group date" data-provide="datepicker">
								 <input class="form-control date-picker input-medium" id="endDate"  name="endDate" type="text" placeholder="请输入结束时间" data-date-format="yyyymmdd" />
								  <div class="input-group-addon">
								      <span class="icon-calendar bigger-110"></span>
								  </div>
							</div> 
		         		</td>
		         		
		         		<td>
		         			<div class="col-sm-10">
				                <button type="button" class="btn btn-primary pull-right" id="searchBtn">查询</button>
				            </div>
		         		</td>
		         	</tr>
		         	
		         </table>
			<br/>
					<table style="height: 100%;width:100%;" id="grid-table"></table>

					<div id="grid-pager"></div>
					<div id="footer">
						Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
					</div>
				</div>
				<!-- /.row -->
			<!-- /.page-content -->
			</form>
		</div>

    
   </div>
   <div class="tab-pane fade" id="ios">
     <div class="main-container-inner">
			<form class="form-horizontal" id="jqgridForm" role="form" action=""
		        method="post">
	   <div class="page-content">
		         <table>
		         	<tr>
						<td>操作人：</td>
		         		<td>
		         			<div class="col-sm-10 input-group date">
							   <input type="text" name="name1" id="name1"  class="col-xs-12 col-sm-10 form-control" placeholder="请输入操作人"/>   
							</div>
							 
		         		</td>
						
		         		<td>操作开始日期：</td>
		         		<td>
		         			<div class="col-sm-10 input-group date" data-provide="datepicker">
								 <input class="form-control date-picker input-medium" id="startDate1"  name="startDat1e" type="text" placeholder="请输入开始时间" data-date-format="yyyymmdd" />
								  <div class="input-group-addon">
								      <span class="icon-calendar bigger-110"></span>
								  </div>
							</div> 
		         		</td>

		         		<td>操作结束日期：</td>
		         		<td>
							<div class="col-sm-10 input-group date" data-provide="datepicker">
								 <input class="form-control date-picker input-medium" id="endDate1"  name="endDate1" type="text" placeholder="请输入结束时间" data-date-format="yyyymmdd" />
								  <div class="input-group-addon">
								      <span class="icon-calendar bigger-110"></span>
								  </div>
							</div> 
		         		</td>
		         		
		         		<td>
		         			<div class="col-sm-10">
				                <button type="button" class="btn btn-primary pull-right" id="searchExceptionBtn">查询</button>
				            </div>
		         		</td>
		         	</tr>
		         	
		         </table>
			<br/>
					<table style="height: 100%;" id="gridTable"></table>

					<div id="gridPager"></div>
					<div id="footer">
						Copyright &copy;上海天正 2005-2012 <a href="http://www.topcheer.com">www.topcheer.com</a>
					</div>
				</div>
				<!-- /.row -->
			<!-- /.page-content -->
			</form>

	</div>

   </div>
</div>

<script type="text/javascript">
$(function(){
    $(window).resize(function(){   
      $("#gridTable").setGridWidth($(window).width());
      $("#grid_table").setGridWidth($(window).width());
     });
    }); 
    
    
$("#searchBtn").unbind('click').click(function(){
	var name = $("#name").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	 jQuery("#grid-table").jqGrid('setGridParam', {
		    url : ctx+'/log/getTopLogListByParams.do',
		    postData:{"name":name,"startDate":startDate,"endDate":endDate}
		  }).trigger("reloadGrid");
});	

$("#searchExceptionBtn").unbind('click').click(function(){
	var name = $("#name1").val();
	var startDate = $("#startDate1").val();
	var endDate = $("#endDate1").val();
	 jQuery("#gridTable").jqGrid('setGridParam', {
		    url : ctx+'/log/getExcptionLogListByParams.do',
		    postData:{'name':name,"startDate":startDate,"endDate":endDate}
		  }).trigger("reloadGrid");
});	
</script>
</body>  
</html> 
