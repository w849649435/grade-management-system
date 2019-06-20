
<%@page import="note.dao.LogInfoDAO"%>
<%@page import="loginDMO.adminlogin"%>
<%@page import="loginDMO.teacherlogin"%>
<%@page import="loginDMO.studentlogin"%>
<%@page contentType="text/html;charset=UTF-8"  %>

<html>
    <head>
        <title></title>
    </head>
    <body>
          <% 
            request.setCharacterEncoding("UTF-8");          
            String type=request.getParameter("type");
            System.out.println(type);
            %>           
      <%   
            String adminid = request.getParameter("userId");
            String managerpassword = request.getParameter("password");
            String teacherid = request.getParameter("userId");
            String teacherpassword = request.getParameter("password");
            String studentid = request.getParameter("userId");
            String uesrpassword = request.getParameter("password");
         if("2".equals(type)){
        	       adminlogin adminDAO = new adminlogin();
                   boolean flag2= adminDAO.adminlgn(
             		adminid,managerpassword);

                 if (flag2){
                      LogInfoDAO infoDAO = new LogInfoDAO();
                      infoDAO.addLog(adminid);
                      session.setAttribute("adminid", adminid);
                      session.setAttribute("managerpassword", managerpassword);
                      response.sendRedirect("admin/index.jsp");
                 } else{
                  out.println("<script>alert('用户名或密码错误');window.location='login.jsp';</script>");        	
                       }
         }if("1".equals(type)){
        	      teacherlogin teacher = new teacherlogin();
                  boolean flag1 = teacher.teacherlgn(
                  		teacherid,teacherpassword);

                  if (flag1) {
                       LogInfoDAO infoDAO = new LogInfoDAO();
                     infoDAO.addLog(teacherid);
                  
                     session.setAttribute("teacherid", teacherid);
                     session.setAttribute("teacherpassword", teacherpassword);

                     response.sendRedirect("teacher/index.jsp");
                 } else {
               
                      out.println("<script>alert('用户名或密码错误');window.location='login.jsp';</script>");
                 	
                        }
        	 }if("3".equals(type)){
       	      studentlogin student = new studentlogin();
              boolean flag3 = student.studentlgn(
            		 studentid, uesrpassword);

              if (flag3) {
                   LogInfoDAO infoDAO = new LogInfoDAO();
                 infoDAO.addLog(studentid);
              
                 session.setAttribute("studentid", studentid);
                 session.setAttribute("studentpassword", uesrpassword);

                 response.sendRedirect("student/index.jsp");
             } else {
           
                  out.println("<script>alert('用户名或密码错误');window.location='login.jsp';</script>");
             	
                    }
    	 }
//          else{
//         	 request.getRequestDispatcher("student/index.jsp").forward(request, response);
//         	 }
       %>
       
       
       
       
       
<%--          <%       --%>
//              adminlogin adminDAO = new adminlogin();
//              boolean flag = adminDAO.adminlgn(
//              		adminid,managerpassword);

//              if (flag) {
//                    LogInfoDAO infoDAO = new LogInfoDAO();
//                  infoDAO.addLog(adminid);
             
//                  session.setAttribute("adminid", adminid);
//                  session.setAttribute("managerpassword", managerpassword);

//                 response.sendRedirect("admin/index.jsp");
//              } else {
//                  //response.sendRedirect("login.jsp?userNamePasswordLevelError=error");
//                   out.println("<script>alert('用户名或密码错误');window.location='login.jsp';</script>");
            	
<%--              }     %> --%>
<%-- <%          --%>
            
//              String teacherid = request.getParameter("userId");
//              String teacherpassword = request.getParameter("password");
<%-- %> --%>
<%-- <%              teacherlogin teacher = new teacherlogin(); --%>
//              boolean flag1 = teacher.teacherlgn(
//              		teacherid,teacherpassword);

//              if (flag1) {
//                   LogInfoDAO infoDAO = new LogInfoDAO();
//                 infoDAO.addLog(teacherid);
             
//                 session.setAttribute("teacherid", teacherid);
//                 session.setAttribute("teacherpassword", teacherpassword);

//                 response.sendRedirect("teacher/index.jsp");
//             } else {
//                 //response.sendRedirect("login.jsp?userNamePasswordLevelError=error");
//                  out.println("<script>alert('用户名或密码错误');window.location='login.jsp';</script>");
            	
//             }


<%-- %> --%>
    </body>
</html>