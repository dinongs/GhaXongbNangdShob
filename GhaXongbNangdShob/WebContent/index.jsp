<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Bootstrap 实例 - 基本的表格</title>
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<script src="dist/js/jquery-1.11.2.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
<style type="text/css">
.iput-wrap {
	position: relative;
	min-height: 180px;
	height: 180px;
	padding-bottom: 30px;
}
</style>
</head>
<body>
	<br />
	<div class="">
		<div class="form-group" style="float: center;">
			<label for="name" style="align: center">原文</label>
		</div>
	</div>


	<div class="group" style="width: 98%; height: 500px">
		<div class="form-group"
			style="float: left; padding: 100px; display: inline">
			<label for="name">原文</label>
			<textarea id="input_content" class="form-control"
				style="height: 150px; width: 450px"></textarea>
		</div>
		<div class="form-group"
			style="float: left; padding-top: 160px; display: inline">
			<a id="btn" href="#" style="algin: left"><span>翻译</span></a>
		</div>

		<div class="form-group"
			style="float: left; padding-top: 100px; display: inline">
			<label for="name">译文</label> <label class="form-control"
				style="height: 150px; width: 450px; bgroundcolor: red"></label>

		</div>
		<div>
			<ul id="list">
			</ul>
		</div>
	</div>
</body>
</html>
<script>
	$(document).ready(function() {
		$('#btn').click(function() {
			var ndeud = $('#input_content').val();
			$.ajax({
				url : "SearchNdeud",
				type : 'get',
				dataType : 'json',
				data : "ndeud=" + ndeud,
				success : function(msg) {
					var str = "";
					$('li').remove();
					for (var i = 0; i < msg.length; i++) {
						str = str + "<br/><li>" + msg[i].ndeudx + "</li>";
					}
					$('#list').append(str);
				}

			});
		});
	});
</script>