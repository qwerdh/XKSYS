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
       <div id="container" style="height: 100%">
	   </div>
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
app.title = '坐标轴刻度与标签对齐';

option = {
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['mac魅可官方旗舰店', 'givenchay纪梵希官方旗舰店', '阿玛尼美妆官方旗舰店', 'ysl圣罗兰美妆官方旗舰店', '雅诗兰黛官方旗舰店', '美宝莲旗舰店', '美康粉黛旗舰店','玫倩莱旗舰店','美艳秘笈旗舰店','perfectdiary旗舰店','稚优泉化妆品旗舰店','tb129695162','zeesea旗舰店','欧莱雅彩妆官方旗舰店','hkh旗舰店','vnk旗舰店','lancome兰蔻官方旗舰店','ukiss旗舰店','hedonefashionsnobs旗舰店','holdlive旗舰店','3ce官方旗舰店','曼诗丽旗舰店','玛丽黛佳旗舰店','碧奥泉旗舰店','欧莱雅官方旗舰店','guelain娇兰官方旗舰店','conandanube','yunhao831','卡婷旗舰店','卡姿兰恋尚专卖店'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'直接访问',
            type:'bar',
            barWidth: '60%',
            data:[68000000,38100000,37000000,28000000,24000000,18000000,18000000,19000000,19000000,19000000,17000000,14000000,13500000,13000000,12600000,12000000,11000000,10400000,10000000,8000000,6000000,5600000,5200000,5000000,5000000,4800000,4800000,4750000,4700000,4600000,4600000,4500000]
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
       </script>
          <form name="select" action="${pageContext.request.contextPath }/four.action" method="post">
	<td><input type="submit" name="xuanke" value="点击下一个" ></td>
	</form>
   </body>
</html>