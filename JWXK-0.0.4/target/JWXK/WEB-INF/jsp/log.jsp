<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wel" id="background-3"></div>
<div class="wel" id="box">
    <div class="box-1 lefp"></div>
    <div class="box-1">
        <div class="righp"></div>
    </div>
</div>
<div class="wel" id="git"></div>
<div class="wel" id="from">
	<div class="flrg-1">
		<div class="a">
             <button type="button" id="time"></button>
        </div>
	</div>
	<div class="flrg-1" style="width: 800px; height: 300px; margin: 0 auto;
            position: relative;
            top: 10%; 
            margin-top: 250px; 
			left:360px;
			">
			<h2 align="left"> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp青春最让你憧憬的事是什么？相信很大一部人会说是爱情。我们的项目就与爱情有关。
				据调查显示，我国2018年总人口13.95亿，单身人数达2.4亿人，且在大学生群体中，单身比例达
				百分之七十，所以我们在此基础上主要想为年轻人提供一点帮助。我们获取了淘宝三月份的
				口红销售情况，并对这些数据进行了整理和分析，希望为男生提供一些借鉴和帮助，更加容易地为女生挑选口红礼物
				从而避免被称呼为"直男"，也为一些为买何种口红而纠结的一些女生提供一些推荐。
			<div class="flrg-1">
			<div class="a">
                 <button type="button"><a href="log.action">点击按钮查看数据分析奥~</a></button>
                </div>
				</div>
			</h3>

	</div>
</div>
<script type="text/javascript">
function time(){
var vWeek,vWeek_s,vDay;
vWeek = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
var date =  new Date();
year = date.getFullYear();
month = date.getMonth() + 1;
day = date.getDate();
hours = date.getHours();
minutes = date.getMinutes();
seconds = date.getSeconds();
vWeek_s = date.getDay();
if(minutes<10){
if(seconds<10){
document.getElementById("time").innerHTML = year + "年" + month + "月" + day + "日" + "\t" + hours + ":0" + minutes +":0" + seconds + "\t" + vWeek[vWeek_s] ;
}
else{
document.getElementById("time").innerHTML = year + "年" + month + "月" + day + "日" + "\t" + hours + ":0" + minutes +":" + seconds + "\t" + vWeek[vWeek_s] ;
}
}
else{
if(seconds<10){
document.getElementById("time").innerHTML = year + "年" + month + "月" + day + "日" + "\t" + hours + ":" + minutes +":0" + seconds + "\t" + vWeek[vWeek_s] ;
}
else{
document.getElementById("time").innerHTML = year + "年" + month + "月" + day + "日" + "\t" + hours + ":" + minutes +":" + seconds + "\t" + vWeek[vWeek_s] ;
}
}

};
setInterval("time()",1000);

</script>
</body>
</html>