<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
	<head>
		<title>Bootstrap Template</title>
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
	<body>
		<div class="container-fluid">
		  <div class="row-fluid">
			<div class="span9">
			  <div class="hero-unit">
				<!-- <h1></h1> -->
				<form class="form-search" action="searchService.action">
  					<input type="text" class="input-medium search-query" name="sch" id="sch">
  					<button type="submit" class="btn">Search</button>
				</form>
				<form name="form1" action="list.action" method="post">
					<div class="btn-group">
						<button class="btn">按类型分类</button>
						<button class="btn dropdown-toggle" data-toggle="dropdown">
						  <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
						  <li><a tabindex="-1" onclick="form1.action='getAllService.action';form1.submit()">全部</a> </li>
						  <li><a tabindex="-1" onclick="form1.action='getWebService.action';form1.submit()">WebService</a> </li>
						  <li class="disabled"><a tabindex="-1" href="#">本地应用</a></li>
						  <li><a tabindex="-1" onclick="form1.action='getURL.action';form1.submit()">Web应用</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button class="btn">按业务分类</button>
						<button class="btn dropdown-toggle" data-toggle="dropdown">
						  <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
						  <li><a tabindex="-1" href="#">Regular link</a></li>
						  <li class="disabled"><a tabindex="-1" href="#">Disabled link</a></li>
						  <li><a tabindex="-1" href="#">Another link</a></li>
						</ul>
					</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>服务编号</th>
							<th>服务名称</th>
							<th>服务类型</th>
							<th>服务级别</th>
							<th>服务最大负荷</th>
							<th>服务审核状态</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="services">
						<tr>
							<td><s:property value="serviceId"/></td>
							<td><s:property value="serviceName"/></td>
							<td><s:property value="serviceType"/></td>
							<td><s:property value="serviceLevel"/></td>
							<td><s:property value="maxLoad"/></td>
							<td><s:property value="serviceState"/></td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
				</form>
				
			  </div>
			</div><!--/span-->
		  </div><!--/row-->

		  <hr>

		</div><!--/.fluid-container-->
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="http://code.jquery.com/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>