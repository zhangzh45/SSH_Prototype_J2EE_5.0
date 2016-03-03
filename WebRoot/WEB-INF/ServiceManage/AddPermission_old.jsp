
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>添加权限</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-horizontal" action="addPermission.action" method="post">
		  <div class="control-group">
		    <label class="control-label" for="inputRoleName">权限名</label>
		    <div class="controls">
		      <input type="text" id="inputPermissionName" name="permission.permissionName" placeholder="PermissionName">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputPermissionDesc">权限描述</label>
		    <div class="controls">
		      <input type="text" id="inputPermissionDesc" name="permission.permissionDesc" placeholder="PermissionDesc">
		    </div>
		  </div>
		  <div class="form-actions">
			  <button type="submit" class="btn btn-primary">提交</button>
			  <button type="button" class="btn">清空</button>
			</div>
</form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
