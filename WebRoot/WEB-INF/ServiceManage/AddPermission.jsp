<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	

	<title>企业服务管理系统 | 添加权限</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

						<h3 class="page-title">

							添加权限

							 <small>添加权限配置中的权限</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<span class="icon-angle-right"></span>

							</li>

							<li>

								<a href="#">权限配置</a>

								<span class="icon-angle-right"></span>

							</li>

							<li><a href="#">添加权限</a></li>

						</ul>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>添加权限</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form action="addPermission.action" class="form-horizontal" id="form2">

									<div class="control-group">
								    <label class="control-label" for="inputRoleName">权限名</label>
								    <div class="controls">
								      <input type="text" id="inputPermissionName" name="permission.permissionName" placeholder="PermissionName">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputPermissionDesc">权限描述</label>
								    <div class="controls">
								      <input type="text" id="inputPermissionDesc" name="permission.permissionDesc" placeholder="PermissionDesc">
								    </div>
								  </div>
								  <div class="form-actions">
									  <button type="submit" class="btn btn-primary">提交</button>
									  <button type="button" class="btn">清空</button>
									</div>

								</form>

								<!-- END FORM-->       

							</div>

						</div>

						<!-- END SAMPLE FORM PORTLET-->

					</div>

				</div><div class="row-fluid">

					<div class="span12"></div>

				</div><div class="row-fluid">

					<div class="span12">

						<!-- BEGIN PORTLET--><br><!-- END PORTLET-->

					</div>

				</div>

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXTRAS PORTLET--><br><!-- END EXTRAS PORTLET-->

					</div>

				</div>

			




	

	

</body>

<!-- END BODY -->

</html>