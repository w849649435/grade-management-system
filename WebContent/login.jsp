<%-- 
    Document   : main
    Created on : 2015-11-15, 10:15:22
    Author     : Administrator
--%>
<%@page import="note.dao.LogInfoDAO"%>
<%@page import="loginDMO.adminlogin"%>
<%@page import="com.sun.glass.ui.Size"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>

<script type="text/javascript" src="<%=request.getContextPath()%>/res/js/jquery.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css" type="text/css" media="screen" />


<!--<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">-->


</head>
<body>
    <div class="jumbotron">

    
<div class="div_from_aoto" style="width: 500px;">
    <h3>欢迎使用成绩查询管理系统</h3>
       
    <FORM  action="check.jsp" method="post"> 
        <div class="control-group">
            <label class="laber_from">用户类型</label>
            <div  class="controls" >
            <select id="type" name="type">
	<option   value="2">   管理员用户     </option>
	<option   value="1">      教师      </option>
	<option   value="3">      学生      </option>
           </select>
<!--            <select name="type"> -->
<!--                 <option value="1">普通用户</option> -->
<!--                 <option value="2">管理员</option> -->
<!--             </select> -->
<!--             <input type="submit"> -->

            <p class=help-block></p></div>
        </div>
        <div class="control-group">
            <label class="laber_from">用户名</label>
            <div  class="controls" ><input class="input_from" type=text name="userId"  ><p class=help-block></p></div>
        </div>
        <div class="control-group">
            <label class="laber_from">密码</label>
            <div  class="controls"><input class="input_from" type=password  name="password"><p class=help-block></p></div>
        </div>
        
        
        <div class="control-group">
            <label class="laber_from" ></label>
            <button class="btn btn-lg btn-primary " type="submit">登 陆</button>
        </div>
      
    </FORM>
</div>
    </div>
    
</body>
</html>