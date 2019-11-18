<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>选课系统－登录</title>
		<!-- 内部样式表 -->
		<style type="text/css">
		*{
			margin: 0;
			padding: 0;
		}
/* #################### 上 ##################### */
		/* 以#开头，id 选择器可以为标有特定 id 的 HTML 元素指定特定的样式。 */
		#head {
			height: 120px;
			width: 100;
			/* background-color 属性定义了元素的背景颜色. */
			background-color: brown;
			text-align: center;
			position: relative;
		}
		/* 高校选课系统 */
		.title {
			font-family: "宋体";
			color: #FFFFFF;
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
			font-size: 36px;
			height: 40px;
			width: 30%;
		}
/* ###################### 中 ####################### */
		#wrap {
			height: 719px;
			width: 100;
			/* background-image 属性描述了元素的背景图像 */
			background-image: url(images/bee.png);
			/* 使用 background-repeat: no-repeat,让背景图像不影响文本的排版 */
			background-repeat: no-repeat;
			background-position: center center;
			position: relative;
		}
		#wrap .logGet {
			height: 408px;
			width: 368px;  
			position: absolute;
			background-color: #FFFFFF;
			top: 20%;
			right: 15%;
		}
		
		/* 登录 */
		#wrap .logGet .logD.logDtip {
			width: 86%;
			border-bottom: 1px solid #ee7700;
			margin-bottom: 60px;
			margin-top: 0px;
			margin-right: auto;
			margin-left: auto;
		}
		
		/* 输入框 */
		#wrap .logGet .lgD {
			width: 86%;
			position: relative;
			margin-bottom: 30px;
			margin-top: 30px;
			margin-right: auto;
			margin-left: auto;
		}
		
		/* 登录按钮 */
		#wrap .logGet .logC {
			width: 86%;
			margin-top: 0px;
			margin-right: auto;
			margin-bottom: 0px;
			margin-left: auto;
		}
		
		/* 登录 */
		.sub{
			width: 100%;
			height: 45px;
			background-color: #ee7700;
			border: none;
			color: white;
			font-size: 18px;
		}
		/* class选择器以一个点"."号显示，用于描述一组元素的样式 */
		.logGet .logD.logDtip .logo {
			background: url(images/logo.png) no-repeat center top;
			background-size: 120px 35px;
			width:120px;
			height:35px;
			margin:10px auto 10px;
		}
		.logGet .lgD input {
			width: 100%;
			height: 42px;
			text-indent: 2.5rem;
		}
/* ###################### 下 ####################### */		 
		 #foot {
		 	width: 100;
		 	height: 126px;
		 	background-color: #CC9933;
		 	position: relative;
		 }
		 
		.copyright {
			font-family: "宋体";
			color: #FFFFFF;
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
			height: 60px;
			width: 40%;
			text-align:center;
		}
		 
		#foot .copyright p {
			height: 24px;
			width: 100%;
		}
		</style>
<script type="text/javascript">   
function show_alert(){
var xh=document.getElementById("xh").value;
var pass=document.getElementById("pass").value;
if(xh.length<8||pass==null){
alert("*---学号或密码出错！---*");    
return false;
}
else{
return true;
}
}
</script>
	</head>
 
	<body>
		<div class="header" id="head">
		  <div class="title">高校选课系统</div>			
		</div>
		
		<div class="wrap" id="wrap">
			<div class="logGet">
				<!-- 头部提示信息 -->
				<div class="logD logDtip">
					<p class="logo"></p>
				</div>
				<!-- 输入框 -->
				<form name="reform" action="${pageContext.request.contextPath }/load.action"  method="post" onsubmit="return show_alert()">
				<div class="lgD">
					<input type="text" id="xh" name="xh"
						placeholder="输入用户名" value="${xh}"/>
				</div>
				<div class="lgD">
					<input type="password" id="pass" name="pass"
						placeholder="输入用户密码" value="${pass}"/>
				</div>
				<div class="logC">
					<input class="sub" type="submit" value="登 录"/>
				</div>
				</form>
			</div>
		</div>
			
		<div class="footer" id="foot">
		  <div class="copyright">
			<p>Copyright © 2019 cczu.edu.cn All Rights Reserved.</p>
			<div>
				<span>联系地址：常州大学</span>
			</div>
			<div>
				<span>Powered by 好奇蜂</span>
			</div>
		  </div>
		</div>
	</body>
</html>