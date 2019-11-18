<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询课程列表</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
function true_click(){
	var se=confirm("请确认选课!");
	if (se==true)
	  {
	  return true;
	  }
	else
	  {
	  alert("取消成功!");
	  javascript:location.reload();
		return false;
	  }
	
}
function tk_click(){
	var se=confirm("请确认退课!");
	if (se==true)
	  {
	  return true;
	  }
	else
	  {
	  alert("取消成功!");
	  javascript:location.reload();
	  return false;
	  }
	
}

</script>
</head>
<body>
<div class="container"> 
<br>
<table class="table table-bordered" style="width: 50%;">
<thead>
<tr class="table-info">
<th class="text-center">姓名</th>
<th class="text-center">班级</th>
<th class="text-center">学号</th>
<th class="text-center">学期</th>
</tr>
</thead>
<tbody>
<tr>
<th class="text-center">${xm}</th>
<th class="text-center">${bj}</th>
<th class="text-center">${xh}</th>
<th class="text-center">${xq}</th>
</tr>
</tbody>



</table>
<br><br>
<table class="table table-bordered table-hover"  style="width: 50%;">
<thead>
<tr class="table-info">
<th class="text-center">已修课程</th>
<th class="text-center">课程成绩</th>
</tr>
</thead>
<tbody>
 <c:forEach items="${befclass}" var="bef" varStatus="s">
    <tr>
    <th class="text-center">${bef.lbmc}</th>
    <th class="text-center">${bef.kscj}</th>
    </c:forEach>
</tbody>
</table>
<br><br>

<table class="table table-bordered table-hover"  style="width: 50%;">
<thead>
<tr class="table-info">
<th class="text-center">本次已选</th>
<th class="text-center">退课</th>
</tr>
</thead>
<tbody>
 <c:forEach items="${NowClass}" var="now" varStatus="s">
    <tr class="a1">
    <th class="text-center">${now.kcmc}</th>
    <form name="reselect" action="${pageContext.request.contextPath }/reselect.action?kcmc=${now.kcmc}&xh=${xh}&xq=${xq}" method="post">
    <td class="text-center"><input type="submit" class="btn btn-info" value="点击退课" onclick="return tk_click()"></td>
    </form></tr>
    </c:forEach>
</tbody>
</table>
<br><br>
  <table class="table table-bordered table-condensed table-hover table-striped" style="width: 100%;">
    <thead>
      <tr class="table-info">
        <th class="text-center">课程名称</th>
        <th class="text-center">课程教师</th>
        <th class="text-center">课程类别</th>
		<th class="text-center">课程教室</th>
		<th class="text-center">课程时间</th>
		<th class="text-center">可选人数</th>
		<th class="text-center">确认选课</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${classes}" var="classes" varStatus="s">
  	<tr class="a1">
    <td class="text-center">${classes.vjwkcdm.kcmc}/${classes.kcxh}</td>
    <td class="text-center">${classes.jsmc}</td>
    <td class="text-center">${classes.vjwlbdh.lbmc}/${classes.lbdh}</td>
    <td class="text-center">${classes.jse}</td>
    <td class="text-center">${classes.xxrs}</td>
	<td class="text-center">周${classes.zc}//${classes.jc1}-${classes.jc2}节//${classes.zc1}-${classes.zc2}</td>
    <form name="select" action="${pageContext.request.contextPath }/select.action?kcmc=${classes.vjwkcdm.kcmc}&kcxh=${classes.kcxh}&xh=${xh}&xq=${xq}" method="post">
	<td class="text-center"><input type="submit" name="xuanke" class="btn btn-info" value="选课" onclick="return true_click()"></td>
	</form>
	</tr>
</c:forEach>  
    </tbody>
  </table>
</div>

</body>
</html>
