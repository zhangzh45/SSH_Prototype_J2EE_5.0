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

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
	

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

	

				<div>

					<div>

						

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceOperation"></s:text> <small><s:text name="ServiceOperation.Description"></s:text></small>

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

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i><s:text name="ServiceList"></s:text></div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">Service Id</label>
											<label><input type="checkbox" checked data-column="1">Service Name</label>
											<label><input type="checkbox" checked data-column="2">Service Type</label>
											<label><input type="checkbox" checked data-column="3">Service Address</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>Service Id</th>
											<th>Service Name</th>
											<th class="hidden-480">Service Type</th>
											<th class="hidden-480">Service Address</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="services" status="L">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td class="hidden-480"><s:property value="serviceType"/></td>
												<td class="hidden-480"><s:property value="serviceAddress"/></td>
												<!-- <td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td> -->
											</tr>
										</s:iterator>
									</tbody>
								</table>

							</div>

						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ServiceOperation.Operation"></s:text>
								</div>
								<div class="portlet-body">
									<h5><s:text name="ServiceId"></s:text>
										<select class="form-control" name="opt1" id="opt1">
											<s:iterator value="services" status="L2">
												<option><s:property value="serviceId"/></option>
											</s:iterator>
										</select>
									</h5>
									<button type="button" class="btn btn-primary" onclick="changeValue(); form2.action='inputParameter.action'; form2.submit();"><s:text name="Run"></s:text></button>
									
									<input name="option1" type="hidden" value="" id="option1">
									<input name="option2" type="hidden" value="" id="option2">
								</div>
							</div>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

		

	

	

	

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
	
		function changeValue()
		{
			var selectIndex1 = document.getElementById("opt1").selectedIndex;
			document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
			/*var selectIndex2 = document.getElementById("opt2").selectedIndex;
			document.getElementById("option2").value = document.getElementById("opt2").options[selectIndex2].text;*/
		}

	</script>

</body>

<!-- END BODY -->

</html>