<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  	<title><s:text name="SystemName"></s:text> | <s:text name="RoleServiceConfiguration"></s:text></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script src="media/js/jquery-1.10.2.js"></script>
      <script src="media/js/jquery.dataTables.js"></script>
     <script src="media/js/bootstrap.min.js"></script>
  </head>
  
  <body> 
   <div >
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

						<s:text name="RoleServiceConfiguration"></s:text> <small><s:text name="RoleServiceConfiguration.Description"></s:text></small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li>

								<a href="#"><s:text name="PermissionConfiguration"></s:text></a>

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#"><s:text name="RoleServiceConfiguration"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

	</div>
	
		          <!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-globe"></i><s:text name="RoleServiceConfiguration.List"></s:text></div>
							</div>
							<!-- BEGIN portlet body -->
								<div class="portlet-body">
									<table class="table table-bordered  table-full-width" id="table_id">
										<thead>
											<tr>
											<th>rssId</th>
											<th>roleId</th>
											<th>roleName</th>
											<th >roleDesc</th>
											<th >serviceId</th>
											<th >serviceName</th>
											<th >serviceType</th>
											<th >serviceLevel</th>
											<th >serviceDesc</th>
											<th>delete</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
									<div class="container-fluid">
									<form >
										<div class="control-group">
									    	<label class="control-label" for="inputRoleName"><s:text name="RoleName"></s:text></label>
										    	<div class="controls">
										    		<select id="roles">  
												      <s:iterator value="roles" status="L" var="roles">
														<option><s:property value="roleName"/></option>
													  </s:iterator>
												    </select>
										    		<input type="hidden" id="inputRoleName" name="roleName" placeholder="UserName">
										    	</div>
									  	</div>
									  	<div class="control-group">
									    	<label class="control-label" for="inputServiceName"><s:text name="ServiceName"></s:text></label>
									    		<div class="controls">
									    		    <select id="services">  
												      <s:iterator value="services" status="L" var="services">
														<option><s:property value="serviceName"/></option>
													  </s:iterator>
												    </select>
									      			<input type="hidden" id="inputServiceName" name="serviceName" placeholder="ServiceName">
									    		</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
									  	</div>
									  	<div class="form-actions">
											<button type="button" class="btn btn-primary" onclick="add();"><s:text name="Submit"></s:text></button>
											<button type="reset" class="btn"><s:text name="Clear"></s:text></button>
									  	</div>
									  </form>
									</div>
							</div>	
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->
	<script type="text/javascript">
	var RoleSpecSerJson;
	function  loadRoleSpecSer(){
		$.ajax({
			url		:	"loadRoleSpecSer.action",
			type	:	"post",
			dataType:	"json",
			async:  false,
			success	: function(RoleSpecSerString){
			RoleSpecSerJson=JSON.parse(RoleSpecSerString);
			},
			error : function (XMLHttpRequest, textStatus, errorThrown) {
         // 通常情况下textStatus和errorThown只有其中一个有值 
     
        alert( errorThrown);
         }
		});
	}
	
   function updateTable(){
  $("#table_id").DataTable({
				data: RoleSpecSerJson ,
				 columns: [
		{ data: 'rssId' },
      	{ data: 'roleId' },
        { data: 'roleName' },
        { data: 'roleDesc' },
        { data: 'serviceId' },
        { data: 'serviceName' },
        { data: 'serviceType' },
        { data: 'serviceLevel' },
        { data: 'serviceDesc' },
        { data: null }
				],
	    "aoColumnDefs": [ { "bVisible": false, "aTargets": [ 0 ] },
	    				  { "bSortable": false, "aTargets": [ 9 ] }	
	    				] ,
		"fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(8)', nRow).html("<button class='btn btn-primary' onclick='deleteRoleSpecSer(\""+ aData.rssId+"\",\""+ aData.roleId+"\",\""+ aData.serviceId+"\")'>Delete</button>");
			return nRow;
		}/*,
		"language": {
                 "lengthMenu": "每页 _MENU_ 条记录",
                 "zeroRecords": "没有找到记录",
                 "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                 "infoEmpty": "无记录",
                 "infoFiltered": "(从 _MAX_ 条记录过滤)"
             }*/
         
			   });
	}
function deleteRoleSpecSer(rssId,roleId,serviceId){
		$.ajax({
			    url: "deleteRoleSpecSer.action",
			    type: "post",
			    async: false,
			    data: {"rssId":rssId,"roleId":roleId,"serviceId":serviceId},
			    dataType: "json",
			    success: function(RoleSpecSerString){
			    	location.reload(true);
			    	//loadRoleSpecSer();
			    	//updateTable();
			    }
			    
		});
		//location.reload(true);
}

function add(){
		var servicenameobj = document.getElementById("services");
		var servicenameindex = servicenameobj.selectedIndex;
		var servicenamevalue = servicenameobj.options[servicenameindex].value;
		document.getElementById("inputServiceName").value = servicenamevalue;
		
		var rolenameobj = document.getElementById("roles");
		var rolenameindex = rolenameobj.selectedIndex;
		var rolenamevalue = rolenameobj.options[rolenameindex].value;
		document.getElementById("inputRoleName").value = rolenamevalue;


		var roleName=document.getElementById("inputRoleName").value.toString();
		var serviceName=document.getElementById("inputServiceName").value.toString();
		if((roleName!="")&&(serviceName!="")){
			addRoleService(roleName,serviceName);
			//location.reload(true);
		}else{
			alert("角色名或服务名不能为空！");
		}
}

function addRoleService(roleName,serviceName){
	$.ajax({
				url: "addRoleService.action",
				type: "post",
			dataType: "json",
			    async:false,
				data: {"roleName":roleName,"serviceName":serviceName},
				success: function(RoleSpecSerString){
					location.reload(true);
					//loadRoleSpecSer();
			    	//updateTable();
				}
			});
}
		
	jQuery(document).ready(function() {   
		checkuser();
	
	    
		   // initiate layout and plugins
		  loadRoleSpecSer();
		  updateTable();
		  $('#table_id tbody').on( 'click', 'tr', function () {
		        $(this).toggleClass('selected');
		        //$('tr td checkebox').attr('checked').value="checked";
		    } );
		   
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
  
</html>
