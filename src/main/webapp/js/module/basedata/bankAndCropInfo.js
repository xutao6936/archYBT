 jQuery(function ($) {

	 $('#tree1').ace_tree({
			dataSource: treeDataSource3 ,
			multiSelect:true,
			loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
			'open-icon' : 'icon-minus',
			'close-icon' : 'icon-plus',
			'selectable' : true,
			'selected-icon' : 'icon-ok',
			'unselected-icon' : 'icon-remove'
		});

        });

 
 var tree_data_3 = {
			'for-sale' : {name: '总行', type: 'folder'}	,
			'vehicles' : {name: 'Vehicles', type: 'folder'}	,
			'rentals' : {name: 'Rentals', type: 'folder'}	,
			'real-estate' : {name: 'Real Estate', type: 'folder'}	,
			'pets' : {name: 'Pets', type: 'folder'}	,
			'tickets' : {name: 'Tickets', type: 'item'}	,
			'services' : {name: 'Services', type: 'item'}	,
			'personals' : {name: 'Personals', type: 'item'}
		}
 		tree_data_3['for-sale']['additionalParameters'] = {
			'children' : {
				'appliances' : {name: 'Appliances', type: 'item'},
				'arts-crafts' : {name: 'Arts & Crafts', type: 'item'},
				'clothing' : {name: 'Clothing', type: 'item'},
				'computers' : {name: 'Computers', type: 'item'},
				'jewelry' : {name: 'Jewelry', type: 'item'},
				'office-business' : {name: 'Office & Business', type: 'item'},
				'sports-fitness' : {name: 'Sports & Fitness', type: 'item'}
			}
		}
 		tree_data_3['vehicles']['additionalParameters'] = {
			'children' : {
				'cars' : {name: 'Cars', type: 'folder'},
				'motorcycles' : {name: 'Motorcycles', type: 'item'},
				'boats' : {name: 'Boats', type: 'item'}
			}
		}
 		tree_data_3['vehicles']['additionalParameters']['children']['cars']['additionalParameters'] = {
			'children' : {
				'classics' : {name: 'Classics', type: 'item'},
				'convertibles' : {name: 'Convertibles', type: 'item'},
				'coupes' : {name: 'Coupes', type: 'item'},
				'hatchbacks' : {name: 'Hatchbacks', type: 'item'},
				'hybrids' : {name: 'Hybrids', type: 'item'},
				'suvs' : {name: 'SUVs', type: 'item'},
				'sedans' : {name: 'Sedans', type: 'item'},
				'trucks' : {name: 'Trucks', type: 'item'}
			}
		}

 		tree_data_3['rentals']['additionalParameters'] = {
			'children' : {
				'apartments-rentals' : {name: 'Apartments', type: 'item'},
				'office-space-rentals' : {name: 'Office Space', type: 'item'},
				'vacation-rentals' : {name: 'Vacation Rentals', type: 'item'}
			}
		}
 		tree_data_3['real-estate']['additionalParameters'] = {
			'children' : {
				'apartments' : {name: 'Apartments', type: 'item'},
				'villas' : {name: 'Villas', type: 'item'},
				'plots' : {name: 'Plots', type: 'item'}
			}
		}
		tree_data_3['pets']['additionalParameters'] = {
			'children' : {
				'cats' : {name: 'Cats', type: 'item'},
				'dogs' : {name: 'Dogs', type: 'item'},
				'horses' : {name: 'Horses', type: 'item'},
				'reptiles' : {name: 'Reptiles', type: 'item'}
			}
		}
 
 var treeDataSource3 = new DataSourceTree({data: tree_data_3});
 var DataSourceTree = function(options) {
	 alert(1111);
		this._data 	= options.data;
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