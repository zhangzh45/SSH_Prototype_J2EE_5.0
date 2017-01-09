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
		<IFRAME id="service" frameborder="0" width="100%" height="600" src="<s:property value="accessaddress"/>"></IFRAME>
	</div>	


	<script>

	</script>

</body>

<!-- END BODY -->

</html>