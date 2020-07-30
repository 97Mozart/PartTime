<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 我的仲裁页面 -->
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
			<font>我的仲裁</font>
		</div>
		<c:forEach items="${arbitrations}" var="arbitration">
			<div class="row clearfix box">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<!--商家信息-->
						<div class="col-md-6 column">

							<h3 class="company"><b><a href='EmployeeOrderInfo?recruitmentid=${arbitration.key.recruitment_id}'>${arbitration.key.business_name}</a></b></h3>

						</div>
						<div class="col-md-6 column"></div>
					</div>
					<!--仲裁内容-->
					<p>仲裁内容：&nbsp;${arbitration.value.arbitration_content}</p>
					<div class="row clearfix">
						<div class="col-md-6 column">
							<div class="row clearfix">
								<div class="col-md-8 column">
									<!--仲裁状态-->
									<p>当前仲裁状态：&nbsp;${arbitration.value.arbitration_state}</p>
								</div>
								<div class="col-md-4 column"></div>
							</div>
						</div>
						<div class="col-md-6 column">
							<div class="row clearfix">
								<form action="EmployeeOrdersServlet" method="post">
									<input type="hidden" name="action" value="toBewerten">
									<div class="col-md-6 column"></div>
								</form>
								<!--删除评价-->
								<div class="col-md-6 column">
									<form action="EmployeeDeleteArbitration" method="post">
										<input type="hidden" name="arbitration_id"
											value="${arbitration.value.arbitration_id}">
										<button type="submit" class="btn btn-default">取消仲裁</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>