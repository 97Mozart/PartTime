<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 我的工作页面	正在进行中的工作 -->
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
			<font>我的工作</font>
		</div>
		<!-- 订单未完成评价，则订单尚未完成 -->
		<c:forEach items="${recruitments}" var="recruitment">
			<c:if test="${recruitment.key.orders_state != '已结账'}">
				<div class="row clearfix box">
					<div class="col-md-12 column">
						<div class="row clearfix">
							<!--商家信息-->
							<div class="col-md-6 column">
	
								<h3 class="company"><b><a href='EmployeeOrderInfo?recruitmentid=${recruitment.key.recruitment_id}'>${recruitment.key.business_name}</a></b></h3>
												
							</div>
							<div class="col-md-6 column"></div>
						</div>
						<!--工作描述-->
						<p>工作内容：&nbsp;${recruitment.value.recruitment_jobcontent}</p>
						<!--工作要求-->
						<p>工作要求：&nbsp;${recruitment.value.recruitment_jobrequirements}</p>
						<div class="row clearfix ">
							<div class="col-md-6 column">
								<div class="row clearfix">
									<div class="col-md-8 column">
										<!--工作状态-->
										<p>当前订单状态：&nbsp;${recruitment.key.orders_state}</p>
									</div>
									<div class="col-md-4 column"></div>
								</div>
							</div>
							<div class="col-md-6 column">
								<div class="row clearfix">
									<!--评价-->
									<form action="EmployeeOrdersServlet" method="post">
										<input type="hidden" name="action" value="toBewerten">
										<div class="col-md-6 column">
											<c:if test="${recruitment.key.orders_state != '已完成' && recruitment.key.orders_state != '已结账'}">
												<button type="button" class="btn btn-default" disabled>工作尚未完成</button>
											</c:if>
											<!-- 判断工作是否已完成 -->
											<c:if test="${recruitment.key.orders_state == '已完成' || recruitment.key.orders_state == '已结账'}">
												<c:if test="${recruitment.key.business_evaluated == 'YES'}">
													<button type="button" class="btn btn-default" disabled>已评价</button>
												</c:if>
												<!-- 判断工作是否已完成 -->
												<c:if
													test="${recruitment.key.business_evaluated != 'YES' && (recruitment.key.orders_state == '已完成' || recruitment.key.orders_state == '已结账')}">
													<button type="button" class="btn btn-default">评价</button>
												</c:if>
											</c:if>
										</div>
									</form>
									<!--取消订单-->
									<div class="col-md-6 column">
										<form action="EmployeeCancelOrder" method="get">
											<input type="hidden" name="orders_id" value="${recruitment.key.orders_id}">
											<%-- <c:set var="OrderAndRecruitment" value="${orders}" scope="request"></c:set> --%>
											<c:if test="${recruitment.key.orders_state == '已完成' || recruitment.key.orders_state == '已结账'}">
												<button type="submit" class="btn btn-default" style="display: none;">取消订单</button>
											</c:if>
											<c:if test="${recruitment.key.orders_state != '已完成' && recruitment.key.orders_state != '已结账'}">
												<button type="submit" class="btn btn-default" >取消订单</button>
											</c:if>
										</form>
									</div>
									
								</div>
							</div>
							
						</div>
					</div>
				</div>
	
			</c:if>
		</c:forEach>
	</div>
</body>
</html>