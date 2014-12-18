<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
	<title>Basic Form - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="../jquery.min.js"></script>
	<script type="text/javascript" src="../jquery.easyui.min.js"></script>
</head>
<body style = "text-align:center">
	<h2>Basic Form</h2>
	<p>Fill the form and submit it.</p>
	<div style="margin:0 auto;"></div>
	<div class="easyui-panel" title="New Topic" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Email:</td>
	    			<td><input class="easyui-textbox" type="text" name="password" data-options="required:true"></input></td>
	    		</tr>
		   	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit', {
			    url:'http://192.168.1.200:8080/bone/login/doLogin.json',
			    onSubmit: function(){
			        //进行表单验证
			        //如果返回false阻止提交
			    },
			    success:function(data){
			    	 alert(data);
			    	 //var obj1 = JSON.parse(data);
			    	 //var obj1 = data.parseJSON();
			    	 //var obj1 = $.parseJSON(data);
			    	 //alert(obj1.code);
			    	 window.location.href='list.html';
			    }
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>