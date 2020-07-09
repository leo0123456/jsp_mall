<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-08
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${title }</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>

<div class="banner"><a href="#"><img src="img/temp/banner1.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="indexselect">首页</a><span>/</span><a
            href="#">Leo</a><span>/</span><a href="proList.html" class="on">${title }</a></div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">${title }</h3>
        <div class="fr choice"><p class="default">排序方式</p>
            <ul class="select">
                <li>新品上市</li>
                <li>销量从高到低</li>
                <li>销量从低到高</li>
                <li>价格从高到低</li>
                <li>价格从低到高</li>
            </ul>
        </div>
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">


    <c:forEach var="p" items="${list }">
        <li><a href="selectproductview?id=${p.PRODUCT_ID}">
            <dl>
                <dt><img src="images/product/${p.PRODUCT_FILENAME }"></dt>
                <dd>【LeoHome】${p.PRODUCT_NAME }</dd>
                <dd>￥${p.PRODUCT_PRICE }.00</dd>
            </dl>
        </a></li>
    </c:forEach>




<!----------------mask------------------->

</div><!--返回顶部-->
        <div class="gotop">
            <a href="#" class="dh">
                <dl>
                    <dt><img src="img/gt2.png"/></dt>
                    <dd>联系<br/>站长</dd>
                </dl>
            </a><a href="mygxin.jsp">
            <dl>
                <dt><img src="img/gt3.png"/></dt>
                <dd>个人<br/>中心</dd>
            </dl>
        </a><a href="#" class="toptop" style="display: none">
            <dl>
                <dt><img src="img/gt4.png"/></dt>
                <dd>返回<br/>顶部</dd>
            </dl>
        </a>
            <p>1999996</p></div><!-------------------login--------------------------><!--footer-->
        <div class="footer">
            <div class="top">
                <div class="wrapper">
                    <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退源码</span>
                    </div>
                    <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换源码</span>
                    </div>
                    <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">远程操作服务</span>
                    </div>
                </div>
            </div>
            <p class="dibu">HHSTU_LeoHome&copy;2020-2021公司版权所有 豫ICP备080100-44备0000111000号<br/>
                违法和不良信息举报电话：123123123，本网站商品皆有站长个人解释</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
