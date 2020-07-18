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
			<font>申请仲裁</font>
		</div>
		<form action="EmployeeOrdersServlet" method="post">
			<input type="hidden" name="action" value="insertArbitration">
			<input type="hidden" name="orders_id" value="${arbitration.orders_id}">
			<input type="hidden" name="employee_id" value="${arbitration.employee_id}">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<!--商家信息-->
						<div class="col-md-6 column">

							<h3>${business_name}</h3>

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
						<div class="col-md-6 column"></div>
						<div class="col-md-6 column">
							<div class="row clearfix">
								<!--申请仲裁-->
								<div class="col-md-6 column">
									<input type="submit">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>