<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String user = request.getParameter("uname");
request.getSession().setAttribute("username", user);     //用Session保存用户名
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />
	<title><s:text name="SystemName"></s:text> | <s:text name="ViewKeyword"></s:text></title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<script src="media/js/table-managed.js"></script> 

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">
							<s:text name="ViewKeyword"></s:text><small><s:text name="ViewKeyword.Description"></s:text></small>
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
							<li><a href="#"><s:text name="ViewKeyword"></s:text></a></li>
						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<form name="form2" action="" method="post">
					
						<div class="portlet box light-grey">
							<div class="portlet-title">
								<div class="caption"><i class="icon-globe"></i><s:text name="ViewKeyword.KeywordInfo"></s:text></div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="javascript:;" class="reload"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<div class="btn-group">

										<button id="sample_editable_1_new" class="btn green">

										Add New <i class="icon-plus"></i>

										</button>

									</div>

									<div class="btn-group pull-right">

										<button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>

										</button>

										<ul class="dropdown-menu pull-right">

											<li><a href="#">Print</a></li>

											<li><a href="#">Save as PDF</a></li>

											<li><a href="#">Export to Excel</a></li>

										</ul>

									</div>

								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">
									<thead>
										<tr>
											<th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
											<th>Name</th>
											<th class="hidden-480">Detail</th>
											<th class="hidden-480">Value</th>
											<th class="hidden-480">Desc</th>
											<th ></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="keywords" status="L">
										<tr class="odd gradeX">
											<td><input type="checkbox" class="checkboxes" value="1" /></td>
											<td><s:property value="keywordname"/></td>
											<td class="hidden-480"><s:property value="keyword"/></td>
											<td class="hidden-480"><s:property value="keywordvalue"/></td>
											<td class="center hidden-480"><s:property value="keyworddesc"/></td>
											<td ><span class="label label-success">Approved</span></td>
										</tr>
										</s:iterator>
									</tbody>

								</table>

							</div>

						</div>
						
						<div name="byadmin" class="portlet box light-grey">
								<div class="portlet-title">
									<s:text name="ViewKeyword.Management"></s:text>
								</div>
								<div class="portlet-body">
									<div class="container-fluid">
									  <div class="row-fluid">
										
										<div class="span9">
											<br><s:text name="ViewKeyword.KeywordId"></s:text>
											<select class="form-control" name="opt1" id="opt1">
												<s:iterator value="keywords" status="L2">
													<option><s:property value="searchkeywordid"/></option>
												</s:iterator>
											</select>
											<br>
											<br><s:text name="ViewKeyword.Delete"></s:text>
											<button type="button" class="btn" onclick="changeValue(); form2.action='deleteKeyword.action'; form2.submit();"><s:text name="Delete"></s:text>&raquo; </button>
											<input name="option1" type="hidden" value="" id="option1">
											<input name="option2" type="hidden" value="" id="option2">	
										</div><!--/span-->
									  </div><!--/row-->
									</div><!--/.fluid-container-->
								</div>
							</div>
						<!-- END EXAMPLE TABLE PORTLET-->
						</form>
					</div>

				</div><!-- END PAGE CONTAINER-->

	

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