<%-- 
    Document   : list
    Created on : 2014-10-30, 11:12:27
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="note.dao.TeachercourseDAO"%>
<%@page import="note.vo.Teachercourse"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />

<!--         <script> -->
<!-- //             function del(teachercourseid) { -->
<!-- //                 if (confirm("你确定要删除吗")) { -->
<!-- //                     window.location = "delete.jsp?teachercourseid=" + teachercourseid; -->
<!-- //                 } -->
<!-- //             } -->
<!--         </script> -->
    </head>
    <body>


        <a href="insert.jsp">给老师派课</a> 
        <h1>课程信息</h1>
        <table class="table table-striped table-bordered">
            <tr>
                <th>教师课程编号</th>
                <th>课程名称</th>
                <th>教师姓名</th>
                <th>班级名称</th>
<!--                 <th colspan="2">操作</th> -->
            </tr>
            <%
            TeachercourseDAO sdao = new TeachercourseDAO();
                ArrayList<Teachercourse> list = sdao.findAll2("teachercourseid");
                //多条记录用while循环
                for (Teachercourse s : list) {
            %>

            <tr>
                <td>
                    <%=s.getTeachercourseid()%>
                </td>
                <td>
                    <%=s.getCourseid()%>
                </td>
                <td>
                    <%=s.getTeacherid()%>
                </td>
                <td>
                    <%=s.getClassid()%>
                </td>
                
     
                
<!--                 <td> -->
<%--                     <a href="update.jsp?teachercourseid=<%=s.getTeachercourseid()%>">更新</a>   --%>
<!--                 </td> -->
<!--                 <td> -->
<%--                     <a href="javascript:del(<%=s.getTeachercourseid()%>)">删除</a> --%>
<!--                 </td> -->
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
