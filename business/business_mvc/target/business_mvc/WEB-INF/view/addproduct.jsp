<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!Doctype html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">添加商品</h1>
 <table cellpadding="10px" style="margin:0px auto">
<form:form action="" method="post" enctype="multipart/form-data" modelAttribute="product">
<tr>
 <td>商品名称:</td>
 <td><form:input type="text" path="pname"/></td>
</tr>

<tr>
 <td>商品图片:</td>
 <td><form:input type="file" path="pic"/></td>
</tr>
<tr >

<tr>
 <td>商品类别:</td>
 <td>
 <form:select path="cateid">
   <option value="1" selected="selected">手机</option>
   <option value="2">电脑</option>
   <option value="3">电视</option>
 </form:select>
   
 </td>
</tr>

<tr>
 <td>商品价格:</td>
 <td><form:input type="text" path="price"/></td>
</tr>

<tr>
 <td>商品描述:</td>
 <td><form:input type="textarea" cols="10" rows="10" path="pdesc"/></td>
</tr>

 <td colspan="2"  style="text-align:center" >
 
 <input  type="submit" value="添加商品"/>

  
 </td>
</tr>
</form:form>
</table>
 


</body>
</html>