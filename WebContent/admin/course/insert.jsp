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
  
        <h1>添加课程 </h1>
    
         <form action="insert_do.jsp" method="post">
<%--         <form action="${pageContext.request.contextPath}/admin/LoginServlet?method=insert" method="post"> --%>
            <table border="0">
                <tr>
                    <td>课程编号</td>
                    <td><input type="text" name="courseid" value="1"></td>

                </tr>
                <tr>
                    <td>课程名称</td>
                    <td><input type="text" name="coursename" value="java"></td>

                </tr>
               
            </table>
<!--             <input type="submit" value="查询会员" class="btn btn-success" /> -->
<!--             <input type="submit" value="添加" " class="btn btn-info"> -->
            <input style= "color:black;background-color:yellow;" type="submit" id="start" value="添加" />
            
        </form>

    </body>
</html>
