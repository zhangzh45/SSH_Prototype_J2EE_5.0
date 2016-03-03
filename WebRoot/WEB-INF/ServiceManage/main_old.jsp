<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
	<head>
		<title>企业服务管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
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
    <%
    	String user = request.getParameter("user.userId");
    	request.getSession().setAttribute("user", user);     //用Session保存用户名
     %>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
		  <div class="navbar-inner">
			<div class="container-fluid">
			  <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="brand" href="index.jsp">企业服务管理系统</a>
			  <div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
				  欢迎你 <a href="#" class="navbar-link"><%=request.getSession().getAttribute("user")%></a>
				</p>
				<ul class="nav">
				  <li class="active"><a href="#">主页</a></li>
				  <li><a href="#help">帮助</a></li>
				  <li><a href="#about">关于</a></li>
				  <li><a href="#contact">联系我们</a></li>
				</ul>
			  </div><!--/.nav-collapse -->
			</div>
		  </div>
		</div>

		<div class="container-fluid">
		  <div class="row-fluid">
			<div class="span3">
			  <div class="well sidebar-nav">
				<ul class="nav nav-list">
				  <li class="nav-header">服务管理</li>
				  <li><a onclick="gotoStatistic()">服务统计</a></li>
				  <li><a onclick="gotoAuditService()">审核服务</a></li>
				  <li><a onclick="gotoMaintain()">维护服务</a></li>
				  <li><a onclick="gotoConfig()">配置服务</a></li>
				  <li><a onclick="gotoEvaluate()">评价服务</a></li>
				  <li class="nav-header">权限管理</li>
				  <li><a href="#">审核权限</a></li>
				  <li><a onclick="gotoPermissionConfig()">配置权限</a></li>
				  <li class="nav-header">服务使用</li>
				  <li><a href="#">申请服务权限</a></li>
				  <li><a onclick="gotoServiceRequest()">注册服务</a></li>
				  <li class="nav-header">组织管理</li>
				  <li><a onclick="gotoUserManagement()">用户管理</a></li>
				  <li><a onclick="gotoRoleManagement()">角色管理</a></li>
				</ul>
			  </div><!--/.well -->
			</div><!--/span-->
			
			<div class="span9">
			  <iframe src="welcome.jsp" name="iframe" id="IF" width="100%" height="550" frameborder="no"  id="ifrid"   scrolling=""></iframe>
			</div><!--/span-->
		  </div><!--/row-->

		  <hr>

		  <footer>
			<p>&copy; 中山大学软件学院A304 2013</p>
		  </footer>

		</div><!--/.fluid-container-->
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script>
			function gotoStatistic()
			{
				document.getElementById("IF").src="statisticManagement.jsp";
			}
			function gotoServiceRequest()
			{
				document.getElementById("IF").src="ServiceRequest.jsp";
			}
			function gotoAuditService()
			{
				document.getElementById("IF").src="AuditWelcome.jsp";
			}
			function gotoUserManagement()
			{
				document.getElementById("IF").src="UserManagement.jsp";
			}
			function gotoRoleManagement()
			{
				document.getElementById("IF").src="RoleManagement.jsp";
			}
			function gotoConfig()
			{
				document.getElementById("IF").src="Config.jsp";
			}
			function gotoEvaluate()
			{
				document.getElementById("IF").src="ServiceEvaluate.jsp";
			}
			function gotoPermissionConfig()
			{
				document.getElementById("IF").src="PermissionConfig.jsp";
			}
			function gotoMaintain()
			{
				document.getElementById("IF").src="Maintain.jsp";
			}
		</script>
		
	</body>
</html>