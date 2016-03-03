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

							服务关系<small>显示组合服务与子服务之间的关系</small>

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

							<li><a href="#">服务关系</a></li>

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
							<div class="container-fluid">
			  <div class="navbar">
			  	<div class="navbar-inner">
			  		<!--  <a class="brand" href="#">Title</a> -->
			  		<ul class="nav">
			  			<li ><a href="chart.jsp">服务概况</a></li>
			  			<li><a onclick="form2.action='busyClass.action';form2.submit()">技术分类</a></li>
			  			<li  class="active"><a onclick="form2.action='workClass.action';form2.submit()">业务分类</a></li>
			  			<li><a href="#">其他</a></li>
			  		</ul>
			  	</div>
			  </div>
			  <div class="row-fluid">
			  	<div class="span3">	
					<div>
						<s:iterator value="conditions" status="L" var="conditions">
							<input name="ce" type="hidden" value="<s:property value="condtionExpression"/>">
							<input name="csub" type="hidden" value="<s:property value="subServiceId"/>">
							<input name="csid" type="hidden" value="<s:property value="serviceId"/>">
							<input name="cid" type="hidden" value="<s:property value="conditionId"/>">
						</s:iterator>
					</div> 
					<div class="dtree">
					<p><a href="javascript: d.openAll();">展开全部</a> | <a href="javascript: d.closeAll();">关闭全部</a></p>
					
					<script type="text/javascript">
						<!--
							
						d = new dTree('d');
						var fatherid = document.getElementsByName("csid");
						var sonid = document.getElementsByName("csub");
						var busyclass = 1;
						
						d.add(0,-1,'企业组合服务');
						d.add(1, 0,'BaseService');
						//alert(fatherid.length);
						for(var i = 1 + busyclass; i <= fatherid.length + busyclass; i++)
						{
							d.add(i, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value, 'example01.html');
						}
						d.add(fatherid.length + busyclass + 2, 0,'Financial');
						d.add(fatherid.length + busyclass + 3, 0,'Social');
						//d.add(fatherid.length + busyclass + 5, fatherid.length + busyclass + 2,'XXX');
						//d.add(fatherid.length + busyclass + 6, fatherid.length + busyclass + 3,'XXX');
						//d.add(fatherid.length + busyclass + 7, fatherid.length + busyclass + 4,'XXX');
						//d.add(fatherid.length + 1, 2, 'aa', 'example01.html');
						/*
						d.add(0,-1,'企业组合服务');
						d.add(1,0,'WebService','example01.html');
						d.add(2,0,'HTTP','example01.html');
						d.add(3,1,'可靠组合服务1','example01.html');
						d.add(4,0,'URL','example01.html');
						d.add(5,3,'服务2','example01.html');
						d.add(6,5,'服务3','example01.html');
						d.add(7,0,'Ajax','example01.html');
						d.add(8,1,'服务4','example01.html');
						d.add(9,0,'本地应用','example01.html','Pictures I\'ve taken over the years','','','img/imgfolder.gif');
						d.add(10,9,'服务5','example01.html','Pictures of Gullfoss and Geysir');
						d.add(11,9,'服务6','example01.html');
						d.add(12,0,'其他','example01.html','','','img/trash.gif');
						d.add(13,5,'服务7','example01.html');
						*/
						document.write(d);
					
						//-->
					</script>
					
					</div>
				</div>
				<div class="span9">
					<IFRAME name="topo" frameborder="0" width="100%" height="600" src="topodemo.jsp"></IFRAME>”
				</div>	
			  </div><!--/row-->
			 
			  
			</div><!--/.fluid-container-->
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		

	

	<script>

		jQuery(document).ready(function() {       
		   App.init();
		   TableAdvanced.init();
		});
		
		

	</script>

</body>

<!-- END BODY -->

</html>