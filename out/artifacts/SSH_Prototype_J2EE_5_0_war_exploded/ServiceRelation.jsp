<!doctype html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>jsPlumb 1.5.3 - flowchart connectors demonstration - jQuery</title>
		<link rel="stylesheet" href="css/topo-all.css">
		<link rel="stylesheet" href="css/topo.css">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		
		<!-- DEP -->
	    <script src="js/jquery-1.9.0-min.js"></script>
		<script src="js/jquery-ui-1.9.2-min.js"></script>
        
		<!-- /DEP -->
		
		<script src="media/js/form-components.js"></script>
				
		<!-- JS -->
		<!-- support lib for bezier stuff -->
		<script src="js/jsBezier-0.6-min.js"></script> 
		<!-- jsplumb geom functions -->   
		<script src="js/jsplumb-geom-0.1.js"></script>
		<!-- jsplumb util -->
		<script src="js/util.js"></script>
        <!-- base DOM adapter -->
		<script src="js/dom-adapter.js"></script>        
		<!-- main jsplumb engine -->
		<script src="js/jsPlumb.js"></script>
        <!-- endpoint -->
		<script src="js/endpoint.js"></script>                
        <!-- connection -->
		<script src="js/connection.js"></script>
        <!-- anchors -->
		<script src="js/anchors.js"></script>        
		<!-- connectors, endpoint and overlays  -->
		<script src="js/defaults.js"></script>
		<!-- connector editors -->
		<script src="js/connector-editors.js"></script>
		<!-- bezier connectors -->
		<script src="js/connectors-bezier.js"></script>
		<!-- state machine connectors -->
		<script src="js/connectors-statemachine.js"></script>
        <!-- flowchart connectors -->
		<script src="js/connectors-flowchart.js"></script>        
		<!-- SVG renderer -->
		<script src="js/renderers-svg.js"></script>
		<!-- canvas renderer -->
		<script src="js/renderers-canvas.js"></script>
		<!-- vml renderer -->
		<script src="js/renderers-vml.js"></script>
        
        <!-- jquery jsPlumb adapter -->
		<script src="js/jquery.jsPlumb.js"></script>
		<!-- /JS -->
		
		<!--  demo code -->
		<script src="js/drawtopo.js"></script>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
			jsPlumb.bind("ready", function() {
				
				// 鎷撴墤鏁版嵁缁撴瀯鏍硅妭鐐逛綅缃缃�				
				var rootPosition = [200, 200];
				var sonids = document.getElementsByName("lsonid");
				//alert(document.getElementsByName("lsonid").item(0).value);
				var sontypes = document.getElementsByName("lsontype");
				var fatherids = document.getElementsByName("lfatherid");
				var fathertypes = document.getElementsByName("lfathertype");
				
				var fatheraddress = document.getElementsByName("lfatheraddress");
				var sonaddress = document.getElementsByName("lsonaddress");
				var fathernames = document.getElementsByName("lfathername");
				var sonnames = document.getElementsByName("lsonname");
				
				
				if(fatherids.length == 0 && document.getElementById('relationFather').value !== ""){
					//alert(document.getElementById('relationFather').value);
					$('#topoRegion').html("该服务没有调用其他服务！");
				}
				else{
					var nodeTypeArray = ['APPLICATION', 'SERVICE', 'BUSINESS', 'LOCAL'];
					var topoData = {
						type: fathertypes.item(0).value, 
						key: fatherids.item(0).value + "_" + fathernames.item(0).value, 
						rel: [
						     {
						    	 type: sontypes.item(0).value,
						    	 key: sonids.item(0).value + "_" + sonnames.item(0).value,
						    	 data: {'url': sonaddress.item(0).value}
						     },
						], 
						data: {'url': fatheraddress.item(0).value}
					};
					
					drawTopo(topoData, rootPosition, nodeTypeArray);
					for(var i = 1; i < fatherids.length; i++)
					{
						//alert(sontypes.item(i).value);
						var newTopoData = {
							type: fathertypes.item(i).value,
					    	key: fatherids.item(i).value + "_" + fathernames.item(i).value,
					    	rel: [
		                           {
		                            	type: sontypes.item(i).value,
		                            	key: sonids.item(i).value + "_" + sonnames.item(i).value,
		                            	data: {'url': sonaddress.item(i).value}
		                           },
					    	],
					    	data: {'url': fatheraddress.item(i).value}
						};
						var mergedTopoData = mergeNewTopo(topoData, newTopoData);
						if(mergedTopoData == topoData){
							drawTopo(newTopoData, rootPosition, nodeTypeArray);
						}
						else{
							$('#topoRegion').empty();
							drawTopo(mergedTopoData, rootPosition, nodeTypeArray);
						}
						topoData = mergedTopoData;
					}
				}
			});
		
		</script>
		
	</head>
	<body>
		<form name="form1" action="callRelationDetail.action" method="post">
			<!--   <div> -->
				<!-- <input name="relationFather" type="text" value=""> -->
				<!-- <input name="btn" type="button" class="btn" onclick="form1.submit()" value="关系图"> -->
				<!-- <input name="btn" type="button" class="btn" onclick="document.getElementById('table1').style.display=''" value="详情"> -->
			<!--  </div> -->
			 <div class="input-group">
			 	<div class="control-group">
					<label class="control-label" for="inputServiceGranularity"><s:text name="SelectServiceGranularity"></s:text></label>
					<div class="controls">
						<select id="ServiceGranularity"  onchange="selectServiceGranularity()">
							<option><s:text name="SingleService"></s:text></option>
							<option><s:text name="RelatedServices"></s:text></option>
							<option><s:text name="AllServices"></s:text></option>
						</select>
					</div>
				</div>
			</div>
			 
			 	<input type="hidden" class="form-control" id="serviceGranularity" name="serviceGranularity" value="single">
      			<input type="text" class="form-control" name="relationFather" value="<s:property value="relationFather"/>">
      			<input type="hidden" class="form-control" id="relationFather" value="<s:property value="relationFather"/>">
      			<span class="input-group-btn">
        			<button class="btn btn-default" type="button" onclick="form1.submit()"><s:text name="RelationGraph"></s:text></button>
        			<button class="btn btn-default" type="button" onclick="document.getElementById('table1').style.display=''"><s:text name="Details"></s:text></button>
      			</span>
    		</div><!-- /input-group -->
    		
    	<!--<input id="userid" name="userid" type="hidden" value=<%=request.getSession().getAttribute("user")%>>
    		<input id="option1" name="option1" type="hidden" value="">  -->
			
		</form>
        <div id="topoRegion">
	    </div>
	    <div>
			<s:iterator value="conditions" status="L" var="conditions">
				<input name="ce" type="hidden" value="<s:property value="condtionExpression"/>">
				<input name="csub" type="hidden" value="<s:property value="subServiceId"/>">
				<input name="csid" type="hidden" value="<s:property value="serviceId"/>">
				<input name="cid" type="hidden" value="<s:property value="conditionId"/>">
			</s:iterator>
		</div>
		<div>
		<table>
			<s:iterator value="callrelations" status="L" var="callrelations">
			<tr>
				<td><input name="lsonid" type="hidden" value="<s:property value="sonid"/>"></td>
				<td><input name="lsontype" type="hidden" value="<s:property value="sontype"/>"></td>
				<td><input name="lfathertype" type="hidden" value="<s:property value="fathertype"/>"></td>
				<td><input name="lfatherid" type="hidden" value="<s:property value="fatherid"/>"></td>
				<td><input name="lfatheraddress" type="hidden" value="<s:property value="fatheraddress"/>"></td>
				<td><input name="lsonaddress" type="hidden" value="<s:property value="sonaddress"/>"></td>
				<td><input name="lfathername" type="hidden" value="<s:property value="fathername"/>"></td>
				<td><input name="lsonname" type="hidden" value="<s:property value="sonname"/>"></td>
				<!-- <input name="ldesc" type="hidden" value="<s:property value="desc"/>"> -->
			</tr>
			</s:iterator>
			
			</table>
		</div>
		<div>
			<table class="table table-condensed" style="display:none" id="table1">
				<thead>
					<tr>
						<th>Service Id</th>
						<th>Service Type</th>
						<th>Relate Business</th>
						<th>Service Address</th>
						<th>Parameters</th>
						<!-- <th>操作</th> -->
					</tr>
				</thead>
				<tbody>
					<s:iterator value="calldetails" status="L">
						<tr>
							<td><s:property value="sonid"/></td>
							<td><s:property value="sontype"/></td>
							<td><s:property value="sonbusiness"/></td>
							<td><s:property value="sonaddress"/></td>
							<td><s:property value="sonparameter"/></td>
							<!-- <td><button type="button" class="btn btn-primary" onclick="window.location.href='<s:property value="serviceAddress"/>'">URL &raquo;</button></td> -->
						</tr>
					</s:iterator>
				</tbody>
			</table>
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
	
						<input id="option1" name="option1" type="hidden" value="">  <!-- 运行服务的id -->
						<input id="userid" name="userid" type="hidden" value=<%=request.getSession().getAttribute("user")%>> 
				</form>
		
		
		
		
	</body>
</html>

<script type="text/javascript">

	function loadservice(serviceid){
		
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
		
	}
	
	
	function selectServiceGranularity(){
			var serviceGranularityobj = document.getElementById("ServiceGranularity");
			var serviceGranularityindex = serviceGranularityobj.selectedIndex;
			alert(serviceGranularityindex);
			if(serviceGranularityindex == 0){
				document.getElementById("serviceGranularity").value="single";
			}else if(serviceGranularityindex == 1){
				document.getElementById("serviceGranularity").value="related";
			}else if(serviceGranularityindex == 2){
				document.getElementById("serviceGranularity").value="all";
			}
	}
</script>

