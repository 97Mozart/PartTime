<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!-- 修改密码页面-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.top {
	text-align: center;
	font-size: 26px;
}

.form-control {
	width: 500px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="top">
			<font>修改密码</font>
		</div>
		<div class="row clearfix center">
			<div class="col-md-12 column">
				<form role="form" action="EmployeeInfoServlet" method="post">
					<input type="hidden" name="action" value="alterEmployeePassword">
					<div class="form-group">
						<label for="name">${requestScope.mess }</label>
					</div>
					<div class="form-group">
						<label for="name">请输入原密码</label><input type="password" class="form-control" id="employee_password" name="employee_password" />
					</div>
					<div class="form-group">
						<label for="name">请输入新密码</label><input type="password" class="form-control" id="employee_password_new1" name="employee_password_new1" />
					</div>
					<div class="form-group">
						<label for="name">再次输入密码</label><input type="password" class="form-control" id="employee_password_new2" name="employee_password_new2" />
					</div>
					<button type="submit" class="btn btn-default">提交</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>