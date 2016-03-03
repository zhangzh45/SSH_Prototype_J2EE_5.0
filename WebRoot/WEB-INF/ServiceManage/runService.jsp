<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 运行服务</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

	<link rel="stylesheet" href="media/css/DT_bootstrap.css" />

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body onload="showURL()">

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							运行结果 <small>显示服务运行的结果</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">服务管理</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">运行结果</a></li>

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
									结果URL
								</div>
								<div class="portlet-body">
									<iframe src="" name="iframe" id="IF" width="100%" height="300" id="ifrid"></iframe>
								</div>
							</div>
							
							<div class="portlet box blue">
								<div class="portlet-title">
									结果文字描述
								</div>
								<div class="portlet-body">
									<table class="table table-bordered">
										<thead>
											
										</thead>
										<tbody>
											<s:iterator var="parameters" value="ss" status="L">
												<tr>
													<td><s:property /></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
									<input name="url" type="hidden" value=<s:property value="url"/> id="url">
								</div>
							</div>
								
							<div class="portlet box blue">
								<div class="portlet-title">
									运行确认
								</div>
								<div class="portlet-body">
								</div>
							</div>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		

	

	<script>

		jQuery(document).ready(function() {       
		   App.init();
		   TableAdvanced.init();
		});
		
		function showURL()
		{
			//alert("nimei");
			//alert(document.getElementById("url").value);
			document.getElementById("IF").src= document.getElementById("url").value;
		}
	</script>

</body>

<!-- END BODY -->

</html>