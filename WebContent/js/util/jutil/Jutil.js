/**
 * 一个JS工具类
 * @author dfggking@hotmail.com
 * @version 1.0
 */

/**
 * 对Date扩展，将Date转换为指定格式的String日期格式
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


