<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceApply"></s:text></title>
	 
	
	
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

							<s:text name="ServiceApply"></s:text> <small><s:text name="ServiceApply.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.jsp">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceManagement"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="ServiceApply"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

					

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
											<label><input type="checkbox" checked data-column="4">Service Desc</label>
											<label><input type="checkbox" checked data-column="5">Service State</label>
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
											<th>Service Desc</th>
											<th>Service State</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="appliedservices" status="L">
											<tr>
												<td class="serviceid"><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td><s:property value="serviceType"/></td>
												<td><s:property value="serviceLevel"/></td>
												<td><s:property value="serviceDesc"/></td>
												<td><button type="button" class="btn btn-primary" onclick="apply()"><s:property value="serviceState"/></button></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>

							</div>

						</div>
						
						<input name="userid" value="<s:property value="nowuser"/>" type="hidden" id="userid"/>
						
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
		   
		   $("button").click(function(){  
		   		var applystr = $(this).html();  //&转义符
		   		var serviceid = $(this).parents("tr").find(".serviceid").text();
		   		var userid = $("#userid").val();
		   		if(applystr == "auditing&amp;cancel"){
		   			$.ajax({
						url		:	"cancelTemp.action",
						type	:	"post",
						dataType:	"json",
						async:  false,
						data: {"userId":userid, "serviceId":serviceid},
						success	: function(){
							location.reload(true);
						},
						error : function (XMLHttpRequest, textStatus, errorThrown) {
							// 通常情况下textStatus和errorThown只有其中一个有值 
					        alert(errorThrown);
					   	}
					});
		   		}
		   		else if(applystr == "applied&amp;remove"){
		   			$.ajax({
						url		:	"removeSpecSer.action",
						type	:	"post",
						dataType:	"json",
						async:  false,
						data: {"userId":userid, "serviceId":serviceid},
						success	: function(){
							location.reload(true);
						},
						error : function (XMLHttpRequest, textStatus, errorThrown) {
							// 通常情况下textStatus和errorThown只有其中一个有值 
					        alert(errorThrown);
					   	}
					});
		   		}
		   		else if(applystr == "applicable&amp;add"){
		   			$.ajax({
						url		:	"addTemp.action",
						type	:	"post",
						dataType:	"json",
						async:  false,
						data: {"userId":userid, "serviceId":serviceid},
						success	: function(){
							location.reload(true);
						},
						error : function (XMLHttpRequest, textStatus, errorThrown) {
							// 通常情况下textStatus和errorThown只有其中一个有值 
					        alert(errorThrown);
					   	}
					});
		   		}
			});  
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