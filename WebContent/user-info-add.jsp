<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="css/nav.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<style type="text/css">
.check {
	text-align: center;
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="top">
			<font>请完善个人信息</font>
		</div>
		<div class="row clearfix" style="width: 60%; margin-left: 20%">
			<div class="col-md-12 column">
				<form role="form" action="EmployeeInfoPerfection" method="post">
					<div class="form-group">
						<label for="name"
							style="float: left; line-height: 34px; width: 100px">姓名</label><input
							type="text" disabled class="form-control" id="employee_name"
							name="employee_name" value="${employee.employee_name }" />
					</div>
					<div class="form-group">
						<label for="name"
							style="float: left; line-height: 34px; width: 100px">年龄</label><input
							required type="text" placeholder="请认真填写，年龄填写后无法修改"
							class="form-control" id="employee_age" name="employee_age"
							onblur="bage(this)" onfocus="fage(this)" />
						<div class="check"></div>
					</div>
					<div class="form-group">
						<label for="age"
							style="float: left; line-height: 34px; width: 100px">用户账号</label><input
							required type="text" class="form-control"
							placeholder="请认真填写，账号填写后无法修改" id="employee_account"
							name="employee_account" onblur="bage(this)" onfocus="fage(this)" />
						<div class="check"></div>
					</div>
					<div class="form-group">
						<label for="ssex"
							style="float: left; line-height: 34px; width: 100px">工作类别</label>
						<input type="checkbox" name="label" value="技术"
							style="line-height: 34px">技术 <input type="checkbox"
							name="label" value="教育" style="line-height: 34px">教育 <input
							type="checkbox" name="label" value="体力" style="line-height: 34px">体力
						<input type="hidden" name="employee_label" id="employee_label">
					</div>
					<div class="form-group">
						<label for="phone"
							style="float: left; line-height: 34px; width: 100px; margin-left: -100px">家庭地址</label>
						<br /> <br />
						<!--省份选择-->
						<select class="form-control" id="prov" onchange="showCity(this)"
							required>
							<option></option>
						</select> <input type="hidden" name="address_province" id="pr">

						<!--城市选择-->
						<select class="form-control" id="city"
							onchange="showCountry(this)" required>
						</select> <input type="hidden" name="address_city" id="ci">

						<!--县区选择-->
						<select class="form-control" id="country"
							onchange="selecCountry(this)" required>
						</select> <input type="hidden" name="address_county" id="co">

						<script src="js/city.js"></script>
						<script src="js/method.js"></script>

						<input required type="text" class="form-control" id="address"
							name="address_detail" placeholder="详细地址" onblur="bage(this)"
							onfocus="fage(this)" />
						<div class="check"></div>
					</div>
					<button type="submit" class="btn btn-default" onclick="chk()">提交</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		/* 表单校验 */
		function bage(e) {
			if (e.name == "employee_age") {
				var c_age = /^[0-9]+$/;
				
				var age = e.value;
				res = c_age.test(age);
				if (res) {
					if (age<0 || age >150) {
						e.value = ""
						e.nextElementSibling.innerHTML = "输入年龄不合法";
					}
				} else {
					e.nextElementSibling.innerHTML = "请输入正确年龄";
				}
			} else if (e.name == "employee_account") {
				var c_age = /^[A-z0-9]{6,16}$/;
				var account = e.value;
				res = c_age.test(account);
				if (!res) {
					e.nextElementSibling.innerHTML = "账号不合法，由6-16字母数字组合";
				}
			} else if (e.name == "address_detail") {

			}
		}
		function fage(e) {
			e.nextElementSibling.innerHTML = "";
		}

		//给employee_label赋值
		function chk() {
			var obj = document.getElementsByName('label'); //选择所有name="'label'"的对象，返回数组 
			//取到对象数组后，我们来循环检测它是不是被选中 
			var s = '';
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].checked)
					s += obj[i].value + ';'; //如果选中，将value添加到变量s中 
			}
			var te = document.getElementById("employee_label");
			te.value = s;
		}
	</script>
</body>

</html>
