<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 查看用户</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							用户管理 <small>查看并且管理用户</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">组织管理</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">查看用户</a></li>

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
	
									<div class="caption"><i class="icon-globe"></i>用户列表</div>
	
									<div class="actions">
	
										<div class="btn-group">
	
											<a class="btn" href="#" data-toggle="dropdown">
	
											Columns
	
											<i class="icon-angle-down"></i>
	
											</a>
	
											<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
												<label><input type="checkbox" checked data-column="0">用户ID</label>
												<label><input type="checkbox" checked data-column="1">姓名</label>
												<label><input type="checkbox" checked data-column="2">类型</label>
											</div>
										</div>
	
									</div>
	
								</div>
	
								<div class="portlet-body">
	
									<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
	
										<thead>
											<tr>
												<th>用户ID</th>
												<th>姓名</th>
												<th>类型</th>
								
				
											</tr>
										</thead>
										<tbody>
											<s:iterator value="users" status="L">
												<tr>
													<td><s:property value="userId"/> </td>
													<td><s:property value="userName"/></td>
													<td><s:property value="userType"/></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
						
							<div class="portlet box blue">
								<div class="portlet-title">
									用户管理
								</div>
								<div class="portlet-body">
									<div class="container-fluid">
									  <div class="row-fluid">
										
										<div class="span9">
											<br>选择角色ID
											<select class="form-control" name="opt1" id="opt1">
												<s:iterator value="users" status="L2">
													<option><s:property value="userId"/></option>
												</s:iterator>
											</select>
											<br>
											<br>删除角色
											<button type="button" class="btn" onclick="changeValue(); form2.action='deleteUser.action'; form2.submit();">删除&raquo; </button>
											<input name="option1" type="hidden" value="" id="option1">
											<input name="option2" type="hidden" value="" id="option2">	
										</div><!--/span-->
									  </div><!--/row-->
									</div><!--/.fluid-container-->
								</div>
							</div>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

			

	     

	<script>
		jQuery(document).ready(function() {       
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "http://localhost:8080/SSH_Prototype_J2EE_5.0/error.jsp";
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
		}
	</script>

</body>

<!-- END BODY -->

</html>