<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text>| <s:text name="ServiceStatistics.Runlogging"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceStatistics.Runlogging"></s:text><small><s:text name="ServiceStatistics.RunloggingDescription"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceStatistics.Runlogging"></s:text></a></li>

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

								<div class="caption"><i class="icon-globe"></i><s:text name="ServiceStatistics.Runlogging"></s:text></div>

								<div class="actions">
									
									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">Run Id</label>
											<label><input type="checkbox" checked data-column="1">Service Id</label>
											<label><input type="checkbox" checked data-column="2">User Id</label>
											<label><input type="checkbox" checked data-column="3">Start Time</label>
											<label><input type="checkbox" checked data-column="4">Finish Time</label>
											<label><input type="checkbox" checked data-column="5">Run State</label>
											<label><input type="checkbox" checked data-column="6">Run Desc</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>Run Id</th>
											<th>Service Id</th>
											<th>User Id</th>
											<th class="hidden-480">Start Time</th>
											<th class="hidden-480">Finish Time</th>
											<th class="hidden-480">Run State</th>
											<th class="hidden-480">Run Desc</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="rls" status="L">
											<tr>
												<td><s:property value="runid"/></td>
												<td><s:property value="serviceid"/></td>
												<td><s:property value="userid"/></td>
												<td class="hidden-480"><s:property value="starttime"/></td>
												<td class="hidden-480"><s:property value="finishtime"/></td>
												<td class="hidden-480"><s:property value="runstate"/></td>
												<td class="hidden-480"><s:property value="rundesc"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>

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

	<script src="media/js/form-components.js"></script>

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
		

	</script>

</body>

<!-- END BODY -->

</html>