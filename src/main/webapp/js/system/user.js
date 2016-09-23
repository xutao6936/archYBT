$(function() {
	init();
	//validate();
	
	$("#searchFilter").unbind('click').click(function(){
		 var loginAccount = jQuery("#loginAccount").val()||"";
		 var userName = jQuery("#searchuserName").val()||"";
		  jQuery("#grid-table").jqGrid('setGridParam', {
		    url : ctx+'/user/getUserList.do',
		    page : 1,
		    postData:{'loginAccount':loginAccount,"userName":userName}
		  }).trigger("reloadGrid");
	});
	
	
	$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
		_title: function(title) {
			var $title = this.options.title || '&nbsp;';
			if( ("title_html" in this.options) && this.options.title_html == true )
				title.html($title);
			else title.text($title);
		}
	}));
	
});


var zTree;

function validate(){
	$('#validation-form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: false,
		rules: {
			loginAccount: {
				required: true
			},
			loginPwd: {
				required: true,
				minlength: 5
			},
			confirm_password:{
				required: true,
				minlength: 5,
				equalTo:'#loginPwd'
			},
			userName:{
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
				url : ctx+'/user/getUserList.do',
				datatype : "json",
				height : 330,
				mtype : "post",
				colNames : [ '','用户名', '真实姓名', '状态', '创建日期',  '更新日期',
						'更新时间', '操作用户' ],
				colModel : [{
					name : 'userId',
					index : 'userId',
					hidden:true,
					width : 90,
					editable : true
				},{
					name : 'loginAccount',
					index : 'loginAccount',
					width : 90,
					editable : true
				}, {
					name : 'userName',
					index : 'userName',
					width : 150,
					editable : true,
					editoptions : {
						size : "20",
						maxlength : "30"
					}
				}, {
					name : 'userStatus',
					index : 'userStatus',
					width : 70,
					editable : true,
					edittype : "select",
					stype:'select',
					editoptions : {
						value : "0:有效;1:无效"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "有效";
						}else if(cellValue=='1'){
							return "无效";
						}
					},
					unformat : aceSwitch
				},  {
					name : 'createDate',
					index : 'createDate',
					width : 90,
					editable : false,
					sorttype : "date",
					unformat : pickDate,
					//stype:'date',
					searchrules:{date:true}
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
				}, {
					name : 'updateOperator',
					index : 'updateOperator',
					width : 150,
					sortable : false,
					editable : true
				} ],
				//sortname : 'userId',
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
				caption : "用户信息列表",
				//toolbar: [true, 'top'],
				autowidth : true,
				

			});
	// enable search/filter toolbar
	 //jQuery(grid_selector).jqGrid('filterToolbar',{searchOperators :true});
		
		jQuery(grid_selector).navGrid(pager_selector,{edit:false,add:false,del:false,search:false}).navButtonAdd(pager_selector,{  
		   caption:"新增",   
		   buttonicon:"icon-plus-sign purple",   
		   onClickButton: function(){
			   $("#loginAccount_userName").val("");
			   /*$("#loginPwd").val("");
			   $("#confirm_password").val("");*/
			   $("#userName").val("");
			   $("#userDept").val("");
			   
			   $("#dialog-form").dialog({
				   title:"<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-plus'></i>新增用户</h4></div>",
				   title_html: true,
				   autoOpen: true,
				   height: 400,
				   width: 350,
			       modal: true,
			      buttons:[{
			    	  text:'提交',
			    	  "class" : "btn btn-primary btn-xs",
			    	  click:function(){
			    		  $.ajax({
			    			  url:ctx+'/user/insert.do',
							  type: "POST",
							  data:$('#validation-form').serialize(),
							  dataType:'json',
							  beforeSend:validate(),
							  error:function(msg){
								  if('SUCC'==msg.responseText){
									  $("#dialog-form").dialog('close');
									  $(grid_selector).trigger("reloadGrid");
								  }else{
									  layer.alert(msg.responseText,{icon:2}); 
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
				   var cell = $(grid_selector).jqGrid("getGridParam","selrow");
				   if(cell!=null && cell.length>0){ 
					   $("#dialog-form").dialog({
						      title:"<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-edit'></i>更新用户</h4></div>",
							  title_html: true,
							  autoOpen:true,
							  height: 400,
						      width: 350,
						      open:function(){
						    	  $(grid_selector).jqGrid('GridToForm',cell, '#dialog-form');
						      },
						      modal: true,
						      buttons:[{
						    	  text:'提交',
						    	  "class" : "btn btn-primary btn-xs",
						    	  click:function(){
						    		  $.ajax({
						    			  url:ctx+'/user/update.do',
										  type: "POST",
										  data:$('#validation-form').serialize(),
										  dataType:'json',
										  beforeSend:validate(),
										  error:function(msg){
											  if('SUCC'==msg.responseText){
												  $("#dialog-form").dialog('close');
												  $(grid_selector).trigger("reloadGrid");
											  }else{
												  layer.alert(msg.responseText,{icon:2}); 
											  }
										  }
						    		  });
						    	  }},{
						    		  text:"关闭",
							    	  "class" : "btn btn-xs",
						    		  click:function(){
						    			  $(this).dialog('close');
						    			  $(this).dialog('destroy');					    			  
						    		  }
						    	  }]

						   }); 
					   }else {
						  layer.alert('请选中一行!',{icon:2}); 
					   
				   }
				   
			   },   
			   position:"last"  
			}).navButtonAdd(pager_selector,{  
		   caption:"删除",   
		   buttonicon:"icon-trash red",   
		   onClickButton: function(){   
			   var cells = $(grid_selector).jqGrid("getGridParam","selarrrow");
			   if(cells.length>0){
				   var params = new Array();
				   $.each(cells,function(i,v){
					   var ret = $(grid_selector).jqGrid('getRowData', v);
					   params.push(ret.userId);
				   });
				   layer.confirm("确定删除吗？",{
					   btn: ['确定','取消'] //按钮
				   },function(r){
					   if(r){					   
						   $.ajax({
							   url:ctx+'/user/deleteUser.do',
							   type: "POST",
							   data:{"ids[]":params},
							   success:function(msg){
								   if('SUCC'==msg){
									   $(grid_selector).trigger("reloadGrid");
									   layer.close(r);
								   }else {
									   layer.alert('删除失败',{icon:2});  
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
				   caption:"上传",   
				   buttonicon:"icon-upload green",   
				   onClickButton: uploadPath,   
				   position:"last"  
				}).navButtonAdd(pager_selector,{  
					   caption:"角色设置",   
					   buttonicon:"icon-user green",   
					   onClickButton: function(){glmenu();},   
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

	
function uploadPath(){
	var cell = $(grid_selector).jqGrid("getGridParam","selrow");
	   if(cell !=null && cell.length > 0){
		   $("#img_file").attr("value","");
		   $("#userFile-dialog").dialog({
			   
			      title:"<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-upload'></i>上传图片</h4></div>",
				  title_html: true,
				  //autoOpen: false,
			      height: 450,
			      width: 400,
			      open:function(){
			    	  $(grid_selector).jqGrid('GridToForm',cell, '#upload-form');
			      },
			      width: 400,
			      modal: true,
			      buttons:[{
			    	  text:"提交",
			    	  "class" : "btn btn-primary btn-xs",
			    	  click:function(){
			    		  var selectedFile = $('#img_file').get(0).files[0];
			    		  if(null==selectedFile){
			    			  layer.alert("请选择文件，或者不要重复提交！",{icon:2});
			    			  return;
			    		  }else{
			    			  $("#img_file").fileinput('upload');
			    		  }
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
			   layer.alert('请选中一行!',{icon:2}); 
	   }
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
	
	
	
	//菜单管理方法
	function glmenu(){
		var cell = $(grid_selector).jqGrid("getGridParam","selrow");
		if(null == cell || 0 == cell.length){
			layer.alert('请选中一行!',{icon:2}); 
		}else{
			var ret = $(grid_selector).jqGrid('getRowData', cell);
			var userId = ret.userId;
			$.ajax({
			  	  url:ctx+'/topUserRole/userRole.do',
				  type: "POST",
				  data:{"userId":userId},
				  dataType:'json',
				  error:function(msg){
					  if('SUCC'==msg.responseText){
						  $("#menu-dialog").dialog('close');
						  $(grid_selector).trigger("reloadGrid");
					  }else{
						  layer.alert(msg.responseText,{icon:2}); 
					  }
				  },
				  success:function(data){
					  
					  var setting = {
							    showLine: true,
							    checkable: true
							};
					  
					  var zTreeNodes = eval(data.menulist);
					  
					  zTree = $("#menuTree").zTree(setting,zTreeNodes);
					  $("#userId").empty().val(userId);
					  $("#menu-dialog").dialog({
						  title:"<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-user'></i>角色设置 </h4></div>",
						  title_html: true,
					      height: 400,
					      width: 350,
					      modal: true,
					      buttons:[{
						    	  text:"提交",
						    	  "class" : "btn btn-primary btn-xs",
						    	  click:function(){
						    		  savemenu();
						    	  }
						      },{
						    	  text:"关闭",
						    	  "class" : "btn btn-xs",
						    	  click:function(){
						    		  $(this).dialog('close');
						    	  }
						      }]

					   });
					  
					  
				  }
			  });
			
			
		}
		
	}

	function savemenu(){
	     	nodes = zTree.getCheckedNodes(true);
		 
		 	var tmpNode;
			var ids = "";
			var param = new Array();
			for(var i=0; i<nodes.length; i++){
				tmpNode = nodes[i];
				if(i!=nodes.length-1){
					ids += tmpNode.id+",";
					param.push(tmpNode.id);
				}else{
					ids += tmpNode.id;
					param.push(tmpNode.id);
				}
			}
			$.ajax({
			  url:ctx+'/topUserRole/updateUserRole.do',
			  type: "POST",
			  data:{"roleId":ids,"userId":$("#userId").val(),"idstrs":param},
			  dataType:'json',
			  success:function(data){
				  if("SUCC" == data.result){
					  $("#menu-dialog").dialog('close');
					  layer.alert("设置成功！",{icon:1});
					  //$(grid_selector).trigger("reloadGrid");
				  }else{
					  layer.alert(msg.responseText,{icon:2}); 
				  }
			  }
		  });
	}
	
}



// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

