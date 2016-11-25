$(function() {
	
	$.common.plugin.jqGrid.autoResize({
        dataGrid: '#grid-table',
        callback: init,
        filterToolbar:false,
        enableAutoResize: true
    });
	
	//init();
	//validate();	
});

function init(size) {

	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
    $(grid_selector).jqGrid($.extend($.common.plugin.jqGrid.settings({
        size: size
    }),{
				url : ctx+'/topBankinfo/getTopBankinfoList.do',
				/*datatype : "json",
				height : 330,
				mtype : "post",*/
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
					editable : true,
					edittype:'text',
					editoptions:{
						dataInit:function(e){
							$(e).autocomplete({
								delay:1000,
								source:function(query,process){
					        		$.post(ctx+'/topBankinfo/getTopBankinfoList.do',{"bankCode":query,"page":1,"rows":10},function(data){
						        	    return process(data.list);
					        		},"json");
					        	},
					        	formatItem:function(item){
					                return item["bankName"]+"("+item["bankCode"]+"，"+item["bankName"]+") - "+item["bankLevel"];
					            },
					            setValue:function(item){
					                return {'data-value':item["bankCode"],'real-value':item["bankCode"]};
					            }
								
				            });
						}
					}
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
				//rowNum : 10,// 每页显示记录数
				//rowList : [ 10, 20, 30 ],// 用于改变显示行数的下拉列表框的元素数组。
				pager : pager_selector,
				altRows : true,// 设置为交替行表格,默认为false
				// toppager: true,
				editurl:ctx+'/topBankinfo/oper.do',
				multiselect : true,
				// multikey: "ctrlKey",
				multiboxonly : true,
				caption : "机构信息列表",
				//toolbar: [true, 'top'],
				autowidth : true

			})).navGrid(pager_selector,{
				add:true,
				edit:true,
				del:true,
				view:true,
				edittext:'编辑',
				edittitle:'编辑数据',
				addtext:'新增',
				addicon:'icon-plus-sign purple',
				addtitle:'新增一条数据',
				alerttext:'请选择一条数据',
				deltitle:'删除一条数据',
				deltext:'删除',
				search:false,
				refresh:true,
				refreshicon:'icon-refresh green',
				viewicon:'ui-icon icon-zoom-in grey',
				refreshtext:'刷新',
				refreshtitle:'刷新数据',
				viewtext:'查看',
				viewtitle:'查看',
				delfunc:function (options){
					 var cells = $(grid_selector).jqGrid("getGridParam","selarrrow");
					   if(cells.length>0){
						   var params = new Array();
						   $.each(cells,function(i,v){
							   var ret = $(grid_selector).jqGrid('getRowData', v);
							   params.push(ret.bankId);
						   });
						   
						   layer.confirm("确定删除吗？",{
							   btn: ['确定','取消'] //按钮
						   },function(r){
							   if(r){					   
								   $.ajax({
									   url:ctx+'/topBankinfo/delete.do',
									   type: "POST",
									   dataType:'json',
									   data:{"ids[]":params},
								       success:function(msg){
								    	   if('SUCC'==msg.result){
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
				}
			},
				// edit options
			    $.extend($.common.plugin.jqGrid.form.edit, {
					editCaption:'编辑机构'
				}),
				$.extend($.common.plugin.jqGrid.form.add, {
					editCaption:'新增机构'
				}),
				$.extend($.common.plugin.jqGrid.form.del, {
				}),
				$.extend($.common.plugin.jqGrid.form.search, {
				}),
				$.extend($.common.plugin.jqGrid.form.view, {
				})).navSeparatorAdd(pager_selector,{
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

	function delFunc(options){
		var defaults = {
			url:null
		};
		options = $.extend({}, defaults, options);
		 var cells = $(grid_selector).jqGrid("getGridParam","selarrrow");
		   if(cells.length>0){
			   var params = new Array();
			   $.each(cells,function(i,v){
				   var ret = $(grid_selector).jqGrid('getRowData', v);
				   params.push(ret.bankId);
			   });
			   
			   layer.confirm("确定删除吗？",{
				   btn: ['确定','取消'] //按钮
			   },function(r){
				   if(r){					   
					   $.ajax({
						   url:options.url,
						   type: "POST",
						   dataType:'json',
						   data:{"ids[]":params},
					       success:function(msg){
					    	   if('SUCC'==msg.result){
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
	}


}


// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

