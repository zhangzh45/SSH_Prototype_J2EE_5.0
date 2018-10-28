<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceQos"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceQos"></s:text><small><s:text name="ServiceQos.Description"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceQos"></s:text></a></li>

						</ul>

					

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

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
											<label><input type="checkbox" checked data-column="3">Service Reliability</label>
											<label><input type="checkbox" checked data-column="4">Service Availability</label>
											<label><input type="checkbox" checked data-column="5">Service Time</label>
											<label><input type="checkbox" checked data-column="6">Service Cost</label>
											<label><input type="checkbox" checked data-column="7">Service LoadDegree</label>
											<label><input type="checkbox" checked data-column="8">User AvgEvaluation</label>
											<label><input type="checkbox" checked data-column="9">Service Qos</label>
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
											<th>Service Type</th>
											<th>Service Reliability</th>
											<th>Service Availability</th>
											<th>Service Time</th>
											<th>Service Cost</th>
											<th>Service LoadDegree</th>
											<th>User AvgEvaluation</th>
											<th>Service Qos</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="allQos" status="L">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td><s:property value="serviceType"/></td>
												<td><s:property value="reliability"/></td>
												<td><s:property value="availability"/></td>
												<td><s:property value="serviceTime"/></td>
												<td><s:property value="serviceCost"/></td>
												<td><s:property value="busyDegree"/></td>
												<td><s:property value="avgEvaluation"/></td>
												<td><s:property value="serviceQos"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->


	
	<script>
		jQuery(document).ready(function() {       
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

	</script>

</body>

<!-- END BODY -->

</html>