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
<style type="text/css">
.top {
	text-align: center;
	font-size: 26px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="top">
			<font>我的工作</font>
		</div>
		<!-- 订单未完成评价，则订单尚未完成 -->
		<c:if test="${orders.employee_evaluated != 'YES'}">
			<c:forEach items="${orders_list}" var="orders">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix">
							<!--商家信息-->
							<div class="col-md-6 column">
	
								<h3>${orders.business_name}</h3>
	
							</div>
							<div class="col-md-6 column"></div>
						</div>
						<!--工作描述-->
						<p>${orders.recruitment_jobcontent}</p>
						<!--工作要求-->
						<p>${orders.recruitment_jobrequirements}</p>
						<div class="row clearfix">
							<div class="col-md-6 column">
								<div class="row clearfix">
									<div class="col-md-8 column">
										<!--工作状态-->
										<p>${orders.orders_state}</p>
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
											<c:if test="${orders.orders_state != '已完成' && orders.orders_state != '已结账'}">
												<button type="button" class="btn btn-default" disabled>工作尚未完成</button>
											</c:if>
											<!-- 判断工作是否已完成 -->
											<c:if test="${orders.orders_state == '已完成' || orders.orders_state == '已结账'}">
												<button type="button" class="btn btn-default">评价</button>
											</c:if>
										</div>
									</form>
									<!--取消订单-->
									<div class="col-md-6 column">
										<form action="EmployeeOrdersServlet" method="post">
											<input type="hidden" name="action" value="beseitigenOrder">
											<input type="hidden" name="orders_id" value="${orders.orders_id}">
											<c:set var="OrderAndRecruitment" value="${orders}" scope="request"></c:set>
											<c:if test="${orders.orders_state == '已完成' || orders.orders_state == '已结账'}">
												<button type="submit" class="btn btn-default" style="display: none;">取消订单</button>
											</c:if>
											<c:if test="${orders.orders_state != '已完成' && orders.orders_state != '已结账'}">
												<button type="submit" class="btn btn-default" >取消订单</button>
											</c:if>
										</form>
									</div>
									
								</div>
							</div>
							
						</div>
					</div>
				</div>
	
			</c:forEach>
		</c:if>
	</div>
</body>
</html>