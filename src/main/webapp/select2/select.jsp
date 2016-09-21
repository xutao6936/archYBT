<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${ctx }/css/select2/select2.min.css" />
<html>
<head>
<title>SELCT2</title>
<jsp:include page="../common.jsp"></jsp:include>
<script src="${ctx }/js/select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx }/js/sidebar-menu.js"></script>
<script type="text/javascript" src="${ctx }/js/bootstrap-tab.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$(".sigleSelect").select2({
		//隐藏下拉列表框中的检索框
		 minimumResultsForSearch: Infinity,
		 placeholder:"请选择",
		 allowClear: true
	});
}); 



//menuList正常显示多选
$(document).ready(function(){
	 $(".test").select2({
		//text框中显示的内容
		 placeholder:"请选择",
		 //选择的最多项目数
		 maximumSelectionLength:2,
		
		 //图文形式显示用
		 templateResult: formatState,
		 //templateSelection: formatState,
	 } );
	});  
//图片显示
function formatState(state) {
    if (!state.id) { return state.text; }
    var $state = $(
      '<span><img src="../css/zTreeStyle3.5/img/diy/' + state.element.value.toLowerCase() + '.png"  class="img-flag" /> ' + state.text + '</span>'
    );
    return $state;
};
$(function () {
	  $.ajax({
		 	url: ctx+"/select2/getMenuListForSelect2.do" ,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		        //请求成功时处理
		    	 var control = $('#menuSelect');
		    	 for(var i=0;i<req.length;i++){
		    		// control.append("<option value='" + req[i].menuCode + "'>&nbsp;" +req[i].menuName + "</option>");
		    		 control.append("<option value='" + req[i].menuCode + "'>&nbsp;" +req[i].menuName + "</option>");
		    	 }
		    },
		    complete: function() {
		        //请求完成的处理
		    },
		    error: function() {
		    }
		});
});

//树行LIst显示
$(document).ready(function(){
	 $(".treeSelect").select2({	 
		 placeholder:"请选择",
		 //控制下拉列表内容左右显示
	     dir: "rtl",
	     //显示样式
	   //  theme: "classic"
	 } );
	});  
$(function () {
	  $.ajax({
		 	url: ctx+"/select2/getMenuListForSelect2.do" ,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		        //请求成功时处理
		    	 var control = $('#treeSelect2');
		    	 for(var i=0;i<req.length;i++){
		    		 if( req[i].faMenuCode=="YBT"){
		    			var group =  control.append("<optgroup  label='" + req[i].menuName + "'></option>");
		    			for(var j=0;j<req.length;j++){
		    				if(req[j].faMenuCode ==req[i].menuCode){
		    					group.append("<option value='" + req[j].menuCode + "'>&nbsp;" +req[j].menuName + "</option>");
		    				}
		    			}
		    		 }
		    	 }
		    },
		    complete: function() {
		        //请求完成的处理
		    },
		    error: function() {
		    	//错误处理
		    }
		});
});

//Data实现给select2赋值
$(function () {
	  $.ajax({
		 	url: ctx+"/select2/getMenuListForSelect2.do" ,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		        //请求成功时处理
		    	 for(var i=0;i<req.length;i++){
		    		 $('.select2Data').select2({ 
		    		//	 minimumResultsForSearch: Infinity,
			    		 allowClear: true,  
			    		 data:[{id:req[i].menuCode,text:req[i].menuName}] 
			    	 });
		    	 }
		    }
		});
});
 
 //取得select选中值与显示内容
function onclickButton(){
	 var menuSelect2Val = $("#menuSelect").val();
	 var menuSelect2Text = $('#menuSelect').find("option:selected").text(); 
	 var dataSelect2Value =  $("#dataSelect2").select2("val");
	 var dataSelect2text = $("#dataSelect2").find("option:selected").text();
	alert("menuSelect2Val==="+menuSelect2Val+"*****menuSelect2Text=="+menuSelect2Text);
	alert("dataSelect2Value=="+dataSelect2Value+"****dataSelect2text===="+dataSelect2text);
}
 
 
 
//联动显示
$(document).ready(function(){
	$(".mainMenu").select2({
		 placeholder:"请选择主菜单",
		 allowClear: true
	});
	$(".childMenu").select2({
		 placeholder:"请选择子菜单",
		 allowClear: true
	});
}); 
$(function () {
	BindSelect("mainMenu","/select2/getMenuListForSelect2.do");
	  $("#mainMenu").on("change", function (e) {
          var mainMenuVal = $("#mainMenu").val();
          alert("主菜单改变"+mainMenuVal);
          BindSelect("childMenu", "/select2/getMenuListSelect2ForWhere.do?faMenuCode="+ mainMenuVal );
}); 
});
function BindSelect(select2Name,url){
	  $.ajax({
		 	url: ctx+url ,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		    	$("."+select2Name).empty();//清空下拉列表框
		        //请求成功时处理
		    	 for(var i=0;i<req.length;i++){
		    		 $("."+select2Name).select2({ 
			    		 allowClear: true,  
			    		 data:[{id:req[i].menuCode,text:req[i].menuName}] 
			    	 });
		    	 }
		    }
		});
}
$(document).ready(function(){
	//设置select框是否可编辑
	$("#disableMenu").on("click", function () {
    	$("#mainMenu").prop("disabled", false);
		$("#childMenu").prop("disabled", false);
     });
	$("#enableMenu").on("click", function () {
		$("#mainMenu").prop("disabled", true);
		$("#childMenu").prop("disabled", true);
	});
	
});
</script>
</head>
<body>
<table>
	<tr>
		<td>
			<label for="selectSingle" class="control-label">select2单选</label>
			<select class="sigleSelect" name="select2Single" id=“select2Single” style="width:200px"  >
			<option value="1" >1</option>
			<option >2</option>
			<option >3</option>
			<option >4</option>
			</select>
		</td>
	</tr>
	<tr>
		<td> &nbsp;</td>
	</tr>
	<tr>
		<td>
			<label for="menuSelect" class="control-label">菜单列表（复选）</label>
			<select class="test" id="menuSelect" style="width:200px"  multiple></select>
		</td>
	</tr>
	<tr>
		<td> &nbsp;</td>
	</tr>
	<tr>
		<td>
			<label for="treeSelect2" class="control-label">树形列表（复选）</label>
			<select class="treeSelect" id="treeSelect2" style="width:200px" ></select>
		</td>
	</tr>
	<tr>
		<td> &nbsp;</td>
	</tr>
	<tr>
		<td>
			<label for="dataSelect2" class="control-label">Select2加载</label>
			<select class="select2Data" id="dataSelect2" style="width:200px" ></select>
		</td>
	</tr>
	<tr>
		<td> &nbsp;</td>
	</tr>
	<tr>
		<td>
			<input type="button" onclick="onclickButton()" value="取得选择的值">
		</td>
	</tr>
	<tr>
		<td> &nbsp;</td>
	</tr>
</table>
<table>
	<tr>
	<td>
			<label for="mainMenu" class="control-label">主菜单</label>
			<select class="mainMenu" id="mainMenu" style="width:200px" ></select>
	</td>
	<td>
			<label for="childMenu" class="control-label">子菜单</label>
			<select class="childMenu" id="childMenu" style="width:200px" ></select>
	</td>
	</tr>
	<tr>
		<td> &nbsp;</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="disable" id="disableMenu">
		</td>
	<td>
			<input type="button" value="enable" id="enableMenu">
	</td>
	</tr>
</table>
</body>
</html>