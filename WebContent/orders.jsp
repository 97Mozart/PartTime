<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!-- 我的订单页面 -->
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			<font>我的订单</font>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<!--商家信息-->
					<div class="col-md-6 column">
						<h3>
							h3. 这是一套可视化布局系统.
						</h3>
					</div>
					<div class="col-md-6 column">
					</div>
				</div>
				<!--工作描述-->
				<p>
					<em>Git</em> 是一个分布式的版本控制系统，最初由 <strong>Linus Torvalds</strong> 编写，用作Linux内核代码的管理。在推出后，Git在其它项目中也取得了很大成功，尤其是在 <small>Ruby</small> 社区中。
				</p>
				<!--工作要求-->
				<p>
					<em>Git</em> 是一个分布式的版本控制系统，最初由 <strong>Linus Torvalds</strong> 编写，用作Linux内核代码的管理。在推出后，Git在其它项目中也取得了很大成功，尤其是在 <small>Ruby</small> 社区中。
				</p>
				<div class="row clearfix">
					<div class="col-md-6 column">
						<div class="row clearfix">
							<div class="col-md-8 column">
								<!--工作状态-->
								<p>
									<em>Git</em> 是一个分布式的版本控制系统，最初由 <strong>Linus Torvalds</strong> 编写，用作Linux内核代码的管理。在推出后，Git在其它项目中也取得了很大成功，尤其是在 <small>Ruby</small> 社区中。
								</p>
							</div>
							<div class="col-md-4 column">
							</div>
						</div>
					</div>
					<div class="col-md-6 column">
						<div class="row clearfix">
							<!--评价-->
							<div class="col-md-6 column">
								<button type="button" class="btn btn-default">按钮</button>
							</div>
							<!--申请仲裁-->
							<div class="col-md-6 column">
								<button type="button" class="btn btn-default">按钮</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>