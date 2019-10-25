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
app.title = '多 Y 轴示例';

var colors = ['#5793f3', '#d14a61', '#675bba'];

option = {
    color: colors,

    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    grid: {
        right: '20%'
    },
    toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    legend: {
          data:['均价','总额','销售量']
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            data: ['美艳秘笈旗舰店','perfectdiary旗舰店','稚优泉化妆品旗舰店','tb129695162','mac魅可官方旗舰店', 'givenchay纪梵希官方旗舰店', '阿玛尼美妆官方旗舰店', 'ysl圣罗兰美妆官方旗舰店', '雅诗兰黛官方旗舰店','美宝莲旗舰店',
    '美康粉黛旗舰店','玫倩莱旗舰店']
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '平均价格',
            min: 0,
            max: 200,
            position: 'right',
            axisLine: {
                lineStyle: {
                    color: colors[0]
                }
            },
            axisLabel: {
                formatter: '{value} 元'
            }
        },
        {
            type: 'value',
            name: '销售总额',
            min: 0,
            max: 100,
            position: 'right',
            offset: 80,
            axisLine: {
                lineStyle: {
                    color: colors[1]
                }
            },
            axisLabel: {
                formatter: '{value} 百万'
            }
        },
        {
            type: 'value',
            name: '销售量',
            min: 0,
            max: 60,
            position: 'left',
            axisLine: {
                lineStyle: {
                    color: colors[2]
                }
            },
            axisLabel: {
                formatter: '{value} 万'
            }
        }
    ],
    series: [
        {
            name:'均价',
            type:'bar',
            data:[108, 121, 111, 93,123, 98, 96, 101, 97, 96, 96, 102 ]
        },
        {
            name:'销售总额',
            type:'bar',
            yAxisIndex: 1,
            data:[19.0, 19.0, 17.0, 14.0,68.0, 38.1, 37.0, 28.0, 24.0, 18.0, 18.0, 19.0]
        },
        {
            name:'销售量',
            type:'line',
            yAxisIndex: 2,
            data:[17, 15, 15, 15,55, 38, 38, 27, 24, 18, 18, 18]
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
       </script>
   </body>
   <form name="select" action="${pageContext.request.contextPath }/four.action" method="post">
	<td><input type="submit" name="xuanke" value="点击下一个" ></td>
	</form>
</html>