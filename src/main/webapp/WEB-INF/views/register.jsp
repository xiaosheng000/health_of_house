<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/demo.css">
</head>
<body>
		<div class="demo" style="padding: 20px 0;">
		<center><div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<form class="form-horizontal" action="${pageContext.request.contextPath }/re.action" method="POST">
						<span class="heading">用户注册</span>
						<font color="red">${msg}</font>
						<div class="form-group">
							<input type="text" class="form-control" id="inputEmail3" placeholder="用户名" name="username" required="required">
							<i class="fa fa-user"></i>
						</div>
						<div class="form-group help">
							<input type="password" class="form-control" id="inputPassword3" placeholder="密　码" name="password" required="required">
							<i class="fa fa-lock"></i>
						</div>
						<div class="form-group help" style="text-align: left;">
							&nbsp;&nbsp;&nbsp;<i1 class="fa fa-mars-double"></i1>&nbsp;&nbsp;性别：
							<input type="radio" id="gender_male" class="form-control2" name="sex" value="男" checked="checked" />&nbsp;男&nbsp;&nbsp;
		            		<input type="radio" id="gender_female" class="form-control2" name="sex" value="女" />&nbsp;女
		            		
						</div>
						<div class="form-group help">
							<input type="text" class="form-control" id="inputPassword3" placeholder="昵称" name="names" required="required">
							<i class="fa fa-user"></i>
						</div>
						<div class="form-group help">
							<input type="email" class="form-control" id="inputPassword3" placeholder="邮件" name="email" required="required">
							<i class="fa fa-envelope"></i>
						</div>
						<div class="form-group help">
							<input type="text" class="form-control" id="inputPassword3" placeholder="QQ" name="qq" required="required">
							<i class="fa fa-qq"></i>
						</div>
						<div class="form-group">
							<button type="text" class="btn btn-default">注册</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div style="text-align:center;">
</center>
</div>
</body>
</html>