<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="RolePermissionConfiguration"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="RolePermissionConfiguration"></s:text><small><s:text name="RolePermissionConfiguration.Description"></s:text></small>

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

							<li><a href="#"><s:text name="RolePermissionConfiguration"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i><s:text name="RoleList"></s:text></div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">Role Id</label>
											<label><input type="checkbox" checked data-column="1">Role Name</label>
											<label><input type="checkbox" checked data-column="2">Role Desc</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>Role Id</th>
											<th>Role Name</th>
											<th>Role Desc</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="roles" status="L">
											<input name="serviceID" type="hidden" value="" id="serviceID">
											<tr>
												<td><s:property value="roleId"/></td>
												<td><s:property value="roleName"/></td>
												<td><s:property value="roleDesc"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						
						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i><s:text name="PermissionList"></s:text></div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_3_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">Permission Id</label>
											<label><input type="checkbox" checked data-column="1">Permission Name</label>
											<label><input type="checkbox" checked data-column="2">Permission Desc</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_3">

									<thead>
										<tr>
											<th>Permission Id</th>
											<th>Permission Name</th>
											<th>Permission Desc</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="permissions" status="L">
											<input name="serviceID" type="hidden" value="" id="serviceID">
											<tr>
												<td><s:property value="permissionId"/></td>
												<td><s:property value="permissionName"/></td>
												<td><s:property value="permissionDesc"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>

						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="RolePermissionConfiguration"></s:text>
								</div>
								<div class="portlet-body">
									<br><s:text name="PermissionId"></s:text>
									<select class="form-control" name="opt1" id="opt1">
										<s:iterator value="permissions" status="L2">
											<option><s:property value="permissionId"/></option>
										</s:iterator>
									</select>
									<br><s:text name="RoleId"></s:text>
									<select class="form-control" name="opt2" id="opt2">
										<s:iterator value="roles" status="L2">
											<option><s:property value="roleId"/></option>
										</s:iterator>
									</select>
									<br>
									<button type="button" class="btn" onclick="changeValue(); form2.action='addPermissionRole.action'; form2.submit();"><s:text name="OK"></s:text>&raquo; </button>
									<input name="option1" type="hidden" value="" id="option1">
									<input name="option2" type="hidden" value="" id="option2">
									
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

	</script>

</body>

<!-- END BODY -->

</html>