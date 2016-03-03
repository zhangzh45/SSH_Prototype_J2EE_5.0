
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

      <form class="form-horizontal" action="register.action" method="post" enctype="multipart/form-data">
		  <div class="control-group">
		    <label class="control-label" for="inputServiceName">服务名称</label>
		    <div class="controls">
		      <input type="text" id="inputServiceName" name="sr.serviceName" placeholder="ServiceName">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceType">服务类型</label>
		    <div class="controls">
		      <input type="text" id="inputServiceType" name="sr.serviceType" placeholder="ServiceType">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceTarget">服务目标</label>
		    <div class="controls">
		      <input type="text" id="inputServiceTarget" name="sr.serviceTarget" placeholder="ServiceTarget">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceDesc">服务描述</label>
		    <div class="controls">
		      <input type="text" id="inputServiceDesc" name="sr.serviceDesc" placeholder="ServiceDesc">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceRange">服务范围</label>
		    <div class="controls">
		      <input type="text" id="inputServiceRange" name="sr.serviceRange" placeholder="ServiceRange">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceAddress">服务地址</label>
		    <div class="controls">
		      <input type="text" id="inputServiceAddress" name="sr.serviceAddress" placeholder="ServiceAddress">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceMaxLoad">服务最大负荷</label>
		    <div class="controls">
		      <input type="text" id="inputServiceMaxLoad" name="maxLoad" placeholder="ServiceMaxLoad">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceLevel">服务级别</label>
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
		  <div class="control-group">
		    <label class="control-label" for="inputRelateBusiness">涉及业务</label>
		    <div class="controls">
		      <input type="text" id="inputRelateBusiness" name="sr.relateBusiness" placeholder="RelateBusiness">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputServiceWay">服务提供方式</label>
		    <div class="controls">
		      <label class="radio">
				<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
				     本地
		  	  </label>
			  <label class="radio">
				<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
				   远程
			  </label>
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <div class="controls">
		      <label class="checkbox">
		        <input type="checkbox"> 匿名
		      </label>
		    </div>
		  </div>
		  <div class="control-group">
		    <div class="controls">
				附件<input name="myFile" type="FILE" id="myFile" size="50" >
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
