<%-- 
    Document   : insert_do
    Created on : 2012-9-17, 19:33:41
    Author     : Administrator
--%>


<%@page import="note.dao.StudentmarkDAO"%>
<%@page import="note.vo.Studentmark"%>
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
            String courseid= request.getParameter("courseid");
            String score= request.getParameter("score");
            StudentmarkDAO sDao = new StudentmarkDAO();
            if (sDao.insert(studentid, courseid, score)) {
                out.println("录入学生成绩成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=studentmark.jsp");
            } else {
                out.println("录入学生成绩失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=studentmark.jsp");
            }
        %>


    </body>
</html>
