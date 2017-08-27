/**
 * 一个JS工具类
 * @author dfggking@hotmail.com
 * @version 1.0
 * API : 
 * 1、 返回字符串长度 strLength
 * 2、 获取URL中的参数 getQueryStringRegExp
 * 3、 字符串去掉空格方法
 * 4、 日期格式化
 * 5、 农历日期
 * 6、 浏览器缩放检测工具
 */
/****************************************************************************************************/
/**
 * 1、 返回字符串长度 strLength
 * @author dfggking@hotmail.com
 * @create 2017-07-26
 * @since 1.0
 */
function strLength(str) {
    var a = 0;
    for (var i = 0; i < str.length; i++) {
      if (str.charCodeAt(i) > 255)
          a += 2;//按照预期计数增加2
      else
          a++;
    }
    return a;
}

/**
 * 2、 获取URL中的参数 getQueryStringRegExp
 * @author dfggking@hotmail.com
 * @create 2017-07-26
 * @since 1.0
 */
function getQueryStringRegExp(name,url) {
    var reg = new RegExp("(^|\?|&)" + name + "=([^&]*)(\s|&|$)", "i");
    if (reg.test(url)) return decodeURIComponent(RegExp.$2.replace(/+/g, " ")); return "";
}

/**
 * 3、 字符串去掉空格方法
 * @author dfggking@hotmail.com
 * @create 2017-07-26
 * @since 1.0
 */
String.prototype.trim = function(){ return this.replace(/(^s*)|(s*$)/g, ""); }
String.prototype.lTrim = function(){return this.replace(/(^s*)/g, "");}
String.prototype.rTrim = function(){return this.replace(/(s*$)/g, "");}　

/**
 * 4、 对Date扩展，将Date转换为指定格式的String日期格式
 * (new Date()).format('yyyy-MM-dd hh:mm:ss.S');
 * (new Date()).format('yyyy-MM-hh:mm');
 * (new Date()).format('yyyy年MM月dd日 hh:mm:ss.S');
 * (new Date()).format('yyyy年MM月dd日 hh:mm:ss.S EE'); 周五
 * (new Date()).format('yyyy年MM月dd日 hh:mm:ss.S EEE'); 星期五
 * @author dfggking@hotmail.com
 */
Date.prototype.format = function(fmt){
    var o = {
        'M+' : this.getMonth() + 1,
        'd+' : this.getDate(),
        'h+' : this.getHours(),
        'm+' : this.getMinutes(),
        's+' : this.getSeconds(),
        'S'  : this.getMilliseconds() 
    };
    var week = {
        '0' : '日',
        '1' : '一',
        '2' : '二',
        '3' : '三',
        '4' : '四',
        '5' : '五',
        '6' : '六'
    }; 
    if(/(y+)/.test(fmt)){
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? '星期' : '周') : '') + week[this.getDay() + '']);
    }
    for(var k in o){
        if(new RegExp('('+ k +')').test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)));
        }
    }
    return fmt;
}

/**
 * 5、 农历日期
 */
