$(function () {
	
	init();
});

function resetSearchForm(){
	document.searchForm.reset();
}

function submitSearchForm(){
	 jQuery("#grid-table").jqGrid('setGridParam', {
		   url:ctx+'/topAgentrate/getInsCorpByInsCorpCode.do',
		   type: "POST",
		   postData:$('#searchForm').serialize()
}).trigger("reloadGrid");
}

function init() {

	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
		jQuery(grid_selector).jqGrid(
			{
				url : ctx+'/topAgentrate/getTopAgentrateList.do',
				datatype : "json",
				height : 330,
				mtype : "post",
				colNames : [ '编号','保险产品编码','交易类型','机构','缴费年期','缴费年期单位','缴费类型','保障年期','保障年期单位', 
				             '收费方式','一次性收费金额','百分比收费比例','操作机构','更新日期','更新时间'],
				colModel : [{
					name : 'id',
					index : 'id',
					hidden:true,
					width : 60,
					sorttype : "int",
					editable : false
				},{
					name : 'insprdCode',
					index : 'insprdCode',
					width : 90,
					editable : true
					
				},{
					name : 'transType',
					index : 'transType',
					width : 100,
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='1'){
							return "实时";
						}else if(cellValue=='2'){
							return "非实时";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}	
				},{
					name : 'adminBank',
					index : 'adminBank',
					width : 90,
					editable : true
					
				}, {
					name : 'payPeriod',
					index : 'payPeriod',
					width : 90,
					editable : true
				}, {
					name : 'payPeriodType',
					index : 'payPeriodType',
					editable : true,
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='0'){
							return "年";
						}else if(cellValue=='1'){
							return "周岁";
						}else if(cellValue=='2'){
							return "终生";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}	
				}, {
					name : 'payType',
					index : 'payType',
					editable : true,
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='1'){
							return "趸缴";
						}else if(cellValue=='2'){
							return "月缴";
						}else if(cellValue=='3'){
							return "季缴";
						}else if(cellValue=='4'){
							return "半年缴";
						}else if(cellValue=='5'){
							return "年缴";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}	
				},{
					name : 'insPeriod',
					index : 'insPeriod',
					editable : true,
					editrules:{edithidden:true}
				}, {
					name : 'insPeriodType',
					index : 'insPeriodType',
					editable : true,
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='0'){
							return "年";
						}else if(cellValue=='1'){
							return "周岁";
						}else if(cellValue=='2'){
							return "保终生";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}	
				}, {
					name : 'rateType',
					index : 'rateType',
					width : 90,
					editable : true,
					formatter:function(cellValue, options, rowObject){
						if(cellValue=='1'){
							return "一次性";
						}else if(cellValue=='2'){
							return "百分比";
						}else if(cellValue=='' || cellValue==null){
							return "";
						}
					}	
				}, {
					name : 'onceAmt',
					index : 'onceAmt',
					width : 90,
					editable : true
				}, {
					name : 'percentAmt',
					index : 'percentAmt',
					width : 90,
					editable : true,
					formatter:function(cellValue, options, rowObject){
						if(cellValue!= ""){
							return cellValue+"%";
						}
					}
				}, {
					name : 'operatorBank',
					index : 'operatorBank',
					hidden:true
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
				caption : "手续费设置信息表",
				autowidth : true

			});
		jQuery(grid_selector).navGrid(pager_selector,{edit:false,add:false,del:false,search:false}).navButtonAdd(pager_selector,{  
			   caption:"新增",   
			   buttonicon:"icon-plus-sign purple",   
			   onClickButton: function(){ 
				   $("#insPrdCode").val($("#insProducts").val());
				   initGridData();
				   
				   $("#dialog-form").dialog({
					  title:"新增手续费",
					  title_html: true,
				      height: 650,
				      width: 1000,
				      modal: true,
				      buttons:[{
				    	  text:'提交',
				    	  "class" : "btn btn-primary btn-xs",
				    	  click:function(){
				    		  if(validate()==false){//当验证不通过时，直接组织提交
				    			  return false;
				    		  }else{
				    			  var obj = $("#gridData").jqGrid("getRowData");
					    		  var array=[]; 
					    		  var transType = $("#transType").val();
					    		  var bankcode = $("#bankcode").val();
					    		  var chargebacks = $("#chargebacks").val();
					    		  var rateProperty = $("#rateProperty").val();
					    		  var chargeMethod = $("#chargeMethod").val();
					    		  var numRenewalPeriod = $("#numRenewalPeriod").val();
					    		  var insPrdName = $("#insPrdName").val();
					    		    jQuery(obj).each(function(){
					    		    	var object = new Object();  
					    		    	object.transType = transType;
					    		    	object.numRenewalPeriod = numRenewalPeriod;
					    		    	object.bankcode = bankcode;
					    		    	object.chargebacks = chargebacks;
					    		    	object.rateProperty = rateProperty;
					    		    	object.insPrdName = insPrdName;
					    		    	object.chargeMethod = chargeMethod;
					    		    	object.payPeriod = this.payPeriod;  
					    		    	object.insPeriod = this.insPeriod; 
					    		    	object.percentAmt = this.percentAmt;
					    		    	object.onceAmt = this.onceAmt;
					    		    	array.push(object);  
					    		    });
					    		    var postData =  JSON.stringify(array); 
					    		  $.ajax({
					    			  url:ctx+'/topAgentrate/insertTopAgentrate.do',
									  type: "POST",
									  data:{postData:postData,insPrdName:$("#insPrdName").val()},
									  dataType:'json',
									  //beforeSend:validate(),
									  success:function(req){
										  if('SUCC'==req.msg){
											  layer.alert('添加成功',{
										            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
										            ,closeBtn: 0,icon:1
										        }); 
											  $("#dialog-form").dialog('close');
											  $(grid_selector).trigger("reloadGrid");
											
										  }else{
											  layer.alert('添加失败',{
										            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
										            ,closeBtn: 0,icon:2
										        }); 
										  }
									  }
					    		  });  
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
	
	/**
	 * 提交前校验
	 */
	function validate(){
		 var transType = $("#transType").val();
		 var bankcode = $("#bankcode").val();
		 var chargebacks = $("#chargebacks").val();
		 var rateProperty = $("#rateProperty").val();
		 var chargeMethod = $("#chargeMethod").val();
		 if(transType == ""){
		        layer.alert('交易类型不能为空',{
		            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
		            ,closeBtn: 0,icon:2
		        });
			 return false;
		 }
		 if(bankcode == ""){
		        layer.alert('总公司/分行不能为空',{
		            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
		            ,closeBtn: 0,icon:2
		        });
			 return false;
		 }
		 if(chargebacks == ""){
		        layer.alert('扣款方式不能为空',{
		            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
		            ,closeBtn: 0,icon:2
		        });
			 return false;
		 }
		 if(rateProperty == ""){
		        layer.alert('费率性质不能为空',{
		            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
		            ,closeBtn: 0,icon:2
		        });
			 return false;
		 }
		 if(chargeMethod == ""){
		        layer.alert('收费方式不能为空',{
		            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
		            ,closeBtn: 0,icon:2
		        });
			 return false;
		 }
		if(typeof(lastrow) == "undefined"){//如果jqgrid未被编辑，直接跳过
			return;
		}else{
	        $("#gridData").jqGrid("saveCell",lastrow,lastcell);
		}
		
	}
	
	
	function initGridData() {
		var grid_selector = "#gridData";
			jQuery(grid_selector).jqGrid(
				{
					url : ctx+'/topAgentrate/getAgentrateByInsPrdCode.do',
					datatype : "json",
					height: 350,
					width: 1000,
					mtype : "post",
					colNames : [ '编号','缴费年期','保险年期','百分比收费比例(%)','一次性收费金额(元)'],
					colModel : [{
					name : 'id',
					index : 'id',
					hidden:true,
						 width: 200,
						sorttype : "int",
						editable : false
					},{
						name : 'payPeriod',
						index : 'payPeriod',
						editable : false,
						 formatter:function(cellValue, options, rowObject){
								if(cellValue=='0趸缴'){
									return "趸缴";
								}else {
									return cellValue;
								}
							}	
						
					},{
						name : 'insPeriod',
						index : 'insPeriod',
						 width: 200,
						 formatter:function(cellValue, options, rowObject){
								if(cellValue=='2终生'){
									return "终生";
								}
								else {
									return cellValue;
								}
							}	
					},{
						name : 'percentAmt',
						index : 'percentAmt',
						width: 200,
						editable : true
					}, {
						name : 'onceAmt',
						index : 'onceAmt',
						width: 200,
						editable : true
					}],
					sortname : 'id',
					viewrecords : true,// 是否在浏览导航栏显示记录总数
					altRows : true,// 设置为交替行表格,默认为false
					cellsubmit:"clientArray",
					cellEdit : true,
					multiselect : false,
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
					autowidth : true,
					
					beforeEditCell:function(rowid, cellname, value, iRow, iCol){
						lastrow = iRow;
						lastcell = iCol;
			
					},
				    afterSaveCell:function(rowid, cellname, value, iRow, iCol){
				        $("#gridData").jqGrid('setCell', rowid, cellname, value);
				    },
				   
				    onCellSelect:function(rowid, index, contents, event){
				    	//alert(rowid+","+index+","+contents);
				    	var rowid = $("#gridData").getGridParam("selrow"); 
						var rowData = $("#gridData").getRowData(rowid);
						//alert(rowData.percentAmt+","+rowData.onceAmt);
				    	}
				});
			
	}

}



