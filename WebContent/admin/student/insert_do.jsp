<%-- 
    Document   : insert_do
    Created on : 2012-9-17, 19:33:41
    Author     : Administrator
--%>


<%@page import="note.dao.StudentDAO"%>
<%@page import="note.vo.Student"%>
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
            String studentid= request.getParameter("studentid");
            String studentname = request.getParameter("studentname");
            String studentpassword = request.getParameter("studentpassword");
            String studentclass = request.getParameter("studentclass");
            StudentDAO studentDao = new StudentDAO();
            if (studentDao.insert(studentid, studentname, studentpassword, studentclass)) {
                out.println("添加学生信息成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            } else {
                out.println("添加学生信息失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            }
        %>


    </body>
</html>
