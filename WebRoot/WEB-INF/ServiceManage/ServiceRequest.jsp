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

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceRegistration"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	


		
				<div >

					<div >

					

						<h3 class="page-title">

							<s:text name="ServiceRegistration"></s:text>

							 <small><s:text name="ServiceRegistration.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<span class="icon-angle-right"></span>

							</li>

							<li>

								<a href="#"><s:text name="ServiceManagement"></s:text></a>

								<span class="icon-angle-right"></span>

							</li>

							<li><a href="#"><s:text name="ServiceRegistration"></s:text></a></li>

						</ul>

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i><s:text name="ServiceRegistration.Info"></s:text></div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form name="form2" class="form-horizontal" action="register.action" method="post" enctype="multipart/form-data">

									<div class="control-group">
								    <label class="control-label" for="inputServiceName"><s:text name="ServiceName"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceName" name="sr.serviceName" placeholder="ServiceName">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceType"><s:text name="ServiceType"></s:text></label>
								    <div class="controls">
								      <select id="servicetype"  onchange="changeServicetype()">
										  <option>SERVICE</option>
										  <option>APPLICATION</option>
										  <option>BUSINESS</option>
										  <option>LOCAL</option>
								      </select>
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceTarget"><s:text name="ServiceTarget"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceTarget" name="sr.serviceTarget" placeholder="ServiceTarget">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceDesc"><s:text name="ServiceDesc"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceDesc" name="sr.serviceDesc" placeholder="ServiceDesc">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceRange"><s:text name="ServiceRange"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceRange" name="sr.serviceRange" placeholder="ServiceRange">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceAddress"><s:text name="ServiceAddress"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceAddress" name="sr.serviceAddress" placeholder="ServiceAddress">
								    </div>
								  </div>
								  <div id='ServiceQuery' class="control-group">
								    <label class="control-label" for="inputServiceQuery"><s:text name="ServiceQuery"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceQuery" name="sr.serviceQuery" placeholder="ServiceQuery">
								    </div>
								  </div>
								  <div id='AppRoleURL' style="display:none" class="control-group">
								    <label class="control-label" for="inputServiceQuery"><s:text name="ServiceAppRoleURL"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputAppRoleURL" name="sr.appRoleUrl" placeholder="AppRoleURL">
								    </div>
								  </div>
								  <div class="control-group">
								    <label class="control-label" for="inputServiceMaxLoad"><s:text name="ServiceMaxLoad"></s:text></label>
								    <div class="controls">
								      <input type="text" id="inputServiceMaxLoad" name="maxLoad" placeholder="ServiceMaxLoad">
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
								      <input type="text" id="inputRelateBusiness" name="sr.relateBusiness" placeholder="RelateBusiness">
								    </div>
								  </div>
								  
								  <div class="control-group">
								    <label class="control-label" for="inputCallService"><s:text name="ServiceCalledServices"></s:text></label>
								    <div class="controls">
								    <table class="" style="" id="CallServiceTable">
									    <tr>
											<td>
												<select name="callservices">  <!-- 审核通过的服务 -->
												      <s:iterator value="calledservices" status="L" var="calledservices">
														<option><s:property value="serviceId"/></option>
													  </s:iterator>
												  </select>
												  <button type="button" onclick="addCallService();">+</button>
												  <button type="button" onclick="deleteCallService();">-</button>
											</td>
										</tr>
									</table>
									</div>
								  </div>
								  
								  <div id="Businessfile" style="display:none" class="control-group">
								    <label class="control-label" for="inputBusinessfile"><s:text name="UploadSpecificationFile"></s:text></label>
								    <div class="controls">
										<input name="myFile" type="FILE" id="myFile" size="500" >
									</div>
								  </div>
								  
								  <div class="control-group">
								    <label class="control-label" for="inputServiceWay"><s:text name="ServiceProvidingMode"></s:text></label>
								    <div class="controls">
								      <label class="radio">
										<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
										     <s:text name="ServiceLocalMode"></s:text>
								  	  </label>
									  <label class="radio">
										<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
										   <s:text name="ServiceRemoteMode"></s:text>
									  </label>
								    </div>
								  </div>
								  
								  <div class="control-group">
								    <div class="controls">
								      <label class="checkbox">
								        <input type="checkbox"><s:text name="ServiceAnonymous"></s:text>
								      </label>
								    </div>
								  </div>
								<div class="control-group" id="upload" style="display:none">
								    <div class="controls">
										<s:text name="ServiceAppendix"></s:text><input name="uploadFile" type="FILE" id="uploadFile" size="500" >
									</div>
								</div>
								  
								  <div class="control-group">
								    <div class="controls">
								      <input id="inputServiceType" name="sr.serviceType" type="hidden" value="">
								    </div>
								  </div>
								  <div class="control-group">
								    <div class="controls">
								      <input id="inputServiceLevel" name="sr.serviceLevel" type="hidden" value="">
								    </div>
								  </div>
								  <div class="control-group">
								    <div class="controls">
								      <input id="inputCallService" name="sr.callService" type="hidden" value="">
								    </div>
								  </div>

									<div class="form-actions">             

										<button type="button" class="btn blue" onclick="changevalue()" ><s:text name="Submit"></s:text></button>

										<button type="button" class="btn"><s:text name="Cancel"></s:text></button></div>

								</form>

								<!-- END FORM-->       

							</div>

						</div>


                        <div class="portlet-body" style="display:none">
							<s:iterator value="services" status="L">
								<input name="servicenames" type="hidden" value=<s:property value="serviceName"/>>
							</s:iterator>
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

	
	<script src="media/js/form-components.js"></script>     

	<!-- END PAGE LEVEL SCRIPTS -->

	<script>

		jQuery(document).ready(function() {     
		   checkuser(); 
		  // App.init();
		  // FormComponents.init();
		  // alert("ss");
		   
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "http://localhost:8080/SSH_Prototype_J2EE_5.0/error.jsp";
			}
			if(admin != "true"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
		function changeServicetype(){
			var servicetypeobj = document.getElementById("servicetype");
			var servicetypeindex = servicetypeobj.selectedIndex;
			var servicetypevalue = servicetypeobj.options[servicetypeindex].value;
			if(servicetypevalue == "APPLICATION"){
				document.getElementById("Businessfile").style="display:none";
				document.getElementById("AppRoleURL").style="display:block";
				document.getElementById("ServiceQuery").style="display:none";
				document.getElementById("upload").style="display:none";
			}else if(servicetypevalue == "SERVICE"){
				document.getElementById("Businessfile").style="display:none";
				document.getElementById("AppRoleURL").style="display:none";
				document.getElementById("ServiceQuery").style="display:block";
				document.getElementById("upload").style="display:none";
			}else if(servicetypevalue == "BUSINESS"){
				document.getElementById("Businessfile").style="display:block";
				document.getElementById("AppRoleURL").style="display:none";
				document.getElementById("ServiceQuery").style="display:none";
				document.getElementById("upload").style="display:none";
			}else if(servicetypevalue == "LOCAL"){
				document.getElementById("Businessfile").style="display:none";
				document.getElementById("AppRoleURL").style="display:none";
				document.getElementById("ServiceQuery").style="display:none";
				document.getElementById("upload").style="display:block";
			}
		}
		
		function addCallService()
		{
			var table=document.getElementById("CallServiceTable");
			var row = table.insertRow(-1);
			var cc = row.insertCell(0);
			cc.innerHTML='<select name="callservices"><s:iterator value="services" status="L" var="services"><option><s:property value="serviceId"/></option></s:iterator></select>';
		}
		function deleteCallService()
		{
			var table=document.getElementById("CallServiceTable");
			table.deleteRow(table.rows.length-1);
		}
		
		
		
		function changevalue(){
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
		    
		    var servicetypeobj = document.getElementById("servicetype");
			var servicetypeindex = servicetypeobj.selectedIndex;
			var servicetypevalue = servicetypeobj.options[servicetypeindex].value;
			if(servicetypevalue == "BUSINESS"){
				var inputfile = document.getElementById("myFile").value;
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
			}
		    
			
			var servicetypeobj = document.getElementById("servicetype");
			var servicetypeindex = servicetypeobj.selectedIndex;
			var servicetypevalue = servicetypeobj.options[servicetypeindex].value;
			document.getElementById("inputServiceType").value = servicetypevalue;
			
			var servicelevelobj = document.getElementById("servicelevel");
			var servicelevelindex = servicelevelobj.selectedIndex;
			var servicelevelvalue = servicelevelobj.options[servicelevelindex].value;
			document.getElementById("inputServiceLevel").value = servicelevelvalue;
			
			
			var callservicesobj = document.getElementsByName("callservices");
			var callstring = "";
			for(var i = 0; i < callservicesobj.length; i++){
				var callservice = callservicesobj[i];
				var callserviceindex = callservice.selectedIndex;
				var callservicevalue = callservice.options[callserviceindex].value;
				if(callstring.indexOf(callservicevalue) >= 0 )  //程序健壮性，处理添加相同调用服务的情况
				{
				    //alert('重复调用相同服务');
				}
				else{
					if(i != callservicesobj.length - 1){
						callstring += callservicevalue + ",";
					}else{
						callstring += callservicevalue;
					}
				}
			}
			document.getElementById("inputCallService").value = callstring;
			form2.action='register.action'; 
			form2.submit();
		}

	</script>

	<!-- END JAVASCRIPTS -->   

</body>

<!-- END BODY -->

</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                