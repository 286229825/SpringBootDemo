<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 这里的/代表当前web应用的根路径，是绝对路径 -->
<script src="/js/jquery-3.2.1.min.js"></script>
<!-- 写jquery最好依照官方要求的格式 -->
<script>
	$(document).ready(function(){
		var username="${Session.username}";
		$("button").click(function(){
			alert("Value: " + $("#test").val());
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>id</td>
			<td>typeName</td>
			<td>days</td>
		</tr>
		<tr>
			<td>${booktype.id}</td>
			<td>${booktype.typeName}</td>
			<td>${booktype.days}</td>
		</tr>
	</table>
	<body>
<p>姓名：<input type="text" id="test" value="米老鼠"></p>
<button>显示值</button>
<!-- 使用 ${Session.username}来获取Session域中的username的值 -->
<h1>your name is:${Session.username} </h1>
</body>
</html>