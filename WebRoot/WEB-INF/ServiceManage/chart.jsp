<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 服务关系</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							服务关系<small>查看组合服务与子服务之间的关系</small>

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

							<li><a href="#">服务关系</a></li>

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
							<div class="container-fluid">
							  <div class="navbar">
							  	<div class="navbar-inner">
							  		<!--  <a class="brand" href="#">Title</a> -->
							  		<ul class="nav">
							  			<li class="active"><a href="#">服务概况</a></li>
							  			<li><a onclick="form2.action='busyClass.action';form2.submit()">技术分类</a></li>
							  			<li><a onclick="form2.action='workClass.action';form2.submit()">业务分类</a></li>
							  			<li><a href="#">其他</a></li>
							  		</ul>
							  	</div>
							  </div>
							  <div class="row-fluid">
								
								<div class="span9">
								  <div class="row-fluid">
								  	<img src="<%=request.getContextPath()+"/images/company.jpeg"%>">
								  </div><!--/row-->
								</div><!--/span-->
							  </div><!--/row-->
					
							</div><!--/.fluid-container-->
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

			
	


	

	<script>

		jQuery(document).ready(function() {       
		  
		   TableAdvanced.init();
		});
		
		

	</script>

</body>

<!-- END BODY -->

</html>