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
								<th>服务最大负荷</th>
								<th>服务地址</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="services" status="L">
								<input name="serviceID" type="hidden" value="" id="serviceID">
								<input name="sId" type="hidden" value="<s:property value="serviceId"/>">
								<tr>
									<td><s:property value="serviceId"/></td>
									<td><s:property value="serviceName"/></td>
									<td><s:property value="serviceType"/></td>
									<td><s:property value="serviceLevel"/></td>
									<td><s:property value="maxLoad"/></td>
									<td><s:property value="serviceAddress"/></td>
									<td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<table id="hide">
						<tr>
							<s:iterator value="conditions" status="L" var="conditions">
								<input name="ce" type="text" value="<s:property value="condtionExpression"/>">
								<input name="csub" type="hidden" value="<s:property value="subServiceId"/>">
								<input name="csid" type="hidden" value="<s:property value="serviceId"/>">
								<input name="cid" type="hidden" value="<s:property value="conditionId"/>">
							</s:iterator>
							<s:iterator value="variables" status="L" var="variables">
								<input name="vid" type="hidden" value="<s:property value="variableId"/>">
								<input name="vsid" type="hidden" value="<s:property value="serviceId"/>">
								<input name="vname" type="text" value="<s:property value="variableName"/>">
								<input name="vdesc" type="hidden" value="<s:property value="variableDesc"/>">
							</s:iterator>
						</tr>
					</table>
					<button type="button" class="btn btn-primary" onclick="form1.action='auditService.action'; form1.submit();">查看</button>
					<br>选择服务编号
					<select class="form-control" name="opt1" id="opt1" onchange="getVC()">
						<s:iterator value="services" status="L2">
							<option><s:property value="serviceId"/></option>
						</s:iterator>
					</select>
					<br>
					<table id="varTable">
						<tr>
							<td>
								
							</td>
						</tr>
					</table>
					<br>
					<select class="form-control" name="opt2" id="opt2" style="display:none">
						<option>Accept</option>
						<option>Refuse</option>
					</select>
					<br>确认运行
					<button type="button" class="btn" onclick="changeValue(); form1.action='inputParameter.action'; form1.submit();">运行&raquo; </button>
					<input name="option1" type="hidden" value="" id="option1">
					<input name="option2" type="hidden" value="" id="option2">
					<input name="varName" type="hidden" value="" id="varName">
					<input name="esp" type="hidden" value="" id="esp">
					<input name="esp2" type="hidden" value="" id="esp2">
					<input name="sid1" type="hidden" value="" id="sid1">
					<input name="sid2" type="hidden" value="" id="sid2">
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
			function getVC()
			{
				var id = document.getElementById("opt1").selectedIndex;
				//var num = document.getElementById("opt1").options.length;
				
				var jq = document.getElementsByName("vname");
				var jq2 = document.getElementsByName("vsid");
				var jq3 = document.getElementsByName("sId");
				
				var jq4 = document.getElementsByName("csid");
				var jq5 = document.getElementsByName("ce");
				var jq6 = document.getElementsByName("csub");
								
				var table = document.getElementById("varTable");
				
				var rowNum = table.rows.length;
				
				for (var i = 0;i < rowNum; i++)
				{
					table.deleteRow(i);
					rowNum=rowNum-1;
					i=i-1;
				}
				
				alert(id);
				var counter = 0;
				for(var i = 0; i < jq5.length; i++)
				{
					if(jq4.item(i).value == jq3.item(id).value)
					{
						counter++;
						if(counter == 1)
						{
							document.getElementById("sid1").value = jq6.item(i).value;
							document.getElementById("esp").value = jq5.item(i).value;
						}
						if(counter == 2)
						{
							document.getElementById("esp2").value = jq5.item(i).value;
							document.getElementById("sid2").value = jq6.item(i).value;
						}
					}
						
				}
				
				for(var i = 0; i < jq.length; i++)
				{
					if(jq2.item(i).value == jq3.item(id).value)
					{
					
						document.getElementById("varName").value = jq.item(i).value;
						
						
						var row = table.insertRow(-1);
						var c = row.insertCell(0);
						c.innerHTML = jq.item(i).value;
						var cc = row.insertCell(1);
						cc.innerHTML='<input name="var1" type="text" value="">';
					}
					
					
				}
			}
		</script>
	</body>
</html>