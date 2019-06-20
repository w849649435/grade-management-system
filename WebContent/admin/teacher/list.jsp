<%-- 
    Document   : list
    Created on : 2014-10-30, 11:12:27
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="note.dao.TeacherDAO"%>
<%@page import="note.vo.Teacher"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />

        <script>
            function del(teacherid) {
                if (confirm("你确定要删除吗")) {
                    window.location = "delete.jsp?teacherid=" + teacherid;
                }
            }
        </script>
    </head>
    <body>
<div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
		<a href="${pageContext.request.contextPath}/admin/teacher/insert.jsp"
				class="btn btn-info">添加教师</a> 
        <h1>教师数据</h1>
</div>        
        <table class="table table-striped table-bordered">
            <tr>
               
                <th>教师编号</th>
                <th>教师姓名</th>
                <th>登陆密码</th>
                <th colspan="2">操作</th>
            </tr>
            <%
            TeacherDAO sdao = new TeacherDAO();
                ArrayList<Teacher> list = sdao.queryAll();
                //多条记录用while循环
                for (Teacher s : list) {
            %>

            <tr>
               
                 <td>
                    <%=s.getTeacherid()%>
                </td>
                 <td>
                    <%=s.getTeachername()%>
                </td>
                <td>
                    <%=s.getTeacherpassword()%>
                </td>
<!--                 <td> -->
<%--                     <a href="update.jsp?teacherid=<%=s.getTeacherid()%>">更新</a>   --%>
<!--                 </td> -->
                <td>
                    <a href="javascript:del(<%=s.getTeacherid()%>)" class="btn btn-danger">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
