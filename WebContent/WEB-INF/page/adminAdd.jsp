<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>后台</title>
    <script src="/themes/dist/js/jquery.js" ></script>
    <script src="/themes/dist/js/bootstrap.min.js" ></script>
    <script src="/themes/dist/js/vue.min.js" ></script>
    <script src="/themes/js/jquery.form.js" ></script>
    <link rel="stylesheet" type="text/css" href="/themes/dist/css/bootstrap-theme.min.css" >
    <link rel="stylesheet" type="text/css" href="/themes/dist/css/bootstrap.min.css" >
    <script>
        $(function(){
        	loadForms();
        })
       function loadForms(){
        	$("#form").ajaxForm({
        		success : function(data) {
        			console.log(data);
        			if ("fail" == data.data) {
        				alert('上传失败！');
        			}else{
        				$('#img').show();
        				$('#img').attr('src',data.data);
        			}
        		},
        		complete : function(t) {
        		}
        	});
        }
        function add(){
         	var  myselect=document.getElementById("type");
         	var index=myselect.selectedIndex ;             // selectedIndex代表的是你所选中项的index
        	var params = 'typeId='+myselect.options[index].value+'&typeName='+myselect.options[index].text+'&title='+$('#title').val()+
        	'&imgUrl='+$('#img').attr('src')+'&content='+$('#content').val();
        	$.ajax({
        		url:'/data/articleContent/add.html',
        		data:params,
        		type:'post',
        		dataType:'json',
        		success:function(res){
        			alert('保存成功！');
        			location.href = '/adminArticle.html';
        		}
        	})
        }
    </script>
    <style>
        .info-table{
            margin-top: 10px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">巾帼园</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a  href="/adminArticle.html">文章列表</a></li>
                <li class="active"><a href="javascript:location.reload();">添加文章</a></li>
            </ul>
        </div>
    </div>
</nav>
<table class="table table-striped info-table">
    <thead>
        <tr>
            <th>类别</th>
            <th>内容</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>标题</td>
            <td>
            	<textarea rows="" cols="" class="form-control" id="title" ></textarea>
            </td>
           </tr> 
           <tr> 
             <td>头图</td>
            <td>
            	<form id="form" method="post" enctype="multipart/form-data" action="/uploadArticleFile.html">
           		<div class="form-group">
						<label class="sr-only" for="exampleInputAmount">选择图片</label>
						<div class="input-group">
							<input type="text" class="form-control" id="exampleInputAmount" placeholder="选择图片" readonly="readonly">
							<div class="input-group-addon" onclick="$('input[id=imgUrl]').click();">浏览</div>
						</div>
					</div>
					<img alt="" id="img"  style="display: none;width: 100px;" src="">
					 <input type="file" name="file" id="imgUrl" readonly="readonly" class="form-control" style="display: none" />
					 <button type="submit" class="btn btn-success" >上传</button>
            	</form>
            	<script type="text/javascript">
					$('input[id=imgUrl]').change(function() {
						$('#exampleInputAmount').val($(this).val());
					});
				</script>
            </td>
            </tr> 
           <tr>  
            <td>链接</td>
            <td>
            	<textarea rows="" cols="" class="form-control" id="content" ></textarea>
            </td>
             </tr> 
           <tr> 
            <td>类别</td>
            <td>
            	<select class="form-control" id="type" >
            		<option value="2" >公益课堂</option>
            		<option value="7" >维权课堂</option>
            		<option value="22" >最新活动</option>
            		<option value="12" >巾帼园简介</option>
            		<option value="11" >巾帼园首页</option>
            		<option value="1" >巾帼园介绍</option>
            		<option value="9" >小蓓蕾最新招生</option>
            		<option value="14" >巾帼家政简介</option>
            		<option value="6" >女性NGO</option>
            		<option value="5" >志愿者</option>
            		<option value="19" >女性NGO简介</option>
            		<option value="8" >热门活动</option>
            	</select>
            </td>
        </tr>
        <tr> 
        	<td>操作</td>
            <td>
            	<a class="btn btn-danger" onclick="add();" >添加</a>
            </td>
         </tr>
    </tbody>
</table>
</body>
</html>