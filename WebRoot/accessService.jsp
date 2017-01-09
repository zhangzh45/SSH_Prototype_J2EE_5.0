<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="ServiceOperation.Called"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />
	
	<script src="js/dtree.js"></script>
	
	<script src="media/js/form-components.js"></script>
	
	<script src="js/jquery-1.9.0-min.js"></script>
	<script src="js/jquery-ui-1.9.2-min.js"></script>
	<script src="media/js/app.js"></script>

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >
	<div class="">
		<form name="form1" method="post" action="accessService.action">
			<input id="accessid" type="hidden" name="accessid"  value="">
			<input id="accessaddress" type="hidden" name="accessaddress"  value="">
			<input id="userid" name="userid" type="hidden" value=<%=request.getSession().getAttribute("user")%>>
			<input id="clientuserid" name="clientuserid" type="hidden" value="">
			<IFRAME id="service" frameborder="0" width="100%" height="600" src="<s:property value="accessaddress"/>"></IFRAME>
		</form>
	</div>	


	<script>
	
		
		//alert(serviceurl);
		//document.getElementById("service").src = serviceurl;
		//document.getElementById("accessaddrss").value = serviceurl;

		$(document).ready(function() {       
		   //App.init();
		   //TableAdvanced.init();
		   
		   //封装URL的形式为：本地URL+ ?URL=实际服务URL
			var currenturl = window.location.href;
			var localurl = currenturl.substring(0, currenturl.indexOf("?"));
			var serviceurl = currenturl.substring(currenturl.indexOf("?") + 1, currenturl.length);
		   // alert(currenturl);
			if(serviceurl !== null){
				var clientuserid = serviceurl.substring(0, serviceurl.indexOf("&"));
				var tempurl = serviceurl.substring(serviceurl.indexOf("&") + 1, serviceurl.length);
				var serviceid = tempurl.substring(0, tempurl.indexOf("&"));
				var serviceaddress = tempurl.substring(tempurl.indexOf("&") + 1, tempurl.length);
				
				document.getElementById("clientuserid").value = clientuserid.substring(clientuserid.indexOf("=") + 1, clientuserid.length);
				document.getElementById("accessaddress").value = serviceaddress.substring(serviceaddress.indexOf("=") + 1, serviceaddress.length);
				document.getElementById("accessid").value = serviceid.substring(serviceid.indexOf("=") + 1, serviceid.length);
				//alert(document.getElementById("clientuserid").value+"  "+document.getElementById("accessaddress").value+"  "+document.getElementById("accessid").value);
		   	    //form1.action="accessService";
		   	    form1.submit();
		    }
		   
		});
		
		

	</script>

</body>

<!-- END BODY -->

</html>