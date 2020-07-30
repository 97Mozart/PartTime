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
<link rel="stylesheet" href="css/nav.css">
<style type="text/css">
.top {
	text-align: center;
	font-size: 26px;
}

.column {
	width: 40%;
	margin-left: 30%;
}

.check {
	text-align: center;
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<!-- 个人信息头部页面 -->
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<!-- 跳转回首页 -->
					<a class="navbar-brand" href="#">PartTime用户中心</a>
				</div>
				<div>
					<ul class="nav nav-tabs">
						<li><a href="EmployeeOrders">我的订单</a></li>
						<li><a href="EmployeeWork">我的工作</a></li>
						<li><a href="EmployeeEvaluate">我的评价</a></li>
						<li><a href="EmployeeArbitration">我的仲裁</a></li>
		
						<li class="dropdown pull-right"><a href="#"
							data-toggle="dropdown" class="dropdown-toggle">${employee.employee_name}<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="EmployeeInfo">个人资料</a></li>
								<li class="divider"></li>
								<li><a href="EmployeePasswordModify">密码修改</a></li>
								<li class="divider"></li>
								<li><a href="EmployeeInfoServlet?action=exit">退出</a></li>
								<li class="divider"></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="top">
			<font>修改密码</font>
		</div>
		<div class="row clearfix center">
			<div class="col-md-12 column">
				<form role="form" action="EmployeePasswordModify" method="post">
					<div class="form-group">
						<label for="name">${requestScope.mess }</label>
					</div>
					<div class="form-group">
						<label for="name">请输入原密码</label><input required type="password"
							class="form-control" id="employee_password"
							name="employee_password" />
					</div>
					<div class="form-group">
						<label for="name">请输入新密码</label><input required type="password"
							class="form-control" id="employee_password_new1"
							name="employee_password_new1" onblur="bage(this)"
							onfocus="fage(this)" />
						<div class="check"></div>
					</div>
					<div class="form-group">
						<label for="name">再次输入密码</label><input required type="password"
							class="form-control" id="employee_password_new2"
							name="employee_password_new2" onblur="bage(this)"
							onfocus="fage(this)" />
						<div class="check"></div>
					</div>
					<button type="submit" class="btn btn-default"
						style="margin-left: 45%">提交</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		/* 表单校验 */
		function bage(e) {
			if (e.name == "employee_password_new1") {
				var c_age = /\w{6,16}/;

				var password = e.value;
				res = c_age.test(password);
				if (!res) {
					e.nextElementSibling.innerHTML = "密码由6-16为字母、数字和下划线字符组成";
				}
			} else if (e.name == "employee_password_new2") {
				var password = document
						.getElementById("employee_password_new1").value;
				if (e.value != password) {
					e.nextElementSibling.innerHTML = "两次输入密码不一致";
				}
			}
		}
		function fage(e) {
			e.nextElementSibling.innerHTML = "";
		}
	</script>
</body>
</html>