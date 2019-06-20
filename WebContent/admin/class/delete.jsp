<%-- 
    Document   : delete
    Created on : 2015-11-30, 13:52:17
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
//         int classid=Integer.parseInt(request.getParameter("classid"));
                  request.setCharacterEncoding("UTF-8");
                  String classid= request.getParameter("classid");
                  ClassDAO studentDao = new ClassDAO();
            if (studentDao.delete(classid)) {
                out.println("删除成功，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");

            } else {
                out.println("删除失败，过1秒到列表页面");
                response.setHeader("refresh", "1;url=list.jsp");

            }
        %>
    </body>
</html>
