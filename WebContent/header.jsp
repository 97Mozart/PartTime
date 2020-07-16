<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 个人信息头部页面 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">PartTime用户中心</a>
		</div>
		<div>
			<ul class="nav nav-tabs">
				<li class="active"><a href="EmployeeOrdersServlet?action=toorder">我的订单</a></li>
				<li><a href="">我的工作</a></li>
				<li><a href="#">我的评价</a></li>
				<li><a href="#">我的仲裁</a></li>

				<li class="dropdown pull-right"><a href="#"
					data-toggle="dropdown" class="dropdown-toggle">${employee.employee_name}<strong
						class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a href="EmployeeInfoServlet?action=queryEmployeeInfo">个人资料</a></li>
						<li class="divider"></li>
						<li><a href="EmployeeInfoServlet?action=topassword">密码修改</a></li>
						<li class="divider"></li>
						<li><a href="EmployeeInfoServlet?action=exit">退出</a></li>
						<li class="divider"></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

