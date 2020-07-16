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
<style type="text/css">
.top {
	text-align: center;
	font-size: 26px;
}

.delete {
	display: none;
}

.form-control {
	width: 500px;
}
</style>
<script>
	$(function() {
		$("[name=modify]").click(function() {
			$(this).prev().removeAttr("readonly");
			$(this).next().removeClass("delete");
			$(this).next().next().removeClass("delete");
		})
		$(".form-control").blur(function(){
			var newtell = $(this).val();
			$(this).attr("value",newtell);
		})
		
		$("[type=submit]").click(function() {
			$("[type=submit]").addClass("delete");
		})
	}

	)
</script>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="top">
			<font>个人资料</font>
		</div>
		<div class="row clearfix center">
			<div class="col-md-12 column">
				<div class="form-group">
					<label for="name">姓名</label><input type="text" class="form-control" id="employee_name" name="employee_name" value="${requestScope.employee.employee_name }" readonly />
				</div>
				<div class="form-group">
					<label for="name">年龄</label><input type="text" class="form-control" id="employee_age" name="employee_age" value="${requestScope.employee.employee_age }" readonly />
				</div>
				<div class="form-group">
					<label for="name">性别</label><input type="text" class="form-control" id="employee_sex" name="employee_sex" value="${requestScope.employee.employee_sex }" readonly />
				</div>
				<div class="form-group">
					<label for="name">账号</label><input type="text" class="form-control" id="employee_account" name="employee_account" value="${requestScope.employee.employee_account }" readonly />
				</div>
				<div class="form-group">
					<label for="name">学校</label><input type="text" class="form-control" id="employee_school" name="employee_school" value="${requestScope.employee.employee_school }" readonly />
				</div>
				<div class="form-group">
					<label for="name">手机</label>
					<form class="form-inline" role="form" action="EmployeeInfoServlet?action=updateEmployeeTell" method="post">
						<input type="text" class="form-control" id="employee_tell" name="employee_tell" value="${requestScope.employee.employee_tell }" readonly />
						<input type="button" name="modify" value="修改" />
						<button type="submit" class="btn btn-default delete">保存</button>
					</form>
				</div>
				<div class="form-group">
					<label for="name">邮箱</label>
					<form class="form-inline" role="form" action="EmployeeInfoServlet?action=updateEmployeeEmail" method="post">
						<input type="text" class="form-control" id="employee_email" name="employee_email" value="${requestScope.employee.employee_email }" readonly />
						<input type="button" name="modify" value="修改" />
						<button type="submit" class="btn btn-default delete">保存</button>
					</form>
				</div>
				<div class="form-group">
					<label for="ssex">工作类别</label>
					<form class="form-inline" role="form" action="EmployeeInfoServlet?action=updateEmployeeLabel" method="post">
						<input type="text" class="form-control" id="employee_label" name="employee_label" value="${requestScope.employee.employee_label }" readonly />
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
				</script>
			</div>
		</div>
	</div>
</body>
</html>