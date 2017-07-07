(function( $ ) {
    'use strict';
    $.fn.jmap = function( options ){
        /*************************************  地图初始化参数  ******************************************************/
        var $this = this,
            _mapDOMId = $this.get(0).id, // 地图 DOM ID
            defaultsMap = { // default options MapOptions from : http://lbs.amap.com/api/javascript-api/reference/map/
                width: '100%',
                height: '100%',
                center: [ 116.397428, 39.90923 ], // beijing center
                zoom: 10,
                animateEnable: true,
                isHotspot: false, // 是否开启地图热点
                rotateEnable: false, // 地图是否可旋转
                resizeEnable: false, // 是否监控地图容器尺寸变化
                showIndoorMap: true, // 是否在有矢量底图时候自动展示室内地图
                indoorMap: false,
    //          expendZoomRange: false,
                dragEnable: true,
                zoomEnable: true,
                doubleClickZoom: true,
                keyboardEnable: true,
                jogEnable: true,
                scrollWheel: true,
                touchZoom: true,
                mapStyle: 'normal',
    //          features: [],
                showBuildingBlock: true, // 设置地图显示3D楼块效果
            }
        /*************************************  地图初始化参数结束  ******************************************************/
       
        /*************************************  地图自定义方法  ******************************************************/
        // 创建自己的Map对象 -- JMap
        function JMap(){ 
            this.map = null; // 存储AMap对象
        }
        // 地图打点方法
        JMap.prototype.setMarker = function(marker){
            var that = this, // JMap
                _amap = that.map, // 该amap对象
                defaultMarker = { // 设置默认值,全部API请见 http://lbs.amap.com/api/javascript-api/guide/draw-on-map/marker-point
                    map : _amap,
                    position : [],
                    offset : new AMap.Pixel(-10, -34),
                    icon : '',
                    content : '',
                    topWhenClick : false,
                    topWhenMouseOver : false,
                    draggable : false,
                    raiseOnDrag : true,
                    title : '',
                    clickable : false
                }
                
            // 验证
            if(!marker.position){
                alert('position can not be null');
                return false;
            }
            marker = $.extend( defaultMarker, marker );
            return new AMap.Marker(marker);
        }
        var JMap = new JMap();
        /*************************************  地图自定义方法结束  ******************************************************/
        /*************************************  地图初始化  ******************************************************/
        options = $.extend( defaultsMap, options );
        JMap.map = new AMap.Map( _mapDOMId, options );
        /*************************************  地图初始化结束  ******************************************************/
       
        // 地图控件处理
        var pluginArr = options.plugins;
        if(pluginArr){
            AMap.plugin( ['AMap.ToolBar','AMap.Scale','AMap.OverView', 'AMap.Geolocation', 'AMap.MapType'] , function(){
                for(var i=0, len=pluginArr.length; i<len; i++){
                    var _plugin = pluginArr[i];
                    if('AMap.ToolBar' === _plugin){
                        JMap.map.addControl( new AMap.ToolBar() );
                        continue;
                    }
                    if('AMap.Scale' === _plugin){
                        JMap.map.addControl( new AMap.Scale() );
                        continue;
                    }
                    if('AMap.Geolocation' === _plugin){
                        JMap.map.addControl( new AMap.Geolocation() );
                        continue;
                    }
                    if('AMap.OverView' === _plugin){
                        JMap.map.addControl( new AMap.OverView({isOpen:true}) );
                        continue;
                    }
                    if('AMap.MapType' === _plugin){
                        JMap.map.addControl( new AMap.MapType() );
                        continue;
                    }
                }
            });
        }
        /*************************************  地图方法设置结束  ******************************************************/
        
        return JMap;
    }
})( jQuery );
