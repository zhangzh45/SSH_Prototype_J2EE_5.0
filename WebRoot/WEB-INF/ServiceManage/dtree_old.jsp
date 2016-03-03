<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
	<head>
		<title>Bootstrap Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
		<script type="text/javascript" src="js/dtree.js"></script>

	<style type="text/css">
      body {
        padding-top: 0px;
        padding-bottom: 0px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
	<body>
		<form name="form1" action="" method="post">
			<div class="container-fluid">
			  <div class="navbar">
			  	<div class="navbar-inner">
			  		<!--  <a class="brand" href="#">Title</a> -->
			  		<ul class="nav">
			  			<li ><a href="chart.jsp">服务概况</a></li>
			  			<li class="active"><a href="dtree.jsp">技术分类</a></li>
			  			<li><a href="#">业务分类</a></li>
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
						d.add(1, 0,'WebService');
						//alert(fatherid.length);
						for(var i = 1 + busyclass; i <= fatherid.length + busyclass; i++)
						{
							d.add(i, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value, 'example01.html');
						}
						d.add(fatherid.length + busyclass + 2, 0,'Http');
						d.add(fatherid.length + busyclass + 3, 0,'Ajax');
						d.add(fatherid.length + busyclass + 4, 0,'URL');
						d.add(fatherid.length + busyclass + 5, fatherid.length + busyclass + 2,'XXX');
						d.add(fatherid.length + busyclass + 6, fatherid.length + busyclass + 3,'XXX');
						d.add(fatherid.length + busyclass + 7, fatherid.length + busyclass + 4,'XXX');
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
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>

	</body>
</html>
