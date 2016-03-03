
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>Signin Template for Bootstrap</title>

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

      <form class="form-horizontal" action="addUser.action" method="post">
		  <div class="control-group">
		    <label class="control-label" for="inputUserId">用户ID</label>
		    <div class="controls">
		      <input type="text" id="inputUserId" name="user.userId" placeholder="UserId">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputUserName">姓名</label>
		    <div class="controls">
		      <input type="text" id="inputUserName" name="user.userName" placeholder="UserName">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputPassword">密码</label>
		    <div class="controls">
		      <input type="text" id="inputPassword" name="user.password" placeholder="Password">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputUserDesc">用户描述</label>
		    <div class="controls">
		      <input type="text" id="inputUserDesc" name="user.userDesc" placeholder="UserDesc">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputAddress">居住地址</label>
		    <div class="controls">
		      <input type="text" id="inputAddress" name="user.address" placeholder="Address">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputUserType">用户类型</label>
		    <div class="controls">
		      <select>
				  <option>1</option>
				  <option>2</option>
				  <option>3</option>
				  <option>4</option>
				  <option>5</option>
		      </select>
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
