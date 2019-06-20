<%-- 
    Document   : insert_do
    Created on : 2012-9-17, 19:33:41
    Author     : Administrator
--%>


<%@page import="note.dao.ClassDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String classid= request.getParameter("classid");
            String classname = request.getParameter("classname");
       
            ClassDAO classDao = new ClassDAO();
            if (classDao.insert(classid, classname)) {
                out.println("添加班级成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            } else {
                out.println("添加班级失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            }
        %>


    </body>
</html>
