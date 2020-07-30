<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 用户中心主页面 -->
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
								<li><a href="EmployeeExist">退出</a></li>
								<li class="divider"></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="top">
			<font>${mess}</font>
		</div>
	</div>
</body>
</html>