<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ReliabilityCombination"></s:text></title>

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

							<s:text name="ReliabilityCombination"></s:text> <small><s:text name="ReliabilityCombination.Description"></s:text></small>

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
							<li><a ><s:text name="ReliabilityCombination"></s:text></a></li>
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
							  			<li class="active"><a onclick="form2.action='combineAService.action'; form2.submit();"><s:text name="ReliabilityCombination"></s:text></a></li>
							  			<li><a onclick="form2.action='combineBService.action'; form2.submit();"><s:text name="ApplicabilityCombination"></s:text></a></li>
							  			<li><a onclick="form2.action='combineCService.action'; form2.submit();"><s:text name="ProcessCombination"></s:text></a></li>
							  			<li><a ><s:text name="Other"></s:text></a></li>
							  		</ul>
							  	</div>
							  </div>
							  <div class="row-fluid">
							  	<div class="span3">	
									<div>
										<s:iterator value="dtnodes" status="L" var="dtnodes">
											<input name="nself" type="hidden" value="<s:property value="self"/>">
											<input name="nfather" type="hidden" value="<s:property value="father"/>">
											<input name="ncontent" type="hidden" value="<s:property value="content"/>">
										</s:iterator>
									</div> 
									<div class="dtree">
									<p><a href="javascript: d.openAll();"><s:text name="OpenAll"></s:text></a> | <a href="javascript: d.closeAll();"><s:text name="CloseAll"></s:text></a></p>
					
									<script type="text/javascript">
										<!--
											
										d = new dTree('d');
										var nfather = document.getElementsByName("nfather");
										var ncontent= document.getElementsByName("ncontent");
										
										d.add(0,-1,'Combination Service');
										//alert(nfather.length);
										for(var i = 0; i < nfather.length; i++)
										{
											d.add(i + 1, nfather.item(i).value, ncontent.item(i).value, 'example01.html');
										}
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
									<script>
										function smt()
										{
											
											var inputServiceName = document.getElementById("inname").value;
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
											document.getElementById("intype").value = servicetypevalue;
											
											var servicelevelobj = document.getElementById("servicelevel");
											var servicelevelindex = servicelevelobj.selectedIndex;
											var servicelevelvalue = servicelevelobj.options[servicelevelindex].value;
											document.getElementById("inlevel").value = servicelevelvalue;
											
											
											var srs = document.getElementsByName("sr1");
											var pts = "s";
											for(var i = 0; i < srs.length; i++)
											{
												if(pts.indexOf(srs.item(i).value) >= 0 )  //程序健壮性
												{
												    //alert('重复添加相同的子服务');
												}
												else{
													pts += srs.item(i).value;
													pts += "s";
												}
											}
											//alert(pts);
											document.getElementById("inpts").value = pts;
											form2.action='addCombineA.action';
											form2.submit();
										}
										function addSub()
										{
											var table=document.getElementById("table3");
											var row = table.insertRow(-1);
											var cc = row.insertCell(0);
											cc.innerHTML='<s:text name="ServiceComposition.Subservice"></s:text><input name="sr1" type="text" value="" readOnly="true">';
											var vars = document.getElementsByName("sr1");
											//vars.item(vars.length - 1).value = document.getElementById("userviceid").value;
											vars.item(vars.length - 1).value = $('#userviceid').find("option:selected").text();
											document.getElementById("smt").style.display="";
											
										}
										function newService()
										{
											document.getElementById("bt1").style.display="";
											document.getElementById("table2").style.display="";
											document.getElementById("table3").style.display="";
											
											var table=document.getElementById("table3");
											
											for(var i = 0; i < table.rows.length; i++)
											{
												table.deleteRow(table.rows.length - 1);
											}
											
											var table=document.getElementById("table2");
											
											for(var i = 0; i < table.rows.length - 4; i++)
											{
												table.deleteRow(table.rows.length-1);
											}
											
											
											var psids = document.getElementsByName("psid");
											var ppnames = document.getElementsByName("ppname");
											var ct = 0;
											//alert(psids.length);
											for(var i = 0; i < psids.length; i++)
											{
												//alert(i);
												//alert(psids.item(i).value);
												//if(psids.item(i).value == document.getElementById("userviceid").value)
												if(psids.item(i).value == $('#userviceid').find("option:selected").text())
												{
													//alert("nimei");
													var row = table.insertRow(-1);
													var cc = row.insertCell(0);
													cc.innerHTML='<s:text name="ServiceComposition.Parameter"></s:text><input name="var1" type="text" value="" readOnly="true">';
													ct++;
													var vars = document.getElementsByName("var1");
													vars.item(ct - 1).value = ppnames.item(i).value;
												}
											}
											var table=document.getElementById("table3");
											var row = table.insertRow(-1);
											var cc = row.insertCell(0);
											cc.innerHTML='<s:text name="ServiceComposition.Subservice"></s:text><input name="sr1" type="text" value="" readOnly="true">';
											var vars = document.getElementsByName("sr1");
											//vars.item(0).value = document.getElementById("userviceid").value;
											vars.item(0).value = $('#userviceid').find("option:selected").text();
										}
										function showModal()
										{
											$("#myModal").modal('show');
											//document.getElementById("msid").value = document.getElementById("userviceid").value;
											document.getElementById("msid").value = $('#userviceid').find("option:selected").text();
											var names = document.getElementsByName("ssname");
											var types = document.getElementsByName("sstype");
											var tts = document.getElementsByName("sstt");
											var ids = document.getElementsByName("ssid");
											var ranges = document.getElementsByName("ssrange");
											var adds = document.getElementsByName("ssadd");
											var busis = document.getElementsByName("ssbusi");
											var descs = document.getElementsByName("ssdesc");
											for(var i = 0; i < names.length; i++)
											{
												if(document.getElementById("msid").value == ids.item(i).value)
												{
													document.getElementById("msname").value = names.item(i).value;
													document.getElementById("mstype").value = types.item(i).value;
													document.getElementById("mstt").value = tts.item(i).value;
													document.getElementById("msrange").value = ranges.item(i).value;
													document.getElementById("msadd").value = adds.item(i).value;
													document.getElementById("msdesc").value = descs.item(i).value;
													document.getElementById("msbusi").value = busis.item(i).value;
												}
											}
											
											var psids = document.getElementsByName("psid");
											
										}
									</script>
									
									</div>
								</div>
								<div class="span9">
									<!-- Button to trigger modal -->
									<!--<input type="text" class="form-control" id="userviceid" name="userviceid" value="">  -->
									
									<select  id="userviceid">
										<s:iterator value="acceptedservices" status="L" var="acceptedservices">
											<option><s:property value="serviceId"/></option>
										</s:iterator>
									</select>
									
									
									
									
									<input type="hidden" id="inpts" name="inpts" value="">
									<a onclick="showModal()"  role="button" class="btn" data-toggle="modal"><s:text name="ServiceComposition.ViewServiceDetails"></s:text></a>
									<a onclick="newService()"  role="button" class="btn" data-toggle="modal"><s:text name="ServiceComposition.NewCompositeService"></s:text></a>
									<a onclick="addSub()"  role="button" class="btn" id="bt1" data-toggle="modal" style="display:none"><s:text name="ServiceComposition.JoinCompositeService"></s:text></a>
										<table class="table table-condensed" style="display:none" id="table2">
											<tr>
									  			<td>
										    		&nbsp;<s:text name="ServiceName"></s:text><input type="text" id="inname" name="inname" value="" style="width:80px" >
										    		&nbsp;<s:text name="ServiceType"></s:text><select id="servicetype" style="width:150px">
																  <option>SERVICE</option>
																  <option>APPLICATION</option>
																  <option>BUSINESS</option>
																  <option>LOCAL</option>
														       </select>
														<input type="hidden" id="intype" name="intype" value="" style="width:80px" >
										    	    &nbsp;<s:text name="ServiceLevel"></s:text><select id="servicelevel" style="width:80px">
																  <option>1</option>
																  <option>2</option>
																  <option>3</option>
																  <option>4</option>
																  <option>5</option>
														       </select>
														<input type="hidden" id="inlevel" name="inlevel" value="" style="width:80px" >
										    	
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceTarget"></s:text><input type="text" id="intt" name="intt" value="" style="width:100px" >
										    		&nbsp;<s:text name="ServiceRange"></s:text><input type="text" id="inrange" name="inrange" value="" style="width:100px" >
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceRelateBusiness"></s:text><input type="text" id="inbusiness" name="inbusiness" value="" style="width:250px" >
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceAddress"></s:text><input type="text" id="inadd" name="inadd" value="" style="width:250px" >
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceDesc"></s:text><input type="text" id="indesc" name="indesc" value="" style="width:250px" >
										    	</td>
										    </tr>
										</table>
										<table class="table table-condensed" style="display:none" id="table3">
											
										</table>
										<a onclick="smt()"  id="smt" class="btn" data-toggle="modal" style="display:none"><s:text name="Submit"></s:text></a>
									</div>
									<!-- Modal -->
									<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									  <div class="modal-header">
									    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									    <h3 id="myModalLabel"><s:text name="ServiceDetail"></s:text></h3>
									  </div>
									  <div class="modal-body">
									  	<table id="table1">
									  		<tr>
									  			<td>
											     	<s:text name="ServiceId"></s:text><input type="text" id="msid" name="msid" value="" style="width:50px" readOnly="true">
										    		&nbsp;<s:text name="ServiceName"></s:text><input type="text" id="msname" name="msname" value="" style="width:80px" readOnly="true">
										    		&nbsp;<s:text name="ServiceType"></s:text><input type="text" id="mstype" name="mstype" value="" style="width:100px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceTarget"></s:text><input type="text" id="mstt" name="mstt" value="" style="width:100px" readOnly="true">
										    		&nbsp;<s:text name="ServiceRange"></s:text><input type="text" id="msrange" name="msrange" value="" style="width:100px" readOnly="true">
										    	</td>
										    </tr>
										    
										    <tr>
										    	<td>
										    		<s:text name="ServiceRelateBusiness"></s:text><input type="text" id="msbusi" name="msbusi" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceAddress"></s:text><input type="text" id="msadd" name="msadd" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		<s:text name="ServiceDesc"></s:text><input type="text" id="msdesc" name="msdesc" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										</table>
									  </div>
									  <div class="modal-footer">
									    <button class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="Close"></s:text></button>
									     <!-- <button class="btn btn-primary">Save changes</button>  -->
									  </div>
									</div>
								</div>
								<div>
									<s:iterator value="acceptedservices" status="L" var="acceptedservices">
										<input name="ssname" type="hidden" value="<s:property value="serviceName"/>">
										<input name="sstype" type="hidden" value="<s:property value="serviceType"/>">
										<input name="ssbusi" type="hidden" value="<s:property value="relateBusiness"/>">
										<input name="ssid" type="hidden" value="<s:property value="serviceId"/>">
										<input name="sstt" type="hidden" value="<s:property value="serviceTarget"/>">
										<input name="ssrange" type="hidden" value="<s:property value="serviceRange"/>">
										<input name="ssadd" type="hidden" value="<s:property value="serviceAddress"/>">
										<input name="ssdesc" type="hidden" value="<s:property value="serviceDesc"/>">
									</s:iterator>
								</div> 
								<div>
					<s:iterator value="prts" status="L" var="prts">
						<input name="psid" type="hidden" value="<s:property value="serviceid"/>">
						<input name="ppid" type="hidden" value="<s:property value="parameterid"/>">
						<input name="ppname" type="hidden" value="<s:property value="parametername"/>">
						<input name="pptype" type="hidden" value="<s:property value="parametertype"/>">
					</s:iterator>
				</div> 
			</div><!--/.fluid-container-->
						</form>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		

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
		
		function changeValue()
		{
			var selectIndex1 = document.getElementById("opt1").selectedIndex;
			document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
		}
		
	</script>

</body>

<!-- END BODY -->

</html>