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
    <link rel="stylesheet" type="text/css" href="/themes/dist/css/bootstrap-theme.min.css" >
    <link rel="stylesheet" type="text/css" href="/themes/dist/css/bootstrap.min.css" >
    <script>
        $(function(){
            $.ajax({
                url:'/data/articleContent/list.html',
                type:'GET',
                dataType:'JSON',
                success:function(res){
                    new Vue({
                        el: 'body',
                        data:{items:res.data}
                    })
                }
            })
        })
        function dele(id){
        	var params = 'id='+id;
        	if(confirm('确定要删除？')){
        		$.ajax({
                    url:'/data/articleContent/delete.html',
                    type:'post',
                    data:params,
                    dataType:'JSON',
                    success:function(res){
                    	alert('删除成功！');
                       location.reload();
                    }
                })
        	}
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
                <li class="active"><a href="javascript:location.reload();">文章列表</a></li>
                <li><a href="/adminAdd.html">添加文章</a></li>
            </ul>
        </div>
    </div>
</nav>
<table class="table table-striped info-table">
    <thead>
        <tr>
            <th>编号</th>
            <th>标题</th>
            <th>头图</th>
            <th>链接</th>
            <th>分类</th>
        </tr>
    </thead>
    <tbody>
        <tr v-for="model in items" >
            <td v-text="model.id" ></td>
            <td v-text="model.title" ></td>
            <td>
                <img v-bind:src="model.imgUrl" height="38px" >
            </td>
            <td><a v-bind:href="model.content" >查看</a></td>
            <td v-text="model.typeName" ></td>
            <td><a class="btn btn-success" onclick="dele('{{model.id}}')" >删除</a></td>
        </tr>
    </tbody>
</table>
</body>
</html>