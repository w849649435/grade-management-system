<%-- 
    Document   : list
    Created on : 2014-10-30, 11:12:27
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="note.dao.StudentmarkDAO"%>
<%@page import="note.vo.Studentmark"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />

        <script>
            function del(studentmarkid) {
                if (confirm("你确定要删除吗")) {
                    window.location = "delete2.jsp?studentmarkid=" + studentmarkid;
                }
            }
        </script>
    </head>
    <body>
    <div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
<%-- 				<a href="${pageContext.request.contextPath}/admin/member/import.jsp" --%>
<!-- 				class="btn btn-info">导入会员</a>  -->
<%-- 				<a href="${pageContext.request.contextPath}/src/note.dao/StudentmarkDAO?method=exportExcel" --%>
<!-- 				class="btn btn-success">导出会员</a> -->
<!--         <a href="insert.jsp">添加学生分数</a>  -->
        <h1>学生成绩列表</h1>
        
        <table class="table table-striped table-bordered">
            <tr>
               
                <th>学生成绩编号</th>          
                <th>学生编号</th>
                <th>课程编号</th>
                <th>学生分数</th>
                
            </tr>
   </div>         
            <%
            StudentmarkDAO sdao = new StudentmarkDAO();
                ArrayList<Studentmark> list = sdao.queryAll();
                //多条记录用while循环
                for (Studentmark s : list) {
            %>

            <tr>
               
                 <td>
                    <%=s.getStudentmarkid()%>
                </td>
                 <td>
                    <%=s.getStudentid()%>
                </td>
                <td>
                    <%=s.getCourseid()%>
                </td>
                <td>
                    <%=s.getScore()%>
                </td>
<!--                 <td> -->
<%--                     <a href="update.jsp?studentmarkid=<%=s.getStudentmarkid()%>">更新</a>   --%>
<!--                 </td> -->
<!--                 <td> -->
<%--                     <a href="javascript:del(<%=s.getStudentmarkid()%>)">删除</a> --%>
<!--                 </td> -->
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
