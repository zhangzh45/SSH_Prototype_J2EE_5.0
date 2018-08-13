<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ViewConfiguration"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ViewConfiguration"></s:text><small><s:text name="ViewConfiguration.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceConfiguration"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="ViewConfiguration"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

			
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<form name="form1" id="form1" action="listconfig.action" method="post">
						<div>
							<s:text name="ServiceId"></s:text>
							<input type="hidden" name="serviceid" id="serviceid" value=<s:property value="serviceid"/>>
							<select name="selectservice" id="selectservice"> 
								<s:iterator value="services" status="L" var="services">
									<option><s:property value="serviceId"/></option>
								</s:iterator>
							</select>
							<button onclick="changeValue();form1.submit()"><s:text name="ViewConfiguration"></s:text></button>
						</div>
					</form>

						
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="LicenseList"></s:text>
								</div>
								<div class="portlet-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th>License Id</th>
												<th>License Type</th>
												<th>License Time</th>
												<th>License Code</th>
												<th>License Location</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="licences" value="licences" status="L">
												<tr>
													<td><s:property value="licenceId"/></td>
													<td><s:property value="licenceType"/></td>
													<td><s:property value="licenceTime"/></td>
													<td><s:property value="licenceCode"/></td>
													<td><s:property value="licenceLocation"/></td>      <!-- <button class="btn btn-primary" value=<s:property value="licenceId"/> onclick="edit('Licence', this.value)">Edit</button> -->
													<td><button class="btn btn-primary" value=<s:property value="licenceId"/> onclick="remove('Licence', this.value)">Remove</button><button class="btn btn-primary" value=<s:property value="licenceId"/> onclick="edit('Licence', this.value)">Edit</button></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
							
							
							
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ParameterList"></s:text>
								</div>
								<div class="portlet-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th>Parameter Id</th>
												<th>Parameter Name</th>
												<th>Parameter Type</th>
												<th>Parameter Desc</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="paras" value="paras" status="L">
												<tr>
													<td><s:property value="parameterid"/></td>
													<td><s:property value="parametername"/></td>
													<td><s:property value="parametertype"/></td>
													<td><s:property value="parameterdesc"/></td>         <!-- <button class="btn btn-primary" value=<s:property value="parameterid"/> onclick="edit('Parameter', this.value)">Edit</button> -->
													<td><button class="btn btn-primary" value=<s:property value="parameterid"/> onclick="remove('Parameter', this.value)">Remove<button class="btn btn-primary" value=<s:property value="parameterid"/> onclick="edit('Parameter', this.value)">Edit</button></button></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
							
							<div class="portlet box blue">
								<div class="portlet-title">
									<s:text name="ResultList"></s:text>
								</div>
								<div class="portlet-body">
									<table class="table table-condensed" id="vartable">
										<thead>
											<tr>
												<th>Result Id</th>
												<th>Result Name</th>
												<th>Result Type</th>
												<th>Result Desc</th>
												<th></th>
											</tr>
										</thead>
										<s:iterator var="serviceresults" value="serviceresults" status="L">
											<tr>
												<td><s:property value="resultid"/></td>
												<td><s:property value="resultName"/></td>
												<td><s:property value="resultType"/></td>
												<td><s:property value="resultDesc"/></td>   <!-- <button class="btn btn-primary" value=<s:property value="resultid"/> onclick="edit('Serviceresult', this.value)">Edit</button> -->
												<td><button class="btn btn-primary" value=<s:property value="resultid"/> onclick="remove('Serviceresult', this.value)">Remove</button><button class="btn btn-primary" value=<s:property value="resultid"/> onclick="edit('Serviceresult', this.value)">Edit</button></td>
											</tr>
										</s:iterator>
									</table>
								</div>
							</div>
								
					

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<form name="editlicence" action="editlicence.action" method="post">
			<div id="editlicence" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel"><s:text name="LicenseDetails"></s:text></h3>
				</div>
				<div class="modal-body">
					<table id="table1">
						<tr>
							<td><s:text name="LicenseId"></s:text><input type="text" id="lid" name="lid" value="" style="width:100px" readOnly="true"></td>
						</tr>
						<tr>
							<td><s:text name="LicenseType"></s:text><input type="text" id="ltype" name="ltype" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="LicenseTime"></s:text><input type="text" id="ltime" name="ltime" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="LicenseCode"></s:text><input type="text" id="lcode" name="lcode" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="LicenseLocation"></s:text><input type="text" id="llocation" name="llocation" value="" style="width:100px"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="editlicence.submit()"><s:text name="Save"></s:text></button>
					<button class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="Close"></s:text></button>
				</div>
			</div>
	
			<input id="option1" name="option1" type="hidden" value="">
		</form>
		
		<form name="editparameter" action="editparameter.action" method="post">
			<!-- Modal -->
			<div id="editparameter" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="editparameterLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="editparameterLabel"><s:text name="ParameterDetails"></s:text></h3>
				</div>
				<div class="modal-body">
					<table id="table2">
						<tr>
							<td><s:text name="ParameterId"></s:text><input type="text" id="pid" name="pid" value="" style="width:100px" readOnly="true"></td>
						</tr>
						<tr>
							<td><s:text name="ParameterName"></s:text><input type="text" id="pname" name="pname" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="ParameterType"></s:text><input type="text" id="ptype" name="ptype" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="ParameterDesc"></s:text><input type="text" id="pdesc" name="pdesc" value="" style="width:100px"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="editparameter.submit()"><s:text name="Save"></s:text></button>
					<button class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="Close"></s:text></button>
				</div>
			</div>
		</form>
		
  	   <form name="editresult" action="editresult.action" method="post">
			<div id="editresult" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="editresultLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="editresultLabel"><s:text name="ResultDetails"></s:text></h3>
				</div>
				<div class="modal-body">
					<table id="table3">
						<tr>
							<td><s:text name="ResultId"></s:text><input type="text" id="rid" name="rid" value="" style="width:100px" readOnly="true"></td>
						</tr>
						<tr>
							<td><s:text name="ResultName"></s:text><input type="text" id="rname" name="rname" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="ResultType"></s:text><input type="text" id="rtype" name="rtype" value="" style="width:100px"></td>
						</tr>
						<tr>
							<td><s:text name="ResultDesc"></s:text><input type="text" id="rdesc" name="rdesc" value="" style="width:100px"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="editresult.submit()"><s:text name="Save"></s:text></button>
					<button class="btn" data-dismiss="modal" aria-hidden="true"><s:text name="Close"></s:text></button>
				</div>
			</div>
		</form>

	<script>

		jQuery(document).ready(function() {       
		  // App.init();
		  // TableAdvanced.init();
		   
		   checkuser();
		   //alert(document.getElementById("serviceid").value+"ll");
		   document.getElementById("selectservice").value = document.getElementById("serviceid").value;    
		   //document.getElementById("form1").submit();
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
			var obj = document.getElementById("selectservice");
			var index = obj.selectedIndex;
			var value = obj.options[index].value;
			//alert(value);
			document.getElementById("serviceid").value = value;	
		}
		
		function edit(conftype, confid){
			$.ajax({
				url		:	"queryConfig.action",
				type	:	"post",
				data	:   {
					"conftype":conftype,
					"confid":confid
				},
				dataType:	"json",
				async:  false,
				success	: function(queryServiceresult){
					//alert(queryServiceresult+"KKKKK");
					if(conftype == "Licence"){
						$("#editlicence").modal('show');
						var licence = JSON.parse(queryServiceresult);
						document.getElementById("lid").value = licence[0].licenceid;
						document.getElementById("ltype").value = licence[0].licencetype;
						document.getElementById("ltime").value = licence[0].licencetime;
						document.getElementById("lcode").value = licence[0].licencecode;
						document.getElementById("llocation").value = licence[0].licencelocation;
					}
					else if(conftype == "Parameter"){
						var parameter = JSON.parse(queryServiceresult);
						document.getElementById("pid").value = parameter[0].parameterid;
						document.getElementById("ptype").value = parameter[0].parametertype;
						document.getElementById("pname").value = parameter[0].parametername;
						document.getElementById("pdesc").value = parameter[0].parameterdesc;
						$("#editparameter").modal('show');
					}
					else if(conftype == "Serviceresult"){
						$("#editresult").modal('show');
						var result = JSON.parse(queryServiceresult);
						document.getElementById("rid").value = result[0].srid;
						document.getElementById("rtype").value = result[0].srtype;
						document.getElementById("rname").value = result[0].srname;
						document.getElementById("rdesc").value = result[0].srdesc;
					}
				},
				error : function (XMLHttpRequest, textStatus, errorThrown) {
					 // 通常情况下textStatus和errorThown只有其中一个有值 
			        alert(errorThrown);
	         	}
			});
		}
		
		function remove(conftype, confid){
			$.ajax({
				url		:	"removeConfig.action",
				type	:	"post",
				data	:   {
					"conftype":conftype,
					"confid":confid
				},
				dataType:	"json",
				async:  false,
				success	: function(removeConfigResult){
					//alert(removeConfigResult+"KKKKK");
					if(removeConfigResult == "success"){
						//window.reload();
						window.location = "/listconfig.action";
					}else{
						//alert("删除配置信息失败");
						window.location ="/error.jsp";
					}
					
				},
				error : function (XMLHttpRequest, textStatus, errorThrown) {
					 // 通常情况下textStatus和errorThown只有其中一个有值 
			       //alert(errorThrown);
			       window.location = "/error.jsp";
	         	}
			});
		}
				
	</script>

</body>

<!-- END BODY -->

</html>