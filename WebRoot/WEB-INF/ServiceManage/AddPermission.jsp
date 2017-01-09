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

	

	<title><s:text name="SystemName"></s:text> | <s:text name="AddPermission"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

						<h3 class="page-title">

							<s:text name="AddPermission"></s:text>

							 <small><s:text name="AddPermission.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<span class="icon-angle-right"></span>

							</li>

							<li>

								<a href="#"><s:text name="PermissionConfiguration"></s:text></a>

								<span class="icon-angle-right"></span>

							</li>

							<li><a href="#"><s:text name="AddPermission"></s:text></a></li>

						</ul>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i><s:text name="AddPermission"></s:text></div>

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
								    <label class="control-label" for="inputRoleName"><s:text name="PermissionName"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputPermissionName" name="permission.permissionName" placeholder="PermissionName">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputPermissionDesc"><s:text name="PermissionDesc"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputPermissionDesc" name="permission.permissionDesc" placeholder="PermissionDesc">
								    </div>
								  </div>
								  <div class="form-actions">
									  <button type="submit" class="btn btn-primary"><s:text name="Submit"></s:text></button>
									  <button type="button" class="btn"><s:text name="Clear"></s:text></button>
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