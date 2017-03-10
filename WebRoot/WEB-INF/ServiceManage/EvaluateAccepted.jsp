<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceEvaluation"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceEvaluation"></s:text><small><s:text name="ServiceEvaluation.Description"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceEvaluation"></s:text></a></li>

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
											<label><input type="checkbox" checked data-column="3">Service Level</label>
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
											<th>Service Level</th>
			
										</tr>
									</thead>
									<tbody>
										<s:iterator value="services" status="L">
											<input name="serviceID" type="hidden" value="" id="serviceID">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td><s:property value="serviceType"/></td>
												<td><s:property value="serviceLevel"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>

						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ServiceEvaluation"></s:text>
								</div>
								<div class="portlet-body">
									<br><s:text name="ServiceId"></s:text>
									<select class="form-control" name="opt1" id="opt1">
										<s:iterator value="services" status="L2">
											<option><s:property value="serviceId"/></option>
										</s:iterator>
									</select>
									<br><s:text name="ServiceEvaluation.Score"></s:text>
									<select class="form-control" name="opt2" id="opt2">
										<option>5</option>
										<option>4</option>
										<option>3</option>
										<option>2</option>
										<option>1</option>
									</select>
									<br>
									<button type="button" class="btn" onclick="changeValue(); form2.action='getUnEvaluate.action'; form2.submit();"><s:text name="OK"></s:text>&raquo; </button>
									<button type="button" class="btn" onclick="changeValue(); form2.action='getMyEvaluate.action'; form2.submit()"><s:text name="ServiceEvaluation.MyEvaluation"></s:text>&raquo; </button>
									<input name="option1" type="hidden" value="" id="option1">
									<input name="option2" type="hidden" value="" id="option2">
									<input name="option3" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="option3">
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