<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!Doctype html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="images/favicon.ico?r=gold" type="image/x-icon" />
<title>网易严选，以严谨的态度为中国消费者甄选天下优品</title>
<link rel="stylesheet" href="css/home.css"/>
</head>
<body>
 <!-- header -->
 <header>
   <div>
   <ul>
     <li><a href="login">登录</a></li>
     <li><a href="reg">注册</a></li>
     <li><a href="#">我的订单</a></li>
     <li><a href="#">严选会员</a></li>
     <li><a href="#">企业采购</a></li>
     <li><a href="#">客户服务</a></li>
    </ul> -->
   </div>
    <!-- 搜索栏 -->
     <div id="search_container">
      <div id="search_div">
          <form action="">
           <input type="search" placeholder="2匹大空调5折促销"/>
          <a href="#"><img id="searchpic" src="images/search.png"/></a> 
          </form>
      </div>
      <div id="car_container">
      <a href="#"><img alt="" src="images/addcar.png"></a> 
      </div>
    </div>
    
    <!-- 导航栏 -->
     <nav>
    <ul>
     <li><a href="#"><b>首页</b></a></li>
     <li><a href="#"><b>居家</b></a></li>
     <li><a href="#"><b>餐厨</b></a></li>
     <li><a href="#"><b>配件</b></a></li>
     <li><a href="#"><b>服装</b></a></li>
     <li><a href="#"><b>电器</b></a></li>
     <li><a href="#"><b>洗护</b></a></li>
     <li><a href="#"><b>杂货</b></a></li>
     <li><a href="#"><b>婴卖</b></a></li>
     <li><a href="#"><b>志趣</b></a></li>
     <li><a href="#"><b>为你严选</b></a></li>
     <li><a href="#"><b>甄选家</b></a></li>
    </ul>
    </nav>
 </header>

<!-- content -->

<article>
   <table  cellspacing="10px">
   <tr>
    <th>商品ID</th>
    <th>商品名称</th>
    <th>商品类别</th>
    <th>商品图片</th>
    <th>商品描述</th>
    <th>商品价格</th>
    <th>操作</th>
   </tr>
   <c:forEach items="${pros}" var="product">
    <tr>
      <td>${product.productid }</td>
      <td>${product.pname }</td>
      <td>${product.cateid }</td>
      <td><img src="${product.pic}" width="100px" height="100px"></img></td>
      <td>${product.pdesc }</td>
      <td>${product.price }</td>
       <td><a href="delproduct/${product.productid}">删除</a> <a href="#">修改</a></td>
    </tr>
  </c:forEach>
 </table>
</article>

<!-- footer -->
<footer>

</footer>
</body>
</html>