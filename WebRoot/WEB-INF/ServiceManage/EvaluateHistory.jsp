<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceEvaluation.MyEvaluation"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceEvaluation.MyEvaluation"></s:text> <small><s:text name="ServiceEvaluation.MyEvaluation.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceManagement"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="ServiceEvaluation.MyEvaluation"></s:text></a></li>

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

								<div class="caption"><i class="icon-globe"></i><s:text name="ServiceEvaluation.MyEvaluation.List"></s:text></div>

								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										Columns

										<i class="icon-angle-down"></i>

										</a>
										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<label><input type="checkbox" checked data-column="0">Evaluation Id</label>
											<label><input type="checkbox" checked data-column="1">Evaluated Service</label>
											<label><input type="checkbox" checked data-column="2">Evaluation User</label>
											<label><input type="checkbox" checked data-column="3">My Evaluation</label>
											<label><input type="checkbox" checked data-column="4">Evaluation Number</label>
											<label><input type="checkbox" checked data-column="5">Average Evaluation</label>
										</div>
									</div>
								</div>
							</div>

							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
									<thead>
										<tr>
											<th>Evaluation Id</th>
											<th>Evaluated Service</th>
											<th>Evaluation User</th>
											<th>My Evaluation</th>
											<th>Evaluation Number</th>
											<th>Average Evaluation</th>
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
		
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "/error.jsp";
			}
			if(userid != "0"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
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