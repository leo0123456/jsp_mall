<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-29
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
    </div>

    <div id="register" class="result-wrap">
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th>订单号</th>
                        <th>资源号</th>
                        <th>资源名字</th>
                        <th>资源图片</th>
                        <th>资源价格</th>
                        <th>订单用户</th>
                    </tr>

                    <c:forEach var="o" items="${orderlist}">
                        <tr>

                            <td> ${o.order_id}</td>
                            <td> ${o.order_p_id}</td>
                            <td> ${o.order_p_name}</td>
                            <td> <img src="../images/product/${o.order_p_filename}" width="50" height="50"></td>
                            <td> ${o.order_p_price}</td>
                            <td> ${o.order_u_id}</td>
                        </tr>
                    </c:forEach>




                </table>

            </div>
    </div>
</div>
