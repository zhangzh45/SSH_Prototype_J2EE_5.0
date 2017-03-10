<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceOperation"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

	<link rel="stylesheet" href="media/css/DT_bootstrap.css" />

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />
	
	<script type="text/javascript" src="media/js/form-components.js"></script>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceOperation.Result"></s:text> <small><s:text name="ServiceOperation.Result.Description"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceOperation.Result"></s:text></a></li>

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
									<s:text name="ServiceOperation.Result"></s:text>URL
								</div>
								<div class="portlet-body">
									<iframe src="" name="iframe" id="IF" width="100%" height="300" id="ifrid"></iframe>
								</div>
							</div>
							
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ServiceOperation.Result.LanguageDescription"></s:text>
								</div>
								<div class="portlet-body">
									<table class="table table-bordered">
										<thead>
											
										</thead>
										<tbody>
											<s:iterator var="parameters" value="ss" status="L">
												<tr>
													<td><s:property /></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
									<input name="url" type="hidden" value=<s:property value="url"/> id="url">
								</div>
							</div>
								
							<!-- <div class="portlet box blue">
								<div class="portlet-title">
									运行确认
								</div>
								<div class="portlet-body">
								</div>
							</div> -->
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
				window.location = "http://localhost:8080/SSH_Prototype_J2EE_5.0/error.jsp";
			}
			if(userid != "0"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
		$(window).load(function() {
            showURL();
        });
		
		function showURL()
		{
			//alert("nimei");
			//alert(document.getElementById("url").value);
			document.getElementById("IF").src= document.getElementById("url").value;
			//alert(document.getElementById("url").value);
		}
	</script>

</body>

<!-- END BODY -->

</html>