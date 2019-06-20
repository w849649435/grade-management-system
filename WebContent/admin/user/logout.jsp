<%-- 
    Document   : logout
    Created on : 2014-10-27, 16:57:38
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
            session.invalidate();//ʹsessionʧЧ
            response.sendRedirect("../login.jsp");
            %>
    </body>
</html>
