<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reg.css"/>
</head>
<body>
<h1>文件上传页面</h1>

 <form action="upload" method="post" enctype="multipart/form-data"> 
  <input type="file" name="uploadFile"/>
  <input type="submit" value="上传"/>
 </form>

</body>
</html>