$(function() {
	init();
});

function validate(){
	$('#validation-form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: false,
		rules: {
			code: {
				required: true
			},
			value: {
				required: true,
				minlength: 5
			},
			kindCode:{
				required: true,
				minlength: 5,
			},
			kindName:{
				required: true
			}
			
		}
});
}

function init() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
		jQuery(grid_selector).jqGrid(
			{
				url : ctx+'/topBasicKind/getTopBasickindList.do',
				datatype : "json",
				height : 330,
				mtype : "post",
				colNames : [ 'ID','编号','名称', '父级编号', '父级名称', '更新日期',
						'更新时间','操作柜员'],
				colModel : [{
					name : 'id',
					index : 'id',
					hidden:true,
					width : 90,
					editable : true
				},{
					name : 'code',
					index : 'code',
					width : 90,
					editable : true
				},{
					name : 'value',
					index : 'value',
					width : 90,
					editable : true
				},{
					name : 'kindCode',
					index : 'kindCode',
					width : 70,
					editable : true
				}, {
					name : 'kindValue',
					index : 'kindValue',
					width : 70,
					editable : true
				}, {
					name : 'updateDate',
					index : 'updateDate',
					width : 90,
					editable : false,
					sorttype : "date",
					unformat : pickDate
				}, {
					name : 'updateTime',
					index : 'updateTime',
					width : 90,
					editable : false,
					sorttype : "date",
					unformat : pickDate
				},{
					name : 'operator',
					index : 'operator',
					width : 90,
					editable : false
				} ],
				viewrecords : true,// 是否在浏览导航栏显示记录总数
				rowNum : 10,// 每页显示记录数
				rowList : [ 10, 20, 30 ],// 用于改变显示行数的下拉列表框的元素数组。
				pager : pager_selector,
				altRows : true,// 设置为交替行表格,默认为false
				// toppager: true,
				editurl:ctx+'/topBankinfo/oper.do',
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
				caption : "数据字典列表",
				autowidth : true

			});

		jQuery(grid_selector).navGrid(pager_selector,{edit:false,add:false,del:false,search:false}).navButtonAdd(pager_selector,{  
			   caption:"新增",   
			   buttonicon:"icon-plus-sign purple",   
			   onClickButton: function(){

				   $("#dialog-form").dialog({
					   title:'新增数据字典',
					   title_html: true,
					   autoOpen: true,
					   height: 350,
					   width: 350,
				       modal: true,
				      buttons:[{
				    	  text:'提交',
				    	  "class" : "btn btn-primary btn-xs",
				    	  click:function(){
				    		  $.ajax({
				    			  url:ctx+'/topBasicKind/insert.do',
								  type: "POST",
								  data:$('#validation-form').serialize(),
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
					   var cell = $(grid_selector).jqGrid("getGridParam","selarrrow");
					   if(cell.length >0){ 
						   $("#dialog-form").dialog({
								  title:"编辑数据字典",
								  title_html: true,
								   autoOpen: true,
								   height: 350,
								   width: 350,
							       modal: true,
							      open:function(){
							    	  $(grid_selector).jqGrid('GridToForm',cell, '#dialog-form');
							      },
							      buttons:[{
							    	  text:'提交',
							    	  "class" : "btn btn-primary btn-xs",
							    	  click:function(){
							    		  $.ajax({
							    			  url:ctx+'/topBasicKind/update.do',
											  type: "POST",
											  data:$('#validation-form').serialize(),
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
					var params = {"ids[]":ids};
				   if(cells.length>0){
					   layer.confirm("确定删除吗？",{
						   btn: ['确定','取消'] //按钮
					   },function(r){
						   if(r){					   
							   $.ajax({
								   url:ctx+'/topBasicKind/delete.do',
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


// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

