<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
	<body onload="showURL()">
		<div class="container-fluid">
		  <div class="row-fluid">
			<div class="span12">
			  <div class="hero-unit">
				<!-- <h1></h1> -->
				<div class="span9">
			  		<iframe src="" name="iframe" id="IF" width="100%" height="300" id="ifrid"></iframe>
				</div><!--/span-->
				<form name="form1" action="" method="post">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>结果</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="parameters" value="ss" status="L">
								<tr>
									<td><s:property /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<input name="url" type="hidden" value=<s:property value="url"/> id="url">
				</form>
			  </div>
			</div><!--/span-->
		  </div><!--/row-->

		  <hr>

		</div><!--/.fluid-container-->
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script>
			function showURL()
			{
				//alert("nimei");
				alert(document.getElementById("url").value);
				document.getElementById("IF").src= document.getElementById("url").value;
			}
		</script>
	</body>
</html>