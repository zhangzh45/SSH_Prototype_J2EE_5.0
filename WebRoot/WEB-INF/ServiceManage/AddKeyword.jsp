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

	<title>企业服务管理系统 | 添加关键字</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />


</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

			<div >
						<h3 class="page-title">

							添加关键字

							 <small>设置服务信息爬取的关键字</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<span class="icon-angle-right"></span>

							</li>

							<li>

								<a href="#">服务信息爬取</a>

								<span class="icon-angle-right"></span>

							</li>

							<li><a href="#">添加关键字</a></li>

						</ul>

					</div>

		

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>添加关键字</div>

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

										<label class="control-label">关键字名称</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="skeyword.keywordname"/>

											<span class="help-inline">name for keyword</span>

										</div>

									</div>


									<div class="control-group">

										<label class="control-label">关键字内容</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="skeyword.keyword" data-trigger="hover" data-content="请输入字符串." data-original-title="Popover header" />

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">关键字权值</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap tooltips" name="skeyword.keywordvalue" data-trigger="hover" data-original-title="请输入正整数" />                       

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">有效期限</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;Alabama&quot;,&quot;Alaska&quot;,&quot;Arizona&quot;,&quot;Arkansas&quot;,&quot;California&quot;,&quot;Colorado&quot;,&quot;Connecticut&quot;,&quot;Delaware&quot;,&quot;Florida&quot;,&quot;Georgia&quot;,&quot;Hawaii&quot;,&quot;Idaho&quot;,&quot;Illinois&quot;,&quot;Indiana&quot;,&quot;Iowa&quot;,&quot;Kansas&quot;,&quot;Kentucky&quot;,&quot;Louisiana&quot;,&quot;Maine&quot;,&quot;Maryland&quot;,&quot;Massachusetts&quot;,&quot;Michigan&quot;,&quot;Minnesota&quot;,&quot;Mississippi&quot;,&quot;Missouri&quot;,&quot;Montana&quot;,&quot;Nebraska&quot;,&quot;Nevada&quot;,&quot;New Hampshire&quot;,&quot;New Jersey&quot;,&quot;New Mexico&quot;,&quot;New York&quot;,&quot;North Dakota&quot;,&quot;North Carolina&quot;,&quot;Ohio&quot;,&quot;Oklahoma&quot;,&quot;Oregon&quot;,&quot;Pennsylvania&quot;,&quot;Rhode Island&quot;,&quot;South Carolina&quot;,&quot;South Dakota&quot;,&quot;Tennessee&quot;,&quot;Texas&quot;,&quot;Utah&quot;,&quot;Vermont&quot;,&quot;Virginia&quot;,&quot;Washington&quot;,&quot;West Virginia&quot;,&quot;Wisconsin&quot;,&quot;Wyoming&quot;]" />

											<p class="help-block">E.g: 11 days</p>

										</div>

									</div>

									

									

									

									<div class="control-group">

										<label class="control-label">关键字类型</label>

										<div class="controls">

											<select class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">

												<option value="">Select...</option>

												<option value="Category 1">Category 1</option>

												<option value="Category 2">Category 2</option>

												<option value="Category 3">Category 5</option>

												<option value="Category 4">Category 4</option>

											</select>

										</div>

									</div>

									

									<div class="control-group">

										<label class="control-label">权值计算方式</label>

										<div class="controls">

											<select class="span6 chosen" data-placeholder="Choose a Category" tabindex="1">

												<option value=""></option>

												<option value="Category 1">Category 1</option>

												<option value="Category 2">Category 2</option>

												<option value="Category 3">Category 5</option>

												<option value="Category 4">Category 4</option>

											</select>

										</div>

									</div>

									

									

									

									<div class="control-group">

										<label class="control-label">大小写敏感</label>

										<div class="controls">

											<label class="radio">

											<input type="radio" name="optionsRadios1" value="option1" />

											敏感

											</label>

											<label class="radio">

											<input type="radio" name="optionsRadios1" value="option2" checked />

											不敏感

											</label>  

										</div>

									</div>

									

									<div class="control-group">

										<label class="control-label">匹配方式</label>

										<div class="controls">

											<label class="checkbox">

											<input type="checkbox" value="" /> 完全匹配

											</label>

											<label class="checkbox">

											<input type="checkbox" value="" /> 正则表达式

											</label>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">关键字描述</label>

										<div class="controls">

											<textarea class="span6 m-wrap" rows="3" name="skeyword.keyworddesc" ></textarea>

										</div>

									</div>

									<div class="form-actions">

										<button type="button" class="btn blue" onclick="alert('添加成功！您还可以继续添加');form2.action='addKeyword.action'; form2.submit()" >Submit</button>

										<button type="button" class="btn">Cancel</button></div>

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


</body>

<!-- END BODY -->

</html>