<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!-- 个人信息页面-->
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
<script>
	$(function() {
		$("[name=modify]").click(function() {
			$(this).prev().removeAttr("readonly");
			$(this).next().removeClass("delete");
			$(this).next().next().removeClass("delete");
			$(this).prev().css({"border":"black 1px solid"});
		})
		$(".form-control").blur(function(){
			var newtell = $(this).val();
			$(this).attr("value",newtell);
		})
		
		$("[type=submit]").click(function() {
			$("[type=submit]").addClass("delete");
			$("[type=text]").css({"border":"none"});
		})
	}

	)
</script>
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
			<font>个人资料</font>
		</div>
		<div class="row clearfix center" style="width: 60%;margin-left: 20%">
			<div class="col-md-12 column">
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">姓名:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="employee_name" name="employee_name" value="${requestScope.employee.employee_name }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">年龄:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="employee_age" name="employee_age" value="${requestScope.employee.employee_age }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">性别:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="employee_sex" name="employee_sex" value="${requestScope.employee.employee_sex }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">账号:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="employee_account" name="employee_account" value="${requestScope.employee.employee_account }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">学校:</label><input style="border: none;background-color: white;" type="text" class="form-control" id="employee_school" name="employee_school" value="${requestScope.employee.employee_school }" readonly />
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">手机:</label>
					<form class="form-inline" role="form" action="EmployeeInfoModify" method="post">
						<input type="hidden" name="action" value="tell">
						<input style="border: none;background-color: white;" type="text" class="form-control" id="employee_tell" name="employee_tell" value="${requestScope.employee.employee_tell }" readonly onblur="bage(this)" onfocus="fage(this)"/>
						<input type="button" name="modify" value="修改" />
						<button type="submit" class="btn btn-default delete">保存</button>
						<div class="check"></div>
					</form>
				</div>
				<div class="form-group">
					<label for="name" style="float: left;line-height: 34px;width: 100px">邮箱:</label>
					<form class="form-inline" role="form" action="EmployeeInfoModify" method="post">
						<input type="hidden" name="action" value="email">
						<input style="border: none;background-color: white;" type="text" class="form-control" id="employee_email" name="employee_email" value="${requestScope.employee.employee_email }" readonly onblur="bage(this)" onfocus="fage(this)" />
						<input type="button" name="modify" value="修改" />
						<button type="submit" class="btn btn-default delete">保存</button>
						<div class="check"></div>
					</form>
				</div>
				<div class="form-group">
					<label for="ssex" style="float: left;line-height: 34px;width: 100px">工作类别:</label>
					<form class="form-inline" role="form" action="EmployeeInfoModify" method="post">
						<input type="hidden" name="action" value="label">
						<input style="border: none;background-color: white;" type="text" class="form-control" id="employee_label" name="employee_label" value="${requestScope.employee.employee_label }" readonly />
						<input type="button" name="modify" value="修改" />
						<button type="submit" class="btn btn-default delete" onclick="chk()">保存</button>
						<div class="delete">
							<input type="checkbox" name="label" value="技术">技术
							<input type="checkbox" name="label" value="教育">教育
							<input type="checkbox" name="label" value="体力">体力
							<input type="hidden" name="employee_label" id="employee_label">
						</div>
					</form>
				</div>
				<script type="text/javascript">
					//给employee_label赋值
					function chk() {
						var obj = document.getElementsByName('label'); //选择所有name="'label'"的对象，返回数组 
						//取到对象数组后，我们来循环检测它是不是被选中 
						var s = '';
						for(var i = 0; i < obj.length; i++) {
							if(obj[i].checked) s += obj[i].value + ';'; //如果选中，将value添加到变量s中 
						}
						var te = document.getElementById("employee_label");
						te.value = s;
					}
					function bage(e) {
						if (e.name == "employee_email") {
							var c_age = /^\w+@\w+\.[A-Za-z]{2,3}$/;
							
							var email = e.value;
							res = c_age.test(email);
							if (!res) {
								e.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML = "输入邮箱不合法";
							}
						} else if (e.name == "employee_tell") {
							var c_age = /^1\d{10}$/;
							var tell = e.value;
							res = c_age.test(tell);
							console.log(res);
							if (!res) {
								e.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML = "请输入正确的电话号码";
							}
						}
					}
					function fage(e) {
						e.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML = "";
					}
				</script>
			</div>
		</div>
	</div>
</body>
</html>