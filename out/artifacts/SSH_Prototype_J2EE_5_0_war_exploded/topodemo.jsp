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
				var jq2 = document.getElementsByName("lsonid");
				//alert(document.getElementsByName("lsonid").item(0).value);
				var types = document.getElementsByName("ltype");
				var address = document.getElementsByName("laddress");
				var parameters = document.getElementsByName("lparameter");
				var conditions = document.getElementsByName("lcondition");
				
				//alert(jq2.length);
				if(jq2.length == 1){
					//alert(document.getElementById('relationFather').value);
					$('#topoRegion').html("该服务不是组合服务！");
				}
				else{
					var first = jq2.item(1).value + conditions.item(1).value;
				
					var nodeTypeArray = ['APPLICATION', 'SERVICE', 'BUSINESS', 'LOCAL'];
					var topoData = {
						type: types.item(0).value,//'SERVICE', 
						key: jq2.item(0).value, 
						rel: [
						     {
						    	 type: types.item(1).value,//'SERVICE',
						    	 key: jq2.item(1).value,
						    	 data: {'url': address.item(1).value}
						     },
						],
						data: {'url': address.item(0).value}
					};
					
					drawTopo(topoData, rootPosition, nodeTypeArray);
					
					for(var i = 2; i < jq2.length; i++)
					{
						var newTopoData = {
							type: types.item(0).value,//'SERVICE',
					    	key: jq2.item(0).value,
					    	rel: [
		                           {
		                            	type: types.item(i).value,//'SERVICE',
		                            	key: jq2.item(i).value,
		                            	data: {'url': address.item(i).value}
		                           }
					    	],
							data: {'url': address.item(0).value}	
						};
						var mergedTopoData = mergeNewTopo(topoData, newTopoData);
						$('#topoRegion').empty();
						drawTopo(mergedTopoData, rootPosition, nodeTypeArray);
					}
				
				}
			});
		
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
		</script>
		
	</head>
	<body>
		<form name="form1" action="relationDetail.action" method="post">
			<!--   <div> -->
				<!-- <input name="relationFather" type="text" value=""> -->
				<!-- <input name="btn" type="button" class="btn" onclick="form1.submit()" value="关系图"> -->
				<!-- <input name="btn" type="button" class="btn" onclick="document.getElementById('table1').style.display=''" value="详情"> -->
			<!--  </div> -->
			 <div class="input-group">
      			<input type="text" class="form-control" name="relationFather" value="">
      			<span class="input-group-btn">
        			<button class="btn btn-default" type="button" onclick="form1.submit()"><s:text name="RelationGraph"></s:text></button>
        			<button class="btn btn-default" type="button" onclick="document.getElementById('table1').style.display=''"><s:text name="Details"></s:text></button>
      			</span>
    		</div><!-- /input-group -->
    		
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
			<s:iterator value="relations" status="L" var="relations">
				<input name="lsonid" type="hidden" value="<s:property value="sonid"/>">
				<input name="lcondition" type="hidden" value="<s:property value="condition"/>">
				<input name="ltype" type="hidden" value="<s:property value="type"/>">
				<input name="laddress" type="hidden" value="<s:property value="address"/>">
				<input name="lparameter" type="hidden" value="<s:property value="parameter"/>">
				<input name="ldesc" type="hidden" value="<s:property value="desc"/>">
			</s:iterator>
		</div>
		<div>
			<table class="table table-condensed" style="display:none" id="table1">
				<thead>
					<tr>
						<th>Service Id</th>
						<th>Conditions</th>
						<th>Parameters</th>
						<!-- <th>操作</th> -->
					</tr>
				</thead>
				<tbody>
					<s:iterator value="relations" status="L">
						<tr>
							<td><s:property value="sonid"/></td>
							<td><s:property value="condition"/></td>
							<td><s:property value="parameter"/></td>
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

