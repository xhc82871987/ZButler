<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>店家图片展示</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<style>
.file {
	position: absolute;
	opacity: 0;
	filter: alpha(opacity = 0);
	width: 80px;
	height: 80px;
	cursor: pointer;
	z-index: 1000;
}

.addImg img {
	position: absolute;
}
</style>
</head>

<body>
	<div class="storeImg">
		<div class="storeImg_content">
			<div class="storeImg_addImg">
				<div class="addImg">
					<input type="file" class="file"> <img
						src="<%=basePath%>home/dist/wx_image/addImg.png" />
				</div>
			</div>
			<div class="storeImg_img">
				<div class="storeImg_img_content">
					<img src="<%=basePath%>home/dist/wx_image/111.jpg" cid="1" />
					<div class="storeImg_del">
						<img src="<%=basePath%>home/dist/wx_image/del.png" />
					</div>
				</div>
			</div>
			<div class="storeImg_img">
				<div class="storeImg_img_content">
					<img src="<%=basePath%>home/dist/wx_image/111.jpg" Cid="2" />
					<div class="storeImg_del">
						<img src="<%=basePath%>home/dist/wx_image/del.png" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/md5.js"></script>
	<script>
		!(function($) {
			$('.storeImg').css('height', document.body.scrollHeight);
			$('.storeImg_img_content').click(function(e) {
				//            点击区域外使阻止事件冒泡
				e.stopPropagation();
				$('.storeImg_del').css('display', 'none');
				$(this).find('.storeImg_del').css('display', 'block');
			});
			$('.storeImg').click(function() {
				$('.storeImg_del').css('display', 'none');
			})
	
			var img = $('input[type="file"]');
			img.change(function() {
				var imgFile = new FileReader();
				imgFile.readAsDataURL(img[0].files[0]);
				imgFile.onload = function() {
					var imgData = this.result; //base64数据
					// 创建img 对象
					console.log(imgData)
				// ajax
				}
			});
	
			$('.storeImg_del').click(function() {
				 var img =$($(this).parent()[0]).find("img")[0];
				$(this).parent().parent().remove();
				
			});
	
		})(jQuery);
	</script>
</body>
</html>