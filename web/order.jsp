<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-08
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>order</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!----------------------------------------order------------------>

<%@ include file="header.jsp" %>

<div class="order cart mt"><!-----------------site------------------->


    <div class="orderCon wrapper clearfix">
        <div class="orderL fl"><!--------h3---------------->
            <!--------addres---------------->

            <h3>支付方式</h3><!--------way---------------->
            <div class="way clearfix"><img class="on" src="img/temp/way01.jpg"><img src="img/temp/way02.jpg"><img
                    src="img/temp/way03.jpg"></div>

        </div>
        <div class="orderR fr">

            <div class="msg"><h3>订单内容</h3><!--------ul---------------->
                <ul class="clearfix">
                    <li class="fl"><img src="images/product/${p.PRODUCT_FILENAME }"></li>
                    <li class="fl"><p>资源名称：${p.PRODUCT_NAME }</p>
                        <p>资源简介：${p.PRODUCT_DESCRIPTION}</p>
                        <p>数量：1</p></li>
                    <li class="fr">￥${p.PRODUCT_PRICE }.00</li>
                </ul>
            </div>
            <!--------tips---------------->
            <div class="tips"><p><span class="fl">资源金额：</span><span class="fr">￥${p.PRODUCT_PRICE }.00</span></p>
                <p><span class="fl">优惠金额：</span><span class="fr">￥0.00</span></p>
            </div>
            <!--------tips count---------------->
            <div class="count tips"><p><span class="fl">合计：</span><span class="fr">￥${p.PRODUCT_PRICE }.00</span></p></div>
            <!--<input type="button" name="" value="去支付">--> <a href="/orderadd?id=${p.PRODUCT_ID}" class="pay">去支付</a></div>

    </div>
</div><!--编辑弹框--><!--遮罩-->

<div class="like"><h4>最近访问</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>


                    <c:forEach var="lp" items="${lastlylist }">
                        <a href="selectproductview?id=${lp.PRODUCT_ID }">
                            <dl>
                                <dt><img src="images/product/${lp.PRODUCT_FILENAME }"></dt>
                                <dd>【HHSTU_LEO_Home】${lp.PRODUCT_NAME }</dd>
                                <dd>￥${lp.PRODUCT_PRICE }.00</dd>
                            </dl>
                        </a>
                    </c:forEach>


                </div>
            </div>
        </div>
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
