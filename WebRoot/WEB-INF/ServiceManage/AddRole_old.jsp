<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
  	<script>
		function showModal()
		{
			$("#myModal").modal('show');
		}
	</script>
  <body>

    <div class="container">

      <form class="form-horizontal" action="addRole.action" method="post">
		  <div class="control-group">
		    <label class="control-label" for="inputRoleName">角色名</label>
		    <div class="controls">
		      <input type="text" id="inputRoleName" name="role.roleName" placeholder="UserName">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" for="inputRoleDesc">角色描述</label>
		    <div class="controls">
		      <input type="text" id="inputRoleDesc" name="role.roleDesc" placeholder="UserDesc">
		    </div>
		  </div>
		  <div class="form-actions">
		  	  <button type="button" onclick="showModal()" class="btn">角色派生</button>	
			  <button type="submit" class="btn btn-primary">提交</button>
			  <button type="button" class="btn">清空</button>
		  </div>
	</form>
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">推荐派生角色详情</h3>
	  </div>
	  <div class="modal-body">
	  	<table class="table table-condensed" id="table1">
	  		<thead>
				<tr>
					<th>继承角色集合</th>
					<th>支持度</th>
					<th>阶数</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="apresults" status="L">
					<tr>
						<td><s:property value="setContent"/> </td>
						<td><s:property value="fre"/></td>
						<td><s:property value="k"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	    <button class="btn btn-primary">Save changes</button>
	  </div>
	</div>
   </div> <!-- /container -->

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
