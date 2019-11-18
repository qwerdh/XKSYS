<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="50%" id="Table2"  border="1" class="t1"> 
    <th width="80%">学号</th>
	<th width="20%">姓名</th>
    <c:forEach items="${student}" var="stu" varStatus="s">
    <tr class="a1">
    <td>${stu.teasno}</td>
    <td>${stu.name}</td>
    </c:forEach>
</table>
</body>
</html>