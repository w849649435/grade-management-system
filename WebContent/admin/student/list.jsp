<%-- 
    Document   : list
    Created on : 2014-10-30, 11:12:27
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="note.dao.StudentDAO"%>
<%@page import="note.vo.Student"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />

        <script>
            function del(studentid) {
                if (confirm("你确定要删除吗")) {
                    window.location = "delete.jsp?studentid=" + studentid;
                }
            }
        </script>
    </head>
    <body>


		<a href="${pageContext.request.contextPath}/admin/student/insert.jsp"
				class="btn btn-success">添加学生</a>
				 
        <h1>学生数据</h1>
        <div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
        <table class="table table-striped table-bordered">
        
            <tr> 
                <th>学生编号</th>          
                <th>登陆密码</th>
                <th>学生姓名</th>
                <th>学生班级</th>
                <th colspan="2">操作</th>
            </tr>
        
            <%
            StudentDAO sdao = new StudentDAO();
                ArrayList<Student> list = sdao.queryAll();
                //多条记录用while循环
                for (Student s : list) {
            %>

            <tr>
               
                 <td>
                    <%=s.getStudentid()%>
                </td>
                 <td>
                    <%=s.getStudentname()%>
                </td>
                <td>
                    <%=s.getStudentpassword()%>
                </td>
                <td>
                    <%=s.getStudentclass()%>
                </td>
<!--                 <td> -->
<%--                     <a href="update.jsp?studentid=<%=s.getStudentid()%>">更新</a>   --%>
<!--                 </td> -->
                <td>
                    <a href="javascript:del(<%=s.getStudentid()%>)" class="btn btn-danger">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>    
    </body>
</html>
