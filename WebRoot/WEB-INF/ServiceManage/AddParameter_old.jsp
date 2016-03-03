
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>add Paramete for servicer</title>

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

      <form class="form-horizontal" action="addParameter.action" method="post" enctype="multipart/form-data">
		  <div class="control-group">
		    <label class="control-label" for="inputparametername">参数名称</label>
		    <div class="controls">
		      <input type="text" id="parametername" name="pr.parametername" placeholder="parametername">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputserviceid">服务编号</label>
		    <div class="controls">
		      <input type="text" id="serviceid" name="serviceid" placeholder="serviceid">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputparametertype">参数类型</label>
		    <div class="controls">
		      <input type="text" id="inputparametertype" name="pr.parametertype" placeholder="parametertype">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputparameterdesc">参数描述</label>
		    <div class="controls">
		      <input type="text" id="inputparameterdesc" name="pr.parameterdesc" placeholder="parameterdesc">
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
