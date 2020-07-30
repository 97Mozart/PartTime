<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!-- 订单详情界面-->
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
	font-size: 34px;
	font-family: 华文行楷;
}

.delete {
	display: none;
}

.form-control {
	width: 500px;
}
.check {
	float:right;
	color: red;
	margin-right: 0;
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
			<font>订单详情</font>
		</div>
		<div class="row clearfix center" style="width: 60%;margin-left: 20%">
			<div class="col-md-12 column">
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">公司:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="business_name" name="business_name" value="${requestScope.recruitment.business_name }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工作名称:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_name" name="recruitment_name" value="${requestScope.recruitment.recruitment_name }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工作地址:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_area" name="recruitment_area" value="${requestScope.recruitment.recruitment_area }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工资:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_salary" name="recruitment_salary" value="${requestScope.recruitment.recruitment_salary }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">需求人数:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_num" name="recruitment_num" value="${requestScope.recruitment.recruitment_num }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工作时长:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_duration" name="recruitment_duration" value="${requestScope.recruitment.recruitment_duration }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">福利:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_welfare" name="recruitment_welfare" value="${requestScope.recruitment.recruitment_welfare }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工作内容:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_jobcontent" name="recruitment_jobcontent" value="${requestScope.recruitment.recruitment_jobcontent }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工作要求:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_jobrequirements" name="recruitment_jobrequirements" value="${requestScope.recruitment.recruitment_jobrequirements }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">工作类型:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_label" name="recruitment_label" value="${requestScope.recruitment.recruitment_label }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">下单时间:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="recruitment_time" name="recruitment_time" value="${requestScope.recruitment.recruitment_time }" readonly />
				</div>
			</div>
		</div>
	</div>
</body>
</html>