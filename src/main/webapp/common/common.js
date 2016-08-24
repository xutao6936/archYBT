(function(){
	$.common = {};
	
	
	
	$.common.browser = {
		isIE: function(){
			var _uaMatch = $.uaMatch(navigator.userAgent);
			var _broswer = _uaMatch.broswer;
			if(_broswer=='msie'){
				return true;
			}else {
				return false;
			}
		},
		isChrome:function(){
			var _uaMatch = $.uaMatch(navigator.userAgent);
			var _broswer = _uaMatch.broswer;
			if(_broswer=='webkit'){
				return true;
			}else {
				return false;
			}
		},
		isMozila :function(){
			var _uaMatch = $.uaMatch(navigator.userAgent);
			var _broswer = _uaMatch.broswer;
			if(_broswer=='mozilla'){
				return true;
			}else {
				return false;
			}
		},
		isOpera:function(){
			var _uaMatch = $.uaMatch(navigator.userAgent);
			var _broswer = _uaMatch.broswer;
			if(_broswer=='opera'){
				return true;
			}else {
				return false;
			}
		}
	};
	//  由于需要加载上class后，要重新刷新页面，暂时不用
	$.common.autoResize = {
		topAlign : function(){
			var _this = this;
			if($.common.browser.isChrome){
				$(_this).addClass('topForm'); 
			}
		}
	};
	
	$.common.math = {
		round : function(dight,how){
			return dight.toFixed(how);
		}
	};
	
	$.common.file = {
		download:function(fileName){
			var downUrl = ctx + 'file/download?fileName=' + fileName;
			location.href = encodeURI(downUrl);
		},
		friendlySize: function(size){
			if(size<1024*1024){
				return $.common.math.round(size/1024,2)+'KB';
			}else {
				return $.common.math.round(size/(1024*1024),2)+'MB'
			}
		}
	};
	//  使用extend方法进行类级别的方法追加
	
	$.common.ui = {
		topScroll2:function(){
			var _this = this;
			$(_this).hide();
			$(window).scroll(function(){
				 if ($(window).scrollTop()>100){
	                $(_this).fadeIn(400);
	            }
	            else
	            {
	                $(_this).fadeOut(400);
	            }
			});
			
			$(_this).click(function(){
	            $('body,html').animate({scrollTop:0},400);
	            return false;
	        });
		}
	};
	// 在jquery命名空间里对象级别的追加方法，*但是有可能会方法名重复*
	
	$.form = {};
	// 红色星号
	$.form.ui = {
		required : function(){
			return "<span class='must'>*</span>";
		}
	};
	
	
})();

/*$(document).ready(function(){

//首先将#top_arrow隐藏

    $("#top_arrow").hide();

//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失

    $(function () {
        $(window).scroll(function(){
            if ($(window).scrollTop()>100){
                $("#top_arrow").fadeIn(400);
            }
            else
            {
                $("#top_arrow").fadeOut(400);
            }
        });

//当点击跳转链接后，回到页面顶部位置

        $("#top_arrow").click(function(){
            $('body,html').animate({scrollTop:0},400);
            return false;
        });
    });
});*/