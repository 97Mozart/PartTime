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
			<font>我的仲裁</font>
		</div>
		<c:forEach items="${arbitration_list}" var="arbitration">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<!--商家信息-->
						<div class="col-md-6 column">

							<h3>${arbitration.business_name}</h3>

						</div>
						<div class="col-md-6 column"></div>
					</div>
					<!--仲裁内容-->
					<p>${arbitration.arbitration_content}</p>
					<div class="row clearfix">
						<div class="col-md-6 column">
							<div class="row clearfix">
								<div class="col-md-8 column">
									<!--仲裁状态-->
									<p>${arbitration.arbitration_state}</p>
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
									<form action="EmployeeOrdersServlet" method="post">
										<input type="hidden" name="action" value="deleteArbitration">
										<input type="hidden" name="arbitration_id"
											value="${arbitration.arbitration_id}">
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