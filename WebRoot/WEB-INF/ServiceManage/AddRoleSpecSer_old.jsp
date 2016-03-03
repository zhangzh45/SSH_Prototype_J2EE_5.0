<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 角色权限配置</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							角色权限配置 <small>配置角色拥有的权限</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">权限配置</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">角色权限配置</a></li>

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

								<div class="caption"><i class="icon-globe"></i>角色列表</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">角色编号</label>
											<label><input type="checkbox" checked data-column="1">角色名称</label>
											<label><input type="checkbox" checked data-column="2">角色描述</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>角色编号</th>
											<th>角色名称</th>
											<th>角色描述</th>
							
			
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

								<div class="caption"><i class="icon-globe"></i>权限列表</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_3_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">权限编号</label>
											<label><input type="checkbox" checked data-column="1">权限名称</label>
											<label><input type="checkbox" checked data-column="2">权限描述</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>服务列表</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_3_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">服务编号</label>
											<label><input type="checkbox" checked data-column="1">服务名称</label>
											<label><input type="checkbox" checked data-column="2">服务描述</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_3">

									<thead>
										<tr>
											<th>服务编号</th>
											<th>服务名称</th>
											<th>服务描述</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="services" status="L">
											<input name="serviceID" type="hidden" value="" id="serviceID">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td><s:property value="serviceDesc"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									角色服务配置
								</div>
								<div class="portlet-body">
									
									<br>选择配置角色
									<select class="form-control" name="opt2" id="opt2">
										<s:iterator value="roles" status="L2">
											<option><s:property value="roleId"/></option>
										</s:iterator>
									</select>
									<br>选择配置服务
									<select class="form-control" name="opt2" id="opt2">
										<s:iterator value="services" status="L2">
											<option><s:property value="serviceId"/></option>
										</s:iterator>
									</select>
									<br>确认配置
									<button type="button" class="btn" onclick="changeValue(); form2.action='addPermissionRole.action'; form2.submit();">确定&raquo; </button>
									<input name="option1" type="hidden" value="" id="option1">
									<input name="option2" type="hidden" value="" id="option2">
									
								</div>
							</div>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->
		</div>
		
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	



	<script>

		jQuery(document).ready(function() {       
		 
		   TableAdvanced.init();
		});
		
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