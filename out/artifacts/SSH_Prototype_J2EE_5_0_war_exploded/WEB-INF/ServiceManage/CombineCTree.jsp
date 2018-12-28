<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ProcessCombination"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />
	
	<script src="js/dtree.js"></script>
	
	<script src="media/js/form-components.js"></script>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ProcessCombination"></s:text> <small><s:text name="ProcessCombination.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>
								<a ><s:text name="ServiceComposition"></s:text></a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a ><s:text name="ProcessCombination"></s:text></a></li>
						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

				<div class="portlet-body" style="display:none">
					<s:iterator value="allsers" status="L">
						<input name="servicenames" type="hidden" value=<s:property value="serviceName"/>>
					</s:iterator>
				</div>
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
							  			<li><a onclick="form2.action='combineAService.action'; form2.submit();"><s:text name="ReliabilityCombination"></s:text></a></li>
							  			<li><a onclick="form2.action='combineBService.action'; form2.submit();"><s:text name="ApplicabilityCombination"></s:text></a></li>
							  			<li class="active"><a onclick="form2.action='combineCService.action'; form2.submit();"><s:text name="ProcessCombination"></s:text></a></li>
							  			<li><a ><s:text name="Other"></s:text></a></li>
							  		</ul>
							  	</div>
							  </div>
			</div><!--/.fluid-container-->
						</form>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>
				
				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<form name="form3" class="form-horizontal" action="addCombineC.action" method="post" enctype="multipart/form-data">

							<div>
								<div class="portlet-body">
									<div class="container-fluid">
										<div class="control-group">
										    <label class="control-label" for="inputServiceName"><s:text name="ServiceName"></s:text></label>
										    <div class="controls">
										      <input type="text" id="inputServiceName" name="inname" placeholder="ServiceName">
										    </div>
										</div>
									  <div class="control-group">
									    <label class="control-label" for="inputServiceTarget"><s:text name="ServiceTarget"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputServiceTarget" name="intt" placeholder="ServiceTarget">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputServiceRange"><s:text name="ServiceRange"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputServiceRange" name="inrange" placeholder="ServiceRange">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputServiceLevel"><s:text name="ServiceLevel"></s:text></label>
									    <div class="controls">
									      <select id="servicelevel">
											  <option>1</option>
											  <option>2</option>
											  <option>3</option>
											  <option>4</option>
											  <option>5</option>
									      </select>
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputRelateBusiness"><s:text name="ServiceRelateBusiness"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputRelateBusiness" name="inbusiness" placeholder="RelateBusiness">
									    </div>
									  </div>
									  <div class="control-group">
									    <label class="control-label" for="inputServiceDesc"><s:text name="ServiceDesc"></s:text></label>
									    <div class="controls">
									      <input type="text" id="inputServiceDesc" name="indesc" placeholder="ServiceDesc">
									    </div>
									  </div>
									
									
									
										<div id="Businessfile" class="control-group">
										    <label class="control-label" for="inputSpecificationFile"><s:text name="UploadSpecificationFile"></s:text></label>
										    <div class="controls">
												<input name="specificationFile" type="FILE" id="inputSpecificationFile" >
											</div>
										</div>


									  	<div class="control-group">
										    <label class="control-label" for="inputServiceQoSOptimizationTarget"><s:text name="ServiceQoSOptimizationTarget"></s:text></label>
										    <div class="controls">
										      <select id="ServiceQoSOptimizationTarget">
												  <option>ServiceReliability</option>
												  <option>ServiceAvailability</option>
												  <option>ServiceTime</option>
												  <option>ServiceCost</option>
												  <option>ServiceLoadDegree</option>
												  <option>UserAvgEvaluation</option>
										      </select>
										    </div>
										</div>
										
										<div class="control-group">
										    <div class="controls">
										      <input id="inputServiceLevel" name="inlevel" type="hidden" value="">
										    </div>
										</div>
										
										
										<div class="control-group">
										    <div class="controls">
										      <input id="inputServiceQoSOptimizationTarget" name="serviceQoSOptimizationTarget" type="hidden" value="">
										    </div>
										</div>
										
										<div class="portlet-body" style="display:none">
											<s:iterator value="services" status="L">
												<input name="servicenames" type="hidden" value=<s:property value="serviceName"/>>
											</s:iterator>
										</div>
										
									  	<div class="form-actions">
									  		<button class="btn btn-primary" type="submit" onclick="submit()">提交</button>
											<button class="btn" type="button">清空</button>
									  	</div>
									</div>
								</div>
							</div>
						</form>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>
		

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	

	 

	<script>
		jQuery(document).ready(function() {       
		  
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
		
		function submit(){
			var inputServiceName = document.getElementById("inputServiceName").value;
			if(inputServiceName=="" || inputServiceName==null)
		    {
		        alert("服务名称不能为空");
		        return;
		    }
		    else{
		    	var servicenames = document.getElementsByName("servicenames");
		    	for(var i = 0; i < servicenames.length; i++){
		    		if(inputServiceName == servicenames[i].value){
		    			alert("服务名称已存在");
		        		return;
		    		}
		    	}
		    }
		
		
			var inputfile = document.getElementById("inputSpecificationFile").value;
			if(inputfile == "" || inputfile == null)
			{
				alert("请上传流程文件");
				return;
			}
			else{
				var point = inputfile.lastIndexOf(".");
				var type = inputfile.substr(point).toLowerCase();
				if (type != ".xml" && type != ".yawl") {
					alert("只支持上传xml和yawl格式的流程文件");
					return;
				}
			}
			
			var servicelevelobj = document.getElementById("servicelevel");
			var servicelevelindex = servicelevelobj.selectedIndex;
			var servicelevelvalue = servicelevelobj.options[servicelevelindex].value;
			document.getElementById("inputServiceLevel").value = servicelevelvalue;
			
			var serviceqosobj = document.getElementById("ServiceQoSOptimizationTarget");
			var serviceqosindex = serviceqosobj.selectedIndex;
			var serviceqosvalue = serviceqosobj.options[serviceqosindex].value;
			document.getElementById("inputServiceQoSOptimizationTarget").value = serviceqosvalue;
			
			form3.action='addCombineC.action';
			form3.submit();
		}
		
	</script>

</body>

<!-- END BODY -->

</html>