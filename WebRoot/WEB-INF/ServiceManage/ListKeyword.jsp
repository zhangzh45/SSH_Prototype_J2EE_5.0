<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String user = request.getParameter("uname");
request.getSession().setAttribute("username", user);     //用Session保存用户名
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />
	<title>企业服务管理系统 | 查看关键字</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">
							关键字信息 <small>可以查看关键字的详细信息</small>
						</h3>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="index.html">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="#">服务信息爬取</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">查看关键字</a></li>
						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box light-grey">
							<div class="portlet-title">
								<div class="caption"><i class="icon-globe"></i>关键字信息</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="javascript:;" class="reload"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<div class="btn-group">

										<button id="sample_editable_1_new" class="btn green">

										Add New <i class="icon-plus"></i>

										</button>

									</div>

									<div class="btn-group pull-right">

										<button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>

										</button>

										<ul class="dropdown-menu pull-right">

											<li><a href="#">Print</a></li>

											<li><a href="#">Save as PDF</a></li>

											<li><a href="#">Export to Excel</a></li>

										</ul>

									</div>

								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">
									<thead>
										<tr>
											<th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
											<th>Name</th>
											<th class="hidden-480">Detail</th>
											<th class="hidden-480">Value</th>
											<th class="hidden-480">Desc</th>
											<th ></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="keywords" status="L">
										<tr class="odd gradeX">
											<td><input type="checkbox" class="checkboxes" value="1" /></td>
											<td><s:property value="keywordname"/></td>
											<td class="hidden-480"><s:property value="keyword"/></td>
											<td class="hidden-480"><s:property value="keywordvalue"/></td>
											<td class="center hidden-480"><s:property value="keyworddesc"/></td>
											<td ><span class="label label-success">Approved</span></td>
										</tr>
										</s:iterator>
									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div><!-- END PAGE CONTAINER-->

	

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<script>
		jQuery(document).ready(function() {       

		   App.init();

		   TableManaged.init();

		});
	</script>
</body>
<!-- END BODY -->
</html>