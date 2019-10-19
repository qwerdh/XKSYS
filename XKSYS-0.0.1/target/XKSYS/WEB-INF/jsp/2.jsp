<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>敲得都队</title>
   </head>
   <body style="height: 90%; margin: 0">
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
       <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=YVyBQ2MCo7DUFR5PLCTpSEpGZsy4R3IZ"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
       <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
var dataAxis = [ 'mac魅可官方旗舰店','美康粉黛旗舰店', 'perfectdiary旗舰店', '美宝莲旗舰店', '稚优泉化妆平旗舰店', '健美创研旗舰店', '碧奥泉旗舰店', 'zeesea旗舰店', 'ukiss旗舰店', '美颜秘笈旗舰店', '玫倩莱旗舰店', 'holdlive旗舰店', 'givenchy纪梵希官方旗舰店', '阿玛尼美妆官方旗舰店', 'ysl圣罗兰美妆官方旗舰店', '雅诗兰黛官方旗舰店', 'vnk旗舰店', '欧莱雅彩妆官方旗舰店', '雅邦化妆品旗舰店', 'hedonefashionsnobs旗舰店','健美创研力亿专卖店','玛丽黛佳旗舰店','tb129695162','么么小玄子','rozo旗舰店','bonosidan宝罗丝丹旗舰店','3ce官方旗舰店','cokorrose旗舰店','卡婷旗舰店','卡姿兰恋商专卖店'];
var data = [550500,385000,384620,276400,246500,186720,186830,185420,174680,156400,152300,150230,142300,140050,134560,124650,120450,110050,94860,86450,76500,70320,65010,62040,61050,60040,46040,45230,44650,43540];
var yMax = 600000;
var dataShadow = [];

for (var i = 0; i < data.length; i++) {
    dataShadow.push(yMax);
}

option = {
    title: {
        text: '销售量前三十店铺排行',
        subtext: '购买人数最多的前30店铺 国货口红在购买人数上表现强劲，购买人数最多的前5的店铺，有3家都是国产品牌；前30的店铺中，国产品牌占据半壁江山，其中美康粉黛购表现最强劲。说明国产口红品牌正在强势崛起，热度不输国外大牌。'
    },
    xAxis: {
        data: dataAxis,
        axisLabel: {
            inside: true,
            textStyle: {
                color: '#fff'
            }
        },
        axisTick: {
            show: false
        },
        axisLine: {
            show: false
        },
        z: 10
    },
    yAxis: {
        axisLine: {
            show: false
        },
        axisTick: {
            show: false
        },
        axisLabel: {
            textStyle: {
                color: '#999'
            }
        }
    },
    dataZoom: [
        {
            type: 'inside'
        }
    ],
    series: [
        { // For shadow
            type: 'bar',
            itemStyle: {
                normal: {color: 'rgba(0,0,0,0.05)'}
            },
            barGap:'-100%',
            barCategoryGap:'40%',
            data: dataShadow,
            animation: false
        },
        {
            type: 'bar',
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1,
                        [
                            {offset: 0, color: '#83bff6'},
                            {offset: 0.5, color: '#188df0'},
                            {offset: 1, color: '#188df0'}
                        ]
                    )
                },
                emphasis: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1,
                        [
                            {offset: 0, color: '#2378f7'},
                            {offset: 0.7, color: '#2378f7'},
                            {offset: 1, color: '#83bff6'}
                        ]
                    )
                }
            },
            data: data
        }
    ]
};

// Enable data zoom when user click bar.
var zoomSize = 6;
myChart.on('click', function (params) {
    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
    myChart.dispatchAction({
        type: 'dataZoom',
        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
    });
});;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
       </script>
       <form name="select" action="${pageContext.request.contextPath }/three.action" method="post">
	<td><input type="submit" name="xuanke" value="点击下一个" ></td>
	</form>
   </body>
         
</html>