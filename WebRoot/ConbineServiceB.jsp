<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
	<head>
		<title>ConbineServiceB</title>
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
								<th>服务目标</th>
								<th>服务范围</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="selected" status="L" var="selected">
								<input name="sType" type="hidden" value="<s:property value="serviceType"/>">
								<input name="sTarget" type="hidden" value="<s:property value="serviceTarget"/>">
								<input name="sId" type="hidden" value="<s:property value="serviceId"/>">
								<input name="sRange" type="hidden" value="<s:property value="serviceRange"/>">
								<tr>
									<td><s:property value="serviceId"/></td>
									<td><s:property value="serviceName"/></td>
									<td><s:property value="serviceType"/></td>
									<td><s:property value="serviceLevel"/></td>
									<td><s:property value="maxLoad"/></td>
									<td><s:property value="serviceTarget"/></td>
									<td><s:property value="serviceRange"/></td>
									<td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					
					<br>
					<table id=varTable>
						<tr>
							<td>
								控制变量
								<input name="var1" type="text" value="" id="var1"> 
								<button type="button" onclick="addVar();">+</button>
								<button type="button" onclick="deleteVar();">-</button>
							</td>
						</tr>
					</table>
					<br>选择其中一个服务
					<select class="form-control" name="opt1" id="opt1" onchange="javascript:addSelection()">
						<s:iterator value="selected" status="L2">
							<option><s:property value="serviceId"/></option>
						</s:iterator>
					</select>
					条件表达式
					<input name="e1" type="text" value="" id="e1">
					<br>选择另一个服务
					<select class="form-control" name="opt2" id="opt2">
					</select>
					条件表达式
					<input name="e2" type="text" value="" id="e2">
					<br>确认组合
					<button type="button" class="btn" onclick="changeValue(); form1.action='saveConbineService'; form1.submit();">确定&raquo; </button>
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
			function addSelection()
			{
				document.getElementById("opt2").options.length = 0;
				var id = document.getElementById("opt1").selectedIndex;
				var num = document.getElementById("opt1").options.length;
				//for(var i = 0; i < num; i++)
				//{
					//alert(opt1.options[i].text);
				//}
				var jq = document.getElementsByName("sType");
				//alert(id);
				//alert(jq.length());
				//alert(jq.item(0).value);
				//alert(jq.item(id).value);
				//alert(jq[id]);
				var jq2 = document.getElementsByName("sTarget");
				//alert(id);
				//alert(jq2);
				//alert(jq2[id]);
				var jq3 = document.getElementsByName("sId");
				var jq4 = document.getElementsByName("sRange");
				for(var i = 0; i < num; i++)
				{
					//alert(jq.item(i).value+"="+jq.item(id).value);
					//alert(jq2.item(i).value+"="+jq2.item(id).value);
					if(jq.item(i).value == jq.item(id).value && jq2.item(i).value == jq2.item(id).value && jq4.item(i).value != jq4.item(id).value)
					{
						if(i != id)
						{
							//alert("ok");
							var op = new Option(jq3.item(i).value, jq3.item(i).value);
							document.getElementById("opt2").options.add(op);
						}
					}
				}
			}
			function addVar()
			{
				var table=document.getElementById("varTable");
				var row = table.insertRow(-1);
				var cc = row.insertCell(0);
				cc.innerHTML='控制变量<input name="var1" type="text" value="">';
			}
			function deleteVar()
			{
				var table=document.getElementById("varTable");
				table.deleteRow(table.rows.length-1);
			}
		</script>
	</body>
</html>