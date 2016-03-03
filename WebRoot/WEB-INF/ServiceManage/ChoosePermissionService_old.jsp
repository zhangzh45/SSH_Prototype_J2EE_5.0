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
								<th>权限编号</th>
								<th>权限名称</th>
								<th>权限描述</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="permissions" status="L">
								<input name="serviceID" type="hidden" value="" id="serviceID">
								<tr>
									<td><s:property value="permissionId"/></td>
									<td><s:property value="permissionName"/></td>
									<td><s:property value="permissionDesc"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>服务编号</th>
								<th>服务名称</th>
								<th>服务描述</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="services" status="L">
								<input name="serviceID" type="hidden" value="" id="serviceID">
								<tr>
									<td><s:property value="serviceId"/></td>
									<td><s:property value="serviceName"/></td>
									<td><s:property value="serviceDesc"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<br>选择配置权限
					<select class="form-control" name="opt1" id="opt1">
						<s:iterator value="permissions" status="L2">
							<option><s:property value="permissionId"/></option>
						</s:iterator>
					</select>
					<br>选择配置服务
					<select class="form-control" name="opt2" id="opt2">
						<s:iterator value="services" status="L2">
							<option><s:property value="serviceId"/></option>
						</s:iterator>
					</select>
					<br>确认配置
					<button type="button" class="btn" onclick="changeValue(); form1.action='addPermissionService.action'; form1.submit();">确定&raquo; </button>
					<input name="option1" type="hidden" value="" id="option1">
					<input name="option2" type="hidden" value="" id="option2">
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