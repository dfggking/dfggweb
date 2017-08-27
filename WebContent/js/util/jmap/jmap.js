/**
 * 封装高德地图 AMap
 * @author jinyf@hollysos.com
 * @create 2017-07-20
 * @since 1.0
 * @override 2017-08-02
 */

'use strict';
(function($){
    jmapInit();
    $.fn.extend({
        jmap : function(op){
            
            var $that = this;
            var amap = null; // 高德地图对象
            var geolocation = null; // 定位对象
            var citysearch = null; // 自动定位城市信息返回
            var infoWindow = null; // 信息窗体
            var advancedInfoWindow = null; // 高级窗体
            var placeSearch = null;
            var autocomplete = null;
            var trafficLayer = null;
            var satelliteLayer = null;
            
            // 获取DOM_ID
            var _domId = $that.attr('id');
            var dop = {
                resizeEnable: true,
                zoom: 10,
                showIndoorMap: true, // 是否在有矢量底图时候自动展示室内地图
                mapStyle: 'normal',
                currentPositionOnComplete: null,
                currentPositionOnError: null,
                search: null, // 搜索功能
                customSearchResult: null, // 搜索结果
            }
            op = $.fn.extend(dop, op);
            amap = new AMap.Map(_domId, op);
            
            // 定位
            amap.plugin('AMap.Geolocation', function(){
                geolocation = new AMap.Geolocation({
                    enableHighAccuracy: true,//是否使用高精度定位，默认:true
                    timeout: 10000,          //超过10秒后停止定位，默认：无穷大
                    maximumAge: 0,           //定位结果缓存0毫秒，默认：0
                    convert: false,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                    showButton: false,        //显示定位按钮，默认：true
                    buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
                    buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                    showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
                    showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
                    panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
                    zoomToAccuracy:true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
                });
                amap.addControl(geolocation);
                if(op.currentPositionOnComplete){
                    AMap.event.addListener(geolocation, 'complete', op.currentPositionOnComplete);//返回定位信息
                }
                if(op.currentPositionOnError){
                    AMap.event.addListener(geolocation, 'error', op.currentPositionOnError);      //返回定位出错信息
                }
            });
            
            // 根据IP定位获取当前城市信息
            amap.plugin('AMap.CitySearch', function(){
                citysearch = new AMap.CitySearch();
            });
            
            // 信息窗体加载
            infoWindow = new AMap.InfoWindow({
                isCustom : false,
                closeWhenClickMap : true,
                offset : new AMap.Pixel(20, -15)
                
            });
            // 高级信息窗体
//            amap.plugin('AMap.AdvancedInfoWindow', function () {
//                advancedInfoWindow = new AMap.AdvancedInfoWindow({
//                  panel: 'panel',
//                  placeSearch: true,
//                  asOrigin: true,
//                  asDestination: true,
//                  content: infoWindowContent
//                });
//                
//            });
            
            if(op.trafficLayer){
                trafficLayer = new AMap.TileLayer.Traffic({
                    zoom : 10
                });
            }
            if(op.satelliteLayer){
                satelliteLayer = new AMap.TileLayer.Satellite({
                    zoom : 10
                });
            }
            $('.amap-btn-group').show();
            
            // 搜索功能
            if(op.search){
                amap.plugin(['AMap.PlaceSearch', 'AMap.Autocomplete'], function(){
                    autocomplete = new AMap.Autocomplete({
                        city: op.search.cityId,
                        input: op.search.inputId
                    });
                    
                    placeSearch = new AMap.PlaceSearch({
                        pageSize: 10,
                        pageIndex: 1,
                        type: '',
                        city: op.search.cityId, //城市
                        map: amap,
                        panel: op.search.resultId
                    });
                    
                    AMap.event.addListener(autocomplete, "select", function(e){
                        placeSearch.search(e.poi.name, function(status, result){
                            if(op.search.customSearchResult){
                                op.searchResult(status, result);
                            }else{
                                placeSearch.search(e.poi.name);
                                $('#' + op.search.resultId).show();
                            }
                        });
                    });
                });
            }
            // 拖拽选址
            if(op.positionPicker){
                AMapUI.loadUI(['misc/PositionPicker'], function(PositionPicker) {
                    var positionPicker = new PositionPicker({
                        mode: 'dragMap',
                        map: amap
                    });
                    
                    positionPicker.on('success', function(positionResult) {
                        op.positionPicker.success(positionResult);
                    });
                    
                    positionPicker.on('fail', function(positionResult) {
                        op.positionPicker.fail(positionResult);
                    });
                    
                    var _dragStartListener = AMap.event.addListener(amap, "dragstart", function(){
                        positionPicker.start();
                        AMap.event.removeListener(_dragStartListener);
                    });
                });
            }
            
            AMapUI.loadUI(['control/BasicControl'], function(BasicControl) {
                
                //缩放控件
                amap.addControl(new BasicControl.Zoom({
                    position: 'lb'
                }));
                
                //图层切换控件
//                amap.addControl(new BasicControl.LayerSwitcher({
//                    position: {
//                        bottom : '15px',
//                        right: '400px'
//                    }
//                }));
                
              //图层切换控件
//                amap.addControl(new BasicControl.Traffic({
//                    position: {
//                        bottom : '15px',
//                        right: '360px'
//                    }
//                }));
                
            });
            
            var JMap = {
                AMap : AMap,
                amap : null,
                setMarker : function(op){
                    var marker = null;
                    var dop = {
                        map : amap,
                        position : [],
                        offset : new AMap.Pixel(-10, -34),
                        icon : 'http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png',
                        content : '',
                        topWhenClick : true,
                        topWhenMouseOver : true,
                        draggable : false,
                        raiseOnDrag : true,
                        title : '',
                        clickable : true,
                        infoWin : {}
                    }
                    
                    op = $.fn.extend(dop, op);
                    marker = new AMap.Marker(op);
                    var _infoWIn = op.infoWin;
                    if(_infoWIn){
                        marker.on('click', function(){
                            JMap.setInfoWin(_infoWIn, marker.getPosition());
                        })
                    }
                    return marker;
                },
                setInfoWin : function(op, position){
                    infoWindow.setContent(op.content);
                    infoWindow.open(amap, position);
                },
                showTraffic : function(){
                    trafficLayer.setMap(amap);
                    trafficLayer.show();
                },
                hideTraffic : function(){
                    trafficLayer.hide();
                },
                showSatellite : function(){
                    satelliteLayer.setMap(amap);
                    satelliteLayer.show();
                },
                hideSatellite : function(){
                    satelliteLayer.hide();
                },
                placeSearch : function(keyword, city, callback){
                    placeSearch.setCity(city);
                    placeSearch.search(keyword, function(status, result){
                        if(callback){
                            callback(status, result);
                        }
                    });
                },
                searchNearBy : function(keyword, latlng, circle, callback){
                    placeSearch.searchNearBy(keyword, latlng, circle, function(status, result){
                        if(callback){
                            callback(status, result);
                        }
                    });
                },
                getCurrentPosition : function(){
                    geolocation.getCurrentPosition();
                },
                getCitySearchByIP : function(){ // 异步获取值
                    var def = $.Deferred();
                    citysearch.getLocalCity(function(status, result){
                        def.resolve({status : status, result : result});
                    });
                    return def.promise();
                },
                icon : {
                    iconNap : '/img/xfz/amap-station-marker.png',
                    iconWater : '/img/xfz/amap-water-marker.png',
                    iconEvent : '/img/xfz/amap-event-marker.png'
                }
            };
            JMap.amap = amap;
            return JMap;
            
        }
    });
    
    /**
     * JMap初始化调用
     * @author dfggking@hotmail.com
     * @create 2017-07-31
     * @since 1.0
     */
    function jmapInit(){
        /** 样式自动创建 */
        var style = '.amap-sug-result{position:fixed;z-index:1024;background-color:#fefefe;border:1px solid #d1d1d1;width:400px;}.amap-btn-group{position:absolute;top:20px;right:400px;height:60px;border:1px solid #fafafa;-webkit-box-shadow:1px 3px 8px rgba(204,204,204,.5);-moz-box-shadow:1px 3px 8px rgba(204,204,204,.5);box-shadow:1px 3px 8px rgba(204,204,204,.5);z-index:99}.amap-btn-group .amap-btn{position:relative;float:left;color:#666;background-color:#fefffd;border-color:#EEE;font-weight:300;font-size:16px;font-family:"Helvetica Neue Light","Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif;text-decoration:none;text-align:center;line-height:60px;height:60px;padding:0 23px;margin:0;display:inline-block;appearance:none;cursor:pointer;border:0;-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;-webkit-transition-property:all;transition-property:all;-webkit-transition-duration:.3s;transition-duration:.3s;outline:0;-webkit-box-shadow:inset 1 0 0 rgba(0,0,0,.075),0 0 0 #333;box-shadow:inset 1 0 0 rgba(0,0,0,.075),0 0 0 #333}.amap-btn-group .amap-btn:hover{background-color:#f6f6f6;text-decoration:none;outline:0}.amap-btn-group .amap-btn:after{content:"";position:absolute;top:50%;right:0;width:1px;height:20px;margin-top:-10px;border:1px solid #eee}.amap-btn-group .amap-btn:last-child:after{content:"";border:0}.amap-btn-group .amap-btn-satellite:before{content:"";float:left;width:20px;height:20px;margin:20px 8px 0 0;background:url("../../../img/xfz/css_sprites.png") -210px -370px}.amap-btn-group .amap-btn-fullscreen:before{content:"";float:left;width:20px;height:20px;margin:20px 8px 0 0;background:url("../../../img/xfz/css_sprites.png") -288px -370px}.amap-btn-group .amap-btn-load:before{content:"";float:left;width:20px;height:20px;margin:20px 8px 0 0;background:url("../../../img/xfz/css_sprites.png") -139px -420px}.amap-controls{display:none;position:relative;}.amap-info-content{width:300px;background:#fff;border:1px solid #ccc;padding:0;border-radius:4px;line-height:1.4;overflow:auto;}.info{border:solid 1px silver}div.info-top{position:relative;background:none repeat scroll 0 0 #f9f9f9;border-bottom:1px solid #CCC;border-radius:5px 5px 0 0}div.info-top div{display:inline-block;height:39px;color:#333;font-size:16px;font-weight:bold;line-height:39px;padding:0 10px}div.info-top .offline{font-size:14px;color:#F00;margin-left:10px;}div.info-top .online{font-size:11px;color:#0F0;}.amap-info-close{top:13px;right:7px;}.amap-info-close:hover{color:#C3C3C3;text-decoration:none;}div.info-top img{position:absolute;top:10px;right:10px;transition-duration:.25s}div.info-top img:hover{box-shadow:0 0 5px #000}div.info-middle{margin-top:0;font-size:14px;padding:16px;line-height:24px}div.info-bottom{height:0;width:100%;clear:both;text-align:center}div.info-bottom img{position:relative;z-index:104}.info-middle img{float:left;width:90px;height:90px;margin-right:10px}.info-middle .label1{display:block;float:left;}.info-middle .content{display:block;float:left;width:120px;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;}';
        var node = document.createElement('style');
        node.type = 'text/css';
        if(node.stylesheet){
            node.styleSheet.cssText = style;
        }else{
            node.innerHTML = style;
        }
        document.getElementsByTagName('head')[0].appendChild(node);
        /** 样式自动创建end */
    }
})(jQuery);



