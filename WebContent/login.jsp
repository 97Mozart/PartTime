<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!--临时 登录页面  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a id="modal-930441" href="#modal-container-930441" role="button"
					class="btn" data-toggle="modal"></a>
				<div class="modal fade" style="background-image: url(img/bg.jpg);"
					id="modal-container-930441" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" style="width: 500px; margin-top: 130px;">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">
									用户登录&nbsp;&nbsp;<font color='red'> <c:out
											value=""></c:out></font>
								</h4>

							</div>
							<div class="modal-body">
								<form action="user" method="post" class="form-horizontal"
									role="form">
									<input type="hidden" name="action" value="login">
									<div class="form-group">
										<label for="title" class="col-sm-2 control-label">用户名</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="username"
												autocomplete="off" name="username" placeholder="请输入用户名">
										</div>
									</div>
									<div class="form-group">
										<label for="title" class="col-sm-2 control-label">密码</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="password"
												autocomplete="off" name="password" placeholder="请输入密码">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default">登录</button>
											<a class="btn btn-default">注册</a>
										</div>
									</div>
								</form>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
	</div>
</body>
<script>
	//window.location.href="#modal-container-930441";
	$(function() {
		//$("#modal-930441").click();
		$('#modal-container-930441').modal({
			keyboard : false,
			backdrop : false
		})
	});
</script>
</html>
