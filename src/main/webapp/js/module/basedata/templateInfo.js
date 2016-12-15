$(function() {
	init();
	
});

function validate(){
	
}

function init() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
		jQuery(grid_selector).jqGrid(
			{
				url : ctx+'/topTemplate/getTopTemplateList.do',
				datatype : "json",
				height : 330,
				mtype : "post",
				colNames : [ 'ID','产品库编号','产品库名称', '操作人员','更新日期','更新时间'],
				colModel : [{
					name : 'id',
					index : 'id',
					hidden:true,
					editable : true
				},{
					name : 'templateid',
					index : 'templateid',
					editable : true
				},{
					name : 'templatename',
					index : 'templatename',
					editable : true
				},{
					name : 'operatorcode',
					index : 'operatorcode',
					editable : false
				} , {
					name : 'updatedate',
					index : 'updatedate',
					editable : false,
					sorttype : "date",
					unformat : pickDate
				}, {
					name : 'updatetime',
					index : 'updatetime',
					editable : false,
					sorttype : "date",
					unformat : pickDate
				}],
				viewrecords : true,// 是否在浏览导航栏显示记录总数
				rowNum : 10,// 每页显示记录数
				rowList : [ 10, 20, 30 ],// 用于改变显示行数的下拉列表框的元素数组。
				pager : pager_selector,
				altRows : true,// 设置为交替行表格,默认为false
				// toppager: true,
				multiselect : true,
				// multikey: "ctrlKey",
				multiboxonly : true,
				
				jsonReader : {  
				    root: "list",   // json中代表实际模型数据的入口  
				    page: "pageNum",   // json中代表当前页码的数据  
				    total: "pages", // json中代表页码总数的数据  
				    records: "total", // json中代表数据行总数的数据  
				    repeatitems: true // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。  
				} , 

				loadComplete : function(data) {
					var table = this;
					setTimeout(function() {
						styleCheckbox(table);
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
				   gridComplete: function(){
			             //根据浏览器动态改变宽度
			             $(window).resize(function(){ 
			                 var winwidth=$("#page_content").width();
			                 var winheight = $(window).height()-$("#toolbar").height()-240;
			                 $("#grid-table").setGridWidth(winwidth);
			                 $("#grid-table").setGridHeight(winheight);
			                 //消除由于兼容性问题出现的横向滚动条
			                 var w2 = parseInt($('.ui-jqgrid-labels>th:eq(2)').css('width'))-3;
			                 $('.ui-jqgrid-lables>th:eq(2)').css('width',w2);
			                 $('#grid-table tr').find("td:eq(2)").each(function(){
			                    $(this).css('width',w2);
			                 });
			             });
			             //消除由于兼容性问题出现的横向滚动条
			             var w2 = parseInt($('.ui-jqgrid-labels>th:eq(2)').css('width'))-3;
			             $('.ui-jqgrid-lables>th:eq(2)').css('width',w2);
			             $('#grid-table tr').find("td:eq(2)").each(function(){
			                $(this).css('width',w2);
			             });
			        },
				caption : "产品库信息列表",
				autowidth : true

			});

		jQuery(grid_selector).navGrid(pager_selector,{edit:false,add:false,del:false,search:false}).navButtonAdd(pager_selector,{  
			   caption:"新增",   
			   buttonicon:"icon-plus-sign purple",   
			   onClickButton: function(){

				   $("#dialog-form").dialog({
					   title:'新增产品库信息',
					   title_html: true,
					   autoOpen: true,
					   height: 200,
					   width: 400,
				       modal: true,
				       open:function(){
					    	  $("#templateId").val("");
					    	  $("#templateName").val("");
					      },
				      buttons:[{
				    	  text:'提交',
				    	  "class" : "btn btn-primary btn-xs",
				    	  click:function(){
				    		  $.ajax({
				    			  url:ctx+'/topTemplate/insert.do',
								  type: "POST",
								  data:{templateId:$("#templateId").val(),
									  templateName:$("#templateName").val()},
								  dataType:'json',
								  beforeSend:validate(),
								  error:function(msg){
									  if('SUCC'==msg.responseText){
										  layer.alert('新增成功',{
									            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
									            ,closeBtn: 0,icon:1
									        });
										  $("#dialog-form").dialog('close');
										  $(grid_selector).trigger("reloadGrid");
									  }else if('该产品库编号已存在'==msg.responseText){
										  layer.alert('新增失败，该产品库编号已存在，请重新填写！',{
									            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
									            ,closeBtn: 0,icon:2
									        });
									  }else{
										  layer.alert('新增失败',{
									            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
									            ,closeBtn: 0,icon:2
									        });
									  }
								  }
				    		  });
				    	  }
				      },{
				    	  text:"关闭",
				    	  "class" : "btn btn-xs",
				    	  click:function(){
				    		  $(this).dialog('close');
				    	  }
				      }]

				   }); 
			   },   
			   position:"last"  
			}).navButtonAdd(pager_selector,{  
				 caption:"编辑",   
				   buttonicon:"icon-pencil blue",   
				   onClickButton: function(){  
					   $("#validation-form")[0].reset();
					   var id=$(grid_selector).jqGrid("getGridParam","selrow");
					   var rowData = $(grid_selector).jqGrid('getRowData',id);
					   var cell = $(grid_selector).jqGrid("getGridParam","selarrrow");
					   if(cell.length >0){ 
						   $("#dialog-form").dialog({
								  title:"编辑产品库信息",
								  title_html: true,
								   autoOpen: true,
								   height: 200,
								   width: 400,
							       modal: true,
							      open:function(){
							    	  $("#templateId").val(rowData.templateid);
							    	  $("#templateId").attr("disabled",true);
							    	  $("#templateName").val(rowData.templatename);
							      },
							      buttons:[{
							    	  text:'提交',
							    	  "class" : "btn btn-primary btn-xs",
							    	  click:function(){
							    		  $.ajax({
							    			  url:ctx+'/topTemplate/update.do',
											  type: "POST",
											  data:{templateId:$("#templateId").val(),
												  templateName:$("#templateName").val()},
											  dataType:'json',
											  beforeSend:validate(),
											  error:function(msg){
												  if('SUCC'==msg.responseText){
													  layer.alert('修改成功',{
												            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
												            ,closeBtn: 0,icon:1
												        }); 
													  $("#dialog-form").dialog('close');
													  $(grid_selector).trigger("reloadGrid");
												  }else{
													  layer.alert('修改失败',{
												            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
												            ,closeBtn: 0,icon:2
												        });
												  }
											  }
							    		  });
							    	  }
							      },{
							    	  text:"关闭",
							    	  "class" : "btn btn-xs",
							    	  click:function(){
							    		  $(this).dialog('close');
							    	  }
							      }]

							   }); 
						   }else {
							   layer.alert('请选中一行',{
						            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
						            ,closeBtn: 0,icon:7
						        }); 
					   }
				   } 
				}).navButtonAdd(pager_selector,{  
			   caption:"删除",   
			   buttonicon:"icon-trash red",   
			   onClickButton: function(){   
				   var cells = $(grid_selector).jqGrid("getGridParam","selarrrow");
				   var ids=$('#grid-table').jqGrid("getGridParam","selarrrow");
				   var arrayObj = new Array([ids.length]);
				   for(var i=0;i<ids.length;i++){
					   var rowData = $(grid_selector).jqGrid('getRowData',ids[i]);
					   arrayObj[i]=rowData.templateid;
				   }
					var params = {"ids[]":arrayObj};
				   if(cells.length>0){
					   layer.confirm("确定删除吗？",{
						   btn: ['确定','取消'] //按钮
					   },function(r){
						   if(r){					   
							   $.ajax({
								   url:ctx+'/topTemplate/delete.do',
								   type: "POST",
								   data : params, 
								   success:function(msg){
									   if('SUCC'==msg){
											  layer.alert('删除成功',{
										            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
										            ,closeBtn: 0,icon:1
										        }); 
										   $(grid_selector).trigger("reloadGrid");
										   layer.close(r);
									   }else {
										   layer.alert('删除失败',{
									            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
									            ,closeBtn: 0,icon:2
									        }); 
									   }
								   }	   
							   });
						   }
					   },function(){
				            return;
				       });
				   }else{
					   layer.alert('请选中一行!',{icon:2}); 
				   }
			   },   
			   position:"last"  
			}).navButtonAdd(pager_selector,{   
				   caption:"刷新",   
				   buttonicon:"icon-refresh green",   
				   onClickButton: function(){   
					   $(grid_selector).trigger("reloadGrid");
				   },   
				   position:"last"  
				}).navButtonAdd(pager_selector,{  
					 caption:"绑定信息",   
					   buttonicon:"icon-pencil blue",   
					   onClickButton: function(){  
						   var id=$(grid_selector).jqGrid("getGridParam","selrow");
						   var rowData = $(grid_selector).jqGrid('getRowData',id);
						   var cell = $(grid_selector).jqGrid("getGridParam","selarrrow");
						   if(cell.length >0 && cell.length<=1){ 
							   $("#dialogForm").dialog({
									  title:"产品库绑定保险公司及产品",
									  title_html: true,
									   autoOpen: true,
									   height: 600,
									   width: 1000,
								       modal: true,
								      open:function(){
								    	  $("#tempId").html(rowData.templateid);
								    	  $("#tempName").html(rowData.templatename);
								    	  $("#tree1").remove();
										  $("#tree1Div").append(" <div id='tree1' class='tree'></div>");
										  $("#tree2").remove();
										  $("#test").append(" <div id='tree2' class='tree'></div>");
								    	  initInsCorp(rowData.templateid);
								      },
								      buttons:[{
								    	  text:'提交',
								    	  "class" : "btn btn-primary btn-xs",
								    	  click:function(){
								    		  var ids = "";
								    		  var insPrds="";
								    		     var items = $('#tree1' ).tree('selectedItems' );  
								    		     for (var i in items) if (items.hasOwnProperty(i)) {  
								    		         var item = items[i];  
								    		        ids += item.additionalParameters['id' ];
								    		     }
								    		     if(""==ids){
								    		    	 insPrds="";
								    		     }else{
								    		    	 var items = $('#tree2' ).tree('selectedItems' );  
									    		     for (var i in items) if (items.hasOwnProperty(i)) {  
									    		         var item = items[i];  
									    		         insPrds += item.additionalParameters['id' ] + ",";
									    		     } 
								    		     }
								    		  $.ajax({
								    			  url:ctx+'/topTemplate/insertTempInsPrd.do',
												  type: "POST",
												  data:{insCorpCode:ids,
													  templateId:$("#tempId").html(),
													  insPrds:insPrds},
												  dataType:'json',
												  error:function(msg){
													  if('SUCC'==msg.responseText){
														  layer.alert('修改成功',{
													            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
													            ,closeBtn: 0,icon:1
													        }); 
														  $("#dialogForm").dialog('close');
														  $(grid_selector).trigger("reloadGrid");
														  $("#tree1").remove();
														  $("#tree1Div").append(" <div id='tree1' class='tree'></div>");
														  $("#tree2").remove();
														  $("#test").append(" <div id='tree2' class='tree'></div>");
													  }else{
														  layer.alert('修改失败',{
													            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
													            ,closeBtn: 0,icon:2
													        });
													  }
												  }
								    		  });
								    	  }
								      },{
								    	  text:"关闭",
								    	  "class" : "btn btn-xs",
								    	  click:function(){
								    		  $(this).dialog('close');
								    		  $("#tree1").remove();
											  $("#tree1Div").append(" <div id='tree1' class='tree'></div>");
											  $("#tree2").remove();
											  $("#test").append(" <div id='tree2' class='tree'></div>");
								    	  }
								      }]

								   }); 
							   }else if(cell.length>1){
								   layer.alert('最多只能选中一行',{
							            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
							            ,closeBtn: 0,icon:7
							        }); 
							   }else {
								   layer.alert('请选中一行',{
							            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
							            ,closeBtn: 0,icon:7
							        }); 
						   }
					   } 
					});  
	// switch element when editing inline
	function aceSwitch(cellvalue, options, cell) {
		setTimeout(function() {
			$(cell).find('input[type=checkbox]').wrap(
					'<label class="inline" />').addClass(
					'ace ace-switch ace-switch-5').after(
					'<span class="lbl"></span>');
		}, 0);
	};
	// enable datepicker
	function pickDate(cellvalue, options, cell) {
		setTimeout(function() {
			$(cell).find('input[type=text]').datepicker({
				format : 'yyyy-mm-dd',
				autoclose : true
			});
		}, 0);
	}

	function style_edit_form(form) {
		// enable datepicker on "sdate" field and switches for "stock" field
		form.find('input[name=sdate]').datepicker({
			format : 'yyyy-mm-dd',
			autoclose : true
		}).end().find('input[name=stock]').addClass(
				'ace ace-switch ace-switch-5').wrap('<label class="inline" />')
				.after('<span class="lbl"></span>');

		// update buttons classes
		var buttons = form.next().find('.EditButton .fm-button');
		buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();// ui-icon,
																			// s-icon
		buttons.eq(0).addClass('btn-primary')
				.prepend('<i class="icon-ok"></i>');
		buttons.eq(1).prepend('<i class="icon-remove"></i>')

		buttons = form.next().find('.navButton a');
		buttons.find('.ui-icon').remove();
		buttons.eq(0).append('<i class="icon-chevron-left"></i>');
		buttons.eq(1).append('<i class="icon-chevron-right"></i>');
	}

	function style_delete_form(form) {
		var buttons = form.next().find('.EditButton .fm-button');
		buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();// ui-icon,
																			// s-icon
		buttons.eq(0).addClass('btn-danger').prepend(
				'<i class="icon-trash"></i>');
		buttons.eq(1).prepend('<i class="icon-remove"></i>')
	}

	function style_search_filters(form) {
		form.find('.delete-rule').val('X');
		form.find('.add-rule').addClass('btn btn-xs btn-primary');
		form.find('.add-group').addClass('btn btn-xs btn-success');
		form.find('.delete-group').addClass('btn btn-xs btn-danger');
	}
	function style_search_form(form) {
		var dialog = form.closest('.ui-jqdialog');
		var buttons = dialog.find('.EditTable')
		buttons.find('.EditButton a[id*="_reset"]').addClass(
				'btn btn-sm btn-info').find('.ui-icon').attr('class',
				'icon-retweet');
		buttons.find('.EditButton a[id*="_query"]').addClass(
				'btn btn-sm btn-inverse').find('.ui-icon').attr('class',
				'icon-comment-alt');
		buttons.find('.EditButton a[id*="_search"]').addClass(
				'btn btn-sm btn-purple').find('.ui-icon').attr('class',
				'icon-search');
	}

	function beforeDeleteCallback(e) {
		var form = $(e[0]);
		if (form.data('styled'))
			return false;

		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner(
				'<div class="widget-header" />')
		style_delete_form(form);

		form.data('styled', true);
	}

	function beforeEditCallback(e) {
		var form = $(e[0]);
		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner(
				'<div class="widget-header" />')
		style_edit_form(form);
	}

	// it causes some flicker when reloading or navigating grid
	// it may be possible to have some custom formatter to do this as the grid
	// is being created to prevent this
	// or go back to default browser checkbox styles for the grid
	function styleCheckbox(table) {
		/**
		 * $(table).find('input:checkbox').addClass('ace') .wrap('<label />')
		 * .after('<span class="lbl align-top" />')
		 * 
		 * 
		 * $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
		 * .find('input.cbox[type=checkbox]').addClass('ace') .wrap('<label
		 * />').after('<span class="lbl align-top" />');
		 */
	}

	// unlike navButtons icons, action icons in rows seem to be hard-coded
	// you can change them like this in here if you want
	function updateActionIcons(table) {
		/**
		 * var replacement = { 'ui-icon-pencil' : 'icon-pencil blue',
		 * 'ui-icon-trash' : 'icon-trash red', 'ui-icon-disk' : 'icon-ok green',
		 * 'ui-icon-cancel' : 'icon-remove red' }; $(table).find('.ui-pg-div
		 * span.ui-icon').each(function(){ var icon = $(this); var $class =
		 * $.trim(icon.attr('class').replace('ui-icon', '')); if($class in
		 * replacement) icon.attr('class', 'ui-icon '+replacement[$class]); })
		 */
	}

	// replace icons with FontAwesome icons like above
	function updatePagerIcons(table) {
		var replacement = {
			'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
			'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
			'ui-icon-seek-next' : 'icon-angle-right bigger-140',
			'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
		};
		$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
				.each(
						function() {
							var icon = $(this);
							var $class = $.trim(icon.attr('class').replace(
									'ui-icon', ''));

							if ($class in replacement)
								icon.attr('class', 'ui-icon '
										+ replacement[$class]);
						})
	}

	function enableTooltips(table) {
		$('.navtable .ui-pg-button').tooltip({
			container : 'body'
		});
		$(table).find('.ui-pg-div').tooltip({
			container : 'body'
		});
	}
}


function initInsCorp(templateid){
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

	var showData = new DataSourceTree({  
		 data: getInsCorpTreeData(templateid)  
		});  
		$('#tree1').ace_tree({
			dataSource:  showData ,
			multiSelect: false,//是否多选
			loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
			'open-icon' : 'icon-minus',
			'close-icon' : 'icon-plus',
			'selectable' : true,
			'selected-icon' : 'icon-ok',
			'unselected-icon' : 'icon-remove'
		});
		//使保险公司树默认打开
			$("#tree1").find(".tree-folder-header").each(function(){  
			    if($(this).parent().css("display")=="block"){   
			        $(this).trigger("click");  
			    }  
			});
			
			
			
			$("#tree1").on('loaded',function(event,data){
				var insCorpCode = "";
	        	var items = $('#tree1' ).tree('selectedItems' );  
			     for (var i in items) if (items.hasOwnProperty(i)) {  
			         var item = items[i];  
			         insCorpCode += item.additionalParameters['id' ];
			     }
			     var showData2 = new DataSourceTree({  
			          data: getInsPrdTreeDate(insCorpCode)  
			       });  
			       $('#tree2').ace_tree({
						dataSource:  showData2 ,
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
		    
			   $('#tree1').on('selected', function(evt, data) { 
		        	var insCorpCode = "";
		        	var items = $('#tree1' ).tree('selectedItems' );  
				     for (var i in items) if (items.hasOwnProperty(i)) {  
				         var item = items[i];  
				         insCorpCode += item.additionalParameters['id' ];
				     }
				     $("#tree2").remove();
				     $("#test").append(" <div id='tree2' class='tree'></div>");
				     var showData = new DataSourceTree({  
				          data: bindInsPrd(insCorpCode)  
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
			   
			   function bindInsPrd(insCorpCode){
			    	  var tempId = $("#tempId").html();
			    	  var resultData = {};  
		              $.ajax({    
		                 type: 'POST',  
						 url : ctx+"/topTemplate/getInsPrdInfoByInsCorpCode.do?insCorpCode="+insCorpCode+"&tempId="+tempId, 
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

			      
			      $('#tree1').on('click',function(evt, data) {
			    	  var insCorpCode = "";
			        	var items = $('#tree1' ).tree('selectedItems' );  
					     for (var i in items) if (items.hasOwnProperty(i)) {  
					         var item = items[i];  
					         insCorpCode += item.additionalParameters['id' ];
					     }
					 if(""==insCorpCode){
						 $("#tree2").remove();
					     $("#test").append(" <div id='tree2' class='tree'></div>");
					 }
				  });
	
}


function getInsCorpTreeData(tempId){
	 var resultData = {};  
     $.ajax({    
        type: 'POST',  
		   url: ctx+"/topTemplate/getInsCorpTreeData.do?templateId="+tempId,   
        async : false,  
        dataType: 'json' ,    
        success : function (data) {  
             resultData = data;  
          },     
   });    
 console.log(resultData) ; 
 return resultData;  
}

function getInsPrdTreeDate(insCorpCode){
	 var tempId = $("#tempId").html();
	  var resultData1 = {};  
     $.ajax({    
        type: 'POST',  
		 url : ctx+"/topTemplate/getInsPrdInfoByInsCorpCode.do?insCorpCode="+insCorpCode+"&tempId="+tempId, 
        async : false,  
        dataType: 'json' ,    
        success : function (data) {  
             resultData1 = data;  
          },    
        error: function (response) {      
        }    
   });    
     console.log(resultData1) ; 
     return resultData1;  
}

	 ////////获取tree中选中的数据的id和name

	 function getDatas(){
	 var ids = "";
	     var items = $('#tree1' ).tree('selectedItems' );  
	     for (var i in items) if (items.hasOwnProperty(i)) {  
	         var item = items[i];  
	        ids += item.additionalParameters['id' ];
	     }
	     
	 }
	 
	 function getDatas2(){
//		 var output ="";
		 var ids = "";
		     var items = $('#tree2' ).tree('selectedItems' );  
		     for (var i in items) if (items.hasOwnProperty(i)) {  
		         var item = items[i];  
		        ids += item.additionalParameters['id' ] + ",";
//		        output += item.name + ",";
		     }
		     
//		     ids = ids.substring(0, ids.lastIndexOf(","));
//		     output = output.substring(0, output.lastIndexOf(","));
		    
		   
		 }

