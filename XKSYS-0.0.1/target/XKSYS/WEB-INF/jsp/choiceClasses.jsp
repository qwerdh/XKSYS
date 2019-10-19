<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询课程列表</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
function true_click(){
	var se=confirm("请确认选课!");
	if (se==true)
	  {
	  }
	else
	  {
	  alert("取消成功!");
	  javascript:location.reload();
	  }
	
}
</script>
<style type="text/css">
body,table{
    font-size:12px;
}
table{
    table-layout:fixed;
    empty-cells:show; 
    border-collapse: collapse;
    margin:0 auto;
}
td{
    height:40px;
}

table.t1{
    border:1px solid #cad9ea;
    color:#666;
}
table.t1 th {
    background-image: url(th_bg1.gif);
    background-repeat::repeat-x;
    height:30px;
}
table.t1 td,table.t1 th{
    border:1px solid #cad9ea;
    padding:0 1em 0;
}
table.t1 tr.a1{
    background-color:#f5fafe;
	text-align:center;
}

</style>
</head>

<body>
<table width="30%" id="Table1"  border="1" class="t1"> 
    <th width="25%">姓名</th>
    <th width="25%">学号</th>
	<th width="25%">年级</th>
    <th width="25%">学期</th>
    <tr class="a1">
    <th width="25%">${xm}</th>
    <th width="25%">${xh}</th>
    <th width="50%">${nj}</th>
    <th width="50%">${xq}</th>
    </tr>
</table>
<br><br><br>
<table width="50%" id="Table2"  border="1" class="t1"> 
    <th width="80%">已选课程</th>
	<th width="20%">成绩</th>
    <c:forEach items="${befClass}" var="bef" varStatus="s">
    <tr class="a1">
    <td>${bef.lbmc}</td>
    <td>${bef.kscj}</td>
    </c:forEach>
</table>
<br><br><br>
<table width="50%" id="Table3"  border="1" class="t1"> 
    <th width="80%">本次已选课程</th>
	<th width="20%">退课</th>
    <c:forEach items="${NowClass}" var="now" varStatus="s">
    <tr class="a1">
    <th width="80%">${now.kcmc}</th>
    <form name="reselect" action="${pageContext.request.contextPath }/reselect.action?kcmc=${now.kcmc}&xh=${xh}&xq=${xq}" method="post">
    <td><input type="submit" name="tuike" value="退课"></td>
    </form></tr>
    </c:forEach>
</table>
<br><br><br>
<table width="90%" id="mytab"  border="1" class="t1">
    <th width="20%">课程名称</th>
    <th width="10%">课程教师</th>
	<th width="20%">课程类别</th>
    <th width="10%">课程教师</th>
    <th width="10%">限选人次</th>
    <th width="20%">课程时间</th>
	<th width="10%">确认选课</th>
    <c:forEach items="${classes}" var="classes" varStatus="s">
  	<tr class="a1">
    <td>${classes.vjwkcdm.kcmc}/${classes.kcxh}</td>
    <td>${classes.jsmc}</td>
    <td>${classes.vjwlbdh.lbmc}/${classes.lbdh}</td>
    <td>${classes.jse}</td>
    <td>${classes.xxrs}</td>
	<td>周${classes.zc}/${classes.jc1}-${classes.jc2}节/${classes.zc1}-${classes.zc2}</td>
    <form name="select" action="${pageContext.request.contextPath }/select.action?kcmc=${classes.vjwkcdm.kcmc}&kcxh=${classes.kcxh}&xh=${xh}&xq=${xq}&nj=${nj}" method="post">
	<td><input type="submit" name="xuanke" value="选课" onclick="true_click()"></td>
	</form>
	</tr>
</c:forEach>
</table>
</body>
</html>
