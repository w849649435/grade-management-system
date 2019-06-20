<%-- 
    Document   : insert
    Created on : 2010-9-20, 10:21:47
    Author     : Administrator
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>课程信息</h1>
             <form action="insert_do.jsp" method="post">
<%--         <form action="${pageContext.request.contextPath}/admin/LoginServlet?method=insert" method="post"> --%>
            <table border="0">
<!--                 <tr> -->
<!--                     <td>教师姓名</td> -->
<!--                     <td><input type="text" name="teacherid" value="老邰啊"></td> -->

<!--                 </tr> -->
               <tr>
                    <td>教师姓名</td>
                    <td>
                    
                   <select class="teacherid" name="teacherid" id="teacherid">
                        <option selected="" value="1">老邰啊</option>
                        <option value="2">高军</option>
                        <option value="3">刘丽杰</option> 
                   </select>
                    </td>
                 </tr>   
                 <tr>
                    <td>课程姓名</td>
                    <td>
                    
                   <select class="courseid" name="courseid" id="courseid">
                        <option selected="" value="1">java</option>
                        <option value="2">html</option>
                        <option value="3">面向对象</option> 
                   </select>
                    </td>
                 </tr> 
                 <tr>
                    <td>班级名称</td>
                    <td>
                    
                   <select class="classid" name="classid" id="classid">
                        <option selected="" value="1">计算机1班</option>
                        <option value="2">计算机2班</option>
                        <option value="3">计算机3班</option> 
                   </select>
                    </td>
                 </tr>     
<!--                 <tr> -->
<!--                     <td>课程姓名</td> -->
<!--                     <td><input type="text" name="courseid" value="课程设计"></td> -->

<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>班级名称</td> -->
<!--                     <td><input type="text" name="classid" value="计算机三班"></td> -->

<!--                 </tr> -->
                
<!--                         <SELECT  name="teacherid" style="width: 130px;"value="老邰啊"> -->
                        


                
               
            </table>
              <input style= "color:black;background-color:red;" type="submit" id="start" value="添加" />
        </form>

    </body>
</html>
