<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 审核服务</title>
	 
	
	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

	<!-- BEGIN CONTAINER -->

	<div >

	

		<!-- BEGIN PAGE -->

		<div >

			

			<!-- BEGIN PAGE CONTAINER-->        

			<div >

				<!-- BEGIN PAGE HEADER-->

				<div >

					<div >

					

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							审核服务 <small>审核已经注册但尚未通过的服务</small>

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

							<li><a href="#">审核服务</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

					

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>服务列表</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">编号</label>
											<label><input type="checkbox" checked data-column="1">名称</label>
											<label><input type="checkbox" checked data-column="2">类型</label>
											<label><input type="checkbox" checked data-column="3">地址</label>
											<label><input type="checkbox" checked data-column="4">目标</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>编号</th>
											<th>名称</th>
											<th class="hidden-480">类型</th>
											<th class="hidden-480">地址</th>
											<th class="hidden-480">目标</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="services" status="L">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td class="hidden-480"><s:property value="serviceType"/></td>
												<td class="hidden-480"><s:property value="serviceAddress"/></td>
												<td class="hidden-480"><s:property value="serviceTarget"/></td>
												<!-- <td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td> -->
											</tr>
										</s:iterator>
									</tbody>
								</table>

							</div>

						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								
								<div class="portlet-title">
									<div class="caption"><i class="icon-globe"></i>审核操作</div>
								</div>
								<div class="portlet-body">
									<h5>服务编号
										<select class="form-control" name="opt1" id="opt1">
											<s:iterator value="services" status="L2">
												<option><s:property value="serviceId"/></option>
											</s:iterator>
										</select>
										审核意见
										<select class="form-control" name="opt2" id="opt2">
											<option>Accept</option>
											<option>Refuse</option>
										</select>
									</h5>
									<button type="button" class="btn btn-primary" onclick="changeValue(); form2.action='inputParameter.action'; form2.submit();">运行</button>
									<button type="button" class="btn" onclick="changeValue(); form2.action='acceptService.action'; form2.submit();">提交</button>
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

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->




	<script>

		
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