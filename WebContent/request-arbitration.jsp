<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 申请仲裁页面 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/jquery-1.8.3.js"></script>
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
								<li><a href="EmployeeInfoServlet?action=exit">退出</a></li>
								<li class="divider"></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="top">
			<font>申请仲裁</font>
		</div>
		<form action="EmployeeRequestArbitration" method="post">
			<input type="hidden" name="orders_id" value="${arbitration.orders_id}">
			<input type="hidden" name="employee_id" value="${arbitration.employee_id}">
			<div class="row clearfix">
				<div class="col-md-12 column" style="width: 60%;margin-left: 20%">
					<div class="row clearfix">
						<!--商家信息-->
						<div class="col-md-6 column">

							<h3 class="company"><b>${business_name}</b></h3>

						</div>
						<div class="col-md-6 column"></div>
					</div>
					<!--申请内容-->
					<select class="form-control" id="arbitration_content" name="arbitration_content">
						<option selected>拖欠工资</option>
						<option>工作信息不实</option>
						<option>传销诈骗</option>
					</select>
					<div class="row clearfix">
						<div class="col-md-6 column "></div>
						<br/>
						<div class="col-md-6 column">
							<div class="row clearfix">
								<!--申请仲裁-->
								<div class="col-md-6 column ">
									
								</div>
							</div>
						</div>
						<input class="btn-design" type="submit">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>