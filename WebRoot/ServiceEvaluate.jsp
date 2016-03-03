<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="en">
	<head>
		<title>服务评价</title>
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
					  <h2>年度评价</h2>
					  <p>每年对自己使用的服务进行评价</p>
					  <p><a class="btn" onclick="form1.action='evaluateService.action';form1.submit()">View details &raquo;</a></p>
						<input name="option3" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="option3">
					</div><!--/span-->
					<div class="span4">
					  <h2>我的评价</h2>
					  <p>查看我以前的评价历史记录</p>
					  <p><button class="btn btn-primary" onclick="form1.action='getMyEvaluate.action';form1.submit()">View details &raquo;</button></p>
					</div><!--/span-->
					<div class="span4">
					  <h2>其他</h2>
					  <p>其他 </p>
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