Date.prototype.getLunarDate = function(){
    var theDate = this;
    var isEnd = false;
    var year = theDate.getYear();
    var CalendarData = [0x41A95, 0xD4A, 0xDA5, 0x20B55, 0x56A, 0x7155B, 0x25D, 0x92D, 0x5192B, 0xA95, 0xB4A, 0x416AA, 0xAD5, 0x90AB5, 0x4BA, 0xA5B, 0x60A57, 0x52B, 0xA93, 0x40E95];
    if(year < 1900){
        year += 1900;
    }
    total=(year - 2001) * 365 + Math.floor((year - 2001) / 4)
            + [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334][theDate.getMonth()]
            + theDate.getDate() - 23;
    if(theDate.getYear()%4 == 0 && theDate.getMonth() > 1){
        total++;
    }
    for(var m = 0; ; m++){
      var k = (CalendarData[m] < 0xfff) ? 11 : 12;
      for(var n=k; n>=0; n--){
          if(total<=29+ ((CalendarData[m]>>n)&1)){
              isEnd=true;
              break;
          }
          total = total - 29 - ((CalendarData[m] >> n) & 1);
      }
      if(isEnd)break;
    }
    var cYear = 2001 + m;
    var cMonth = k - n + 1;
    var cDay = total;
    if(k == 12){
        if(cMonth == Math.floor(CalendarData[m] / 0x10000) + 1){
            cMonth = 1 - cMonth;
        }
        if(cMonth > Math.floor(CalendarData[m] / 0x10000) + 1){
            cMonth--;
        }
    }
    var cHour = Math.floor((theDate.getHours() + 3) / 2);
    var dzString = "子丑寅卯辰巳午未申酉戌亥";
    var monString = "正二三四五六七八九十冬腊";
    var result = "";
    result += "甲乙丙丁戊己庚辛壬癸".charAt((cYear - 4) % 10);       //年干
    result += dzString.charAt((cYear - 4) % 12);       //年支
    result += "年";
//    result += "鼠牛虎兔龙蛇马羊猴鸡狗猪".charAt((cYear - 4) % 12);
//    result += ")  ";
    if(cMonth < 1){
        result += "闰";
        result += monString.charAt(-cMonth - 1);
    }else{
        result += monString.charAt(cMonth - 1);
    }
    result += "月";
    result += (cDay < 11)?"初":((cDay < 20)?"十":((cDay < 30) ? "廿" : "卅"));
    if(cDay % 10 != 0 || cDay == 10){
        result += "一二三四五六七八九十".charAt((cDay - 1) % 10);
    }
// 酉时
//    result += " ";
//    if(cHour == 13)result += "夜";
//    result += dzString.charAt((cHour - 1) % 12);
//    result += "时";
    return result;
}

/**
 * 6、 浏览器缩放检测工具
 */
