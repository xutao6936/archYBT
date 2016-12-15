function resetSearchForm(){
	document.searchForm.reset();
}

function init(){
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
		jQuery(grid_selector).jqGrid(
			{
				//url : ctx+'/topInsprdInfo/getTopInsPrdInfoList.do',
				datatype : "json",
				height : 400,
				mtype : "post",
				autowidth:true,
				shrinkToFit:false,  
				autoScroll: true,
				colNames : [ 'ID', '与被保人关系','姓名','证件类型', '证件号码','证件有效期', '出生日期','性别','邮寄地址','受益比例（%）',
				              '受益顺序','受益人类型'],
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
				},  {
					name : 'bfyType',
					index : 'bfyType',
					editable : false
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
				autowidth : true

			});

		jQuery(grid_selector).navGrid(pager_selector,{edit:false,add:false,del:false,search:false}).navButtonAdd(pager_selector,{  
			   caption:"新增",   
			   buttonicon:"icon-plus-sign purple",   
			   onClickButton: function(){ 
			      // $("#validation-form").clearForm();
				   $("#dialog-form").dialog({
					  title:"新增受益人信息",
				      height: 450,
				      width: 1000,
				      modal: true,
				      buttons:[{
				    	  text:'提交',
				    	  "class" : "btn btn-primary btn-xs",
				    	  click:function(){
				    		  jQuery("#grid-table").jqGrid('FormToGrid', '', '#validation-form', 'add', 'last' );
				    		  $("#dialog-form").dialog('close');
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
								  title:"编辑受益人信息",
							      height: 550,
							      open:function(){
							    	  $(grid_selector).jqGrid('GridToForm',cell, '#dialog-form');
							      },
							      width: 1000,
							      modal: true,
							      buttons:[{
							    	  text:'提交',
							    	  "class" : "btn btn-primary btn-xs",
							    	  click:function(){
							    		  jQuery("#grid-table").jqGrid('FormToGrid', '', '#validation-form', 'edit', '' );
							    		  $("#dialog-form").dialog('close');  
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
							  layer.alert('请选中一行!',{
						            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
						            ,closeBtn: 0,icon:7
						        });
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
					       function(index){      //确认后执行的操作  
							   if(index){
								   $.ajax({
									   url:ctx+'/topInsprdInfo/deleteTopInsPrdInfo.do',
									   type: "POST",
									   dataType:'json',
									   data:{"ids[]":params},
								       success:function(msg){
								    	   if('SUCC'==msg.result){
								    		   layer.alert('删除成功',{
										            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
										            ,closeBtn: 0,icon:1
										        });  
								    		   $(grid_selector).trigger("reloadGrid");
								    	   }else {
								    		   layer.alert('删除失败',{
										            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
										            ,closeBtn: 0,icon:2
										        });  
								    	   }
								       }	   
								   });
							   }
					       },  
					       function(){      //取消后执行的操作  
					    	  return;
					       }); 
				   }else{
					   layer.alert('请选中一行!',{
				            skin: 'layui-layer-molv' //样式类名,	墨绿深蓝风
				            ,closeBtn: 0,icon:7
				        });  
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
	
}
