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
<!--  <script src="${ctx }/js/module/basedata/bankAndCropInfo.js"></script>-->
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
												<div class="widget-main padding-8">
													<div id="tree2" class="tree"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
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
		 jQuery(function($){  
             var DataSourceTree = function(options) {  
                 this._data = options.data;  
                 this._delay = options.delay;  
             }  
           
             DataSourceTree.prototype.data = function(options, callback) {
            		var self = this;
            		var $data = null;

            		if(!("name" in options) && !("type" in options)){
            			$data = this._data;//the root tree
            			callback({ data: $data });
            			return;
            		}
            		else if("type" in options && options.type == "folder") {
            			if("additionalParameters" in options && "children" in options.additionalParameters)
            				$data = options.additionalParameters.children;
            			else $data = {}//no data
            		}
            		
            		
            		if($data != null)//this setTimeout is only for mimicking some random delay
            			setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

            		//we have used static data here
            		//but you can retrieve your data dynamically from a server using ajax call
            		//checkout examples/treeview.html and examples/treeview.js for more info
            	};

       
 
         //组装json           
       var showData = new DataSourceTree({  
          data: getTreeData()  
       });  
			 $('#tree1').ace_tree({
				 	dataSource:  showData ,
					multiSelect:true,
					loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
					'open-icon' : 'icon-minus',
					'close-icon' : 'icon-plus',
					'selectable' : true,
					'selected-icon' : 'icon-ok',
					'unselected-icon' : 'icon-remove'
				});

		        });

		 function getTreeData(){  
		        var resultData = {};  
		                $.ajax({    
		                   type: 'POST',  
						   url: ctx+"/topBankAndCrop/getBankInfo.do",   
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
		
		
			 ////////获取tree中选中的数据的id和name

			 function getDatas(){
			 var output ="";
			 var ids = "";
			     var items = $('#tree1' ).tree('selectedItems' );  
			     for (var i in items) if (items.hasOwnProperty(i)) {  
			         var item = items[i];  
			        ids += item.additionalParameters['id' ] + ",";
			        output += item.text + ",";
			     }
			     
			     ids = ids.substring(0, ids.lastIndexOf(","));
			     output = output.substring(0, output.lastIndexOf(","));
			 alert(ids+"___"+output);
			 }
		
		</script>
	 
</body>
</html>
<script>var _hmt = _hmt || [];(function(){var hm=document.createElement("script");hm.src = "//hm.baidu.com/hm.js?a43c39da34531f4da694d4499c5614d4";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(hm, s);})();</script>