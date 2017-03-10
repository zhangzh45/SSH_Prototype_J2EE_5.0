<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="AddRole"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<h3 class="page-title">

							<s:text name="AddRole"></s:text> <small><s:text name="AddRole.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="PermissionConfiguration"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="AddRole"></s:text></a></li>

						</ul>

					

			

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<form name="form2" action="addRole.action" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="AddRole"></s:text>
								</div>
								<div class="portlet-body">
									<div class="container-fluid">
										<div class="control-group">
									    	<label class="control-label" for="inputRoleName"><s:text name="RoleName"></s:text></label>
										    <div class="controls">
										    	<input type="text" id="inputRoleName" name="role.roleName" placeholder="RoleName">
										    </div>
									  	</div>
									  	<div class="control-group">
									    	<label class="control-label" for="inputRoleDesc"><s:text name="RoleDesc"></s:text></label>
									    	<div class="controls">
									      		<input type="text" id="inputRoleDesc" name="role.roleDesc" placeholder="RoleDesc">
									    	</div>
									  	</div>
									  	<div class="form-actions">
									  		<button type="button" onclick="showModal()" class="btn"><s:text name="AddRole.RoleDerivation"></s:text></button>	
											<button type="submit" class="btn btn-primary"><s:text name="Submit"></s:text></button>
											<button type="button" class="btn"><s:text name="Clear"></s:text></button>
									  	</div>
									</div>
								</div>
							</div>
						</form>
						<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-header">
						    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						    <h3 id="myModalLabel"><s:text name="AddRole.RoleDerivationDetail"></s:text></h3>
						  </div>
						  <div class="modal-body">
						  	<table class="table table-condensed" id="table1">
						  		<thead>
									<tr>
										<th><s:text name="AddRole.InheritedRoleSet"></s:text></th>
										<th><s:text name="AddRole.DegreeOfSupport"></s:text></th>
										<th><s:text name="AddRole.OrderNumber"></s:text></th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="apresults" status="L">
										<tr>
											<td><s:property value="setContent"/> </td>
											<td><s:property value="fre"/></td>
											<td><s:property value="k"/></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						  </div>
						  <div class="modal-footer">
						    <button class="btn" data-dismiss="modal"><s:text name="Close"></s:text></button>
						    
						  </div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

			

	
	

	<script>

		jQuery(document).ready(function() {       
		 
		   TableAdvanced.init();
		   
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "http://localhost:8080/SSH_Prototype_J2EE_5.0/error.jsp";
			}
			if(userid != "0"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
		function showModal()
		{
			$("#myModal").modal('show');
		}
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
			alert("sss");
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
		
		function changeValue()
		{
			var selectIndex1 = document.getElementById("opt1").selectedIndex;
			document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
			var selectIndex2 = document.getElementById("opt2").selectedIndex;
			document.getElementById("option2").value = document.getElementById("opt2").options[selectIndex2].text;
		}

	</script>

</body>

<!-- END BODY -->

</html>