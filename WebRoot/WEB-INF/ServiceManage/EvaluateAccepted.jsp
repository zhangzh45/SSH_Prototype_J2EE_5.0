<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 服务评价</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							服务评价 <small>评价我可以使用的服务</small>

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

							<li><a href="#">服务评价</a></li>

						</ul>

					

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

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
											<label><input type="checkbox" checked data-column="1">类型</label>
											<label><input type="checkbox" checked data-column="2">名称</label>
											<label><input type="checkbox" checked data-column="3">地址</label>
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>服务编号</th>
											<th>服务名称</th>
											<th>服务类型</th>
											<th>服务级别</th>
			
										</tr>
									</thead>
									<tbody>
										<s:iterator value="services" status="L">
											<input name="serviceID" type="hidden" value="" id="serviceID">
											<tr>
												<td><s:property value="serviceId"/></td>
												<td><s:property value="serviceName"/></td>
												<td><s:property value="serviceType"/></td>
												<td><s:property value="serviceLevel"/></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>

						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									服务评价
								</div>
								<div class="portlet-body">
									<br>选择服务编号
									<select class="form-control" name="opt1" id="opt1">
										<s:iterator value="services" status="L2">
											<option><s:property value="serviceId"/></option>
										</s:iterator>
									</select>
									<br>选择评价分数
									<select class="form-control" name="opt2" id="opt2">
										<option>5</option>
										<option>4</option>
										<option>3</option>
										<option>2</option>
										<option>1</option>
									</select>
									<br>确认评价意见
									<button type="button" class="btn" onclick="changeValue(); form2.action='getUnEvaluate.action'; form2.submit();">确定&raquo; </button>
									<button type="button" class="btn" onclick="changeValue(); form2.action='getMyEvaluate.action'; form2.submit()">我的评价&raquo; </button>
									<input name="option1" type="hidden" value="" id="option1">
									<input name="option2" type="hidden" value="" id="option2">
									<input name="option3" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="option3">
								</div>
							</div>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->


	
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