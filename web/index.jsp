<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-06
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>


<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner1.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner2.jpg"/></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix"><a href="#"><img src="img/i2.jpg"/></a><a href="#"><img
            src="img/i1.jpg"/></a><a href="#2"><img src="img/i3.jpg"/></a></div>
</div><!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper">
        <div class="top clearfix"><a href="#"><img src="img/n1.jpg"/>
            <p></p></a><a href="#"><img src="img/n2.jpg"/>
            <p></p></a></div>
        <div class="bott clearfix"><a href="#"><img src="img/n3.jpg"/>
            <p></p></a><a href="#"><img src="img/n4.jpg"/>
            <p></p></a></div>
    </div>
</div>

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
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>
