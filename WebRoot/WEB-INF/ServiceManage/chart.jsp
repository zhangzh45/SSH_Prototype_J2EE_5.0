<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceStatistics"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />


	<script src="media/js/form-components.js"></script>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceStatistics"></s:text><small><s:text name="ServiceStatistics.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.jsp">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a ><s:text name="ServiceManagement"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a ><s:text name="ServiceStatistics"></s:text></a></li>

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
							  			<li class="active"><a onclick="form2.action='getPicture.action';form2.submit()"><s:text name="ServiceStatistics.Profile"></s:text></a></li>
							  			<li><a onclick="form2.action='quality.action';form2.submit()"><s:text name="ServiceStatistics.Statistics"></s:text></a></li>
							  			<li><a ><s:text name="Other"></s:text></a></li>
							  		</ul>
							  	</div>
							  </div>
							  <div class="row-fluid">
								
								<div class="span8">
								  <div class="row-fluid">
								  	<img src="<%=request.getContextPath()+"/images/company.jpeg"%>">
								  </div><!--/row-->
								</div><!--/span-->
								
								<div class="span4">
								  <div class="row-fluid">
								  	<div><span style="font-size:23px;font-weight:bold;"><s:text name="ServiceStatistics.RankingList"></s:text></span></div>
								  	<table class="table table-condensed" id="varTable">
										<thead>
										<tr>
											<th>Service Id</th>
											<th class="hidden-480">Service Name</th>
											<th class="hidden-480">Run Times</th>
											<th ></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="ranklistByRuntimes" status="L">
										<tr>
											<td><a name="serviceId" data-toggle="modal"><s:property value="serviceId"/></a></td>
											<td class="hidden-480"><s:property value="serviceName"/></td>
											<td class="hidden-480"><s:property value="runTimes"/></td>
										</tr>
										</s:iterator>
									</tbody>
									</table>
								  </div><!--/row-->
								</div><!--/span-->
								
								
								
							  </div><!--/row-->
					
							</div><!--/.fluid-container-->
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>


			<form name="form3" action="inputParameter.action" method="post">
			<!-- Modal -->
									<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									  <div class="modal-header">
									    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									    <h3 id="myModalLabel">Service Details</h3>
									  </div>
									  <div class="modal-body">
									  	<table id="table1">
									  		<tr>
									  			<td>
											     	Service Id<input type="text" id="msid" name="msid" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
									  			<td>
											     	Service Name<input type="text" id="msname" name="msname" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
									  			<td>
											     	Service Type<input type="text" id="mstype" name="mstype" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		Relate Business<input type="text" id="msbusiness" name="msbusiness" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		Service Target<input type="text" id="mstt" name="mstt" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		Service Range<input type="text" id="msrange" name="msrange" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		Service Address<input type="text" id="msadd" name="msadd" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										    <tr>
										    	<td>
										    		Service Desc<input type="text" id="msdesc" name="msdesc" value="" style="width:250px" readOnly="true">
										    	</td>
										    </tr>
										</table>
									  </div>
									  <div class="modal-footer">
									    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
									    <button class="btn btn-primary" onclick="form3.submit()">Run</button>
									  </div>
									</div>
	
						<input id="option1" name="option1" type="hidden" value="">
				</form>
	

	<script>

		jQuery(document).ready(function() {       
		  
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
		
		
		$('a[name="serviceId"]').click(function(){
			var serviceid = $(this).html();
			$("#myModal").modal('show');
			$.ajax({
				url		:	"queryservice.action",
				type	:	"post",
				data	:   "queryserviceid="+serviceid,
				dataType:	"json",
				async:  false,
				success	: function(queryServiceresult){
					var service = JSON.parse(queryServiceresult);
					//alert(queryServiceresult+"KKKKK");
					document.getElementById("option1").value = serviceid;
					document.getElementById("msid").value = serviceid;
					document.getElementById("msname").value = service[0].servicename;
					document.getElementById("mstype").value = service[0].servicetype;
					document.getElementById("mstt").value = service[0].servicetarget;
					document.getElementById("msrange").value = service[0].servicerange;
					document.getElementById("msbusiness").value = service[0].relatedbusiness;
					document.getElementById("msadd").value = service[0].serviceaddress;
					document.getElementById("msdesc").value = service[0].servicedesc;
				
				},
				error : function (XMLHttpRequest, textStatus, errorThrown) {
					 // 通常情况下textStatus和errorThown只有其中一个有值 
			        alert(errorThrown);
	         	}
			});
		});
		

	</script>

</body>

<!-- END BODY -->

</html>