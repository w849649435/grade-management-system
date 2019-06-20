<%-- 
    Document   : delete
    Created on : 2015-11-30, 13:52:17
    Author     : Administrator
--%>


<%@page import="note.dao.StudentmarkDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
//         int courseid=Integer.parseInt(request.getParameter("courseid"));
                  request.setCharacterEncoding("UTF-8");
                  String studentmarkid= request.getParameter("studentmarkid");
                  StudentmarkDAO studentmarkDao = new StudentmarkDAO();
            if (studentmarkDao.delete(studentmarkid)) {
                out.println("删除成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=studentmark.jsp");

            } else {
                out.println("删除失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=studentmark.jsp");

            }
        %>
    </body>
</html>
