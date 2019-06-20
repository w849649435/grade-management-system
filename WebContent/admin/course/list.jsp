<%-- 
    Document   : list
    Created on : 2014-10-30, 11:12:27
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="note.dao.CourseDAO"%>
<%@page import="note.vo.Course"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />

        <script>
            function del(courseid) {
                if (confirm("你确定要删除吗")) {
                    window.location = "delete.jsp?courseid=" + courseid;
                }
            }
        </script>
    </head>
    <body>
        <div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
		<a href="${pageContext.request.contextPath}/admin/course/insert.jsp"
				class="btn btn-info">添加课程</a> 
        <h1>课程数据</h1>
        <table class="table table-striped table-bordered">
            <tr>
               
                <th>课程编号</th>
                <th>课程名称</th>
                <th colspan="2">操作</th>
            </tr>
         </div>
            <%
            CourseDAO sdao = new CourseDAO();
                ArrayList<Course> list = sdao.queryAll();
                //多条记录用while循环
                for (Course s : list) {
            %>

            <tr>
               
                 <td>
                    <%=s.getCourseId()%>
                </td>
                 <td>
                    <%=s.getCourseName()%>
                </td>
<!--                 <td> -->
<%--                     <a href="update.jsp?courseid=<%=s.getCourseId()%>">更新</a>   --%>
<!--                 </td> -->
                <td>
                    <a href="javascript:del(<%=s.getCourseId()%>)" class="btn btn-danger">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
