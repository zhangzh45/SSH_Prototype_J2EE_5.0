<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
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
	<body style="overflow: auto;" onload="javascript:countDown(5);">
		<div class="container-fluid">
		  <div class="row-fluid">
			
			<div class="span9">
			  <div class="hero-unit">
				<h2>服务审核成功</h2>
				页面将在<span id="jump"></span>秒后自动跳转......
			  </div>
			</div><!--/span-->
		  </div><!--/row-->

		</div><!--/.fluid-container-->
			
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
 		<script type="text/javascript">
 				function countDown(secs) 
 				{
  					document.getElementById("jump").innerHTML = secs;
  					if (--secs > 0){
   					setTimeout("countDown(" + secs + " )", 1000);
   					}else{
  					 location.href="welcome.jsp";
   					}
 				}
		</script>
	</body>
</html>