<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
	<head>
		<title>服务维护</title>
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
			<input type="hidden" id="nowuser" name="nowuser" value="<%=request.getSession().getAttribute("user")%>">
			<div class="container-fluid">
			  <div class="row-fluid">
				
				<div class="span9">
				  <div class="row-fluid">
					<div class="span4">
					  <h2>组合可靠性服务</h2>
					  <p>将具有相同功能和适用性的服务组合以提高服务的可靠性 </p>
					  <p><a class="btn" onclick="form1.action='conbineService.action'; form1.submit();">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>组合适用性服务</h2>
					  <p>将具有相同功能和不同适用性的服务组合来提高适用性</p>
					  <p><button type="submit" class="btn btn-primary" onclick="form1.action='conbineServiceB.action'; form1.submit();">View details &raquo;</button></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>查看维护记录</h2>
					  <p>查看配置历史信息</p>
					  <p><button type="submit" class="btn" onclick="form1.action='combineRelation.action'; form1.submit();">View details &raquo;</button></p>
					</div><!--/span-->
				  </div>
				  <div class="row-fluid">
					<div class="span4">
					  <h2>运行组合服务</h2>
					  <p>运行组合后的服务</p>
					  <p><button type="submit" class="btn btn-primary" onclick="form1.action='combinedService.action'; form1.submit();">View details &raquo;</button></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>组合可靠性服务2</h2>
					  <p>将具有相同功能和适用性的服务组合以提高服务的可靠性 </p>
					  <p><a class="btn" onclick="form1.action='combineAService.action'; form1.submit();">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>组合适用性服务2</h2>
					  <p>将具有相同功能和不同适用性的服务组合来提高适用性 </p>
					  <p><a class="btn" onclick="form1.action='combineBService.action'; form1.submit();">View details &raquo;</a></p>
					</div><!--/span-->
				  </div><!--/row-->
				  <div class="row-fluid">
					<div class="span4">
					  <h2>运行我的服务</h2>
					  <p>运行我具有权限的服务</p>
					  <p><button type="submit" class="btn btn-primary" onclick="form1.action='myService.action'; form1.submit()">View details &raquo;</button></p>
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