<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 我的评价</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							我的评价 <small>查看我评价的历史记录</small>

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

							<li><a href="#">我的评价</a></li>

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

								<div class="caption"><i class="icon-globe"></i>我的评价列表</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">评价Id</label>
											<label><input type="checkbox" checked data-column="1">被评价服务</label>
											<label><input type="checkbox" checked data-column="2">评价人</label>
											<label><input type="checkbox" checked data-column="3">我的评分</label>
											<label><input type="checkbox" checked data-column="4">评分人数</label>
											<label><input type="checkbox" checked data-column="4">平均评分</label>
										</div>
									</div>
								</div>
							</div>

							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
									<thead>
										<tr>
											<th>评价Id</th>
											<th>被评价服务</th>
											<th>评价人</th>
											<th>我的评分</th>
											<th>评分人数</th>
											<th>平均评分</th>
										</tr>
									</thead>

									<tbody>
										<s:iterator value="alle" status="L">
											<input name="serviceID" type="hidden" value="" id="serviceID">
											<tr>
												<td><s:property value="EvaluationId"/></td>
												<td><s:property value="EvaluationService"/></td>
												<td><s:property value="EvaluationUser"/></td>
												<td><s:property value="EvaluationMark"/></td>
												<td><s:property value="num[#L.index]"/></td>
												<td><s:property value="score[#L.index]"/></td>
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

		
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	

	

	  

	<script>

		jQuery(document).ready(function() {       
		   App.init();
		   TableAdvanced.init();
		});
		
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