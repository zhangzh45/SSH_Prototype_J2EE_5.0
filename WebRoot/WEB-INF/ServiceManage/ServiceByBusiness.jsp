<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceClassification"></s:text></title>
	 
	
	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

	<!-- BEGIN CONTAINER -->

	<div >

	

		<!-- BEGIN PAGE -->

		<div >

			

			<!-- BEGIN PAGE CONTAINER-->        

			<div >

				<!-- BEGIN PAGE HEADER-->

				<div >

					<div >

					

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceClassification"></s:text> <small><s:text name="ServiceClassification.Description"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceClassification"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

					
						<form name="form2" action="" method="post">
						  <div class="navbar">
						  	<div class="navbar-inner">
						  		<!--  <a class="brand" href="#">Title</a> -->
						  		<ul class="nav">
						  			<li><a onclick="form2.action='serviceByType.action';form2.submit()"><s:text name="ServiceClassification.TechnicalClassification"></s:text></a></li>
						  			<li class="active"><a onclick="form2.action='serviceByBusiness.action';form2.submit()"><s:text name="ServiceClassification.BusinessClassification"></s:text></a></li>
						  			<li><a ><s:text name="Other"></s:text></a></li>
						  		</ul>
						  	</div>
						  </div>
						</form>
					

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<form id="form3" method="post" action="ServiceOfSelectedBusiness.action">
							<div class="control-group">
								<div class="controls"><s:text name="ServiceClassification.BusinessHint"></s:text>
									<select id="selectbusinesses">  <!-- 审核通过的服务 -->
										<option>ALL</option>
										<s:iterator value="servicebusinesses" status="L" var="servicebusinesses">
											<option><s:property/></option>
										</s:iterator>
									</select>
									<div style="display:none"><span id="business"><s:property value="selectedbusiness"/></span></div>
									<input id="selectedbusiness" name="selectedbusiness" type="hidden" value=<s:property value="selectedbusiness"/>>
								</div>
							</div>
						</form>

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
											<label><input type="checkbox" checked data-column="3">Relate Business</label>
											<label><input type="checkbox" checked data-column="4">Service Target</label>
											<label><input type="checkbox" checked data-column="5">Service Range</label>
											<label><input type="checkbox" checked data-column="6">Service Address</label>
											<label><input type="checkbox" checked data-column="7">Service Desc</label>
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
											<th class="hidden-480">Relate Business</th>
											<th class="hidden-480">Service Target</th>
											<th class="hidden-480">Service Range</th>
											<th class="hidden-480">Service Address</th>
											<th class="hidden-480">Service Desc</th>
										</tr>
									</thead>

									<tbody id="tbody">
										<s:iterator value="services" status="L">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td class="hidden-480"><s:property value="serviceType"/></td>
												<td class="hidden-480"><s:property value="relateBusiness"/></td>
												<td class="hidden-480"><s:property value="serviceTarget"/></td>
												<td class="hidden-480"><s:property value="serviceRange"/></td>
												<td class="hidden-480"><s:property value="serviceAddress"/></td>
												<td class="hidden-480"><s:property value="serviceDesc"/></td>
												<!-- <td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td> -->
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

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->




	<script>
		 jQuery(document).ready(function() {       
		 
		   checkuser();
		   
		   //alert(document.getElementById("selectedbusiness").value);
		   //alert(document.getElementById("business").innerHTML);
		   //if(document.getElementById("selectedbusiness").value == "null"){
		   if(document.getElementById("business").innerHTML == "null"){
		  		document.getElementById("selectbusinesses")[0].checked = true;
		   }else{
		   		//var selected = document.getElementById("selectedbusiness").value;
		   		var selected = document.getElementById("business").innerHTML;
		  		document.getElementById("selectbusinesses").value = selected;
		   }
		});
		
		$('#selectbusinesses').change(function(){ 
			var servicetypeobj = document.getElementById("selectbusinesses");
			var servicetypeindex = servicetypeobj.selectedIndex;
			var servicetypevalue = servicetypeobj.options[servicetypeindex].value;
			document.getElementById("selectedbusiness").value = servicetypevalue;
			form3.submit();
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
			//var selectIndex2 = document.getElementById("opt2").selectedIndex;
			//document.getElementById("option2").value = document.getElementById("opt2").options[selectIndex2].text;
		}

	</script>

</body>

<!-- END BODY -->

</html>