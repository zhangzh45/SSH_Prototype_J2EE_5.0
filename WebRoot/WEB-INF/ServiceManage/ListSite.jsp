<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String user = request.getParameter("uname");
request.getSession().setAttribute("username", user);     //用Session保存用户名
%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ViewCrawlingSite"></s:text></title>

	<meta content="width=device-width, height=device-height, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ViewCrawlingSite"></s:text> <small><s:text name="ViewCrawlingSite.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceInfoCrawling"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="ViewCrawlingSite"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->          

				<div class="row-fluid">

					<div class="span12">

						<div class="alert alert-success">

							<button class="close" data-dismiss="alert"></button>

							Please try to re-size your browser window in order to see the tables in responsive mode.<br>

							<span class="label label-important">NOTE:</span>&nbsp;This feature is supported by Internet Explorer 10, Latest Firefox, Chrome, Opera and Safari

						</div>

						<!-- BEGIN SAMPLE TABLE PORTLET-->
					<form name="form2" action="" method="post">
					
						<div class="portlet box green">

							<div class="portlet-title">

								<div class="caption"><i class="icon-cogs"></i><s:text name="SiteInfo"></s:text></div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body flip-scroll">

								<table class="table-bordered table-striped table-condensed flip-content">
									<thead class="flip-content">
										<tr>
											<th>Site Id</th>
											<th>Site Address</th>
											<th>Page Control</th>
											<th>Site Supplier</th>
											<th>Supplier Area</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="searchsites" status="L">
										<tr>
											<td><s:property value="siteid"/></td>
											<td><s:property value="address"/></td>
											<td><s:property value="pagecontrol"/></td>
											<td><s:property value="supplier"/></td>
											<td><s:property value="area"/></td>
										</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						
						
						<div name="byadmin" class="portlet box green">
								<div class="portlet-title">
									<s:text name="ViewCrawlingSite.Management"></s:text>
								</div>
								<div class="portlet-body">
									<div class="container-fluid">
									  <div class="row-fluid">
										
										<div class="span9">
											<br><s:text name="ViewCrawlingSite.SiteId"></s:text>
											<select class="form-control" name="opt1" id="opt1">
												<s:iterator value="searchsites" status="L2">
													<option><s:property value="siteid"/></option>
												</s:iterator>
											</select>
											<br>
											<br><s:text name="ViewCrawlingSite.Delete"></s:text>
											<button type="button" class="btn" onclick="changeValue(); form2.action='deleteSite.action'; form2.submit();"><s:text name="Delete"></s:text>&raquo; </button>
											<input name="option1" type="hidden" value="" id="option1">
											<input name="option2" type="hidden" value="" id="option2">	
										</div><!--/span-->
									  </div><!--/row-->
									</div><!--/.fluid-container-->
								</div>
							</div>
						</form>
						<!-- END SAMPLE TABLE PORTLET-->
						<!-- BEGIN SAMPLE TABLE PORTLET-->
						<!-- END SAMPLE TABLE PORTLET-->
					</div>
				</div>

				<!-- END PAGE CONTENT-->

			
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->



 

	<script>

		jQuery(document).ready(function() {       
		   //App.init();
		   
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "http://localhost:8020/SSH_Prototype_J2EE_5.0/error.jsp";
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