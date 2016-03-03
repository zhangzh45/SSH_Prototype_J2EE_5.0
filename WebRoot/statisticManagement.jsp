<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<form name="form1" action="" method="post">
			<div class="container-fluid">
			  <div class="row-fluid">
				
				<div class="span9">
				  <div class="row-fluid">
					<div class="span4">
					  <h2>服务统计</h2>
					  <p>查看服务的统计数据 </p>
					  <p><a class="btn" onclick="form1.action='getAllService.action';form1.submit()">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>服务概况</h2>
					  <p>预览服务的大致情况 </p>
					  <p><a class="btn" onclick="form1.action='getPicture.action';form1.submit()">View details &raquo;</a></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>服务关系</h2>
					  <p>预览服务的关系图 </p>
					  <p><a class="btn" onclick="form1.action='getServiceRelation.action';form1.submit()">View details &raquo;</a></p>
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