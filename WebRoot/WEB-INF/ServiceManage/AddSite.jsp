<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="AddCrawlingSite"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<h3 class="page-title">
							<s:text name="AddCrawlingSite"></s:text>
							 <small><s:text name="AddCrawlingSite.Description"></s:text></small>
						</h3>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="index.html">Home</a> 
								<span class="icon-angle-right"></span>
							</li>
							<li>
								<a href="#"><s:text name="ServiceInfoCrawling"></s:text></a>
								<span class="icon-angle-right"></span>
							</li>
							<li><a href="#"><s:text name="AddCrawlingSite"></s:text></a></li>
						</ul>

					

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->   
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-reorder"></i><s:text name="AddCrawlingSite"></s:text></div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="javascript:;" class="reload"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>

							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form action="#" class="form-horizontal" id="form2">
									<div class="control-group">
										<label class="control-label"><s:text name="SiteName"></s:text></label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="skeyword.keywordname"/>
											<span class="help-inline">name of site</span>
										</div>
									</div>

									

									<div class="control-group">
										<label class="control-label"><s:text name="SiteAddress"></s:text></label>
										<div class="controls">
											<input type="text" class="span6 m-wrap popovers" name="searchsite.address" data-trigger="hover" data-content="请输入字符串." data-original-title="Popover header" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label"><s:text name="SitePageControl"></s:text></label>
										<div class="controls">
											<input type="text" class="span6 m-wrap tooltips" name="searchsite.pagecontrol" data-trigger="hover" data-original-title="请输入正整数" />                       
										</div>
									</div>

									<div class="control-group">
										<label class="control-label"><s:text name="SiteSupplier"></s:text></label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="searchsite.supplier" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;Alabama&quot;,&quot;Alaska&quot;,&quot;Arizona&quot;,&quot;Arkansas&quot;,&quot;California&quot;,&quot;Colorado&quot;,&quot;Connecticut&quot;,&quot;Delaware&quot;,&quot;Florida&quot;,&quot;Georgia&quot;,&quot;Hawaii&quot;,&quot;Idaho&quot;,&quot;Illinois&quot;,&quot;Indiana&quot;,&quot;Iowa&quot;,&quot;Kansas&quot;,&quot;Kentucky&quot;,&quot;Louisiana&quot;,&quot;Maine&quot;,&quot;Maryland&quot;,&quot;Massachusetts&quot;,&quot;Michigan&quot;,&quot;Minnesota&quot;,&quot;Mississippi&quot;,&quot;Missouri&quot;,&quot;Montana&quot;,&quot;Nebraska&quot;,&quot;Nevada&quot;,&quot;New Hampshire&quot;,&quot;New Jersey&quot;,&quot;New Mexico&quot;,&quot;New York&quot;,&quot;North Dakota&quot;,&quot;North Carolina&quot;,&quot;Ohio&quot;,&quot;Oklahoma&quot;,&quot;Oregon&quot;,&quot;Pennsylvania&quot;,&quot;Rhode Island&quot;,&quot;South Carolina&quot;,&quot;South Dakota&quot;,&quot;Tennessee&quot;,&quot;Texas&quot;,&quot;Utah&quot;,&quot;Vermont&quot;,&quot;Virginia&quot;,&quot;Washington&quot;,&quot;West Virginia&quot;,&quot;Wisconsin&quot;,&quot;Wyoming&quot;]" />
											<p class="help-block"></p>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label"><s:text name="SiteSupplierArea"></s:text></label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="searchsite.area" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;Alabama&quot;,&quot;Alaska&quot;,&quot;Arizona&quot;,&quot;Arkansas&quot;,&quot;California&quot;,&quot;Colorado&quot;,&quot;Connecticut&quot;,&quot;Delaware&quot;,&quot;Florida&quot;,&quot;Georgia&quot;,&quot;Hawaii&quot;,&quot;Idaho&quot;,&quot;Illinois&quot;,&quot;Indiana&quot;,&quot;Iowa&quot;,&quot;Kansas&quot;,&quot;Kentucky&quot;,&quot;Louisiana&quot;,&quot;Maine&quot;,&quot;Maryland&quot;,&quot;Massachusetts&quot;,&quot;Michigan&quot;,&quot;Minnesota&quot;,&quot;Mississippi&quot;,&quot;Missouri&quot;,&quot;Montana&quot;,&quot;Nebraska&quot;,&quot;Nevada&quot;,&quot;New Hampshire&quot;,&quot;New Jersey&quot;,&quot;New Mexico&quot;,&quot;New York&quot;,&quot;North Dakota&quot;,&quot;North Carolina&quot;,&quot;Ohio&quot;,&quot;Oklahoma&quot;,&quot;Oregon&quot;,&quot;Pennsylvania&quot;,&quot;Rhode Island&quot;,&quot;South Carolina&quot;,&quot;South Dakota&quot;,&quot;Tennessee&quot;,&quot;Texas&quot;,&quot;Utah&quot;,&quot;Vermont&quot;,&quot;Virginia&quot;,&quot;Washington&quot;,&quot;West Virginia&quot;,&quot;Wisconsin&quot;,&quot;Wyoming&quot;]" />
											<p class="help-block"></p>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label"><s:text name="SiteType"></s:text></label>
										<div class="controls">
											<select class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">
												<option value="">Select...</option>
												<option value="Category 1">Category 1</option>
												<option value="Category 2">Category 2</option>
											</select>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label"><s:text name="SiteCrawlingMode"></s:text></label>
										<div class="controls">
											<select class="span6 chosen" data-placeholder="Choose a Category" tabindex="1">
												<option value=""></option>
												<option value="Category 1">Category 1</option>
												<option value="Category 2">Category 2</option>
											</select>
										</div>
									</div>


									<div class="control-group">
										<label class="control-label"><s:text name="SitePriorityStrategy"></s:text></label>
										<div class="controls">
											<label class="radio">
											<input type="radio" name="optionsRadios1" value="option1" />
											<s:text name="SiteDepthFirst"></s:text>
											</label>
											<label class="radio">
											<input type="radio" name="optionsRadios1" value="option2" checked />
											<s:text name="SiteBreadthFirst"></s:text>
											</label>  
										</div>
									</div>

									<div class="control-group">
										<label class="control-label"><s:text name="SiteLanguageAnalysis"></s:text></label>
										<div class="controls">
											<label class="checkbox">
											<input type="checkbox" value="" /> <s:text name="SiteChinese"></s:text>
											</label>
											<label class="checkbox">
											<input type="checkbox" value="" /> <s:text name="SiteEnglish"></s:text>
											</label>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label"><s:text name="SiteDesc"></s:text></label>
										<div class="controls">
											<textarea class="span6 m-wrap" rows="3" name="searchsite.keyworddesc" ></textarea>
										</div>
									</div>

									<div class="form-actions">
										<button type="button" class="btn blue" onclick="alert('添加成功！您还可以继续添加');form2.action='addSite.action'; form2.submit()" ><s:text name="Submit"></s:text></button>
										<button type="button" class="btn"><s:text name="Cancel"></s:text></button></div>
								</form>
								<!-- END FORM-->       
							</div>
						</div>

						<!-- END SAMPLE FORM PORTLET-->

					</div>

				</div><div class="row-fluid">

					<div class="span12"></div>

				</div><div class="row-fluid">

					<div class="span12">

						<!-- BEGIN PORTLET--><br><!-- END PORTLET-->

					</div>

				</div>

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXTRAS PORTLET--><br><!-- END EXTRAS PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->         

			

	

</body>

<!-- END BODY -->

</html>



<script>
	jQuery(document).ready(function() {       
alert("ss");
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			alert(userid);
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
</script>