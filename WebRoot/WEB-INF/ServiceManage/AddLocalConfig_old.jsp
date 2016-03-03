
<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>添加本地软件配置</title>

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

      <form class="form-horizontal" action="addConfig.action" method="post">
		  <div class="control-group">
		    <label class="control-label" for="inputServiceId">软件ID</label>
		    <div class="controls">
		      <input type="text" id="inputServiceId" name="licence.ServiceId" placeholder="ServiceId">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputLicenceType">许可证类型</label>
		    <div class="controls">
		      <input type="text" id="inputLicenceType" name="licence.LicenceType" placeholder="LicenceType">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputLicenceTime">许可证时间</label>
		    <div class="controls">
		      <input type="text" id="inputLicenceTime" name="licence.LicenceTime" placeholder="LicenceTime">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputLicenceCode">注册码</label>
		    <div class="controls">
		      <input type="text" id="inputLicenceCode" name="licence.LicenceCode" placeholder="LicenceCode">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputLicenceLocation">安装路径</label>
		    <div class="controls">
		      <input type="text" id="inputLicenceLocation" name="licence.LicenceLocation" placeholder="LicenceLocation">
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
