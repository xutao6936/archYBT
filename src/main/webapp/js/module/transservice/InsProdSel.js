function resetSearchForm(){
	document.searchForm.reset();
}


function initInsProdSel(){
	var grid_selector = "#gridTable";
		jQuery(grid_selector).jqGrid(
			{
				datatype : "json",
				height : 400,
				mtype : "post",
				autowidth:true,
				shrinkToFit:false,  
				autoScroll: true,
				colNames : [ 'ID', '保险产品','险种中文名称','保障年期', '缴费方式','缴费年期', '保费','保额','份数','领取起始年龄',
				              '领取终止年龄'],
				colModel : [ {
					name : 'id',
					index : 'id',
					hidden:true,
					editable : false
				}, {
					name : 'rnRelation',
					index : 'rnRelation',
					editable : true,
				},{
					name : 'bfyName',
					index : 'bfyName',
					editable : true
				},{
					name : 'bfyCfcType',
					index : 'bfyCfcType',
					editable : true
				},{
					name : 'bfyCfcNo',
					index: 'bfyCfcNo',
					editable : true
				}, {
					name : 'expiryDate',
					index : 'expiryDate',
					editable : true,
				},  {
					name : 'bfyBirth',
					index : 'bfyBirth',
					editable : true,
					
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='0'){
							return "主险";
						}else if(cellValue=='1'){
							return "附加险";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				},  {
					name : 'bfySex',
					index : 'bfySex',
					editable : false,
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='1'){
							return "男";
						}else if(cellValue=='2'){
							return "女";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}
				}, {
					name : 'bfyAddress',
					index : 'bfyAddress',
					editable : false,
				}, {
					name : 'bfybm',
					index : 'bfybm',
					editable : false
				},   {
					name : 'bfyOrder',
					index : 'bfyOrder',
					editable : false
				}],
				//sortname : 'userId',
				viewrecords : true,// 是否在浏览导航栏显示记录总数
				rowNum : 10,// 每页显示记录数
				rowList : [ 10, 20, 30 ],// 用于改变显示行数的下拉列表框的元素数组。
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
				autowidth : true

			});
	
}
	//enable search/filter toolbar
	//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

	//switch element when editing inline
	function aceSwitch( cellvalue, options, cell ) {
		setTimeout(function(){
			$(cell) .find('input[type=checkbox]')
					.wrap('<label class="inline" />')
				.addClass('ace ace-switch ace-switch-5')
				.after('<span class="lbl"></span>');
		}, 0);
	}
	//enable datepicker
	function pickDate( cellvalue, options, cell ) {
		setTimeout(function(){
			$(cell) .find('input[type=text]')
					.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
		}, 0);
	}


	function beforeDeleteCallback(e) {
		var form = $(e[0]);
		if(form.data('styled')) return false;
		
		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
		style_delete_form(form);
		
		form.data('styled', true);
	}
	
	function beforeEditCallback(e) {
		var form = $(e[0]);
		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
		style_edit_form(form);
	}



	//it causes some flicker when reloading or navigating grid
	//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
	//or go back to default browser checkbox styles for the grid
	function styleCheckbox(table) {

	}
	

	//unlike navButtons icons, action icons in rows seem to be hard-coded
	//you can change them like this in here if you want
	function updateActionIcons(table) {

	}
	
	//replace icons with FontAwesome icons like above
	function updatePagerIcons(table) {
		var replacement = 
		{
			'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
			'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
			'ui-icon-seek-next' : 'icon-angle-right bigger-140',
			'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
		};
		$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
			var icon = $(this);
			var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
			
			if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
		});
	}

	function enableTooltips(table) {
		$('.navtable .ui-pg-button').tooltip({container:'body'});
		$(table).find('.ui-pg-div').tooltip({container:'body'});
	}
	
	
		//datepicker控件需要加的js方法
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
			$(this).next().focus();
		});
	

