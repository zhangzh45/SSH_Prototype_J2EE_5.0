<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceStatistics"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />
	
	<script type="text/javascript" src="media/js/form-components.js"></script>
	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceStatistics"></s:text><small><s:text name="ServiceStatistics.Description"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceStatistics"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->


				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						
						
						<form name="form4" action="" method="post">
							<div class="container-fluid">
							  <div class="navbar">
							  	<div class="navbar-inner">
							  		<!--  <a class="brand" href="#">Title</a> -->
							  		<ul class="nav">
							  			<li><a onclick="form2.action='getPicture.action';form2.submit()"><s:text name="ServiceStatistics.Profile"></s:text></a></li>
							  			<li class="active"><a onclick="form2.action='quality.action';form2.submit()"><s:text name="ServiceStatistics.Statistics"></s:text></a></li>
							  			<li><a ><s:text name="Other"></s:text></a></li>
							  		</ul>
							  	</div>
							  </div>
					
							</div><!--/.fluid-container-->
						</form>
						
						
						
						
						
						
<form name="form2" action="" method="post">
						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i><s:text name="ServiceStatistics.Statistics"></s:text></div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Rows

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" name="sel1">Running and scoring services</label>
											<label><input type="checkbox" name="sel2">Running services</label>
											<label><input type="checkbox" name="sel3">All services</label>
											<input name="select1" type="hidden" id="select1" value=<s:property value="select1"/>>
											<input name="select2" type="hidden" id="select2" value=<s:property value="select2"/>>
											<input name="select3" type="hidden" id="select3" value=<s:property value="select3"/>>
											<button type="button" class="btn" onclick="changeselect();form2.action='quality.action'; form2.submit();">OK</button>
										</div>
									</div>
									
									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">Service Id</label>
											<label><input type="checkbox" checked data-column="1">Service Name</label>
											<label><input type="checkbox" checked data-column="2">Service Address</label>
											<label><input type="checkbox" checked data-column="3">WSDL Location</label>
											<label><input type="checkbox" checked data-column="4">Run Times</label>
											<label><input type="checkbox" checked data-column="5">Fail Times</label>
											<label><input type="checkbox" checked data-column="6">Qos</label>
											<label><input type="checkbox" checked data-column="7">Score Number</label>
											<label><input type="checkbox" checked data-column="8">Average score</label>
											<label><input type="checkbox" checked data-column="9">Overall score</label>
											<label><input type="checkbox" checked data-column="10">Run Logging</label>
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
											<th>Service Address</th>
											<th>WSDL Location</th>
											<th>Run Times</th>
											<th class="hidden-480">Fail Times</th>
											<th class="hidden-480">Qos</th>
											<th class="hidden-480">Score Number</th>
											<th class="hidden-480">Average score</th>
											<th class="hidden-480">Overall score</th>
											<th>Run Logging</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="sqs" status="L">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td><s:property value="serviceAddress"/></td>
												<td><s:property value="WSDLLocation"/></td>
												<td><s:property value="runTime"/></td>
												<td class="hidden-480"><s:property value="failTime"/></td>
												<td class="hidden-480"><s:property value="Qos"/></td>
												<td class="hidden-480"><s:property value="evaluationNumber"/></td>
												<td class="hidden-480"><s:property value="avg"/></td>
												<td class="hidden-480"><s:property value="f"/></td>
												<td>
													<button class="btn btn-primary" value=<s:property value="serviceId"/> onclick="getlog(this.value)">View</button>
												</td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
								<input name="serviceid" type="hidden" id="serviceid">
								<input name="userid" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="userid">	
							</div>

						</div>
						
</form>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		
<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/table-advanced.js"></script>   

	   

	<script>

		jQuery(document).ready(function() {  
		
			checkuser();   
   	     // alert(document.getElementById("select1").value+document.getElementById("select2").value+document.getElementById("select3").value);
		  if(document.getElementById("select1").value == "true"){
		  	document.getElementsByName("sel1")[0].checked = true;
		  }else{
		  	document.getElementsByName("sel1")[0].checked = false;
		  }
		  if(document.getElementById("select2").value == "true"){
		  	document.getElementsByName("sel2")[0].checked = true;
		  }else{
		  	document.getElementsByName("sel2")[0].checked = false;
		  }
		  if(document.getElementById("select3").value == "true"){
		  	document.getElementsByName("sel3")[0].checked = true;
		  }else{
		  	document.getElementsByName("sel3")[0].checked = false;
		  }
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
		
		function changeValue()
		{
			var selectIndex1 = document.getElementById("opt1").selectedIndex;
			document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
			var selectIndex2 = document.getElementById("opt2").selectedIndex;
			document.getElementById("option2").value = document.getElementById("opt2").options[selectIndex2].text;
		}
		
		function changeselect()
		{
			document.getElementById("select1").value = document.getElementsByName("sel1")[0].checked;
			document.getElementById("select2").value = document.getElementsByName("sel2")[0].checked;
			document.getElementById("select3").value = document.getElementsByName("sel3")[0].checked;
			//alert(document.getElementsByName("sel1")[0].checked+document.getElementsByName("sel2")[0].checked+document.getElementsByName("sel3")[0].checked);
		}
		
		
		function getlog(serviceid)
		{
			//alert(serviceid);
			document.getElementById("serviceid").value = serviceid;
			form2.action='runlog.action';
			form2.submit();
		}
	</script>

</body>

<!-- END BODY -->

</html>