<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 服务质量分析</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							服务质量分析<small>根据服务的运行情况和评价进行服务质量分析</small>

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

							<li><a href="#">服务质量分析</a></li>

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

								<div class="caption"><i class="icon-globe"></i>服务质量分析</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">服务ID</label>
											<label><input type="checkbox" checked data-column="1">运行次数</label>
											<label><input type="checkbox" checked data-column="2">失败次数</label>
											<label><input type="checkbox" checked data-column="3">Qos</label>
											<label><input type="checkbox" checked data-column="4">评分人数</label>
											<label><input type="checkbox" checked data-column="5">平均评分</label>
											<label><input type="checkbox" checked data-column="6">综合评价</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>服务ID</th>
											<th>运行次数</th>
											<th class="hidden-480">失败次数</th>
											<th class="hidden-480">Qos</th>
											<th class="hidden-480">评分人数</th>
											<th class="hidden-480">平均评分</th>
											<th class="hidden-480">综合评价</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="sqs" status="L">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="runTime"/></td>
												<td class="hidden-480"><s:property value="failTime"/></td>
												<td class="hidden-480"><s:property value="Qos"/></td>
												<td class="hidden-480"><s:property value="evaluationNumber"/></td>
												<td class="hidden-480"><s:property value="avg"/></td>
												<td class="hidden-480"><s:property value="f"/></td>
												<!-- <td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td> -->
											</tr>
										</s:iterator>
									</tbody>
								</table>

							</div>

						</div>
						

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		
<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/table-advanced.js"></script>   

	   

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