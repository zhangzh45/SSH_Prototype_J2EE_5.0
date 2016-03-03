<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Bootstrap Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<style type="text/css">
      body {
        padding-top: 0px;
        padding-bottom: 0px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
	<body>
		<form name="form1" action="" method="post">
			<div class="container-fluid">
			  <div class="navbar">
			  	<div class="navbar-inner">
			  		<!--  <a class="brand" href="#">Title</a> -->
			  		<ul class="nav">
			  			<li class="active"><a href="#">服务概况</a></li>
			  			<li><a onclick="form1.action='busyClass.action';form1.submit()">技术分类</a></li>
			  			<li><a href="dtree.jsp">业务分类</a></li>
			  			<li><a href="#">其他</a></li>
			  		</ul>
			  	</div>
			  </div>
			  <div class="row-fluid">
				
				<div class="span9">
				  <div class="row-fluid">
				  	<img src="<%=request.getContextPath()+"/images/company.jpeg"%>">
				  </div><!--/row-->
				</div><!--/span-->
			  </div><!--/row-->
	
			</div><!--/.fluid-container-->
		</form>
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>