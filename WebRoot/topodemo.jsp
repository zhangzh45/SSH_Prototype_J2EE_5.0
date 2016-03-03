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
				var rootPosition = [300, 300];
				var jq2 = document.getElementsByName("lsonid");
				var types = document.getElementsByName("ltype");
				var parameters = document.getElementsByName("lparameter");
				var conditions = document.getElementsByName("lcondition");
				
				//alert(jq2.length);
				
				var first = jq2.item(1).value + conditions.item(1).value;
				
				var nodeTypeArray = ['WEB', 'URL', 'COM', 'MULE'];
				var topoData = {
					type: 'WEB', 
					key: jq2.item(0).value, 
					rel: [
					     {
					    	 type: 'COM',
					    	 key: jq2.item(1).value,
					     },
					]
				};
				
				drawTopo(topoData, rootPosition, nodeTypeArray);
				
				for(var i = 2; i < jq2.length; i++)
				{
					var newTopoData = {
						type: 'WEB',
				    	key: jq2.item(0).value,
				    	rel: [
	                           {
	                            	type: 'COM',
	                            	key: jq2.item(i).value,
	                           }
				    	]	
					};
					var mergedTopoData = mergeNewTopo(topoData, newTopoData);
					$('#topoRegion').empty();
					drawTopo(mergedTopoData, rootPosition, nodeTypeArray);
				}
			
				
			});
		
		
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
        			<button class="btn btn-default" type="button" onclick="form1.submit()">关系图</button>
        			<button class="btn btn-default" type="button" onclick="document.getElementById('table1').style.display=''">详情</button>
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
				<input name="lparameter" type="hidden" value="<s:property value="parameter"/>">
				<input name="ldesc" type="hidden" value="<s:property value="desc"/>">
			</s:iterator>
		</div>
		<div>
			<table class="table table-condensed" style="display:none" id="table1">
				<thead>
					<tr>
						<th>编号</th>
						<th>条件</th>
						<th>参数</th>
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
	</body>
</html>

