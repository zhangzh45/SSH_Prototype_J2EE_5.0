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

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 服务注册</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	


		
				<div >

					<div >

					

						<h3 class="page-title">

							服务注册

							 <small>注册需要添加服务的</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<span class="icon-angle-right"></span>

							</li>

							<li>

								<a href="#">服务管理</a>

								<span class="icon-angle-right"></span>

							</li>

							<li><a href="#">服务注册</a></li>

						</ul>

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>服务注册信息</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form name="form2" class="form-horizontal" action="register.action" method="post" enctype="multipart/form-data">

									<div class="control-group">
								    <label class="control-label" for="inputServiceName">服务名称</label>
								    <div class="controls">
								      <input type="text" id="inputServiceName" name="sr.serviceName" placeholder="ServiceName">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceType">服务类型</label>
								    <div class="controls">
								      <input type="text" id="inputServiceType" name="sr.serviceType" placeholder="ServiceType">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceTarget">服务目标</label>
								    <div class="controls">
								      <input type="text" id="inputServiceTarget" name="sr.serviceTarget" placeholder="ServiceTarget">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceDesc">服务描述</label>
								    <div class="controls">
								      <input type="text" id="inputServiceDesc" name="sr.serviceDesc" placeholder="ServiceDesc">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceRange">服务范围</label>
								    <div class="controls">
								      <input type="text" id="inputServiceRange" name="sr.serviceRange" placeholder="ServiceRange">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceAddress">服务地址</label>
								    <div class="controls">
								      <input type="text" id="inputServiceAddress" name="sr.serviceAddress" placeholder="ServiceAddress">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceMaxLoad">服务最大负荷</label>
								    <div class="controls">
								      <input type="text" id="inputServiceMaxLoad" name="maxLoad" placeholder="ServiceMaxLoad">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceLevel">服务级别</label>
								    <div class="controls">
								      <select>
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
								      </select>
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputRelateBusiness">涉及业务</label>
								    <div class="controls">
								      <input type="text" id="inputRelateBusiness" name="sr.relateBusiness" placeholder="RelateBusiness">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceWay">服务提供方式</label>
								    <div class="controls">
								      <label class="radio">
										<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
										     本地
								  	  </label>
									  <label class="radio">
										<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
										   远程
									  </label>
								    </div>
								  </div>
								  
								  <div class="control-group">
								    <div class="controls">
								      <label class="checkbox">
								        <input type="checkbox"> 匿名
								      </label>
								    </div>
								  </div>
								  <div class="control-group">
								    <div class="controls">
										附件<input name="myFile" type="FILE" id="myFile" size="50" >
									</div>
								  </div>

									<div class="form-actions">

										<button type="button" class="btn blue" onclick="alert('注册成功！您还可以继续注册');form2.action='register.action'; form2.submit()" >Submit</button>

										<button type="button" class="btn">Cancel</button></div>

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

			        


		

		



	
	<script src="media/js/form-components.js"></script>     

	<!-- END PAGE LEVEL SCRIPTS -->

	<script>

		jQuery(document).ready(function() {       

		   // initiate layout and plugins

		   App.init();

		   FormComponents.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->   

</body>

<!-- END BODY -->

</html>