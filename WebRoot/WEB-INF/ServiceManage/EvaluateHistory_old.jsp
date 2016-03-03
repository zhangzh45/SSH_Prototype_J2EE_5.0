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
		<div class="container-fluid">
		  <div class="row-fluid">
			<div class="span12">
			  <div class="hero-unit">
				<!-- <h1></h1> -->
				<form name="form1" action="" method="post">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>评价Id</th>
								<th>被评价服务</th>
								<th>评价人</th>
								<th>我的评分</th>
								<th>评分人数</th>
								<th>平均评分</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="alle" status="L">
								<input name="serviceID" type="hidden" value="" id="serviceID">
								<tr>
									<td><s:property value="EvaluationId"/></td>
									<td><s:property value="EvaluationService"/></td>
									<td><s:property value="EvaluationUser"/></td>
									<td><s:property value="EvaluationMark"/></td>
									<td><s:property value="num[#L.index]"/></td>
									<td><s:property value="score[#L.index]"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
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
			function changeValue()
			{
				var selectIndex1 = document.getElementById("opt1").selectedIndex;
				document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
				var selectIndex2 = document.getElementById("opt2").selectedIndex;
				document.getElementById("option2").value = document.getElementById("opt2").options[selectIndex2].text;
			}
		</script>
	</body>
</html>