var WebpageZoomDetect=(function(){var ZoomDetect=(function(){var _isSupport=true;var ie8plus=function(){return Math.round((screen.deviceXDPI/screen.logicalXDPI)*100)/100};var ie10plus=function(){return Math.round((document.documentElement.offsetHeight/window.innerHeight)*100)/100};var standard=function(){var zoom=window.top.outerWidth/window.top.innerWidth;return Math.round(zoom*100)/100};var wzdMatchMedia=function(ratio){var cssRule=[".-wzd-zoomdetect {","text-decoration: none","}","@media only screen and (-o-min-device-pixel-ratio: ",ratio,"/1),","only screen and (min--moz-device-pixel-ratio: ",ratio,"), ","only screen and (-webkit-min-device-pixel-ratio: ",ratio,"), ","only screen and (min-resolution: 240dpi), ","only screen and (min-resolution: 2dppx) {",".-wzd-zoomdetect {","text-decoration: underline","}","}"].join("");var style,div,match=false;try{div=$("<div>a</div>").hide().addClass("-wzd-zoomdetect").appendTo("body");style=$('<style type="text/css">'+cssRule+"</style>");style.insertBefore(div);match=div.css("text-decoration")=="underline";div.remove();style.remove()}catch(err){}return match};var firefox=function(){var epsilon=0.01;var binarySearch=function(minRatio,maxRatio,repeatTime){var midRatio=(minRatio+maxRatio)/2;if(repeatTime<=0||maxRatio-minRatio<epsilon){return midRatio}if(wzdMatchMedia(midRatio)){return binarySearch(midRatio,maxRatio,repeatTime-1)}else{return binarySearch(minRatio,midRatio,repeatTime-1)}};return binarySearch(0,5,10)};var _retinaInfo={detected:false,retina:false};var isRetina=function(){if(_retinaInfo.detected){return _retinaInfo.retina}_retinaInfo={detected:true,retina:wzdMatchMedia(2)};return _retinaInfo.retina};var detect=function(){var ratio=1;var ua=navigator.userAgent.toLowerCase();if(!isNaN(screen.logicalXDPI)&&!isNaN(screen.systemXDPI)){ratio=ie8plus()}else{if(window.navigator.msMaxTouchPoints){ratio=ie10plus()}else{if(/webkit/i.test(ua)||/opera/i.test(ua)){ratio=standard()}else{if(/firefox/i.test(ua)){if(isRetina()){ratio=1;_isSupport=false}else{ratio=firefox()}}else{if(parseInt(window.top.outerWidth,10)){ratio=standard()}else{_isSupport=false}}}}}return ratio};var support=function(){detect();return _isSupport};return{support:support,detect:detect}})();var CookieHandler={get:function(key){var reg=new RegExp("(^| )"+key+"=([^;/]*)([^;\x24]*)(;|\x24)");var result=reg.exec(document.cookie);return result?(result[2]||null):null},set:function(config){var expires=new Date();expires.setTime(expires.getTime()+86400000*183);document.cookie=config.key+"="+config.value+(config.path?"; path="+(config.path=="./"?"":config.path):"/")+(expires?"; expires="+expires.toGMTString():"")+(config.domain?"; domain="+config.domain:"")+(config.secure?"; secure":"")}};var _intervalId;var _running=false;var _detect=function(){var _html=['<div class="mod-zoomdetect">','<a href="#" class="wzd-btnclose" title="关闭">关闭</a>',"<div>",'<span class="wzd-txt">#text#</span>','<a href="#" class="wzd-nevertip" title="永久不再提示">不再提示</a>',"</div>","</div><div></div>"].join("");var text="";var _ratio=ZoomDetect.detect();_ratio=_ratio<0.95?_ratio:(_ratio>1.05?_ratio:1);if(_ratio==1){text="您的浏览器目前处于正常比例！"}else{var tip=_ratio>1?"放大":"缩小";var controlKey=(navigator.platform.toLowerCase().indexOf("mac")>-1)?"command":"Ctrl";text='您的浏览器处于<q class="x-tip">'+tip+"</q>状态，"+tip+"比例为"+String(_ratio*100).substr(0,6)+"%，"+'将会导致显示不正常，您可以用键盘按<q class="x-key">'+controlKey+"+数字0</q>恢复正常比例。"}var elBanner=$(".mod-zoomdetect");var btnClose=$(".mod-zoomdetect .wzd-close");if(!elBanner[0]){elBanner=$(_html.replace("#text#",text)).prependTo("body").attr("data-ratio",_ratio).hide();elBanner.find(".wzd-btnclose,.wzd-nevertip").click(function(e){elBanner.slideUp(200);if(_intervalId!=undefined){_stop()}if($(this).hasClass("wzd-nevertip")){CookieHandler.set({key:"_wzd_nevertip_",value:1})}e.stopPropagation();e.preventDefault()})}else{var _preRatio=parseFloat(elBanner.attr("data-ratio"),10);if(_preRatio!=_ratio){elBanner.attr("data-ratio",_ratio).find(".wzd-txt").html(text)}}if(_ratio==1){elBanner.slideUp(200)}else{elBanner.slideDown(200)}};var _start=function(configs){configs=configs||{};if(_running){return}_running=true;if(ZoomDetect.support()){if(configs.always!=false){if(!CookieHandler.get("_wzd_nevertip_")){_intervalId=window.setInterval(_detect,configs.interval||500)}}else{_detect()}$(window).blur(function(e){_stop()}).focus(function(e){_start()})}};var _stop=function(){if(_intervalId!=undefined){window.clearInterval(_intervalId);_running=false}};var node=document.createElement("style"),style=".mod-zoomdetect{position:fixed;width:100%;height:40px;background:#feffe5;line-height:40px;font-size:16px;text-align:center;border-bottom:1px solid #e7cf7b;user-select:none;clear:both;z-index:999;}.mod-zoomdetect div{text-align:center}.mod-zoomdetect q{font-weight:bold;color:#f00}.mod-zoomdetect .wzd-nevertip{text-decoration:underline;color:#2383c2;font-size:14px}.mod-zoomdetect .wzd-nevertip:hover{color:#23a3c2}.mod-zoomdetect .wzd-btnclose{float:right;margin:12px 10px 0 0;line-height:20px;font-size:14px;text-decoration:none;display:block;cursor:pointer;}.mod-zoomdetect .wzd-close:hover{text-decoration:none}";
node.type="text/css";if(node.styleSheet){node.styleSheet.cssText=style}else{node.innerHTML=style}document.getElementsByTagName("head")[0].appendChild(node);return{version:"1.2",start:_start,stop:_stop}})();
WebpageZoomDetect.start({}); // 启动检测工具

/**
 * 7. 字符串过长优化显示...
 */
function stringTooLongOptimize( str, length ){
    var len = strLength(str);
    if( len > length ){
        str = str.substring(0, length) + '...';
    }
    return str;
}
