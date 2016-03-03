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
								<th>参数ID</th>
								<th>服务ID</th>
								<th>参数类型</th>
								<th>参数名称</th>
								<th>输入</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="parameters" value="ps" status="L">
								<tr>
									<td><s:property value="parameterid"/></td>
									<td><s:property value="serviceid"/></td>
									<td><s:property value="parametertype"/></td>
									<td><s:property value="parametername"/></td>
									<td><input name="parameters.pt" type="text" value=""></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<table class="table table-condensed" id="vartable">
						<thead>
							<tr>
								<th>变量ID</th>
								<th>变量名</th>
								<th>变量描述</th>
								<th>输入</th>
							</tr>
						</thead>
						<s:iterator var="vars" value="vars" status="L">
							<tr>
								<td><s:property value="variableId"/></td>
								<td><s:property value="variableName"/></td>
								<td><s:property value="variableDesc"/></td>
								<td><input name="varvalue" type="text" value=""></td>
							</tr>
						</s:iterator>
					</table>
					
					<h5>服务编号
						<input type="text" name="serviceid" id="serviceid" value=<s:property value="option1"/> Readonly>
					<br>
					服务运行
					<button type="button" class="btn" onclick="getNumber(); form1.action='runService.action'; form1.submit()">运行&raquo; </button>
					</h5>
					<input name="pts" type="hidden" value="" id="pts">
					<input name="vrs" type="hidden" value="" id="vrs">
					<input name="number" type="hidden" value="" id="number">
					<input name="sid" type="hidden" value=<s:property value="option1"/> id="sid">
					<input name="url" type="hidden" value="" id="url">
					<input name="isCombinedB" type="hidden" value=<s:property value="isCombinedB"/> id="url">
					<!--  value="<%=request.getParameter("option1")%>" -->
					
				</form>
			  </div>
			</div><!--/span-->
		  </div><!--/row-->
		  	
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script>
			function getNumber()
			{
				var number = document.getElementsByName("parameters.pt");
				var vv = document.getElementsByName("varvalue");
				alert(number.length);
				document.getElementById("number").value = number.length;
				for(var i = 0; i < number.length; i++)
				{
					if(number[i].value != "")
					{
						document.getElementById("pts").value += number[i].value;
					}
					else
					{
						document.getElementById("pts").value += ";";
					}
					if(i != number.length - 1)
					{
						document.getElementById("pts").value += ",";
					}
				}
				for(var i = 0; i < vv.length; i++)
				{
					if(vv[i].value != "")
					{
						document.getElementById("vrs").value += vv[i].value;
					}
					else
					{
						document.getElementById("vrs").value += ";";
					}
					if(i != vrs.length - 1)
					{
						document.getElementById("vrs").value += ",";
					}
				}
				alert(document.getElementById("vrs").value);
			}
		</script>
	</body>
</html>