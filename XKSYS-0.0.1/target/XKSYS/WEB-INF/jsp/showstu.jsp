<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8;text/html">
<title>test</title>
</head>
<script type="text/javascript"></script>
<body>
<c:forEach items="${stu}" var="student" varStatus="s">
<h2>学生姓名——：${student.name} + 学生手机号码-：${stuent.phone}</h2><br>
</c:forEach>
</body>
</html>