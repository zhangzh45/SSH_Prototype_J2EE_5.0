<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="LicenseConfiguration"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<script src="media/js/jquery-1.10.2.js" type="text/javascript"></script>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="LicenseConfiguration"></s:text><small><s:text name="LicenseConfiguration.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceConfiguration"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="LicenseConfiguration"></s:text></a></li>

						</ul>


				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<form name="form2" action="addConfig.action" method="post">
						
							<input name="nowuser" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="nowuser">
							
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="LicenseConfiguration"></s:text>
								</div>
								<div class="portlet-body">
									<div class="container-fluid">
										<div class="control-group">
									    <label class="control-label" for="inputServiceId"><s:text name="SoftwareId"></s:text></label>
									    <div class="controls">
									    	<select id="providedservices">  <!-- 审核通过的服务 -->
												<s:iterator value="providedservices" status="L" var="providedservices">
													<option><s:property value="serviceId"/></option>
												</s:iterator>
											</select>
									    	<input type="hidden" id="serviceId" name="serviceId" value="">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputLicenceType"><s:text name="LicenseType"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputLicenceType" name="licence.LicenceType" placeholder="LicenceType">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputLicenceTime"><s:text name="LicenseTime"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputLicenceTime" name="licence.LicenceTime" placeholder="LicenceTime">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputLicenceCode"><s:text name="LicenseCode"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputLicenceCode" name="licence.LicenceCode" placeholder="LicenceCode">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputLicenceLocation"><s:text name="LicenseLocation"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputLicenceLocation" name="licence.LicenceLocation" placeholder="LicenceLocation">
									    </div>
									  </div>
									  <div class="form-actions">
										  <button type="button" class="btn btn-primary" onclick="changeValue();form2.submit()"><s:text name="Submit"></s:text></button>
										  <button type="button" class="btn"><s:text name="Cancel"></s:text></button>
										</div>
									</div>
								</div>
							</div>
						
						</form>
						
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>


	<script>


		jQuery(document).ready(function() {       

		  checkuser();

		});
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "http://localhost:8020/SSH_Prototype_J2EE_5.0/error.jsp";
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
			var selectIndex1 = document.getElementById("providedservices").selectedIndex;
			document.getElementById("serviceId").value = document.getElementById("providedservices").options[selectIndex1].text;
			//alert(document.getElementById("serviceId").value);
			//alert(document.getElementById("nowuser").value);
		}

	</script>

</body>

<!-- END BODY -->

</html>