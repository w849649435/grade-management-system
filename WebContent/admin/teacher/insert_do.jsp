<%-- 
    Document   : insert_do
    Created on : 2012-9-17, 19:33:41
    Author     : Administrator
--%>


<%@page import="note.dao.TeacherDAO"%>
<%@page import="note.vo.Teacher"%>
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
            String teacherid= request.getParameter("teacherid");
            String teachername = request.getParameter("teachername");
            String teacherpassword = request.getParameter("teacherpassword");
            TeacherDAO studentDao = new TeacherDAO();
            if (studentDao.insert(teacherid, teachername, teacherpassword)) {
                out.println("添加教师信息成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            } else {
                out.println("添加教师信息失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");
            }
        %>


    </body>
</html>
