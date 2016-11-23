(function($) {
	$.common = {};
	
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
	// -- 窗口工具//

	$.common.window = {
		// -- 获得最上层的window对象 --//
		getTopWin : function() {
			if (parent) {
				var tempParent = parent;
				while (true) {
					if (tempParent.parent) {
						if (tempParent.parent == tempParent) {
							break;
						}
						tempParent = tempParent.parent;
					} else {
						break;
					}
				}
				return tempParent;
			} else {
				return window;
			}
		},
		// 获取可见区域的宽度
		getClientWidth : function() {
			return document.documentElement.clientWidth - 10;
		},
		// 获取可见区域的高度
		getClientHeight : function(options) {
			var defaults = {
				autoSuit : true, // 自动适应高度，因为在firefox下面不减10会出现滚动条
				autoSuitValue : -13
			};
			options = $.extend({}, defaults, options);
			if (options.autoSuit) {
				return document.documentElement.clientHeight
						+ options.autoSuitValue;
			} else {
				return document.documentElement.clientHeight;
			}
		}
	};

	
	var _plugin_jqGrid = {
		jsonReader : {
			root : "list", // json中代表实际模型数据的入口
			page : "pageNum", // json中代表当前页码的数据
			total : "pages", // json中代表页码总数的数据
			records : "total", // json中代表数据行总数的数据
			repeatitems : true
		// 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
		},
		pager : {
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
			viewtitle:'查看'
				
		},

		// -- 格式化 值--//
		formatter : {
			// 日期类型，例如：2010-08-19
			date : function(cellvalue, options, cellobject) {
				if (cellvalue == null || cellvalue == 'null')
					return "";
				else {
					if (cellvalue.length >= 10) {
						return cellvalue.substring(0, 10);
					} else {
						return cellvalue;
					}
				}
			},
			// 日期和时间类型，例如：2010-08-19 12:12:13
			datetime : function(cellvalue, options, cellobject) {
				if (cellvalue == null || cellvalue == 'null') {
					return "";
				} else {
					var preCellValue = cellvalue.substring(0, 10);
					var postCellvalue = cellvalue.substring(11,
							cellvalue.length);
					return preCellValue + " " + postCellvalue;
				}
			},
			trueOrfalse : function(cellvalue, options, cellobject) {
				if (cellvalue == null || cellvalue == 'null' || cellvalue == 0)
					return "否";
				return "是";
			},
			// 使用图片显示是否值，是显示图片，否不显示任何值
			trueOrFalseImg : function(cellvalue, options, cellobject) {
				if (cellvalue == null || cellvalue == 'null' || cellvalue == 0)
					return "";
				var okImgPath = $.common.custom.getCtx() + "/images/tip/ok.gif";
				return "<img src='" + okImgPath + "'/>";
			},
			float2precent : function(cellvalue, options, cellobject) {
				if (cellvalue == null || cellvalue == 'null')
					return "";
				return cellvalue * 100 + '%';
			}
		},
		
		form:{
            // 表单必填标志
            must: function() {
                return "<span class='must'>*</span>";
            },
            mustTip: "带 <span class='must'>*</span> 为必填(选)项。",
            // 添加设置
            add: {
            	top:80,
				left:250,
				height:450,
				dataheight:350,
                closeAfterAdd: true,
                recreateForm: true,
                closeOnEscape:true,
                savekey: [true, 13],
                navkeys: [true, 38, 40],
                bottominfo: "带 <span class='must'>*</span> 为必填(选)项。",
                onInitializeForm: function(formObj) {
					// 鼠标划过的时候高亮当前行
                	$('tr.FormData', formObj).hover(function() {
						$(this).addClass('ui-state-hover');
					}, function() {
						$(this).removeClass('ui-state-hover');
					}).click(function() {
						$('tr.FormData', formObj).removeClass('ui-state-active');
						$(this).addClass('ui-state-active');
					});
					
                    // 如果对话框的高度超过了列表的高度则出现滚动条，延迟20毫秒执行
                    setTimeout(function() {
                        var formDialogHeight = $(formObj).parents('.ui-jqdialog').height();
                        var listId = $(formObj).attr('id').replace('FrmGrid_', '');
                        var gridHeight = $('#gview_' + listId).height();
                        if (formDialogHeight > gridHeight) {
                            $(formObj).height($.common.window.getClientHeight() - $(formObj).next('.EditTable').height() - 38);
                        }
                    }, 20);
                },
				afterSubmit:function(response, postdata) {
					var data = response.responseText;
					data = $.parseJSON(data);
					if(data['result']=='ERROR'){
						layer.alert(data['errInfo'],{icon:2});  
					}else {
						return true;
					}
				},
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
            },
            
            // 编辑设置
            edit: {
                closeAfterEdit: true,
                recreateForm: true,
                closeOnEscape: true,
                savekey: [true, 13],
                navkeys: [true, 38, 40],
                bottominfo: "带 <span class='must'>*</span> 为必填(选)项。",
                onInitializeForm: function(formObj) {
                	// 鼠标划过的时候高亮当前行
                	$('tr.FormData', formObj).hover(function() {
						$(this).addClass('ui-state-hover');
					}, function() {
						$(this).removeClass('ui-state-hover');
					}).click(function() {
						$('tr.FormData', formObj).removeClass('ui-state-active');
						$(this).addClass('ui-state-active');
					});
					
                    // 如果对话框的高度超过了列表的高度则出现滚动条，延迟20毫秒执行
                    setTimeout(function() {
                        var formDialogHeight = $(formObj).parents('.ui-jqdialog').height();
                        var listId = $(formObj).attr('id').replace('FrmGrid_', '');
                        var gridHeight = $('#gview_' + listId).height();
                        if (formDialogHeight > gridHeight) {
                            $(formObj).height($.common.window.getClientHeight() - $(formObj).next('.EditTable').height() - 38);
                        }
                    }, 20);
                },
                afterSubmit:function(response, postdata) {
					var data = response.responseText;
					data = $.parseJSON(data);
					if(data['result']=='ERROR'){
						layer.alert(data['errInfo'],{icon:2});  
					}else {
						return true;
					}
				},
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
					style_edit_form(form);
				}
            },
            // 删除设置
            del: { // empty
}            ,
            // 搜索设置
            search: {
                multipleSearch: true,
                showQuery: false,
                multipleGroup: false,
                sopt: ['eq', 'ne', 'lt', 'le', 'gt', 'ge', 'bw', 'bn', 'in', 'ni', 'ew', 'en', 'cn', 'nc', 'nu', 'nn'],
                afterRedraw: function() {
                    // 从下拉况中选择保存过的查询条件
                    var savedFilters = {
                        '医保在上海年龄20-30之间': {
                            "groupOp": "AND",
                            "rules": [{
                                "field": "age",
                                "op": "ge",
                                "data": "20"
                            }, {
                                "field": "age",
                                "op": "le",
                                "data": "30"
                            }, {
                                field: "medicareAddress",
                                "op": "eq",
                                "data": "上海"
                            }]
                        },
                        年龄20岁以上: {
                            "groupOp": "OR",
                            "rules": [{
                                "field": "age",
                                "op": "le",
                                "data": "20"
                            }]
                        }
                    };
                    $('.opsel').before("<select class='saved-filters' title='已保存搜索条件'><option>--请选择--</option></select>" +
                    "<input id='filterName' size='15' style='display:none' title='输入名称后可以保存搜索条件' />");
                    $.each(savedFilters, function(i, v) {
                        $("<option />", {
                            value: i,
                            text: i
                        }).appendTo('.saved-filters');
                    });
                    
                    $('.saved-filters').unbind('change').bind('change', function() {
                        // 1、删除所有条件
                        $('#fbox_list_reset').trigger('click');
                        
                        // 2、设置条件
                        var filterName = $('option:selected', this).val();
                        var groupOp = savedFilters[filterName].groupOp;
                        var rules = savedFilters[filterName].rules;
                        $('.opsel option[value=' + groupOp + ']').attr('selected', true);
                        for (var i = 0; i < rules.length; i++) {
                            if ($('.columns').length < rules.length) {
                                $('.add-rule').trigger('click');
                            }
                            $('.columns:eq(' + i + ') select option[value=' + rules[i].field + ']').attr('selected', true).trigger('change');
                            $('.operators:eq(' + i + ') select option[value=' + rules[i].op + ']').attr('selected', true);
                            $('.data:eq(' + i + ') *').val(rules[i].data)
                        }
                        
                        // 3、选中当前条件
                        $('.saved-filters option:[text=' + filterName + ']').attr('selected', true);
                        
                    });
                },
                afterShowSearch: function() {
                    /*
                     * 添加回车键搜索功能
                     */
                    $('.ui-searchFilter .data *').keydown(function(e) {
                        if (e.which == 13 || e.which == 10) {
                            $('.ui-searchFilter tfoot .ui-search').trigger('click');
                        }
                    });
                    
                    /*
                     * hack: 搜索类型有select时点击重置按钮后无效
                     */
                    $('.ui-reset').bind('click', function() {
                        $('.data').find('.vdata').removeClass('vdata');
                        $('.data').find('select').hide();
                        $('.data').find('.default').addClass('vdata').show();
                        
                        // 比较符号重置为默认(第一个)
                        $('.ops').find('select').hide();
                        $('.ops').find('.field0').show();
                    });
                }
            },
            // 查看设置
            view: {
                beforeShowForm: function(formid) {
                    $.common.plugin.jqGrid.navGrid.showAllField(formid);
                    setTimeout(function() {
                        // 隐藏编辑按钮
                        $('#trv_options').hide();
                        
                        // 如果对话框的高度超过了列表的高度则出现滚动条，延迟20毫秒执行
                        var formDialogHeight = $(formid).parents('.ui-jqdialog').height();
                        var listId = $(formid).attr('id').replace('ViewGrid_', '');
                        var gridHeight = $('#gview_' + listId).height();
                        if (formDialogHeight > gridHeight) {
                            $(formid).height($.common.window.getClientHeight() - $(formid).next('.EditTable').height() - 38);
                        }
                    }, 10);
                }
            }
		},
		
		/**
		 * 改变窗口大小的时候自动根据iframe大小设置jqGrid列表宽度和高度 参数说明：{ enableAutoResize :
		 * 是否开启自动高度和宽度调整开关 dataGrid : jqGrid数据列表的ID callback :
		 * 计算完dataGrid需要的高度和宽度后的回调函数 width : 默认为iframe的宽度，如果指定则设置为指定的宽度 height :
		 * 默认为iframe的高度，如果指定则设置为指定的高度 beforeAutoResize : 窗口大小调整时自动设置之前
		 * afterAutoResize : 窗口大小调整时自动设置之后 }
		 */
		autoResize : function(options) {
			var defaults = {
				gridContainer : 'body',
				filterToolbar : false,
				groupHeaders : false,
				enableAutoResize : true,
				beforeAutoResize : null,
				afterAutoResize : null
			};
			options = $.extend({}, defaults, options);
			var size = getWidthAndHeigh();
			if ($.isFunction(options.callback)) {
				options.callback(size);
				setToolbarHeight();
			}
			
            // 窗口大小改变的时候
            if (options.enableAutoResize === true) {
                if ($.isFunction(options.beforeAutoResize)) {
                    options.beforeAutoResize();
                }
                window.onresize = function() {
                    var size = getWidthAndHeigh(true);
                    $(options.dataGrid).jqGrid('setGridHeight', size.height).jqGrid('setGridWidth', size.width);
                    setToolbarHeight();
                    if ($.isFunction(options.afterAutoResize)) {
                        options.afterAutoResize(size);
                    }
                };
            }
            
         // 根据浏览器不同设置工具栏的高度
            function setToolbarHeight() {
                // 根据浏览器不同设置工具栏的高度
                if ($.common.browser.isIE() && options.toolbarHeight) {
                    if (options.toolbarHeight.top && options.toolbarHeight.top.ie) {
                        $('#t_' + options.dataGrid.substr(1)).height(options.toolbarHeight.top.ie);
                    }
                    if (options.toolbarHeight.bottom && options.toolbarHeight.bottom.ie) {
                        $('#tb_' + options.dataGrid.substr(1)).height(options.toolbarHeight.bottom.ie);
                    }
                }
            }
            
			// 获取iframe大小
			function getWidthAndHeigh(resize) {
				var hasToolbar = !options.toolbar ? false : options.toolbar[0];
				if (hasToolbar) {
					var toolbarType = options.toolbar[1];
					if (!toolbarType) {
						alert('请设置工具栏的属性，toolbar ： [true, [top, both, bottom]]');
					}
				}

				// 根据列表的容器设置宽度和高度
				var clientHeight = options.gridContainer == 'body' ? document.documentElement.clientHeight
						: $(options.gridContainer).get(0).clientHeight;
				var clientWidth = options.gridContainer == 'body' ? document.documentElement.clientWidth
						: $(options.gridContainer).get(0).clientWidth;

				var iframeHeight = !options.height ? clientHeight
						: options.height;
				var iframeWidth = !options.width ? clientWidth : options.width;

				// chrome
				if ($.common.browser.isChrome()) {
					if (hasToolbar) {
						if (toolbarType == 'top' || toolbarType == 'bottom') {
							iframeWidth -= 8;
							iframeHeight -= 128;
						} else if (toolbarType == 'both') {
							iframeWidth -= 14;
							iframeHeight -= 140;
						}
					} else {
						iframeWidth -= 13;
						iframeHeight -= 87;
					}
				} // firefox
				else if ($.common.browser.isMozila()
						|| $.common.browser.isOpera()) {
					if (hasToolbar) {
						if (toolbarType == 'top' || toolbarType == 'bottom') {
							iframeWidth -= 10;
							iframeHeight -= 122;
						} else if (toolbarType == 'both') {
							iframeWidth -= 12;
							iframeHeight -= 145;
						}
					} else {
						iframeWidth -= 6;
						iframeHeight -= 94;
					}
				} // IE
				else {
					if (hasToolbar) {
						if (toolbarType == 'top' || toolbarType == 'bottom') {
							if ($.common.browser.isIE()
									&& options.toolbarHeight) {
								if (options.toolbarHeight.top
										&& options.toolbarHeight.top.ie) {
									// 减去jqGrid的t_list默认高度和IE的兼容高度
									iframeHeight -= (options.toolbarHeight.top.ie - 21) - 15;
								}
							}
							iframeHeight -= 133;
							iframeWidth -= 6;
							setTimeout(function() {
								// 设置上方的toolbar
								$('#t_' + options.dataGrid.substr(1)).width(
										iframeWidth - 11);
							});
						} else if (toolbarType == 'both') {
							iframeWidth -= 6;
							iframeHeight -= 156;
							setTimeout(function() {
								// 设置上方的toolbar
								$('#t_' + options.dataGrid.substr(1)).width(
										iframeWidth - 11);
							});
						}
					} else {
						iframeWidth -= 6;
						iframeHeight -= 93;
					}
				}

				// 是否有搜索工具条
				if (options.filterToolbar) {
					iframeHeight -= 23;
				}

				// 是否开启标头分组
				if (options.groupHeaders) {
					iframeHeight -= 22;
				}
				return {
					width : iframeWidth,
					height : iframeHeight
				};
			}

		}
	};
	
	
	_plugin_jqGrid.settings = function(options){
		return {
			datatype: "json",
			jsonReader: _plugin_jqGrid.jsonReader,
			width: options.size.width,
            height: options.size.height,
            rowNum: options.rowNum || 20,
            rowList: options.rowList || [10, 15, 20, 30, 40, 50, 100],
            pager: options.pager || '#pager',
            viewrecords: true,
            rownumbers: true,
            loadComplete : function(data) {
    			var table = this;
    			setTimeout(function() {
    				styleCheckbox(table);
    				updateActionIcons(table);
    				updatePagerIcons(table);
    				enableTooltips(table);
    			}, 0);
    		},
            loadError: function(xhr, st, err) {
                //alert("很抱歉，出错了！\n错误类型: " + st + "； 错误内容: "+ xhr.status + " " + xhr.statusText);
                var s = "未知";
                if (xhr.status == 404) {
                    s = "找不到数据源";
                } else if (xhr.status == 500) {
                    s = "服务器内部错误";
                } else if (xhr.responseText == '_login_timeout') {
                    s = "登录超时！";
                }
                alert("很抱歉，数据加载失败！\n错误类型: " + s);
            }
		};
	};
	
	var _common_plugins = {
			jqGrid : _plugin_jqGrid
	};
	// 插件扩展
	$.common.plugin = _common_plugins;
	
	
	 //-- 和系统有关的函数 --//
    $.common.system = {
        // 获取系统属性
        getProp: function(options) {
            var defaults = {
                url: ctx + '/common/sysprop!findProp.action',
                params: {
                    key: ''
                },
                callback: null,
                error: null
            };
            
            $.extend(true, defaults, options);
            
            $.ajax({
                url: defaults.url,
                cache: false,
                dataType: 'json',
                data: defaults.params,
                success: function(prop, textStatus) {
                    if ($.isFunction(defaults.callback)) {
                        defaults.callback(prop);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    if ($.isFunction(defaults.error)) {
                        defaults.error(XMLHttpRequest, textStatus, errorThrown);
                    }
                }
            });
            
        }
    };
    
	$.common.browser = {
		isIE : function() {
			return /firefox/.test(navigator.userAgent.toLowerCase());
		},
		isChrome : function() {
			return /webkit/.test(navigator.userAgent.toLowerCase());
		},
		isMozila : function() {
			return /mozilla/.test(navigator.userAgent.toLowerCase());
		},
		isOpera : function() {
			return /opera/.test(navigator.userAgent.toLowerCase());
		}
	};
	// 由于需要加载上class后，要重新刷新页面，暂时不用
	$.common.autoResize = {
		topAlign : function() {
			var _this = this;
			if ($.common.browser.isChrome) {
				$(_this).addClass('topForm');
			}
		}
	};

	$.common.math = {
		round : function(dight, how) {
			return dight.toFixed(how);
		}
	};

	$.common.file = {
		download : function(fileName) {
			var downUrl = ctx + 'file/download?fileName=' + fileName;
			location.href = encodeURI(downUrl);
		},
		friendlySize : function(size) {
			if (size < 1024 * 1024) {
				return $.common.math.round(size / 1024, 2) + 'KB';
			} else {
				return $.common.math.round(size / (1024 * 1024), 2) + 'MB'
			}
		}
	};
	// 使用extend方法进行类级别的方法追加

	$.common.ui = {
		topScroll2 : function() {
			var _this = this;
			$(_this).hide();
			$(window).scroll(function() {
				if ($(window).scrollTop() > 100) {
					$(_this).fadeIn(400);
				} else {
					$(_this).fadeOut(400);
				}
			});

			$(_this).click(function() {
				$('body,html').animate({
					scrollTop : 0
				}, 400);
				return false;
			});
		}
	};
	// 在jquery命名空间里对象级别的追加方法，*但是有可能会方法名重复*

	$.form = {};
	// 红色星号
	$.form.ui = {
		required : function() {
			return "<span class='must'>*</span>";
		}
	};

})(jQuery);

/*
 * $(document).ready(function(){
 * 
 * //首先将#top_arrow隐藏
 * 
 * $("#top_arrow").hide();
 * 
 * //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
 * 
 * $(function () { $(window).scroll(function(){ if ($(window).scrollTop()>100){
 * $("#top_arrow").fadeIn(400); } else { $("#top_arrow").fadeOut(400); } });
 * 
 * //当点击跳转链接后，回到页面顶部位置
 * 
 * $("#top_arrow").click(function(){ $('body,html').animate({scrollTop:0},400);
 * return false; }); }); });
 */