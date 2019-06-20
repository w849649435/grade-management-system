<%-- 
    Document   : insert_do
    Created on : 2012-9-17, 19:33:41
    Author     : Administrator
--%>


<%@page import="note.dao.TeachercourseDAO"%>
<%@page import="note.vo.Teachercourse"%>

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
            String courseid = request.getParameter("courseid");
            String teacherid= request.getParameter("teacherid");
            String classid = request.getParameter("classid");
            TeachercourseDAO okDao = new TeachercourseDAO();
            if (okDao.insert(courseid, teacherid, classid)) {
                out.println("给老师排课成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=insert.jsp");
            } else {
                out.println("给老师排课失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=insert.jsp");
            }
        %>


    </body>
</html>
