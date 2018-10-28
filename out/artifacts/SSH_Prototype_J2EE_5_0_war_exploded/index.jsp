<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	/*String user = request.getParameter("user.userId");
	if(user == null)
	{
	}
	else
	{
		request.getSession().setAttribute("user", user);     //用Session保存用户名
	}*/

//String username = request.getParameter("user.userName");
//request.getSession().setAttribute("username",username);     //用Session保存用户名

%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title><s:text name="SystemName"></s:text> | <s:text name="HomePage"></s:text></title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

	<link href="media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="login.html">

				<!-- <img src="media/image/logo.png" alt="logo"/> -->
				<s:text name="SystemName"></s:text>

				</a>
				<input type="hidden" name="uname" value=<s:property value="username"/>>
				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">

					<!-- BEGIN NOTIFICATION DROPDOWN -->   

					<li class="dropdown" id="header_notification_bar">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<i class="icon-warning-sign"></i>

						<span class="badge">6</span>

						</a>

						<ul class="dropdown-menu extended notification">

							<li>

								<p>You have 14 new notifications</p>

							</li>

							<li>

								<a href="#">

								<span class="label label-success"><i class="icon-plus"></i></span>

								New user registered. 

								<span class="time">Just now</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="label label-important"><i class="icon-bolt"></i></span>

								Server #12 overloaded. 

								<span class="time">15 mins</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="label label-warning"><i class="icon-bell"></i></span>

								Server #2 not respoding.

								<span class="time">22 mins</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="label label-info"><i class="icon-bullhorn"></i></span>

								Application error.

								<span class="time">40 mins</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="label label-important"><i class="icon-bolt"></i></span>

								Database overloaded 68%. 

								<span class="time">2 hrs</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="label label-important"><i class="icon-bolt"></i></span>

								2 user IP blocked.

								<span class="time">5 hrs</span>

								</a>

							</li>

							<li class="external">

								<a href="#">See all notifications <i class="m-icon-swapright"></i></a>

							</li>

						</ul>

					</li>

					<!-- END NOTIFICATION DROPDOWN -->

					<!-- BEGIN INBOX DROPDOWN -->

					<li class="dropdown" id="header_inbox_bar">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<i class="icon-envelope"></i>

						<span class="badge">5</span>

						</a>

						<ul class="dropdown-menu extended inbox">

							<li>

								<p>You have 12 new messages</p>

							</li>

							<li>

								<a href="inbox.html?a=view">

								<span class="photo"><img src="media/image/avatar2.jpg" alt="" /></span>

								<span class="subject">

								<span class="from">Lisa Wong</span>

								<span class="time">Just Now</span>

								</span>

								<span class="message">

								Vivamus sed auctor nibh congue nibh. auctor nibh

								auctor nibh...

								</span>  

								</a>

							</li>

							<li>

								<a href="inbox.html?a=view">

								<span class="photo"><img src="./media/image/avatar3.jpg" alt="" /></span>

								<span class="subject">

								<span class="from">Richard Doe</span>

								<span class="time">16 mins</span>

								</span>

								<span class="message">

								Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh

								auctor nibh...

								</span>  

								</a>

							</li>

							<li>

								<a href="inbox.html?a=view">

								<span class="photo"><img src="./media/image/avatar1.jpg" alt="" /></span>

								<span class="subject">

								<span class="from">Bob Nilson</span>

								<span class="time">2 hrs</span>

								</span>

								<span class="message">

								Vivamus sed nibh auctor nibh congue nibh. auctor nibh

								auctor nibh...

								</span>  

								</a>

							</li>

							<li class="external">

								<a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>

							</li>

						</ul>

					</li>

					<!-- END INBOX DROPDOWN -->

					<!-- BEGIN TODO DROPDOWN -->

					<li class="dropdown" id="header_task_bar">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<i class="icon-tasks"></i>

						<span class="badge">5</span>

						</a>

						<ul class="dropdown-menu extended tasks">

							<li>

								<p>You have 12 pending tasks</p>

							</li>

							<li>

								<a href="#">

								<span class="task">

								<span class="desc">New release v1.2</span>

								<span class="percent">30%</span>

								</span>

								<span class="progress progress-success ">

								<span style="width: 30%;" class="bar"></span>

								</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="task">

								<span class="desc">Application deployment</span>

								<span class="percent">65%</span>

								</span>

								<span class="progress progress-danger progress-striped active">

								<span style="width: 65%;" class="bar"></span>

								</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="task">

								<span class="desc">Mobile app release</span>

								<span class="percent">98%</span>

								</span>

								<span class="progress progress-success">

								<span style="width: 98%;" class="bar"></span>

								</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="task">

								<span class="desc">Database migration</span>

								<span class="percent">10%</span>

								</span>

								<span class="progress progress-warning progress-striped">

								<span style="width: 10%;" class="bar"></span>

								</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="task">

								<span class="desc">Web server upgrade</span>

								<span class="percent">58%</span>

								</span>

								<span class="progress progress-info">

								<span style="width: 58%;" class="bar"></span>

								</span>

								</a>

							</li>

							<li>

								<a href="#">

								<span class="task">

								<span class="desc">Mobile development</span>

								<span class="percent">85%</span>

								</span>

								<span class="progress progress-success">

								<span style="width: 85%;" class="bar"></span>

								</span>

								</a>

							</li>

							<li class="external">

								<a href="#">See all tasks <i class="m-icon-swapright"></i></a>

							</li>

						</ul>

					</li>

					<!-- END TODO DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<img alt="" src="media/image/avatar1_small.jpg" />
						
						<span class="username"><%=request.getSession().getAttribute("user")%></span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">

							<li><a href="extra_profile.html"><i class="icon-user"></i> My Profile</a></li>

							<li><a href="page_calendar.html"><i class="icon-calendar"></i> My Calendar</a></li>

							<li><a href="inbox.html"><i class="icon-envelope"></i> My Inbox(3)</a></li>

							<li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>

							<li class="divider"></li>

							<li><a href="extra_lock.html"><i class="icon-lock"></i> Lock Screen</a></li>

							<li><a onclick="logout()"><i class="icon-key"></i> Log Out</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" ><s:text name="WebpageTemplate"></s:text></a></div>

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li>
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
					<form class="sidebar-search" id="form1">
						<input type="hidden" id="nowuser" name="nowuser" value="<%=request.getSession().getAttribute("user")%>">
						<input name="option3" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="option3">
						<div class="input-box">
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />
							<input type="button" class="submit" value=" " />
						</div>
					</form>
					<!-- END RESPONSIVE QUICK SEARCH FORM -->
				</li>
				<li class="start ">
					<a onclick="form1.action='dashboard.action'; form1.submit();">
					<i class="icon-home"></i> 
					<span class="title"><s:text name="HomePage"></s:text></span>
					<span class="selected"></span>
					</a>
				</li>
				<li class="active">
					<a href="javascript:;">
					<i class="icon-cogs"></i> 
					<span class="title"><s:text name="ServiceManagement"></s:text></span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a onclick="form1.action='getPicture.action'; form1.submit()"><s:text name="ServiceStatistics"></s:text></a>
						</li>
						<!-- <li >
							<a onclick="form1.action='getPicture.action';form1.submit()">
							服务关系</a>
						</li> -->
						<li >
							<a onclick="form1.action='serviceByType.action';form1.submit()"> 
							<s:text name="ServiceClassification"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='serviceQos.action';form1.submit()"><s:text name="ServiceQos"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='callRelation.action';form1.submit()"><s:text name="ServiceCallRelations"></s:text></a>
						</li>
						<li >
							<a name="byadmin" onclick="form1.action='auditService.action'; form1.submit();"><s:text name="ServiceAudit"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='myService.action'; form1.submit();"><s:text name="ServiceOperation"></s:text></a>
						</li>
						<li >
							<a name="byuser" onclick="form1.action='applyService.action'; form1.submit();"><s:text name="ServiceApply"></s:text></a>
						</li>
						<li >
							<a name="byadmin" onclick="form1.action='appService.action'; form1.submit();"><s:text name="ServiceApplyApproval"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='evaluateService.action'; form1.submit();"><s:text name="ServiceEvaluation"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='ServiceRequest.action'; form1.submit();"><s:text name="ServiceRegistration"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='removeService.action'; form1.submit();"><s:text name="ServiceRemoval"></s:text></a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-bookmark-empty"></i> 
					<span class="title"><s:text name="ServiceConfiguration"></s:text></span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a onclick="form1.action='AddLocalConfig.action'; form1.submit();"><s:text name="LicenseConfiguration"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='AddParameterJSP.action'; form1.submit();"><s:text name="ParameterConfiguration"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='AddOutputJSP.action'; form1.submit();"><s:text name="ResultConfiguration"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='ListConfigJSP.action'; form1.submit();"><s:text name="ViewConfiguration"></s:text></a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-table"></i> 
					<span class="title"><s:text name="ServiceInfoCrawling"></s:text></span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a onclick="form1.action='AddSiteJSP.action'; form1.submit();"><s:text name="AddCrawlingSite"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='listSite.action'; form1.submit();"><s:text name="ViewCrawlingSite"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='AddKeywordJSP.action'; form1.submit();"><s:text name="AddKeyword"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='listKey.action'; form1.submit();"><s:text name="ViewKeyword"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='listResult.action'; form1.submit();"><s:text name="ViewCrawlingResult"></s:text></a>
						</li>
					</ul>
				</li>
				

				<li>
					<a class="active" href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title"><s:text name="ServiceComposition"></s:text></span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
					    <li >
							<a onclick="form1.action='busyClass.action';form1.submit()"><s:text name="ServiceCompositionRelation"></s:text></a>
						</li>
						<li>
							<a onclick="form1.action='combineAService.action'; form1.submit();"><s:text name="ReliabilityCombination"></s:text></a>
						</li>

						<li>
							<a onclick="form1.action='combineBService.action'; form1.submit();"><s:text name="ApplicabilityCombination"></s:text></a>
						</li>
						<li>
							<a onclick="form1.action='combineCService.action'; form1.submit();"><s:text name="ProcessCombination"></s:text></a>
						</li>
					</ul>
				</li>

				<li name="byadmin" class="">
					<a href="javascript:;">
					<i class="icon-gift"></i> 
					<span class="title"><s:text name="PermissionConfiguration"></s:text></span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<!-- <li >
							<a onclick="form1.action='userAndRole.action'; form1.submit();">
							用户角色配置</a>
						</li> -->
						<li >
							<a onclick="form1.action='choosePermissionRole.action'; form1.submit();"><s:text name="RolePermissionConfiguration"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='choosePermissionService.action'; form1.submit();"><s:text name="PermissionServiceConfiguration"></s:text></a>
						</li>
						<li>
							<a onclick="form1.action='chooseRoleService.action'; form1.submit();"><s:text name="RoleServiceConfiguration"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='AddPermissionJSP.action'; form1.submit();"><s:text name="AddPermission"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='listPermission.action'; form1.submit();"><s:text name="ViewPermission"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='freRole.action'; form1.submit();"><s:text name="AddRole"></s:text></a>
						</li>
						<li >
							<a onclick="form1.action='listRole.action'; form1.submit();"><s:text name="ViewRole"></s:text></a>
						</li>
					</ul>
				</li>

				<!--<li name="byadmin" class="last ">
					<a href="javascript:;">
					<i class="icon-user"></i> 
					<span class="title">组织管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="AddUser.jsp">
							添加用户</a>
						</li>
						<li >
							<a onclick="form1.action='listUser.action'; form1.submit();">
							查看用户</a>
						</li>
						<li >
							<a onclick="form1.action='freRole.action'; form1.submit();">
							添加角色</a>
						</li>
						<li >
							<a onclick="form1.action='listRole.action'; form1.submit();">
							查看角色</a>
						</li>
					</ul>
				</li>-->
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>Widget Settings</h3>

				</div>

				<div class="modal-body">

					Widget settings form goes here

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="color-panel hidden-phone">
							
							<div class="color-mode-icons icon-color"></div>

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">

								
								
								<p>THEME COLOR</p>

								<ul class="inline">

									<li class="color-black current color-default" data-style="default"></li>

									<li class="color-blue" data-style="blue"></li>

									<li class="color-brown" data-style="brown"></li>

									<li class="color-purple" data-style="purple"></li>

									<li class="color-grey" data-style="grey"></li>

									<li class="color-white color-light" data-style="light"></li>

								</ul>

								<label>
								
									<span>Language</span>

									<select class="layout-option m-wrap small" id="language" onchange="changeLanguage()">

										<option >chinese</option>

										<option >english</option>

									</select>

								</label>
								
								<label>
								
									<span>Layout</span>

									<select class="layout-option m-wrap small">

										<option value="fluid" selected>Fluid</option>

										<option value="boxed">Boxed</option>

									</select>

								</label>

								<label>

									<span>Header</span>

									<select class="header-option m-wrap small">

										<option value="fixed" selected>Fixed</option>

										<option value="default">Default</option>

									</select>

								</label>

								<label>

									<span>Sidebar</span>

									<select class="sidebar-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

									</select>

								</label>

								<label>

									<span>Footer</span>

									<select class="footer-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

									</select>

								</label>

							</div>

						</div>

						<!-- END BEGIN STYLE CUSTOMIZER -->    

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="Dashboard"></s:text><small><s:text name="DashboardDescription"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="Dashboard"></s:text></a></li>

							<li class="pull-right no-text-shadow">

								<div id="dashboard-report-range" class="dashboard-date-range tooltips no-tooltip-on-touch-device responsive" data-tablet="" data-desktop="tooltips" data-placement="top" data-original-title="Change dashboard date range">

									<i class="icon-calendar"></i>

									<span></span>

									<i class="icon-angle-down"></i>

								</div>

							</li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<div id="dashboard">

					<!-- BEGIN DASHBOARD STATS -->

					<div class="row-fluid">
						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">
							<div class="dashboard-stat blue">
								<div class="visual">
									<i class="icon-comments"></i>
								</div>

								<div class="details">
									<div class="number">
										<s:property value="serviceNum"/>
									</div>
									<div class="desc">                           
										Service Amount
									</div>
								</div>
								<a class="more" href="#">
								View more <i class="m-icon-swapright m-icon-white"></i>
								</a>                 
							</div>
						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">
							<div class="dashboard-stat green">
								<div class="visual">
									<i class="icon-shopping-cart"></i>
								</div>
								<div class="details">
									<div class="number"><s:property value="userNum"/></div>
									<div class="desc">User Amount</div>
								</div>
								<a class="more" href="#">
								View more <i class="m-icon-swapright m-icon-white"></i>
								</a>                 
							</div>
						</div>

						<div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">
							<div class="dashboard-stat purple">
								<div class="visual">
									<i class="icon-globe"></i>
								</div>
								<div class="details">
									<div class="number"><s:property value="roleNum"/></div>
									<div class="desc">Role Amount</div>
								</div>
								<a class="more" href="#">
								View more <i class="m-icon-swapright m-icon-white"></i>
								</a>                 
							</div>
						</div>

						<div class="span3 responsive" data-tablet="span6" data-desktop="span3">
							<div class="dashboard-stat yellow">
								<div class="visual">
									<i class="icon-bar-chart"></i>
								</div>
								<div class="details">
									<div class="number"><s:property value="runTime"/></div>
									<div class="desc">Run Times</div>
								</div>
								<a class="more" href="#">
								View more <i class="m-icon-swapright m-icon-white"></i>
								</a>                 
							</div>
						</div>
					</div>

					<!-- END DASHBOARD STATS -->

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

									<div class="caption"><i class="icon-bar-chart"></i>Site Visits</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn mini">Users</a>

											<a href="" class="btn mini active">Feedbacks</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_statistics_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_statistics_content" class="hide">

										<div id="site_statistics" class="chart"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet solid light-grey bordered">

								<div class="portlet-title">

									<div class="caption"><i class="icon-bullhorn"></i>Activities</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn blue mini active">Users</a>

											<a href="" class="btn blue mini">Orders</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="site_activities_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="site_activities_content" class="hide">

										<div id="site_activities" style="height:100px;"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

							<!-- BEGIN PORTLET-->

							<div class="portlet solid bordered light-grey">

								<div class="portlet-title">

									<div class="caption"><i class="icon-signal"></i>Server Load</div>

									<div class="tools">

										<div class="btn-group pull-right" data-toggle="buttons-radio">

											<a href="" class="btn red mini active">

											<span class="hidden-phone">Database</span>

											<span class="visible-phone">DB</span></a>

											<a href="" class="btn red mini">Web</a>

										</div>

									</div>

								</div>

								<div class="portlet-body">

									<div id="load_statistics_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="load_statistics_content" class="hide">

										<div id="load_statistics" style="height:108px;"></div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

					</div>

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<div class="portlet box purple">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>General Stats</div>

									<div class="actions">

										<a href="javascript:;" class="btn yellow easy-pie-chart-reload"><i class="icon-repeat"></i> Reload</a>

									</div>

								</div>

								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number transactions"  data-percent="55"><span>+55</span>%</div>

												<a class="title" href="#">Transactions <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number visits"  data-percent="85"><span>+85</span>%</div>

												<a class="title" href="#">New Visits <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="easy-pie-chart">

												<div class="number bounce"  data-percent="46"><span>-46</span>%</div>

												<a class="title" href="#">Bounce <i class="m-icon-swapright"></i></a>

											</div>

										</div>

									</div>

								</div>

							</div>

						</div>

						<div class="span6">

							<div class="portlet box blue">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>Server Stats</div>

									<div class="tools">

										<a href="" class="collapse"></a>

										<a href="#portlet-config" data-toggle="modal" class="config"></a>

										<a href="" class="reload"></a>

										<a href="" class="remove"></a>

									</div>

								</div>

								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span4">

											<div class="sparkline-chart">

												<div class="number" id="sparkline_bar"></div>

												<a class="title" href="#">Network <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="sparkline-chart">

												<div class="number" id="sparkline_bar2"></div>

												<a class="title" href="#">CPU Load <i class="m-icon-swapright"></i></a>

											</div>

										</div>

										<div class="margin-bottom-10 visible-phone"></div>

										<div class="span4">

											<div class="sparkline-chart">

												<div class="number" id="sparkline_line"></div>

												<a class="title" href="#">Load Rate <i class="m-icon-swapright"></i></a>

											</div>

										</div>

									</div>

								</div>

							</div>

						</div>

					</div>

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<!-- BEGIN REGIONAL STATS PORTLET-->

							<div class="portlet">

								<div class="portlet-title">

									<div class="caption"><i class="icon-globe"></i>Regional Stats</div>

									<div class="tools">

										<a href="" class="collapse"></a>

										<a href="#portlet-config" data-toggle="modal" class="config"></a>

										<a href="" class="reload"></a>

										<a href="" class="remove"></a>

									</div>

								</div>

								<div class="portlet-body">

									<div id="region_statistics_loading">

										<img src="media/image/loading.gif" alt="loading" />

									</div>

									<div id="region_statistics_content" class="hide">

										<div class="btn-toolbar">

											<div class="btn-group " data-toggle="buttons-radio">

												<a href="" class="btn mini active">Users</a>

												<a href="" class="btn mini">Orders</a> 

											</div>

											<div class="btn-group pull-right">

												<a href="" class="btn mini dropdown-toggle" data-toggle="dropdown">

												Select Region <span class="icon-angle-down"></span>

												</a>

												<ul class="dropdown-menu pull-right">

													<li><a href="javascript:;" id="regional_stat_world">World</a></li>

													<li><a href="javascript:;" id="regional_stat_usa">USA</a></li>

													<li><a href="javascript:;" id="regional_stat_europe">Europe</a></li>

													<li><a href="javascript:;" id="regional_stat_russia">Russia</a></li>

													<li><a href="javascript:;" id="regional_stat_germany">Germany</a></li>

												</ul>

											</div>

										</div>

										<div id="vmap_world" class="vmaps chart hide"></div>

										<div id="vmap_usa" class="vmaps chart hide"></div>

										<div id="vmap_europe" class="vmaps chart hide"></div>

										<div id="vmap_russia" class="vmaps chart hide"></div>

										<div id="vmap_germany" class="vmaps chart hide"></div>

									</div>

								</div>

							</div>

							<!-- END REGIONAL STATS PORTLET-->

						</div>

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet paddingless">

								<div class="portlet-title line">

									<div class="caption"><i class="icon-bell"></i>Feeds</div>

									<div class="tools">

										<a href="" class="collapse"></a>

										<a href="#portlet-config" data-toggle="modal" class="config"></a>

										<a href="" class="reload"></a>

										<a href="" class="remove"></a>

									</div>

								</div>

								<div class="portlet-body">

									<!--BEGIN TABS-->

									<div class="tabbable tabbable-custom">

										<ul class="nav nav-tabs">

											<li class="active"><a href="#tab_1_1" data-toggle="tab">System</a></li>

											<li><a href="#tab_1_2" data-toggle="tab">Activities</a></li>

											<li><a href="#tab_1_3" data-toggle="tab">Recent Users</a></li>

										</ul>

										<div class="tab-content">

											<div class="tab-pane active" id="tab_1_1">

												<div class="scroller" data-height="290px" data-always-visible="1" data-rail-visible="0">

													<ul class="feeds">

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-success">                        

																			<i class="icon-bell"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			You have 4 pending tasks.

																			<span class="label label-important label-mini">

																			Take action 

																			<i class="icon-share-alt"></i>

																			</span>

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	Just now

																</div>

															</div>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New version v1.4 just lunched!   

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		20 mins

																	</div>

																</div>

															</a>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-important">                      

																			<i class="icon-bolt"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			Database server #12 overloaded. Please fix the issue.                      

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	24 mins

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-info">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	30 mins

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-success">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	40 mins

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-warning">                        

																			<i class="icon-plus"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New user registered.                

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	1.5 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-success">                        

																			<i class="icon-bell-alt"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			Web server hardware needs to be upgraded. 

																			<span class="label label-inverse label-mini">Overdue</span>             

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	2 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label">                       

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	3 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-warning">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	5 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-info">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	18 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label">                       

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	21 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-info">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	22 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label">                       

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	21 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-info">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	22 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label">                       

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	21 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-info">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	22 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label">                       

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	21 hours

																</div>

															</div>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-info">                        

																			<i class="icon-bullhorn"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			New order received. Please take care of it.                 

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	22 hours

																</div>

															</div>

														</li>

													</ul>

												</div>

											</div>

											<div class="tab-pane" id="tab_1_2">

												<div class="scroller" data-height="290px" data-always-visible="1" data-rail-visible1="1">

													<ul class="feeds">

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New order received 

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		10 mins

																	</div>

																</div>

															</a>

														</li>

														<li>

															<div class="col1">

																<div class="cont">

																	<div class="cont-col1">

																		<div class="label label-important">                      

																			<i class="icon-bolt"></i>

																		</div>

																	</div>

																	<div class="cont-col2">

																		<div class="desc">

																			Order #24DOP4 has been rejected.    

																			<span class="label label-important label-mini">Take action <i class="icon-share-alt"></i></span>

																		</div>

																	</div>

																</div>

															</div>

															<div class="col2">

																<div class="date">

																	24 mins

																</div>

															</div>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

														<li>

															<a href="#">

																<div class="col1">

																	<div class="cont">

																		<div class="cont-col1">

																			<div class="label label-success">                        

																				<i class="icon-bell"></i>

																			</div>

																		</div>

																		<div class="cont-col2">

																			<div class="desc">

																				New user registered

																			</div>

																		</div>

																	</div>

																</div>

																<div class="col2">

																	<div class="date">

																		Just now

																	</div>

																</div>

															</a>

														</li>

													</ul>

												</div>

											</div>

											<div class="tab-pane" id="tab_1_3">

												<div class="scroller" data-height="290px" data-always-visible="1" data-rail-visible1="1">

													<div class="row-fluid">

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Robert Nilson</a> 

																	<span class="label label-success">Approved</span>

																</div>

																<div>29 Jan 2013 10:45AM</div>

															</div>

														</div>

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Lisa Miller</a> 

																	<span class="label label-info">Pending</span>

																</div>

																<div>19 Jan 2013 10:45AM</div>

															</div>

														</div>

													</div>

													<div class="row-fluid">

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Eric Kim</a> 

																	<span class="label label-info">Pending</span>

																</div>

																<div>19 Jan 2013 12:45PM</div>

															</div>

														</div>

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Lisa Miller</a> 

																	<span class="label label-important">In progress</span>

																</div>

																<div>19 Jan 2013 11:55PM</div>

															</div>

														</div>

													</div>

													<div class="row-fluid">

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Eric Kim</a> 

																	<span class="label label-info">Pending</span>

																</div>

																<div>19 Jan 2013 12:45PM</div>

															</div>

														</div>

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Lisa Miller</a> 

																	<span class="label label-important">In progress</span>

																</div>

																<div>19 Jan 2013 11:55PM</div>

															</div>

														</div>

													</div>

													<div class="row-fluid">

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div><a href="#">Eric Kim</a> <span class="label label-info">Pending</span>

																</div>

																<div>19 Jan 2013 12:45PM</div>

															</div>

														</div>

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Lisa Miller</a> 

																	<span class="label label-important">In progress</span>

																</div>

																<div>19 Jan 2013 11:55PM</div>

															</div>

														</div>

													</div>

													<div class="row-fluid">

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div><a href="#">Eric Kim</a> <span class="label label-info">Pending</span>

																</div>

																<div>19 Jan 2013 12:45PM</div>

															</div>

														</div>

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Lisa Miller</a> 

																	<span class="label label-important">In progress</span>

																</div>

																<div>19 Jan 2013 11:55PM</div>

															</div>

														</div>

													</div>

													<div class="row-fluid">

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Eric Kim</a> 

																	<span class="label label-info">Pending</span>

																</div>

																<div>19 Jan 2013 12:45PM</div>

															</div>

														</div>

														<div class="span6 user-info">

															<img alt="" src="media/image/avatar.png" />

															<div class="details">

																<div>

																	<a href="#">Lisa Miller</a> 

																	<span class="label label-important">In progress</span>

																</div>

																<div>19 Jan 2013 11:55PM</div>

															</div>

														</div>

													</div>

												</div>

											</div>

										</div>

									</div>

									<!--END TABS-->

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

					</div>

					<div class="clearfix"></div>

					<div class="row-fluid">

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet box blue calendar">

								<div class="portlet-title">

									<div class="caption"><i class="icon-calendar"></i>Calendar</div>

								</div>

								<div class="portlet-body light-grey">

									<div id="calendar">

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

						<div class="span6">

							<!-- BEGIN PORTLET-->

							<div class="portlet">

								<div class="portlet-title line">

									<div class="caption"><i class="icon-comments"></i>Chats</div>

									<div class="tools">

										<a href="" class="collapse"></a>

										<a href="#portlet-config" data-toggle="modal" class="config"></a>

										<a href="" class="reload"></a>

										<a href="" class="remove"></a>

									</div>

								</div>

								<div class="portlet-body" id="chats">

									<div class="scroller" data-height="435px" data-always-visible="1" data-rail-visible1="1">

										<ul class="chats">

											<li class="in">

												<img class="avatar" alt="" src="media/image/avatar1.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Bob Nilson</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="out">

												<img class="avatar" alt="" src="media/image/avatar2.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Lisa Wong</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="in">

												<img class="avatar" alt="" src="media/image/avatar1.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Bob Nilson</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="out">

												<img class="avatar" alt="" src="media/image/avatar3.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Richard Doe</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="in">

												<img class="avatar" alt="" src="media/image/avatar3.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Richard Doe</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="out">

												<img class="avatar" alt="" src="media/image/avatar1.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Bob Nilson</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="in">

												<img class="avatar" alt="" src="media/image/avatar3.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Richard Doe</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, 

													sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.

													</span>

												</div>

											</li>

											<li class="out">

												<img class="avatar" alt="" src="media/image/avatar1.jpg" />

												<div class="message">

													<span class="arrow"></span>

													<a href="#" class="name">Bob Nilson</a>

													<span class="datetime">at Jul 25, 2012 11:09</span>

													<span class="body">

													Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. sed diam nonummy nibh euismod tincidunt ut laoreet.

													</span>

												</div>

											</li>

										</ul>

									</div>

									<div class="chat-form">

										<div class="input-cont">   

											<input class="m-wrap" type="text" placeholder="Type a message here..." />

										</div>

										<div class="btn-cont"> 

											<span class="arrow"></span>

											<a href="" class="btn blue icn-only"><i class="icon-ok icon-white"></i></a>

										</div>

									</div>

								</div>

							</div>

							<!-- END PORTLET-->

						</div>

					</div>

				</div>

			</div>

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2013 &copy;  <s:text name="SchoolName"></s:text>

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>
		
		<input name="userid" type="hidden" value=<%=request.getSession().getAttribute("user")%> id="userid">
		<input name="admin" type="hidden" value=<%=request.getSession().getAttribute("admin")%> id="admin">
		<input name="language" type="hidden" value=<%=request.getSession().getAttribute("language")%> id="getLanguage">
	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="media/js/date.js" type="text/javascript"></script>

	<script src="media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js" type="text/javascript"></script>

	<script src="media/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		   Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts();

		   Index.initDashboardDaterange();

		   Index.initIntro();
		   
		   checkuser();
		   
		   if(document.getElementById("getLanguage").value != "null"){
		  	    var language = document.getElementById("getLanguage").value;
		   		document.getElementById("language").value = language.toLowerCase();
		   }
		   else{
		   	   document.getElementById("language").value = "chinese";
		   }
		   
		   if(getCookie("item") != null){
		   	   var menu = $(".sub-menu").parent();
				for(var i=0;i<menu.size();i++)
				{
					menu.eq(i).removeClass("active");
				}
				
			   $(".sub-menu li a").each(function(){
			       if($(this).text() == getCookie("item")){
			       		var li = $(this).parent();
			       		li.parent().parent().addClass("active");
			       		li.addClass("active");
			       		return;
			       }
			   });
		   }

		});
		
		function checkuser(){
			var userid = document.getElementById("userid").value;
			var admin = document.getElementById("admin").value;
			
			//alert(userid);
			if(userid == "null"){    //没有登录
				window.location = "http://localhost:8080/SSH_Prototype_J2EE_5.0/error.jsp";
			}
			if(admin != "true"){
			//if(userid != "0"){    //不是管理员
				var hideobjs = document.getElementsByName("byadmin");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
			else{
				var hideobjs = document.getElementsByName("byuser");
				for(var i=0; i<hideobjs.length; i++){
					hideobjs[i].style="display:none";
				}
			}
		}
		
		function logout(){
			delCookie("item");
		
			$.ajax({
				url		:	"logout.action",
				type	:	"post",
				dataType:	"json",
				async:  false,
				success	: function(result){
					//alert(result);
					if(result == "success"){
						window.location = "/SSH_Prototype_J2EE_5.0";
					}else if(result == "error"){
						window.location = "/SSH_Prototype_J2EE_5.0/error.jsp";
					}
				
				},
				error : function (XMLHttpRequest, textStatus, errorThrown) {
					 // 通常情况下textStatus和errorThown只有其中一个有值 
			        alert(errorThrown);
	         	}
			});
		}
		
		
		function changeLanguage(){
			var languageobj = document.getElementById("language");
			var languageindex = languageobj.selectedIndex;
			var language = languageobj.options[languageindex].value;
			 $.ajax({
			 	url: "language.action",
			 	type: "post",
			 	async: false,
			 	dataType: "json",
			 	data: {"language":language},
			 	success: function(result){
			 		if(result == "error"){
			 			alert(result);
			 		}
			 		location.reload(true);
			 	},
			 	error : function (XMLHttpRequest, textStatus, errorThrown) {
			         // 通常情况下textStatus和errorThown只有其中一个有值 
			         
			        var error=errorThrown;
			        alert(XMLHttpRequest+textStatus+error);
		         }
			 });
		}
		
		var display = false;
		
		var menu = $(".sub-menu").parent();
		menu.click(function(){
			for(var i=0;i<menu.size();i++)
			{
				menu.eq(i).removeClass("active");
			}
			$(this).addClass("active");
			//$(this).children("ul").toggle();
				
		    if(display){
		       $(this).children("ul").css("display", "none");
		       display = false;
		    }
		    else {
		         $(this).children("ul").css("display", "");
		        display = true;
		    }
		});
		
		
		$(".sub-menu li a").click(function(){
			var item = $(this).text();
			document.cookie="item=" + item;
		});
		
		
		function getCookie(objname){//获取指定名称的cookie的值
			var arrstr = document.cookie.split("; ");
			for(var i = 0; i < arrstr.length; i++){
				var temp = arrstr[i].split("=");
				if(temp[0] == objname){
					return unescape(temp[1]);
				}
			}
		}
		
		///删除cookie
		function delCookie (NameOfCookie)
		{
			 // 该函数检查下cookie是否设置，如果设置了则将过期时间调到过去的时间;
			 //剩下就交给操作系统适当时间清理cookie啦
			 if (getCookie(NameOfCookie))
			 {
			 	document.cookie = NameOfCookie + "=" + "; expires=Thu, 01-Jan-70 00:00:01 GMT";
			 }
		}

	</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>