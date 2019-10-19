<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*---选课登录----*</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
<script type="text/javascript">   
function show_alert(){
var number=refForm.number.value;
if(number.length<8||teasno.length<8){
alert("*---要完整填写学号信息奥！---*");    
return false;
}
}
</script>
</head>
<body> 
<div class="container">
<h1>选课系统</h1>
	<div class="signin">
     	<form name="refForm" action="${pageContext.request.contextPath }/load.action" method="post" onsubmit="return show_alert()">
	      	<input type="text" name="xh"  id="xh" class="user" value="学号${xh}"/>
	      	<input type="password" name="password"  id="password" class="user" value="${password}"/>
          	<input type="submit" value="登录" onclick="show_alert()"/>
	 	</form>
	</div>
</div>
</body>
</html>