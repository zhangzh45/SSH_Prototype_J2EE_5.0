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

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							服务运行<small>输入服务运行需要的参数和控制变量</small>

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

							<li><a href="#">服务运行</a></li>

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
									参数列表
								</div>
								<div class="portlet-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th>参数ID</th>
												<th>服务ID</th>
												<th>参数类型</th>
												<th>参数名称</th>
												<th>输入</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="parameters" value="ps" status="L">
												<tr>
													<td><s:property value="parameterid"/></td>
													<td><s:property value="serviceid"/></td>
													<td><s:property value="parametertype"/></td>
													<td><s:property value="parametername"/></td>
													<td><input name="parameters.pt" type="text" value=""></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
							
							<div class="portlet box blue">
								<div class="portlet-title">
									变量列表
								</div>
								<div class="portlet-body">
									<table class="table table-condensed" id="vartable">
										<thead>
											<tr>
												<th>变量ID</th>
												<th>变量名</th>
												<th>变量描述</th>
												<th>输入</th>
											</tr>
										</thead>
										<s:iterator var="vars" value="vars" status="L">
											<tr>
												<td><s:property value="variableId"/></td>
												<td><s:property value="variableName"/></td>
												<td><s:property value="variableDesc"/></td>
												<td><input name="varvalue" type="text" value=""></td>
											</tr>
										</s:iterator>
									</table>
								</div>
							</div>
								
							<div class="portlet box blue">
								<div class="portlet-title">
									运行确认
								</div>
								<div class="portlet-body">
									<h5>服务编号
										<input type="text" name="serviceid" id="serviceid" value=<s:property value="option1"/> Readonly>
									<br>
									服务运行
									<button type="button" class="btn" onclick="getNumber(); form2.action='runService.action'; form2.submit()">运行&raquo; </button>
									</h5>
									<input name="pts" type="hidden" value="" id="pts">
									<input name="vrs" type="hidden" value="" id="vrs">
									<input name="number" type="hidden" value="" id="number">
									<input name="sid" type="hidden" value=<s:property value="option1"/> id="sid">
									<input name="url" type="hidden" value="" id="url">
									<input name="isCombinedB" type="hidden" value=<s:property value="isCombinedB"/> id="url">
									<!--  value="<%=request.getParameter("option1")%>" -->
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
		
		function getNumber()
			{
				var number = document.getElementsByName("parameters.pt");
				var vv = document.getElementsByName("varvalue");
				//alert(number.length);
				document.getElementById("number").value = number.length;
				for(var i = 0; i < number.length; i++)
				{
					if(number[i].value != "")
					{
						document.getElementById("pts").value += number[i].value;
					}
					else
					{
						document.getElementById("pts").value += ";";
					}
					if(i != number.length - 1)
					{
						document.getElementById("pts").value += ",";
					}
				}
				for(var i = 0; i < vv.length; i++)
				{
					if(vv[i].value != "")
					{
						document.getElementById("vrs").value += vv[i].value;
					}
					else
					{
						document.getElementById("vrs").value += ";";
					}
					if(i != vrs.length - 1)
					{
						document.getElementById("vrs").value += ",";
					}
				}
				//alert(document.getElementById("vrs").value);
			}

	</script>

</body>

<!-- END BODY -->

</html>