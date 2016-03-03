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
			  			<li ><a href="CombineATree.jsp">可靠性组合</a></li>
			  			<li class="active"><a href="CombineBTree.jsp">适用性组合</a></li>
			  			<li><a href="#">其他</a></li>
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
					<p><a href="javascript: d.openAll();">展开全部</a> | <a href="javascript: d.closeAll();">关闭全部</a></p>
					
					<script type="text/javascript">
						<!--
							
						d = new dTree('d');
						var nfather = document.getElementsByName("nfather");
						var ncontent= document.getElementsByName("ncontent");
						
						d.add(0,-1,'企业组合服务');
						alert(nfather.length);
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
						function addVar()
						{
							var table=document.getElementById("varTable");
							var row = table.insertRow(-1);
							var cc = row.insertCell(0);
							cc.innerHTML='控制变量<input name="cvar" type="text" value="">';
						}
						function deleteVar()
						{
							var table=document.getElementById("varTable");
							table.deleteRow(table.rows.length-1);
						}
						function smt()
						{
							var srs = document.getElementsByName("sr1");
							var pts = "s";
							for(var i = 0; i < srs.length; i++)
							{
								pts += srs.item(i).value;
								pts += "s";
							}
							//alert(pts);
							document.getElementById("inpts").value = pts;
							var invars = document.getElementsByName("cvar");
							var vars = ";";
							for(var i = 0; i < invars.length; i++)
							{
								vars += invars.item(i).value;
								vars += ";";
							}
							//alert(pts);
							document.getElementById("invars").value = vars;
							var inctns = document.getElementsByName("ctn");
							var ctns = ";";
							for(var i = 0; i < inctns.length; i++)
							{
								ctns += inctns.item(i).value;
								ctns += ";";
							}
							//alert(pts);
							document.getElementById("inctns").value = ctns;
						}
						function addSub()
						{
							var table=document.getElementById("table3");
							var row = table.insertRow(-1);
							
							var cc2 = row.insertCell(0);
							cc2.innerHTML='运行条件<input name="ctn" type="text" value="">';
							var cc = row.insertCell(0);
							cc.innerHTML='子服务<input name="sr1" type="text" value="" readOnly="true">';
							
							var vars = document.getElementsByName("sr1");
							vars.item(vars.length - 1).value = document.getElementById("userviceid").value;
							
							document.getElementById("smt").style.display="";
							
						}
						function newService()
						{
							document.getElementById("bt1").style.display="";
							document.getElementById("table2").style.display="";
							document.getElementById("table3").style.display="";
							document.getElementById("varTable").style.display="";
							
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
								if(psids.item(i).value == document.getElementById("userviceid").value)
								{
									//alert("nimei");
									var row = table.insertRow(-1);
									var cc = row.insertCell(0);
									cc.innerHTML='参数<input name="var1" type="text" value="" readOnly="true">';
									ct++;
									var vars = document.getElementsByName("var1");
									vars.item(ct - 1).value = ppnames.item(i).value;
								}
							}
							var table=document.getElementById("table3");
							var row = table.insertRow(-1);
							var cc2 = row.insertCell(0);
							cc2.innerHTML='运行条件<input name="ctn" type="text" value="">';
							var cc = row.insertCell(0);
							cc.innerHTML='子服务<input name="sr1" type="text" value="" readOnly="true">';
							var vars = document.getElementsByName("sr1");
							vars.item(0).value = document.getElementById("userviceid").value;
							
						}
						function showModal()
						{
							$("#myModal").modal('show');
							document.getElementById("msid").value = document.getElementById("userviceid").value;
							var names = document.getElementsByName("ssname");
							var types = document.getElementsByName("sstype");
							var tts = document.getElementsByName("sstt");
							var ids = document.getElementsByName("ssid");
							var ranges = document.getElementsByName("ssrange");
							var adds = document.getElementsByName("ssadd");
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
								}
							}
							
							var psids = document.getElementsByName("psid");
							
						}
					</script>
					</div>
				</div>
				<div class="span9">
					<input type="text" class="form-control" id="userviceid" name="userviceid" value="">
					<input type="hidden" id="inpts" name="inpts" value="">
					<input type="hidden" id="invars" name="invars" value="">
					<input type="hidden" id="inctns" name="inctns" value="">
					<a onclick="showModal()"  role="button" class="btn" data-toggle="modal">查看服务详情</a>
					<a onclick="newService()"  role="button" class="btn" data-toggle="modal">新建组合服务</a>
					<a onclick="addSub()"  role="button" class="btn" id="bt1" data-toggle="modal" style="display:none">加入组合服务</a>
						<table class="table table-condensed" style="display:none" id="table2">
							<tr>
					  			<td>
						    		&nbsp;服务名称<input type="text" id="inname" name="inname" value="" style="width:80px" >
						    		&nbsp;服务类型<input type="text" id="intype" name="intype" value="" style="width:80px" >
						    	</td>
						    </tr>
						    <tr>
						    	<td>
						    		服务目标<input type="text" id="intt" name="intt" value="" style="width:100px" >
						    		&nbsp;服务范围<input type="text" id="inrange" name="inrange" value="" style="width:100px" >
						    	</td>
						    </tr>
						    <tr>
						    	<td>
						    		服务地址<input type="text" id="inadd" name="inadd" value="" style="width:250px" >
						    	</td>
						    </tr>
						    <tr>
						    	<td>
						    		服务描述<input type="text" id="indesc" name="indesc" value="" style="width:250px" >
						    	</td>
						    </tr>
						</table>
						<table class="table table-condensed" style="display:none" id="varTable">
							<tr>
								<td>控制变量
									<input name="cvar" type="text" value="" id="cvar"> 
									<button type="button" onclick="addVar();">+</button>
									<button type="button" onclick="deleteVar();">-</button>
								</td>
							<tr>
						</table>
						<table class="table table-condensed" style="display:none" id="table3">
							
						</table>
						<a onclick="smt(); form1.action='addCombineB.action';form1.submit()"  id="smt" class="btn" data-toggle="modal" style="display:none">提交</a>
					</div>
					<!-- Modal -->
					<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-header">
					    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					    <h3 id="myModalLabel">服务详情</h3>
					  </div>
					  <div class="modal-body">
					  	<table id="table1">
					  		<tr>
					  			<td>
							     	服务编号<input type="text" id="msid" name="msid" value="" style="width:50px" readOnly="true">
						    		&nbsp;服务名称<input type="text" id="msname" name="msname" value="" style="width:80px" readOnly="true">
						    		&nbsp;服务类型<input type="text" id="mstype" name="mstype" value="" style="width:80px" readOnly="true">
						    	</td>
						    </tr>
						    <tr>
						    	<td>
						    		服务目标<input type="text" id="mstt" name="mstt" value="" style="width:100px" readOnly="true">
						    		&nbsp;服务范围<input type="text" id="msrange" name="msrange" value="" style="width:100px" readOnly="true">
						    	</td>
						    </tr>
						    <tr>
						    	<td>
						    		服务地址<input type="text" id="msadd" name="msadd" value="" style="width:250px" readOnly="true">
						    	</td>
						    </tr>
						    <tr>
						    	<td>
						    		服务描述<input type="text" id="msdesc" name="msdesc" value="" style="width:250px" readOnly="true">
						    	</td>
						    </tr>
						</table>
					  </div>
					  <div class="modal-footer">
					    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					    <button class="btn btn-primary">Save changes</button>
					  </div>
					</div>
				</div>
				<div>
					<s:iterator value="selected" status="L" var="selected">
						<input name="ssname" type="hidden" value="<s:property value="serviceName"/>">
						<input name="sstype" type="hidden" value="<s:property value="serviceType"/>">
						<input name="ssid" type="hidden" value="<s:property value="serviceId"/>">
						<input name="sstt" type="hidden" value="<s:property value="serviceTarget"/>">
						<input name="ssrange" type="hidden" value="<s:property value="serviceRange"/>">
						<input name="ssbus" type="hidden" value="<s:property value="relateBusiness"/>">
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
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>

	</body>
</html>
