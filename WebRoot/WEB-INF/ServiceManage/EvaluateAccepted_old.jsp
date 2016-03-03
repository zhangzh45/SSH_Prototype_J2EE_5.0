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
								<th>服务编号</th>
								<th>服务名称</th>
								<th>服务类型</th>
								<th>服务级别</th>

							</tr>
						</thead>
						<tbody>
							<s:iterator value="services" status="L">
								<input name="serviceID" type="hidden" value="" id="serviceID">
								<tr>
									<td><s:property value="serviceId"/></td>
									<td><s:property value="serviceName"/></td>
									<td><s:property value="serviceType"/></td>
									<td><s:property value="serviceLevel"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<br>选择服务编号
					<select class="form-control" name="opt1" id="opt1">
						<s:iterator value="services" status="L2">
							<option><s:property value="serviceId"/></option>
						</s:iterator>
					</select>
					<br>选择评价分数
					<select class="form-control" name="opt2" id="opt2">
						<option>5</option>
						<option>4</option>
						<option>3</option>
						<option>2</option>
						<option>1</option>
					</select>
					<br>确认评价意见
					<button type="button" class="btn" onclick="changeValue(); form1.action='getUnEvaluate.action'; form1.submit();">确定&raquo; </button>
					<input name="option1" type="hidden" value="" id="option1">
					<input name="option2" type="hidden" value="" id="option2">
					<input name="option3" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="option3">
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