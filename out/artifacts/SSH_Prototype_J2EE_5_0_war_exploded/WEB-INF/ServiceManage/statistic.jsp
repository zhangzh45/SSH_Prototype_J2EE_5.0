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

							服务组合关系<small>显示组合服务与子服务之间的关系</small>

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
							<div class="btn-group">
									<button class="btn">按类型分类</button>
									<button class="btn dropdown-toggle" data-toggle="dropdown">
									  <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
									  <li><a tabindex="-1" onclick="form2.action='getAllService.action';form1.submit()">全部</a> </li>
									  <li><a tabindex="-1" onclick="form2.action='getWebService.action';form1.submit()">WebService</a> </li>
									  <li class="disabled"><a tabindex="-1" href="#">本地应用</a></li>
									  <li><a tabindex="-1" onclick="form2.action='getURL.action';form1.submit()">Web应用</a></li>
									</ul>
								</div>
								<div class="btn-group">
									<button class="btn">按业务分类</button>
									<button class="btn dropdown-toggle" data-toggle="dropdown">
									  <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
									  <li><a tabindex="-1" href="#">Regular link</a></li>
									  <li class="disabled"><a tabindex="-1" href="#">Disabled link</a></li>
									  <li><a tabindex="-1" href="#">Another link</a></li>
									</ul>
								</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>服务编号</th>
										<th>服务名称</th>
										<th>服务类型</th>
										<th>服务级别</th>
										<th>服务最大负荷</th>
										<th>服务审核状态</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="services">
									<tr>
										<td><s:property value="serviceId"/></td>
										<td><s:property value="serviceName"/></td>
										<td><s:property value="serviceType"/></td>
										<td><s:property value="serviceLevel"/></td>
										<td><s:property value="maxLoad"/></td>
										<td><s:property value="serviceState"/></td>
									</tr>
									</s:iterator>
								</tbody>
							</table>
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		
	

	   

	<script>

		jQuery(document).ready(function() {       
		   App.init();
		   TableAdvanced.init();
		   
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
		
		function getNumber()
			{
				var number = document.getElementsByName("parameters.pt");
				var vv = document.getElementsByName("varvalue");
				alert(number.length);
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
				alert(document.getElementById("vrs").value);
			}

	</script>

</body>

<!-- END BODY -->

</html>