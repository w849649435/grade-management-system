<%-- 
    Document   : list
    Created on : 2014-10-30, 11:12:27
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="note.dao.ClassDAO"%>
<%@page import="note.vo.Class1"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />

        <script>
            function del(classid) {
                if (confirm("你确定要删除吗")) {
                    window.location = "delete.jsp?classid=" + classid;
                }
            }
        </script>
    </head>
    <body>
<div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
		<a href="${pageContext.request.contextPath}/admin/class/insert.jsp"
				class="btn btn-info">添加班级</a> 
        <h1>班级数据</h1>
        <table class="table table-striped table-bordered">
            <tr>
               
                <th>班级编号</th>
                <th>班级名称</th>
                <th colspan="2">操作</th>
            </tr>
</div>
            <%
            ClassDAO sdao = new ClassDAO();
                ArrayList<Class1> list = sdao.queryAll();
                //多条记录用while循环
                for (Class1 s : list) {
            %>

            <tr>
               
                 <td>
                    <%=s.getClassId()%>
                </td>
                 <td>
                    <%=s.getClassName()%>
                </td>
<!--                 <td> -->
<%--                     <a href="update.jsp?classid=<%=s.getClassId()%>">更新</a>   --%>
<!--                 </td> -->
                <td>
                    <a href="javascript:del(<%=s.getClassId()%>)" class="btn btn-info">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
