<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceCompositionRelation"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	
	<script src="js/dtree.js"></script>
	
	<script src="media/js/form-components.js"></script>

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceCompositionRelation"></s:text><small><s:text name="ServiceCompositionRelation.Description"></s:text></small>

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

							<li><a ><s:text name="ServiceCompositionRelation"></s:text></a></li>

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
			  			<li class="active"><a onclick="form2.action='busyClass.action';form2.submit()"><s:text name="ServiceCompositionRelation.TechnicalClassification"></s:text></a></li>
			  			<li><a onclick="form2.action='workClass.action';form2.submit()"><s:text name="ServiceCompositionRelation.BusinessClassification"></s:text></a></li>
			  			<li><a ><s:text name="Other"></s:text></a></li>
			  		</ul>
			  	</div>
			  </div>
			  <div class="row-fluid">
			  	<div class="span3">	
					<div>
						<s:iterator value="conditions" status="L" var="conditions">
							<input name="ce" type="hidden" value="<s:property value="condtionExpression"/>">
							<input name="csub" type="hidden" value="<s:property value="serviceBySubServiceId.serviceId"/>">
							<input name="csid" type="hidden" value="<s:property value="serviceByServiceId.serviceId"/>">
							<input name="csubaddress" type="hidden" value="<s:property value="serviceBySubServiceId.serviceAddress"/>">
							<input name="caddress" type="hidden" value="<s:property value="serviceByServiceId.serviceAddress"/>">
							<input name="cid" type="hidden" value="<s:property value="conditionId"/>">
							<input name="ctype"  type="hidden" value="<s:property value="condtionType"/>">
						</s:iterator>
					</div> 
					
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
							
						/*d = new dTree('d');
						var fatherid = document.getElementsByName("csid");
						var sonid = document.getElementsByName("csub");
						var ctype = document.getElementsByName("ctype");
						
						var fatheraddress = document.getElementsByName("caddress");
						var sonaddress = document.getElementsByName("csubaddress");
						//alert(fatherid);
						var busyclass = 1;
						//alert(fatherid.length+"sss"+sonid.length);
						d.add(0,-1,'企业组合服务');
						d.add(1, 0,'WebService');
						//alert(fatherid.item(2).value);
						var index = 2;
						for(var i = 1 + busyclass; i <= fatherid.length + busyclass; i++)
						{	//alert(index++);
							if(ctype.item(i - busyclass - 1).value == 'WebService'){
							//alert('WebService');
								//d.add(index++, 1, fatherid.item(i - busyclass - 1).value);
								d.add(index++, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								//d.add(i, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								//fatherid.splice(i - busyclass - 1, 1);
								//i--;
								ctype.item(i - busyclass - 1).value = 'selected';
							}
							
						}
						//d.add(fatherid.length + busyclass + 2, 0,'Http');
						d.add(index++, 0,'Http');
						for(var i = 1 + busyclass; i <= fatherid.length + busyclass; i++)
						{
							if(ctype.item(i - busyclass - 1).value == 'Http'){
								//d.add(i, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								//alert(fatherid.item(i - busyclass - 1).value+"pp"+ sonid.item(i - busyclass - 1).value);
								d.add(index++, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								ctype.item(i - busyclass - 1).value = 'selected';
							}
							
						}
						//d.add(fatherid.length + busyclass + 3, 0,'Ajax');
						//d.add(fatherid.length + busyclass + 4, 0,'URL');
						d.add(index++, 0,'URL');
						for(var i = 1 + busyclass; i <= fatherid.length + busyclass; i++)
						{
							if(ctype.item(i - busyclass - 1).value == 'URL'){
								//d.add(i, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								d.add(index++, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								ctype.item(i - busyclass - 1).value = 'selected';
							}
							
						}
						//alert(fatherid.length);
						d.add(index++, 0,'Other');
						for(var i = 1 + busyclass; i <= fatherid.length + busyclass; i++)
						{
							if(ctype.item(i - busyclass - 1).value != 'selected'){
								//d.add(i, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								d.add(index++, fatherid.item(i - busyclass - 1).value, sonid.item(i - busyclass - 1).value);
								ctype.item(i - busyclass - 1).value = 'selected';
							}
							
						}
						
						//d.add(fatherid.length + busyclass + 5, fatherid.length + busyclass + 2,'XXX');
						//d.add(fatherid.length + busyclass + 6, fatherid.length + busyclass + 3,'XXX');
						//d.add(fatherid.length + busyclass + 6, fatherid.length + busyclass + 4,'XXX');
						//d.add(fatherid.length + 1, 2, 'aa', 'example01.html');
						
						document.write(d);*/
					
						d = new dTree('d');
						var nfather = document.getElementsByName("nfather");
						var ncontent= document.getElementsByName("ncontent");
						
						d.add(0,-1,'Combination Service');
						//alert(nfather.length);
						for(var i = 0; i < nfather.length; i++)
						{
							d.add(i + 1, nfather.item(i).value, ncontent.item(i).value, 'example01.html');
						}
						document.write(d);
					</script>
					
					</div>
				</div>
				<div class="span9">
					<IFRAME name="topo" frameborder="0" width="100%" height="600" src="topodemo.action"></IFRAME>”
				</div>	
			  </div><!--/row-->
			 
			  
			</div><!--/.fluid-container-->
						</form>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

			

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	

	

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
				window.location = "http://localhost:8080/SSH_Prototype_J2EE_5.0/error.jsp";
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