<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 继承角色派生</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							继承角色派生 <small>根据已有的用户角色配置派生继承角色</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">权限管理</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">继承角色派生</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>继承角色列表</div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>

										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">频繁橘色集</label>
											<label><input type="checkbox" checked data-column="1">支持度</label>
											<label><input type="checkbox" checked data-column="2">集合大小</label>
											
										</div>
									</div>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">

									<thead>
										<tr>
											<th>频繁角色集</th>
											
											<th>支持度</th>
											<th>集合编号</th>
											<th>集合大小</th>
											
			
										</tr>
									</thead>
									<tbody>
										
											
											<tr>
												<td>1God,3Software Student</td>
												
												<td>0.1</td>
												<td>1</td>
												<td>2</td>
											</tr>
											<tr>
												<td>2Fool,3Software Student</td>
												
												<td>0.1</td>
												<td>2</td>
												<td>2</td>
											</tr>
											<tr>
												<td>3Software Student,5Labrary member</td>
												
												<td>0.1</td>
												<td>3</td>
												<td>2</td>
											</tr>
											<tr>
												<td>2SYSU Student,5Labrary member</td>
												
												<td>0.15</td>
												<td>4</td>
												<td>2</td>
											</tr>
											<tr>
												<td>2SYSU Student,3Software Student,5Labrary member</td>
												
												<td>0.1</td>
												<td>5</td>
												<td>3</td>
											</tr>
										
									</tbody>
								</table>
							</div>

						</div>
						<form name="form2" action="" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									继承角色派生
								</div>
								<div class="portlet-body">
									<br>最小支持率
									<input name="option1" type="text" value="0.1" id="">
									<br>选择角色集合
									<select class="form-control" name="opt2" id="opt2">
										<option>5</option>
										<option>4</option>
										<option>3</option>
										<option>2</option>
										<option>1</option>
									</select>
									<br>选择操作
									<button type="button" class="btn" onclick="changeValue(); form2.action='getMyEvaluate.action'; form2.submit()">筛选&raquo; </button>
									<button type="button" class="btn" onclick="changeValue(); form2.action='getMyEvaluate.action'; form2.submit()">生成&raquo; </button>
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