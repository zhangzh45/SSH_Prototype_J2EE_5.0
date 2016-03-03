<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
	<head>
		<title>服务维护</title>
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
						<fieldset>
							<select multiple="multiple" id="usersel" onchange="getRole()">
							  <s:iterator value="users" status="L2">
								<option><s:property value="userId"/>:<s:property value="userName"/></option>
							  </s:iterator>
							</select>
						</fieldset>
					</div><!--/span-->
					<div class="span4">
						<fieldset>
							<input type="hidden" id="guss" name="guss" value="">
							<input type="hidden" id="grls" name="grls" value="">
							<input type="hidden" id="gops" name="gops" value="">
							<a onclick="addA()"  role="button" class="btn" data-toggle="modal">添加权限</a>
							<a onclick="delA()"  role="button" class="btn" data-toggle="modal">删除权限</a>
							<a onclick=""  role="button" class="btn" data-toggle="modal">推荐配置</a>
						</fieldset>
					</div><!--/span-->
					<div class="span4">
						<fieldset>
							<select multiple="multiple" id="rolesel">
							  <s:iterator value="roles" status="L2">
								<option><s:property value="roleId"/>:<s:property value="roleName"/></option>
							  </s:iterator>
							</select>
						</fieldset>
					</div><!--/span-->
				  </div>
				  <div class="row-fluid">
				  		<div>
					  		已有角色
					       	<table class="table table-condensed" style="display:none" id="posa">	
								
							</table>
						</div>
						<div>
					       	角色配置操作
					  		<table class="table table-condensed" style="display:none" id="aop">
								
							</table>
						</div>
						<div>
							<a onclick="getA(); form1.action='addUserRole.action';form1.submit()" style="postion:absolute;left:45%;" role="button" class="btn btn-primary" data-toggle="modal">提交</a>
						</div>
				  </div><!--/row-->
				  <div class="row-fluid">
				  	<div>
						<s:iterator value="userroles" status="L" var="userroles">
							<input name="uid" type="hidden" value="<s:property value="userid"/>">
							<input name="rid" type="hidden" value="<s:property value="roleid"/>">
						</s:iterator>
						<s:iterator value="unames" status="L" var="unames">
							<input name="uname" type="hidden" value="<s:property value="#unames"/>">
						</s:iterator>
						<s:iterator value="rolenames" status="L" var="rolenames">
							<input name="rolename" type="hidden" value="<s:property value="#rolenames"/>">
						</s:iterator>
					</div> 
				  </div><!--/row-->
				</div><!--/span-->
			  </div><!--/row-->
	
			</div><!--/.fluid-container-->
		</form>
		
		<script>
			function getRole()
			{
				document.getElementById("posa").style.display="";
				var table=document.getElementById("posa");
				var rowNum = table.rows.length;
				for(var i = 0; i < rowNum; i++)
				{
					table.deleteRow(i);
					rowNum = rowNum - 1;
					i = i - 1;
				}
				var uids = document.getElementsByName("uid");
				var unames = document.getElementsByName("uname");
				var rolenames = document.getElementsByName("rolename");
				var rids = document.getElementsByName("rid");
				//var suid = document.getElementById("usersel").options[document.getElementById("usersel").selectedIndex].text;
				for(var i = 0; i < uids.length; i++)
				{
					//.split(":").item(0).value;
					if(uids.item(i).value == unames.item(document.getElementById("usersel").selectedIndex).value)
					//alert(uidname);
					//if(suid == uidname)
					{
						var table=document.getElementById("posa");
						var row = table.insertRow(-1);
						var cc = row.insertCell(0);
						cc.innerHTML='<input name="posrole" type="text" value="" readOnly="true">';
						var posroles = document.getElementsByName("posrole");
						//alert(posroles.length);
						//alert(rids.length);
						//alert(i);
						//alert(rids.item(i).value);
						posroles.item(posroles.length - 1).value = rids.item(i).value + ": " + rolenames.item(rids.item(i).value - 1).value;
					}
				}	
			}
			function getA()
			{
				var ops = document.getElementsByName("op1");
				var op = "";
				for(var i = 0; i < ops.length; i++)
				{
					op += ops.item(i).value;
					op += ";";
				}
				document.getElementById("gops").value = op;
				
				var uss = document.getElementsByName("us1");
				var us = "";
				for(var i = 0; i < uss.length; i++)
				{
					us += uss.item(i).value;
					us += ";";
				}
				document.getElementById("guss").value = us;
			
				var rls = document.getElementsByName("rl1");
				var rs = "";
				for(var i = 0; i < rls.length; i++)
				{
					rs += rls.item(i).value;
					rs += ";";
				}
				document.getElementById("grls").value = rs;
			}
			function addA()
			{
				//alert("nimei");
				//document.getElementById("table2").style.display="";
				document.getElementById("aop").style.display="";
				var table=document.getElementById("aop");
				var row = table.insertRow(-1);
				
				var cc = row.insertCell(0);
				cc.innerHTML='<input name="rl1" type="text" value="" readOnly="true">';
				
				var cc3 = row.insertCell(0);
				cc3.innerHTML='<input name="op1" type="text" value="get" readOnly="true">';
				
				var cc2 = row.insertCell(0);
				cc2.innerHTML='<input name="us1" type="text" value="" readOnly="true">';
				
				var rls = document.getElementsByName("rl1");
				rls.item(rls.length - 1).value = document.getElementById("rolesel").options[document.getElementById("rolesel").selectedIndex].text;
				var uss = document.getElementsByName("us1");
				uss.item(uss.length - 1).value = document.getElementById("usersel").options[document.getElementById("usersel").selectedIndex].text;
			}
			function delA()
			{
				//alert("nimei");
				//document.getElementById("table2").style.display="";
				document.getElementById("aop").style.display="";
				var table=document.getElementById("aop");
				var row = table.insertRow(-1);
				
				var cc = row.insertCell(0);
				cc.innerHTML='<input name="rl1" type="text" value="" readOnly="true">';
				
				var cc3 = row.insertCell(0);
				cc3.innerHTML='<input name="op1" type="text" value="lose" readOnly="true">';
				
				var cc2 = row.insertCell(0);
				cc2.innerHTML='<input name="us1" type="text" value="" readOnly="true">';
				
				var rls = document.getElementsByName("rl1");
				rls.item(rls.length - 1).value = document.getElementById("rolesel").options[document.getElementById("rolesel").selectedIndex].text;
				var uss = document.getElementsByName("us1");
				uss.item(uss.length - 1).value = document.getElementById("usersel").options[document.getElementById("usersel").selectedIndex].text;
			}
		</script>
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>