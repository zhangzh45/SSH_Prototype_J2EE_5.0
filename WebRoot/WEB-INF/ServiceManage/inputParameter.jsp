<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceOperation"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceOperation"></s:text><small><s:text name="ServiceOperation.Operation.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceManagement"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="ServiceOperation"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

			
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<form name="form2" action="" method="post">
							
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ParameterList"></s:text>
								</div>
								<div class="portlet-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th>Parameter Id</th>
												<th>Service Id</th>
												<th>Parameter Type</th>
												<th>Parameter Name</th>
												<th>Input</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="parameters" value="ps" status="L">
												<tr>
													<td><span name="parameters.pid"><s:property value="parameterid"/></span></td>
													<td><span name="parameters.sid"><s:property value="service.serviceId"/></span></td>
													<td><span name="parameters.type"><s:property value="parametertype"/></span></td>
													<td><span name="parameters.name"><s:property value="parametername"/></span></td>
													<td><input name="parameters.pt" type="text" value=""></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
							
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="VariableList"></s:text>
								</div>
								<div class="portlet-body">
									<table class="table table-condensed" id="vartable">
										<thead>
											<tr>
												<th>Variable Id</th>
												<th>Service Id</th>
												<th>Variable Name</th>
												<th>Variable Desc</th>
												<th>Input</th>
											</tr>
										</thead>
										<s:iterator var="vars" value="vars" status="L">
											<tr>
												<td><span name="vars.vid"><s:property value="variableId"/></span></td>
												<td><span name="vars.sid"><s:property value="service.serviceId"/></span></td>
												<td><span name="vars.name"><s:property value="variableName"/></span></td>
												<td><span name="vars.desc"><s:property value="variableDesc"/></span></td>
												<td><input name="varvalue" type="text" value=""></td>
											</tr>
										</s:iterator>
									</table>
								</div>
							</div>
								
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ServiceOperation"></s:text>
								</div>
								<div class="portlet-body">
									<h5><s:text name="ServiceId"></s:text>
										<input type="text" name="serviceid" id="serviceid" value=<s:property value="option1"/> Readonly>
									<br>
									<button type="button" class="btn" onclick="getNumber(); form2.action='runService.action'; form2.submit()"><s:text name="Run"></s:text>&raquo; </button>
									</h5>
									<input name="pts" type="hidden" value="" id="pts">
									<input name="vrs" type="hidden" value="" id="vrs">
									<input name="number" type="hidden" value="" id="number">
									<input name="sid" type="hidden" value=<s:property value="option1"/> id="sid">
									<input name="url" type="hidden" value="" id="url">
									<input name="isCombinedB" type="hidden" value=<s:property value="isCombinedB"/> id="url">
									<input name="userid" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="userid">
									<!--  value="<%=request.getParameter("option1")%>" -->
								</div>
							</div>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	

	<script>

		jQuery(document).ready(function() {       
		   App.init();
		   TableAdvanced.init();
		   
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "/error.jsp";
			}
			if(userid != "0"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
		function getNumber()
			{
				var number = document.getElementsByName("parameters.pt");
				var para_sid = document.getElementsByName("parameters.sid");
				var para_name = document.getElementsByName("parameters.name");
				//alert(number.length);
				document.getElementById("number").value = number.length;
				for(var i = 0; i < number.length; i++)
				{
					if(number[i].value != "")
					{
						document.getElementById("pts").value += para_sid[i].innerText + "_" + para_name[i].innerText + "=" + number[i].value;
					}
					else
					{
						document.getElementById("pts").value += para_sid[i].innerText + "_" + para_name[i].innerText + "=" + ";";
					}
					if(i != number.length - 1)
					{
						document.getElementById("pts").value += ",";
					}
				}
				
				var vv = document.getElementsByName("varvalue");
				var var_sid = document.getElementsByName("vars.sid");
				var var_name = document.getElementsByName("vars.name");
				for(var i = 0; i < vv.length; i++)
				{
					if(vv[i].value != "")
					{
						document.getElementById("vrs").value += var_sid[i].innerText + "_" + var_name[i].innerText + "=" + vv[i].value;
					}
					else
					{
						document.getElementById("vrs").value += var_sid[i].innerText + "_" + var_name[i].innerText + "=" + ";";
					}
					if(i != vrs.length - 1)
					{
						document.getElementById("vrs").value += ",";
					}
				}
				//alert(document.getElementById("vrs").value);
			}

	</script>

</body>

<!-- END BODY -->

</html>