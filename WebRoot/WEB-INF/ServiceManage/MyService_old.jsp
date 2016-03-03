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
	<body>
		<!--  <div class="container-fluid"> -->
		  <div class="row-fluid">
			<div class="span12">
			 <div class="hero-unit">
				<!-- <h1></h1> -->
				<form name="form1" action="" method="post">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th>编号</th>
								<th>名称</th>
								<th>类型</th>
								<th>地址</th>
								<!-- <th>操作</th> -->
							</tr>
						</thead>
						<tbody>
							<s:iterator value="services" status="L">
								<input name="serviceID" type="hidden" value="" id="serviceID">
								<tr>
									<td><s:property value="serviceId"/></td>
									<td><s:property value="serviceName"/></td>
									<td><s:property value="serviceType"/></td>
									<td><s:property value="serviceAddress"/></td>
									<!-- <td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td> -->
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<li><a href="#">First</a></li>
							<li><a href="#">Prev</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">6</a></li>
							<li><a href="#">7</a></li>
							<li><a href="#">8</a></li>
							<li><a href="#">9</a></li>
							<li><a href="#">10</a></li>
							<li><a href="#">Next</a></li>
							<li><a href="#">Last</a></li>
						</ul>
					</div>
					<div>
						<h5>服务编号
							<select class="form-control" name="opt1" id="opt1">
								<s:iterator value="services" status="L2">
									<option><s:property value="serviceId"/></option>
								</s:iterator>
							</select>
							审核意见
							<select class="form-control" name="opt2" id="opt2" >
								<option>Accept</option>
								<option>Refuse</option>
							</select>
						</h5>
						<button type="button" class="btn btn-primary" onclick="changeValue(); form1.action='inputParameter.action'; form1.submit();">运行</button>
						<button type="button" class="btn" onclick="changeValue(); form1.action='acceptService.action'; form1.submit();">提交</button>
						<input name="option1" type="hidden" value="" id="option1">
						<input name="option2" type="hidden" value="" id="option2">
					</div>
				</form>
			  </div>
			</div><!--/span-->
		  </div><!--/row-->
		
		
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