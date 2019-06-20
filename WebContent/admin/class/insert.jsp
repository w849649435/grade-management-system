<%-- 
    Document   : insert
    Created on : 2010-9-20, 10:21:47
    Author     : Administrator
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>添加班级</h1>
         <form action="insert_do.jsp" method="post">
<%--         <form action="${pageContext.request.contextPath}/admin/LoginServlet?method=insert" method="post"> --%>
            <table border="0">
                <tr>
                    <td>班级编号</td>
                    <td><input type="text" name="classid" value="1"></td>

                </tr>
                <tr>
                    <td>班级名称</td>
                    <td><input type="text" name="classname" value="计算机3班"></td>

                </tr>
               
            </table>
            <input style= "color:black;background-color:#886622;" type="submit" id="start" value="添加" />
        </form>

    </body>
</html>
