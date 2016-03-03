<!DOCTYPE html>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
	<head>
		<title>Bootstrap Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
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
		<form action="listRole.action" method="post" id="form1">
			<div class="container-fluid">
			  <div class="row-fluid">
				
				<div class="span9">
				  <div class="row-fluid">
					<div class="span4">
					  <h2>添加角色</h2>
					  <p>添加系统中可以使用的角色 </p>
					  <p><a class="btn" onclick="form1.action='freRole.action'; form1.submit()">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>查看和删除角色</h2>
					  <p>查看系统已有的角色 </p>
					  <p><button type="submit" class="btn btn-primary">View details &raquo;</button></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>修改角色</h2>
					  <p>修改系统中的角色 </p>
					  <p><a class="btn" href="#">View details &raquo;</a></p>
					</div><!--/span-->
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