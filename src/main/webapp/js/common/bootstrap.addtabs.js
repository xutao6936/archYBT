var addTabs = function (options) {
  obj = $(this);
  var url = options.url;
  id = "tab_" + options.id;
  $(".active").removeClass("active");

  //如果TAB不存在，创建一个新的TAB
  if (!$("#" + id)[0]) {
    //固定TAB中IFRAME高度
    mainHeight = document.body.scrollHeight*0.85;
    //创建新TAB的title
    title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + options.title;
    //是否允许关闭
    if (options.close) {
      title += ' <i class="icon-remove" tabclose="' + id + '"></i>';
    }
    title += '</a></li>';
    //是否指定TAB内容
    if (options.content) {
      content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + options.content + '</div>';
    } else {//没有内容，使用IFRAME打开链接
      content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe src="' + url + '" width="100%" height="' + mainHeight +
          '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
    }
    if (options.contextmenu) {
        //obj上禁用右键菜单
        obj.on('contextmenu', 'li[role=presentation]', function () {
            var id = $(this).children('a').attr('aria-controls');
            Addtabs.pop(id, $(this));
            return false;
        });

        //刷新页面
        obj.on('click', 'ul.rightMenu a[data-right=refresh]', function () {
            var id = $(this).parent('ul').attr("aria-controls").substring(4);
            var url = $(this).parent('ul').attr('aria-url');
            Addtabs.add({'id': id, 'url': url});
            $('#popMenu').fadeOut();
        });

        //关闭自身
        obj.on('click', 'ul.rightMenu a[data-right=remove]', function () {
            var id = $(this).parent("ul").attr("aria-controls");
            if (id.substring(0,4)!='tab_') return;
            Addtabs.close(id);
            Addtabs.drop();
            $('#popMenu').fadeOut();
        });

        //关闭其他
        obj.on('click', 'ul.rightMenu a[data-right=remove-circle]', function () {
            var tab_id = $(this).parent('ul').attr("aria-controls");
            obj.children('ul.nav').find('li').each(function () {
                var id = $(this).attr('id');
                if (id && id != 'tab_' + tab_id) {
                    Addtabs.close($(this).children('a').attr('aria-controls'));
                }
            });
            Addtabs.drop();
            $('#popMenu').fadeOut();
        });

        //关闭左侧
        obj.on('click', 'ul.rightMenu a[data-right=remove-left]', function () {
            var tab_id = $(this).parent('ul').attr("aria-controls");
            $('#tab_' + tab_id).prevUntil().each(function () {
                var id = $(this).attr('id');
                if (id && id != 'tab_' + tab_id) {
                    Addtabs.close($(this).children('a').attr('aria-controls'));
                }
            });
            Addtabs.drop();
            $('#popMenu').fadeOut();
        });

        //关闭右侧
        obj.on('click', 'ul.rightMenu a[data-right=remove-right]', function () {
            var tab_id = $(this).parent('ul').attr("aria-controls");
            $('#tab_' + tab_id).nextUntil().each(function () {
                var id = $(this).attr('id');
                if (id && id != 'tab_' + tab_id) {
                    Addtabs.close($(this).children('a').attr('aria-controls'));
                }
            });
            Addtabs.drop();
            $('#popMenu').fadeOut();
        });
    }
    //加入TABS
    $(".nav-tabs").append(title);
    $(".tab-content").append(content);
  }
  //激活TAB
  $("#tab_" + id).addClass('active');
  $("#" + id).addClass("active");
  
 
};
var closeTab = function (id) {
  //如果关闭的是当前激活的TAB，激活他的前一个TAB
  if ($("li.active").attr('id') == "tab_" + id) {
    $("#tab_" + id).prev().addClass('active');
    $("#" + id).prev().addClass('active');
  }
  //关闭TAB
  $("#tab_" + id).remove();
  $("#" + id).remove();
};
$(function () {
  mainHeight = $(document.body).height() - 45;
  $('.main-left,.main-right').height(mainHeight);
  $("[addtabs]").click(function () {
    addTabs({ id: $(this).attr("id"), title: $(this).attr('title'), close: true });
  });
 
  $(".nav-tabs").on("click", "[tabclose]", function (e) {
    id = $(this).attr("tabclose");
    closeTab(id);
  });
});