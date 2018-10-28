<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
	<head>
		<title>权限配置</title>
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
		<form name="form1" action="" method="post">
			<div class="container-fluid">
			  <div class="row-fluid">
				
				<div class="span9">
				  <div class="row-fluid">
					<div class="span4">
					  <h2>为角色配置权限</h2>
					  <p>为系统中已有的角色配置权限 </p>
					  <p><a class="btn" onclick="form1.action='choosePermissionRole.action';form1.submit()">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>为权限配置服务</h2>
					  <p>为系统中已有的权限配置服务 </p>
					  <p><a class="btn" onclick="form1.action='choosePermissionService.action';form1.submit()">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>添加权限</h2>
					  <p>添加权限到系统中 </p>
					  <p><a class="btn" href="AddPermission.jsp">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>查看和删除权限</h2>
					  <p>查看系统已有的角色 </p>
					  <p><button type="submit" class="btn btn-primary">View details &raquo;</button></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>修改权限</h2>
					  <p>修改系统中的角色 </p>
					  <p><a class="btn" href="#">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>为用户配置角色</h2>
					  <p>为用户配置已有的角色 </p>
					  <p><a class="btn" onclick="form1.action='userAndRole.action';form1.submit()">View details &raquo;</a></p>
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