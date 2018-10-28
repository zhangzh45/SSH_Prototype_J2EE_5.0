<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->
<%  
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<head>
  <base href="<%=basePath%>">
	 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta   http-equiv="Expires"   CONTENT="0">     
	<meta   http-equiv="Cache-Control"   CONTENT="no-cache">     
	<meta   http-equiv="Pragma"   CONTENT="no-cache">      
	<title><s:text name="SystemName"></s:text> | <s:text name="ServiceApplyApproval"></s:text></title>
	 
	<link rel="stylesheet" type="text/css" href="media/css/jquery.dataTables.css">
	<link rel="stylesheet" href="media/css/bootstrap.min.css">
	 <script src="media/js/jquery-1.10.2.js"></script>
      <script src="media/js/jquery.dataTables.js"></script>
     <script src="media/js/bootstrap.min.js"></script>
	
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body >

	

	<!-- BEGIN CONTAINER -->

	<div >

	

		<!-- BEGIN PAGE -->

		<div >

			

			<!-- BEGIN PAGE CONTAINER-->        

			<div >

				<!-- BEGIN PAGE HEADER-->

				<div >

					<div >

					

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<s:text name="ServiceApplyApproval"></s:text><small><s:text name="ServiceApplyApproval.Description"></s:text></small>

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

							<li><a href="#"><s:text name="ServiceApplyApproval"></s:text></a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

					

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i><s:text name="ServiceList"></s:text></div>

							</div>

							<div class="portlet-body">
							<%
							String submitToken = "1";
  							
							 %>
								<form  method="post" id="add_reject_form">
								<table class="table table-bordered  table-full-width" id="table_id">

									<thead>
										 <tr>
										 	<th><input type="checkbox" name="myBox" id="chkAll" value="0" onclick="selectAll();"/></th>
											<th>tempId</th>
											<th>userId</th>
											<!--<th>applyId</th>
											<th>applyName</th>
											<th >applyType</th>  -->
											<th >serviceId</th>
											<th >serviceName</th>
											<th >serviceType</th>
											<th >serviceDesc</th>
											<th >serviceLevel</th>
											<th>select</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								  <div class="form-actions" >
											  <button type="button" class="btn btn-primary" value="submit"  id="agree_submit" onclick="agreeAll();">Accept</button>
											  <button type="button" class="btn btn-primary" value="reject" id= "reject_submit" onclick="rejectAll();" >Refuse</button>
								 			  <input name="submitToken" value="<%=submitToken%>" type="hidden" id="submitToken"/>
								 </div>
								 </form>
							</div>

						</div>
					

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->




	<script>
	var applyJson;
	function loadApply(){
		$.ajax({
			url		:	"approveService.action",
			type	:	"post",
			dataType:	"json",
			async:  false,
			success	: function(applyString){
			//alert(applyString);
			applyJson=JSON.parse(applyString);
			
			},
			error : function (XMLHttpRequest, textStatus, errorThrown) {

         // 通常情况下textStatus和errorThown只有其中一个有值 
        applyJson=errorThrown;
        alert(applyJson);
         }
		});
		}
		
	
	
	function updateTable(){
		$("#table_id").DataTable({
				data: applyJson,
				 columns: [
		{data: null},
		{data: 'tempId'},
		{ data: 'userId' },
        /*{ data: 'applyId' },
        { data: 'applyName' },
        { data: 'applyType' },*/
        { data: 'serviceId' },
        { data: 'serviceName' },
        { data: 'serviceType' },
        { data: 'serviceDesc' },
        { data: 'serviceLevel' },
        { data: null }
				],
	    "aoColumnDefs": [ { "bVisible": false, "aTargets": [ 1 ] },
	    				  { "bSortable": false, "aTargets": [ 0 ] },
	    				  { "bSortable": false, "aTargets": [ 8 ] }
	    					
	    				] ,
		"fnRowCallback": function( nRow, aData, iDisplayIndex ) {
			 	$('td:eq(0)', nRow).html("<td><input type='checkbox' name='myBox' id='subcheck' value=\""+aData.tempId+"\"  onclick='setSelectAll();' /></td>");
				$('td:eq(8)', nRow).html("<button class='btn btn-primary' onclick='agree(\""+ aData.tempId+"\",\""+ aData.userId+"\",\""+ aData.serviceId+"\")'>Approve</button>"+
				"<button class='btn  btn-primary' onclick='disagree(\""+ aData.tempId+"\",\""+ aData.userId+"\",\""+ aData.serviceId+"\")'>Reject&nbsp;&nbsp;&nbsp;&nbsp;</button>" );
				
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
	
function agree(tempId,userId,serviceId){
		$.ajax({
			url: "agree.action",
			type: "post",
			async: false,
			data: {"tempId":tempId,"userId":userId,"serviceId":serviceId},
			dataType: "json",
			success: function(){
			location.reload(true);
				//loadApply();
				//updateTable();
			
			},
			error : function (XMLHttpRequest, textStatus, errorThrown) {

         // 通常情况下textStatus和errorThown只有其中一个有值 
        var error=errorThrown;
        alert(error);
         }
			
		});
		
	}
	
function disagree(tempId,userId,serviceId){
	 $.ajax({
	 	url: "disagree.action",
	 	type: "post",
	 	async: false,
	 	dataType: "json",
	 	data: {"tempId":tempId,"userId":userId,"serviceId":serviceId},
	 	success: function(){
	 	location.reload(true);
	 		//loadApply();
			//updateTable();
	 	},
	 	error : function (XMLHttpRequest, textStatus, errorThrown) {
         // 通常情况下textStatus和errorThown只有其中一个有值 
         
        var error=errorThrown;
        alert(XMLHttpRequest+textStatus+error);
   
         }
	 });
}
	
function selectAll(){  
	 $("#submitToken").attr("value","0");
    if ($("#chkAll").attr("checked")) {  
    	$("#uniform-subcheck span").attr("class","checked");
        $(":checkbox").attr("checked", true);  
    } else {  
        $("#uniform-subcheck span").attr("class",null);
        $(":checkbox").attr("checked", false);  
    }  
   }  
	
	//子复选框的事件  
function setSelectAll(){  
    //当没有选中某个子复选框时，SelectAll取消选中  
    $("#submitToken").attr("value","0");
    if (!$("#subcheck").checked) {  
        $("#chkAll").attr("checked", false);  
        $("#uniform-chkAll span").attr("class",null);
    }  
    var chsub = $("input[type='checkbox'][id='subcheck']").length; //获取subcheck的个数  
    var checkedsub = $("input[type='checkbox'][id='subcheck']:checked").length; //获取选中的subcheck的个数  
    if (checkedsub == chsub) {  
        $("#chkAll").attr("checked", true);
          $("#uniform-chkAll span").attr("class","checked");
    }  
}  


 function agreeAll(){
 var checknum=$("input[type='checkbox'][id='subcheck']:checked").length;
	if(checknum){
		//alert("确定提交？");
		if(confirm("确定添加？")){
			
			$("#add_reject_form").attr("action","addAll");
			$("#add_reject_form").submit();
			
		}
	}else{
		alert("请先选择！");
	}

}

function rejectAll(){
var checknum=$("input[type='checkbox'][id='subcheck']:checked").length;
	if(checknum){
		if(confirm("确认拒绝？")){
			$("#add_reject_form").attr("action","rejectAll");
			$("#add_reject_form").submit();
		}
	}else{
		alert("请先选择！");
	}
}

	jQuery(document).ready(function() {    
		 checkuser();   
		   // initiate layout and plugins
		   loadApply();
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
				window.location = "/error.jsp";
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