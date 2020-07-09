<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-26
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body><!------------------------------head------------------------------>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="/indexselect"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
                <c:if test="${isLogin !=1 }">
                    <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>

                </c:if>

                <c:if test="${isLogin ==1 }">
                    <b>你好：</b><a href="login.jsp" id="login">${name.USER_NAME }</a>

                </c:if>

                <c:if test="${isAdminLogin ==1 }">
                    <a href="manage/admin_index.jsp" id="login1">进入后台</a>

                </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
        </ul>
    </div>
</div>
<!------------------------------idea------------------------------>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.jpg"/></a>
                <p class="clearfix"><span class="fl"></span><span><a href="logout">退出登录</a></span></p></h3>
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


        <div class="you fl"><h2>个人信息</h2>
            <div class="gxin">
                <div class="xx"><h3 class="clearfix"><strong class="fl">基础资料</strong>
                </h3>
                    <div>姓名：${name.USER_NAME}</div>
                    <div>生日：${name.USER_BIRTHDAY}</div>
                    <div>ID号：${name.USER_ID}</div>
                    <div>邮箱：${name.USER_EMAIL}</div>
                    <div>手机号：${name.USER_MOBILE}</div>
                </div>
            </div>
        </div>
    </div>
</div><!--遮罩-->
<div class="mask"></div>




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
