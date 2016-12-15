$(function () {
			var title	= ['请选择' , '请选择' ];
			$.each(title , function(k , v) {
				title[k]	= '<option value="">'+v+'</option>';
			});	
			$('#insCorpCode').append(title[0]);
			$("#insCorpCode").select2();
			  $.ajax({
				  	url: ctx+"/topAgentrate/getInsCompanyAjax.do",    //请求的url地址
				    dataType: "json",   //返回格式为json
				    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
				    type: "post",   //请求方式
				    success: function(req) {
				        //请求成功时处理
				    	 var control = $('#insCorpCode');
				    	 for(var i=0;i<req.length;i++){
				    		 control.append("<option value='" + req[i].insCorpCode + "'>&nbsp;" +req[i].insCorpCode+"-"+req[i].insSimpName+"</option>");
				    	 }
				    },
				    complete: function() {
				        //请求完成的处理
				    },
				    error: function() {
				    	 layer.alert("保险公司数据加载出错",{icon:2});  
				    }
				});

});

//当保险公司代码变化后，级联出保险公司中文名称
function ChangeInsCompany(value){
	$('#InsCorpChName').empty();
	 $.ajax({
		  	url: ctx+"/topAgentrate/getInsCompanyNameAjax.do?insCorpCode="+value,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		    	 for(var i=0;i<req.length;i++){
		    		 $('#InsCorpChName').val(req[i].insCorpName);
		    	 }
		    getTemplateIdAjax(value);
		    },
		    error: function() {
		    }
		});
}

function getTemplateIdAjax(value){
	$('#templateId').empty();
	var title	= ['请选择' , '请选择' ];
	$.each(title , function(k , v) {
		title[k]	= '<option value="">'+v+'</option>';
	});	
	$('#templateId').append(title[1]);
	$("#templateId").select2();
	 $.ajax({
		  	url: ctx+"/topTemplate/getTemplateIdAjax.do?insCorpCode="+value,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		        //请求成功时处理
		    	 var control = $('#templateId');
		    	 for(var i=0;i<req.length;i++){
		    		 control.append("<option value='" + req[i].templateid + "'>&nbsp;" +req[i].templateid+ "</option>");
		    	 }
		    },
		    error: function() {
		    }
		});
}

function ChangeTemplateId(value){
	$('#templateId').empty();
	 $.ajax({
		  	url: ctx+"/topTemplate/getTemplateInfoByTempId.do?templateId="+value,    //请求的url地址
		    dataType: "json",   //返回格式为json
		    async: true, //请求是否异步，默认为异步，这也是ajax重要特性
		    type: "post",   //请求方式
		    success: function(req) {
		    	 for(var i=0;i<req.length;i++){
		    		 $('#templateName').val(req[i].templatename);
		    	 }
		    },
		    error: function() {
		    }
		});
}