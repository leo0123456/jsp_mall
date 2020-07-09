<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-29
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!------------------------------idea------------------------------>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.jpg"/></a>
                <p class="clearfix"><span class="fl">[${name.USER_NAME }]</span><span>[<a href="logout">退出登录</a>]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>

                    <li><a href="/orderselect?id=${name.USER_ID}">我的订单</a></li>

                </ul>

                <h4>账户管理</h4>
                <ul>
                    <li><a href="mygrxx.jsp">个人信息</a></li>
                    <li><a href="mygrxxupdate.jsp">修改信息</a></li>
                </ul>
            </div>
        </div>

        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                </ul>
            </div>

        <c:forEach var="o" items="${orderlist}">
            <div class="dkuang"><p class="one">已支付</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>资源号：${o.order_p_id}</li>
                        <li>用户：${o.order_u_id}</li>
                        <li>订单号:${o.order_id}</li>
                        <li>在线支付</li>
                    </ul>
                    <p class="fr">订单金额：<span>${o.order_p_price}</span>元</p></div>
                <div class="shohou clearfix"><a href="#" class="fl"><img src="images/product/${o.order_p_filename}"/></a>
                    <p class="fl"><a href="#">资源名称：${o.order_p_name}</a><a href="#">¥${o.order_p_price}</a></p>
                    <p class="fr"><a href="/download?finame=${o.order_p_finame}">资源链接下载</a></p></div>
            </div>
        </c:forEach>


        </div>
    </div>
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
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
