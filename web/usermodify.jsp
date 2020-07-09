<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-26
  Time: 8:58
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
<div class="result-wrap">
    <div class="result-content">
        <form action="/manage/douserupdate" method="post" id="myform" name="myform">
            <input type="hidden" name="userStatus" value="${user.USER_STATUS }">

            <table class="insert-tab" width="100%">
                <tbody>
                <tr>
                    <th><i class="require-red">*</i>用户名：</th>
                    <td>
                        <input class="common-text required" id="title" name="userName" size="50" value="${user.USER_ID }" type="text">
                    </td>
                </tr>

                <tr>
                    <th><i class="require-red">*</i>用户姓名：</th>
                    <td>
                        <input class="common-text required" id="title" name="name" size="50" value="${user.USER_NAME }" type="text">
                    </td>
                </tr>

                <tr>
                    <th><i class="require-red">*</i>登录密码：</th>
                    <td>
                        <input class="common-text required" id="title" name="passWord" size="50" value="${user.USER_PASSWORD }" type="text">
                    </td>
                </tr>



                <tr>
                    <th>性别：</th>
                    <td>
                        <input type="radio" name="sex" value="T" ${user.USER_SEX=='T'?"checked":"" }>男
                        <input  type="radio" name="sex" value="F" ${user.USER_SEX=='F'?"checked":"" }>女
                    </td>
                </tr>


                <tr>
                    <th>出生日期：</th>
                    <td><input class="common-text" name="birthday" size="50" value="${user.USER_BIRTHDAY }" type="text"></td>
                </tr>

                <tr>
                    <th><i class="require-red">*</i>电子邮箱：</th>
                    <td>
                        <input class="common-text required" id="title" name="email" size="50" value="${user.USER_EMAIL }" type="text">
                    </td>
                </tr>

                <tr>
                    <th><i class="require-red">*</i>手机号码：</th>
                    <td>
                        <input class="common-text required" id="title" name="mobile" size="50" value="${user.USER_MOBILE }" type="text">
                    </td>
                </tr>

                <tr>
                    <th><i class="require-red">*</i>送货地址：</th>
                    <td>
                        <input class="common-text required" id="title" name="address" size="50" value="${user.USER_ADDRESS }" type="text">
                    </td>
                </tr>


                <tr>
                    <th></th>
                    <td>
                        <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                        <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                    </td>
                </tr>
                </tbody></table>
        </form>
    </div>
</div>
