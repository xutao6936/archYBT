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

       //组装json           
       var showData2 = new DataSourceTree({  
          data: getCorpInfoTreeData()  
       });  
			 $('#tree2').ace_tree({
				 	dataSource:  showData2 ,
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
		


			 function getCorpInfoTreeData(){  
			        var resultData = {};  
			                $.ajax({    
			                   type: 'POST',  
							   url: ctx+"/topBankAndCrop/getCorpInfo.do",   
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
		