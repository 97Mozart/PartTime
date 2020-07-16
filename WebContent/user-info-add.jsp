<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 新注册用户完善信息界面  -->
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/main.css" />
<style type="text/css">
.top {
	text-align: center;
	font-size: 26px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="top">
			<font>请完善个人信息</font>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form role="form" action="EmployeeInfoServlet" method="post">
					<input type="hidden" name="action" value="insertEmployeeInfo">
					<div class="form-group">
						<label for="name">姓名</label><input type="text" disabled class="form-control" id="employee_name" name="employee_name" value="${employee.employee_name }"/>
					</div>
					<div class="form-group">
						<label for="name">年龄</label><input type="text" placeholder="请认真填写，年龄填写后无法修改" class="form-control" id="employee_age" name="employee_age" />
					</div>
					<div class="form-group">
						<label for="age">用户账号</label><input type="text" class="form-control" placeholder="请认真填写，账号填写后无法修改" id="employee_account" name="employee_account" />
					</div>
					<div class="form-group">
						<label for="ssex">工作类别</label>
						<input type="checkbox" name="label" value="技术">技术
						<input type="checkbox" name="label" value="教育">教育
						<input type="checkbox" name="label" value="体力">体力
						<input type="hidden" name="employee_label" id="employee_label">
					</div>
					<div class="form-group">
						<label for="phone">家庭地址</label>
						<input type="text" class="form-control" id="address" name="address_province" placeholder="省份"/>
						<input type="text" class="form-control" id="address" name="address_city" placeholder="市区"/>
						<input type="text" class="form-control" id="address" name="address_county" placeholder="县城（区）"/>
						<input type="text" class="form-control" id="address" name="address_detail" placeholder="详细地址"/>
					</div>
					<button type="submit" class="btn btn-default" onclick="chk()">提交</button>
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
							te.value=s;
						}
					</script>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
