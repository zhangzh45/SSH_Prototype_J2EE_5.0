<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>企业服务管理系统 | 添加用户</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

	

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							添加用户 <small>新建新的用户</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#">组织管理</a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">添加用户</a></li>

						</ul>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<!-- END EXAMPLE TABLE PORTLET-->

						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<form name="form2" action="addUser.action" method="post">
							<div class="portlet box blue">
								<div class="portlet-title">
									添加角色
								</div>
								<div class="portlet-body">
									<div class="container-fluid">
										
										  <div class="control-group">
										    <label class="control-label" for="inputUserName">姓名</label>
										    <div class="controls">
										      <input type="text" id="inputUserName" name="user.userName" placeholder="UserName">
										    </div>
										  </div>
										  <div class="control-group">
										    <label class="control-label" for="inputPassword">密码</label>
										    <div class="controls">
										      <input type="text" id="inputPassword" name="user.password" placeholder="Password">
										    </div>
										  </div>
										  <div class="control-group">
										    <label class="control-label" for="inputUserDesc">用户描述</label>
										    <div class="controls">
										      <input type="text" id="inputUserDesc" name="user.userDesc" placeholder="UserDesc">
										    </div>
										  </div>
										  <div class="control-group">
										    <label class="control-label" for="inputAddress">居住地址</label>
										    <div class="controls">
										      <input type="text" id="inputAddress" name="user.address" placeholder="Address">
										    </div>
										  </div>
										  <div class="control-group">
										    <label class="control-label" for="inputUserType">用户类型</label>
										    <div class="controls">
										      <select name="opt1" id="opt1">
												  <option>CommonUser</option>
												  <option>ServiceAdministrator</option>
												  <option>PermissionAdministrator</option>
												  <option>OrganizationAdministrator</option>
										      </select>
										    </div>
										  </div>
										  <div class="form-actions">
											  <button type="button" class="btn btn-primary" onclick="changeValue(); form2.action='addUser.action'; form2.submit();" >提交</button>
											  <button type="button" class="btn">清空</button>
											  <input name="option1" type="hidden" value="" id="option1">
											  <input name="option2" type="hidden" value="" id="option2">
										 </div>
									</div>
								</div>
							</div>
						</form>
						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

    

	<script>
		jQuery(document).ready(function() {       
		 
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
	
		function changeValue()
		{
			var selectIndex1 = document.getElementById("opt1").selectedIndex;
			document.getElementById("option1").value = document.getElementById("opt1").options[selectIndex1].text;
		}
		
	</script>

</body>

<!-- END BODY -->

</html>