<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String user = request.getParameter("uname");
request.getSession().setAttribute("username", user);     //用Session保存用户名
%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title> 企业服务管理系统 | 查看爬取站点</title>

	<meta content="width=device-width, height=device-height, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							查看爬取站点 <small>查看服务信息爬取的来源站点</small>

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

							<li><a href="#">查看爬取站点</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->          

				<div class="row-fluid">

					<div class="span12">

						<div class="alert alert-success">

							<button class="close" data-dismiss="alert"></button>

							Please try to re-size your browser window in order to see the tables in responsive mode.<br>

							<span class="label label-important">NOTE:</span>&nbsp;This feature is supported by Internet Explorer 10, Latest Firefox, Chrome, Opera and Safari

						</div>

						<!-- BEGIN SAMPLE TABLE PORTLET-->

						<div class="portlet box green">

							<div class="portlet-title">

								<div class="caption"><i class="icon-cogs"></i>源站点信息</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body flip-scroll">

								<table class="table-bordered table-striped table-condensed flip-content">
									<thead class="flip-content">
										<tr>
											<th>站点id</th>
											<th>站点地址</th>
											<th>页面控制</th>
											<th>供应商名称</th>
											<th>供应商地址</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="searchsites" status="L">
										<tr>
											<td><s:property value="siteid"/></td>
											<td><s:property value="address"/></td>
											<td><s:property value="pagecontrol"/></td>
											<td><s:property value="supplier"/></td>
											<td><s:property value="area"/></td>
										</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>

						<!-- END SAMPLE TABLE PORTLET-->
						<!-- BEGIN SAMPLE TABLE PORTLET-->
						<!-- END SAMPLE TABLE PORTLET-->
					</div>
				</div>

				<!-- END PAGE CONTENT-->

			
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->



 

	<script>

		jQuery(document).ready(function() {       

		   // initiate layout and plugins

		   App.init();

		});

	</script>

</body>

<!-- END BODY -->

</html>