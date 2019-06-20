<%-- 
    Document   : insert_do
    Created on : 2012-9-17, 19:33:41
    Author     : Administrator
--%>


<%@page import="note.dao.CourseDAO"%>
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
            String courseid= request.getParameter("courseid");
            String coursename = request.getParameter("coursename");
       
            CourseDAO studentDao = new CourseDAO();
            if (studentDao.insert(courseid, coursename)) {
                out.println("添加课程成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            } else {
                out.println("添加课程失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            }
        %>


    </body>
</html>
