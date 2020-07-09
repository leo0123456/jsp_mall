<%--
  Created by IntelliJ IDEA.
  User: 10646
  Date: 2020-04-07
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">资源管理</span></div>
    </div>

    <div id="register" class="result-wrap">
        <form action="/manage/admin_doproductdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="/manage/admin_toproductadd"><i class="icon-font"></i>新增资源</a>

                    <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="60%">
                    <tr>

                        <th>ID</th>
                        <th>商品名称</th>
                        <th>操作</th>

                    </tr>

                    <c:forEach var="p" items="${plist }">
                        <tr>
                            <td>${p.PRODUCT_ID }</td>
                            <td><img src="../images/product/${p.PRODUCT_FILENAME}" width="80" height="80">
                                    ${p.PRODUCT_NAME }

                            </td>
                            <td>




                                <a class="link-del" href="/manage/admin_doproductdel?id=${p.PRODUCT_ID}&cpage=${cpage }">删除</a>


                            </td>
                        </tr>
                    </c:forEach>



                </table>
                <div class="list-page">
                    共 ${tsum} 条记录， 当前 ${cpage}/${tpage} 页
                    <a href="/manage/admin_productselect?cp=1">首页</a>
                    <a href="/manage/admin_productselect?cp=${cpage-1<1?1:cpage-1}">上一页</a>
                    <a href="/manage/admin_productselect?cp=${cpage+1>tpage?tpage:cpage+1}">下一页</a>
                    <a href="/manage/admin_productselect?cp=${tpage}">尾页</a>



                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
