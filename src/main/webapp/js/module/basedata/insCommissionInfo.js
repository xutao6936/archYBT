$(function() {
	init();
	//validate();
});

function resetSearchForm(){
	document.searchForm.reset();
}

function submitSearchForm(){
	 jQuery("#grid-table").jqGrid('setGridParam', {
		   url:ctx+'/topInsCorpInfo/getInsCorpByInsCorpCode.do',
		   type: "POST",
		   postData:$('#searchForm').serialize()
}).trigger("reloadGrid");
}

function init() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
		jQuery(grid_selector).jqGrid(
			{
				url : ctx+'/topInsCorpInfo/getTopInsCorpInfoList.do',
				datatype : "json",
				height : 200,
				mtype : "post",
				colNames : [ 'ID','保险公司编码','保险公司名称','简称', '保险公司级别','上级公司代码','保险公司英文名称',
				             '地址','邮编','联系电话','传真','邮箱','状态','操作员','操作机构','创建日期','更新日期', '更新时间',
				             '统一柜面接口','统一网销接口','统一对账接口','统一非实时对账接口','统一退保接口','开通渠道'],
				colModel : [{
					name : 'id',
					index : 'id',
					//隐藏该列
					hidden:true,
					editable:true,
					edittype:'text',editrules:{required:true}
				},{
					name : 'insCorpCode',
					index : 'insCorpCode',
					width : 90,
					editable : true
					
				},{
					name : 'insCorpName',
					index : 'insCorpName',
					width : 90,
					editable : true
				},{
					name : 'insSimpName',
					index : 'insSimpName',
					width : 50,
					editable : true
				},{
					name : 'insCorpLevel',
					index : 'insCorpLevel',
					width : 100,
					unformat:function(cellValue, options, rowObject){
						if(cellValue=='总公司'){
							return "0";
						}else if(cellValue=='分公司'){
							return "1";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					},
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='0'){
							return "总公司";
						}else if(cellValue=='1'){
							return "分公司";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
					
				},{
					name : 'upCorpCode',
					index : 'upCorpCode',
					width : 90,
					editable : true
					
				}, {
					name : 'insCorpEnName',
					index : 'insCorpEnName',
					width : 120,
					editable : true
				}, {
					name : 'address',
					index : 'address',
					hidden:true,
					editable : true,
					editrules:{edithidden:true}
				}, {
					name : 'postCode',
					index : 'postCode',
					hidden:true,
					editable : true,
					editrules:{edithidden:true}
				},{
					name : 'phone',
					index : 'phone',
					hidden:true,
					editable : true,
					editrules:{edithidden:true}
				}, {
					name : 'fax',
					index : 'fax',
					hidden:true,
					editable : true,
					editrules:{edithidden:true}
				}, {
					name : 'email',
					index : 'email',
					hidden:true,
					editable : true,
					editrules:{edithidden:true}
				}, {
					name : 'status',
					index : 'status',
					width : 50,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "0:有效;1:无效"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "有效";
						}else if(cellValue=='1'){
							return "无效";
						}else if(cellValue=='' ||cellValue==null){
							return "";
						}
					}
				}, {
					name : 'operatorCode',
					index : 'operatorCode',
					hidden:true
				}, {
					name : 'operatorBank',
					index : 'operatorBank',
					hidden:true
				},{
					name : 'createDate',
					index : 'createDate',
					width : 70,
					editable : false,
					sorttype : "date",
					unformat : pickDate
				},{
					name : 'updateDate',
					index : 'updateDate',
					width : 70,
					editable : false,
					sorttype : "date",
					unformat : pickDate
				}, {
					name : 'updateTime',
					index : 'updateTime',
					width : 70,
					hidden:true,
					sorttype : "date",
					unformat : pickDate
				},{
					name : 'commonCountFlag',
					index : 'commonCountFlag',
					width : 90,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "0:是;1:否"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "是";
						}else if(cellValue=='1'){
							return "否";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				},{
					name : 'commonNetFlag',
					index : 'commonNetFlag',
					width : 90,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "0:是;1:否"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "是";
						}else if(cellValue=='1'){
							return "否";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				},{
					name : 'commonCheckFlag',
					index : 'commonCheckFlag',
					width : 90,
					editable : false,
					edittype : "select",
					editoptions : {
						value : "0:是;1:否"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "是";
						}else if(cellValue=='1'){
							return "否";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				},{
					name : 'commonNossdcheckFlag',
					index : 'commonNossdcheckFlag',
					width : 130,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "0:是;1:否"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "是";
						}else if(cellValue=='1'){
							return "否";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				},{
					name : 'commonSystbFlag',
					index : 'commonSystbFlag',
					width : 90,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "0:是;1:否"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "是";
						}else if(cellValue=='1'){
							return "否";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				},{
					name : 'channelFlag',
					index : 'channelFlag',
					width : 70,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "01:柜面;02:网银;03:手机;04:直销;05:自助"
					},
					formatter:function(cellValue){
						if(cellValue=='01'){
							return "柜面";
						}else if(cellValue=='02'){
							return "网上银行";
						}else if(cellValue=='03'){
							return "手机银行";
						}else if(cellValue=='04'){
							return "直销银行";
						}else if(cellValue=='05'){
							return "自助终端";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				}],
				//sortname : 'id',
				viewrecords : true,// 是否在浏览导航栏显示记录总数
				rowNum : 10,// 每页显示记录数
				rowList : [ 10, 20, 30 ],// 用于改变显示行数的下拉列表框的元素数组。
				pager : pager_selector,
				altRows : true,// 设置为交替行表格,默认为false
				editurl:ctx+'/topInsCorpInfo/oper.do',
				multiselect : true,
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
				caption : "保险公司信息表",
				autowidth : true

			});
		jQuery(grid_selector).navGrid(pager_selector,{edit:false,add:false,del:false,search:false}).navButtonAdd(pager_selector,{  
			   caption:"新增",   
			   buttonicon:"icon-plus-sign purple",   
			   onClickButton: function(){ 
			      // $("#validation-form").clearForm();
				   $("#dialog-form").dialog({
					  title:"新增用户",
					  title_html: true,
				      height: 550,
				      width: 1000,
				      modal: true,
				      buttons:[{
				    	  text:'提交',
				    	  "class" : "btn btn-primary btn-xs",
				    	  click:function(){
				    		  $.ajax({
				    			  url:ctx+'/topInsCorpInfo/insertTopInsCorpInfo.do',
								  type: "POST",
								  data:$('#validation-form').serialize(),
								  dataType:'json',
								 // beforeSend:validate(),
								  success:function(msg){
									  if('SUCC'==msg.result){
										  layer.alert('添加成功',{icon:1});  
										
										  $("#dialog-form").dialog('close');
										  $(grid_selector).trigger("reloadGrid");
									  }else{
										  layer.alert('添加失败',{icon:2});  
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
			//   position:"last"  
			}).navButtonAdd(pager_selector,{  
				   caption:"编辑",   
				   buttonicon:"icon-pencil blue",   
				   onClickButton: function(){  
					   $("#validation-form")[0].reset();
					   var cell = $(grid_selector).jqGrid("getGridParam","selarrrow");
					   if(cell.length >0){ 
						   $("#dialog-form").dialog({
								  title:"编辑用户",
							      height: 550,
							      open:function(){
							    	  $(grid_selector).jqGrid('GridToForm',cell, '#dialog-form');
							      },
							      width: 1000,
							      modal: true,
							      buttons:{
							    	  "提交":function(){
							    		  $.ajax({
							    			  url:ctx+'/topInsCorpInfo/updateTopInsCorpInfo.do',
											  type: "POST",
											  data:$('#validation-form').serialize(),
											  dataType:'json',
											//  beforeSend:validate(),
											  success:function(msg){
												  alert(msg.result);
												  if('SUCC'==msg.result){
													  layer.alert('修改成功',{icon:1});  
													  $("#dialog-form").dialog('close');
													  $(grid_selector).trigger("reloadGrid");
												  }else{
													  layer.alert('修改失败',{icon:2});  
												  }
											  }
							    		  });
							    	  },
							    	  "关闭":function(){
							    		  $(this).dialog('close');
							    	  }
							      }

							   }); 
						   }else {
							  layer.alert('请选中一行!',{icon:2}); 
					   }
				   } 
				   //position:"last"  
				}).navButtonAdd(pager_selector,{  
			   caption:"删除",   
			   buttonicon:"icon-trash red",   
			   onClickButton: function(){   
				   var cells = $(grid_selector).jqGrid("getGridParam","selarrrow");
				   if(cells.length>0){
					   var params = new Array();
					   $.each(cells,function(i,v){
						   var ret = $(grid_selector).jqGrid('getRowData', v);
						   params.push(ret.id);
					   });
					   layer.confirm("确认删除吗？",  {icon: 3, title:'提示'},
							   //{ btn : ['确定','取消']},//按钮
					       function(index){      //确认后执行的操作  
							   if(index){
								   $.ajax({
									   url:ctx+'/topInsCorpInfo/deleteTopInsCorpInfo.do',
									   type: "POST",
									   dataType:'json',
									   data:{"ids[]":params},
								       success:function(msg){
								    	   if('SUCC'==msg.result){
								    		   layer.alert('删除成功',{icon:1});  
								    		   $(grid_selector).trigger("reloadGrid");
								    	   }else {
								    		   layer.alert('删除失败',{icon:2});  
								    	   }
								       }	   
								   });
							   }
					       },  
					       function(){      //取消后执行的操作  
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
					   caption:"导入",   
					   buttonicon:"icon-upload green",   
					   onClickButton: function(){},   
					   position:"last"  
					}).navButtonAdd(pager_selector,{  
						   caption:"下载",   
						   buttonicon:"icon-download green",   
						   onClickButton: function(){
							   location.href=ctx+'/topInsCorpInfo/download.do';
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
		buttons.eq(1).prepend('<i class="icon-remove"></i>');

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
		buttons.eq(1).prepend('<i class="icon-remove"></i>');
	}

	function style_search_filters(form) {
		form.find('.delete-rule').val('X');
		form.find('.add-rule').addClass('btn btn-xs btn-primary');
		form.find('.add-group').addClass('btn btn-xs btn-success');
		form.find('.delete-group').addClass('btn btn-xs btn-danger');
	}
	function style_search_form(form) {
		var dialog = form.closest('.ui-jqdialog');
		var buttons = dialog.find('.EditTable');
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
				'<div class="widget-header" />');
		style_delete_form(form);
		form.data('styled', true);
	}

	function beforeEditCallback(e) {
		var form = $(e[0]);
		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner(
				'<div class="widget-header" />');
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
						});
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



