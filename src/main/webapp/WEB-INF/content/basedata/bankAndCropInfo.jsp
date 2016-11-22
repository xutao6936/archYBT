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
<script src="${ctx }/js/module/basedata/bankAndCropInfo.js"></script>
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
	
			
			<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

					<div class="page-content">
						<form class="form-horizontal" role="form" name='form' method="post" action="">
								<div class="row">
									<div class="col-sm-6">
										<div class="widget-box">
											<div class="widget-header header-color-blue2">
												<h4 class="lighter smaller">机构</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main padding-8">
													<div id="tree1" class="tree"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="col-sm-6">
										<div class="widget-box">
											<div class="widget-header header-color-green2">
												<h4 class="lighter smaller">保险公司</h4>
											</div>

											<div class="widget-body">
												<div id="test" class="widget-main padding-8">
													<div id="tree2" class="tree"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div>
									<button id="fat-btn" class="btn btn-primary" data-loading-text="努力绑定中..."
									    type="button"> 确认绑定
									</button>
								</div>
						</form>
				</div><!-- /#ace-settings-container -->

		</div><!-- /.main-container -->
		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script src="assets\js\jquery-2.0.3.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets\js\jquery-1.10.2.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${ctx }assets/js/bootstrap.min.js"></script>
		<script src="${ctx }assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="${ctx }/assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="${ctx }/assets/js/fuelux/fuelux.tree.min.js"></script>

		<!-- ace scripts -->

		<script src="${ctx }/assets/js/ace-elements.min.js"></script>
		<script src="${ctx }/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
	    $(function() { 
	    	
	    	//使保险公司树默认打开
	    	$("#tree2").find(".tree-folder-header").each(function(){  
	    	    if($(this).parent().css("display")=="block"){   
	    	        $(this).trigger("click");  
	    	    }  
	    	});
	    	
	    	
	        $(".btn").click(function(){
	            $(this).button('loading').delay(1000).queue(function() {
	            	getDatas();
	             $(this).button('reset');
	            });        
	        });
	        
	        $('#tree2').on('selected', function(evt, data) {  
	            getDatas2();  
	        }); 
	        
	        
	        $('#tree1').on('selected', function(evt, data) { 
	        	var bankCode = "";
	        	var items = $('#tree1' ).tree('selectedItems' );  
			     for (var i in items) if (items.hasOwnProperty(i)) {  
			         var item = items[i];  
			         bankCode += item.additionalParameters['id' ];
			     }
			     $("#tree2").remove();
			     $("#test").append(" <div id='tree2' class='tree'></div>");
			     var showData = new DataSourceTree({  
			          data: bindInsCorp(bankCode)  
			       });  
			       $('#tree2').ace_tree({
						dataSource:  showData ,
						multiSelect: true,//是否多选
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : 'icon-ok',
						'unselected-icon' : 'icon-remove'
					});
			     //使保险公司树默认打开
			       $("#tree2").find(".tree-folder-header").each(function(){  
			    	    if($(this).parent().css("display")=="block"){   
			    	        $(this).trigger("click");  
			    	    }  
			    	});
			       $('#tree2').on('selected', function(evt, data) {  
			            getDatas2();  
			        }); 
	        }); 
	        
	        
	      function bindInsCorp(bankCode){
	    	  
	    	  var resultData = {};  
              $.ajax({    
                 type: 'POST',  
				   url: ctx+"/topBankAndCrop/getCorpInfo.do?bankCode="+bankCode,   
                 async : false,  
                 dataType: 'json' ,    
                 success : function (data) {  
                      resultData = data;  
                   },    
                 error: function (response) {    
                      //console.log(response);    
                 }    
            });    
	          console.log(resultData) ; 
	          return resultData;  
	      }	  

	    $("#fat-btn").unbind('click').click(function(){
	    	var bankCode = "";
        	var items = $('#tree1' ).tree('selectedItems' );  
		     for (var i in items) if (items.hasOwnProperty(i)) {  
		         var item = items[i];  
		         bankCode += item.additionalParameters['id' ];
		     }
			var corpCodes="";
			var items = $('#tree2' ).tree('selectedItems' );  
		     for (var i in items) if (items.hasOwnProperty(i)) {  
		         var item = items[i];  
		         corpCodes += item.additionalParameters['id' ]+ ",";
		     }
		     if(bankCode.length ==0){
		    	 layer.alert('请选择机构',{
			            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
			            ,closeBtn: 0,icon:2
			        });
		    	 return;
		     }
		     if((corpCodes.split(",")).length > 4){
		    	 layer.alert('保险公司只能选择3家！',{
			            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
			            ,closeBtn: 0,icon:2
			        }); 
		    	 return;
		     }
		     $.ajax({  
		         async: false,  
		         cache: true,  
		         type: 'POST',  
		         url: ctx+"/topBankAndCrop/insert.do",  
		         data: "bankCode="+bankCode+"&corpCodes="+corpCodes,  
		         error: function () {// 请求失败处理函数  
		             //$.scojs_message("更新失败,请重新登陆!", $ERROR);  
		         },  
		         success: function (req) {
		        	 var req = eval('('+req+')');
		        	 if('SUCC'==req.result){
						  layer.alert('机构绑定保险公司成功',{
					            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
					            ,closeBtn: 0,icon:1
					        }); 
						
					  }else{
						  layer.alert('机构绑定保险公司失败',{
					            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
					            ,closeBtn: 0,icon:2
					        }); 
					  }    
		          }  
		  	 });   
		});	
	    });  
		</script>
	 
</body>
</html>
<script>var _hmt = _hmt || [];(function(){var hm=document.createElement("script");hm.src = "//hm.baidu.com/hm.js?a43c39da34531f4da694d4499c5614d4";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm, s);})();</script>