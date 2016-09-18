$(function() {
	init();
	//validate();	
});

function init() {

	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
		jQuery(grid_selector).jqGrid(
			{
				url : ctx+'/topBankinfo/getTopBankinfoList.do',
				datatype : "json",
				height : 330,
				mtype : "post",
				colNames : [ '机构ID','机构编号','机构名称', '机构等级', '上级机构编码', '状态',  '更新日期',
						'更新时间'],
				colModel : [{
					name : 'bankId',
					index : 'bankId',
					hidden:true,
					width : 90,
					editable : true
				},{
					name : 'bankCode',
					index : 'bankCode',
					//hidden:true,
					width : 90,
					editable : true
				},{
					name : 'bankName',
					index : 'bankName',
					width : 90,
					editable : true
				}, {
					/*
					0-总行
					1-分行
					2-支行
					3-网点
					*/
					name : 'bankLevel',
					index : 'bankLevel',
					width : 150,
					editable : true,
					edittype : "select",
					editoptions : {
						value : "0:总行;1:分行;2:支行;3:网点"
					},
					formatter:function(cellValue){
						if(cellValue=='0'){
							return "总行";
						}else if(cellValue=='1'){
							return "分行";
						}else if(cellValue=='2'){
							return "支行";
						}else if(cellValue=='3'){
							return "网点";
						}
					}
				},  {
					name : 'upBankCode',
					index : 'upBankCode',
					width : 90,
					editable : true
					//sorttype : "date",
					//unformat : pickDate
				}, {
					name : 'status',
					index : 'status',
					width : 70,
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
						}
					},
					unformat : aceSwitch
				},  {
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
				} ],
				//sortname : 'userId',
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
				// editurl: $path_base+"/dummy.html",//nothing is saved
				caption : "机构信息列表",
				//toolbar: [true, 'top'],
				autowidth : true

			});
		//$("#t_grid-table").append("<table><tr><td>用户名：</td><td><input/></td></tr></table>");
	// enable search/filter toolbar
	// jQuery(grid_selector).jqGrid('filterToolbar',{searchOperators :true});
		jQuery(grid_selector).navGrid(pager_selector,{
			edit:true,
			edittext:'编辑',
			edittitle:'编辑数据',
			add:true,
			addtext:'新增',
			addicon:'icon-plus-sign purple',
			addtitle:'新增一条数据',
			alerttext:'请选择一条数据',
			deltitle:'删除一条数据',
			del:true,
			deltext:'删除',
			search:false,
			refresh:true,
			refreshicon:'icon-refresh green',
			viewicon:'ui-icon icon-zoom-in grey',
			refreshtext:'刷新',
			refreshtitle:'刷新数据',
			view:true,
			viewtext:'查看',
			viewtitle:'查看',
			
			delfunc:function(){
				 var cells = $(grid_selector).jqGrid("getGridParam","selarrrow");
				   if(cells.length>0){
					   var params = new Array();
					   $.each(cells,function(i,v){
						   var ret = $(grid_selector).jqGrid('getRowData', v);
						   params.push(ret.bankId);
					   });
					   $.ajax({
						   url:ctx+'/topBankinfo/delete.do',
						   type: "POST",
						   dataType:'json',
						   data:{"ids[]":params},
					       success:function(msg){
					    	   if('SUCC'==msg.result){
					    		   $(grid_selector).trigger("reloadGrid");
					    	   }else {
					    		   layer.alert('删除失败',{icon:2});  
					    	   }
					       }	   
					   });
				   }else{
					   layer.alert('请选中一行!',{icon:2}); 
				   }
			}
			},{
				//edit_options
				closeAfterEdit:true,
				closeOnEscape:true,
				afterSubmit:function(response, postdata) {
					var data = response.responseText;
					data = $.parseJSON(data);
					if(data['result']=='ERROR'){
						layer.alert(data['errInfo'],{icon:2});  
					}else {
						return true;
					}
				}
			},{
				//add_options
				closeAfterAdd:true,
				closeOnEscape:true,
				afterSubmit:function(response, postdata) {
					var data = response.responseText;
					data = $.parseJSON(data);
					if(data['result']=='ERROR'){
						layer.alert(data['errInfo'],{icon:2});  
					}else {
						return true;
					}
				}
			},{},{},{}).navSeparatorAdd(pager_selector,{
			sepclass : "ui-separator",
			sepcontent: ''
		}).navButtonAdd(pager_selector,{  
			   caption:"导入",   
			   buttonicon:"icon-upload green",   
			   onClickButton: function(){},   
			   position:"last"  
			}).navButtonAdd(pager_selector,{  
				   caption:"下载",   
				   buttonicon:"icon-download green",   
				   onClickButton: function(){
					   location.href=ctx+'/topBankinfo/download.do';
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

// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

