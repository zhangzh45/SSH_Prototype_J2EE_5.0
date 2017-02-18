<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceCallRelations"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />
	
	<script src="js/dtree.js"></script>
	
	<script src="media/js/form-components.js"></script>

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceCallRelations"></s:text><small><s:text name="ServiceCallRelations.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="ServiceManagement"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="ServiceCallRelations"></s:text></a></li>

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
			  <!--<div class="navbar">
			  	<div class="navbar-inner">
			  		<ul class="nav">
			  			<li ><a onclick="form2.action='getPicture.action';form2.submit()">服务概况</a></li>
			  			<li><a onclick="form2.action='levelClass.action';form2.submit()">技术分类</a></li>
			  			<li  class="active"><a onclick="form2.action='workClass.action';form2.submit()">业务分类</a></li>
			  			<li><a >其他</a></li>
			  		</ul>
			  	</div>
			  </div>  -->
			  <div class="row-fluid">
			  	<div class="span3">	
					<div>
						<!-- <s:iterator value="srrelations" status="L" var="srrelations">
							<input name="rsub" type="hidden" value="<s:property value="serviceBySubServiceId.serviceId"/>">
							<input name="rsid" type="hidden" value="<s:property value="serviceByServiceId.serviceId"/>">
							<input name="rid" type="hidden" value="<s:property value="relationId"/>">
						</s:iterator> -->
						
						<s:iterator value="dtnodes" status="L" var="dtnodes">
							<input name="nself" type="hidden" value="<s:property value="self"/>">
							<input name="nfather" type="hidden" value="<s:property value="father"/>">
							<input name="ncontent" type="hidden" value="<s:property value="content"/>">
						</s:iterator>
					</div> 
					
					<div>
						<input id="numOfLevelclass" type="hidden" value="<s:property value="numOfLevelclass"/>">
					</div> 
					
					<div class="dtree">
					<p><a href="javascript: d.openAll();"><s:text name="OpenAll"></s:text></a> | <a href="javascript: d.closeAll();"><s:text name="CloseAll"></s:text></a></p>
					
					<script type="text/javascript">
							
						
						
						d = new dTree('d');
						var nfather = document.getElementsByName("nfather");
						var ncontent= document.getElementsByName("ncontent");
						
						d.add(0,-1,'Enterprise Services');
						//alert(nfather.length);
						for(var i = 0; i < nfather.length; i++)
						{
							d.add(i + 1, nfather.item(i).value, ncontent.item(i).value, 'example01.html');
						}
						
						/*d = new dTree('d');
						var fatherid = document.getElementsByName("rsid");
						var sonid = document.getElementsByName("rsub");
						var levelclass = 1;
						//alert(fatherid.length+"sss"+sonid.length);
						d.add(0,-1,'企业服务');
						
						
						var levelarray = new Array(5, 4, 3, 2, 1);
						var levelnumarray = new Array();
						var numOfLevelclass = document.getElementById("numOfLevelclass").value;
						alert(numOfLevelclass);
						var numOfEachlevel = numOfLevelclass.split(",");
						alert(numOfEachlevel.length);
						for(var i = 0; i < numOfEachlevel.length; i++){
							var numOfCurrentlevel = numOfEachlevel[i].substring(numOfEachlevel[i].indexOf(":") + 1);
							levelnumarray.push(parseInt(numOfCurrentlevel));
						}
						
						var fatherindex = 1;
						var countrelation = 0;
						for(var i = 0; i < levelarray.length; i++){
							var currentlevel = levelarray[i];
							d.add(fatherindex, 0, 'Level '+ currentlevel);
							fatherindex++;
							///var numOfCurrentlevel = numOfEachlevel[i].substring(numOfEachlevel[i].indexOf(":") + 1);
							//alert(numOfCurrentlevel);
							//if(parseInt(numOfCurrentlevel) == 0){
							if(levelnumarray[i] == 0){
								continue;
							}
							//var endindex = fatherindex + parseInt(numOfCurrentlevel);
							var endindex = fatherindex + levelnumarray[i];
							for(var j = fatherindex; j < endindex && countrelation < fatherid.length; j++)
							{
								//alert(j +" "+  (fatherid.item(countrelation).value + fatherindex)+" "+ sonid.item(countrelation).value);
								var numOfBeforeclass = 0;
								for(var k = 0; k < i; k++){
									numOfBeforeclass += levelnumarray[k];
								}
								//d.add(j, parseInt(fatherid.item(countrelation).value) + i + numOfBeforeclass, sonid.item(countrelation).value);
								d.add(j, parseInt(fatherid.item(countrelation).value) + i, sonid.item(countrelation).value);
								
								countrelation++;
								fatherindex++;
							}
						}*/
						document.write(d);
					</script>
					
					</div>
				</div>
				<div class="span9">
					<IFRAME name="topo" frameborder="0" width="100%" height="600" src="ServiceRelation.action"></IFRAME>
				</div>	
			  </div><!--/row-->
			 
			  
			</div><!--/.fluid-container-->
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

		

	

	<script>

		jQuery(document).ready(function() {       
		  // App.init();
		   TableAdvanced.init();
		   
		   checkuser();
		});
		
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			//alert(userid);
			if(userid == "null"){    //不是管理员
				window.location = "http://localhost:8020/SSH_Prototype_J2EE_5.0/error.jsp";
			}
			if(userid != "0"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
		

	</script>

</body>

<!-- END BODY -->

</html>