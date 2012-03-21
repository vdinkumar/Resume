<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    </head>
    <body>
        <%
        if(request.getAttribute("message")!=null)
        {
            out.println("<div class='alert alert-info'>"+request.getAttribute("message")+"</div>");
        }
 %>

 <div class="well offset6" style="width:250px">
      <h1 >User login</h1>
        <form name="login_details" method="post" action="login">
        <label>Username</label>
        <input type="text" name="username" />
        <label>Password</label>
        <input type="password" name="password" /><br/>
        <input type="submit" name="btn" value="Sign In" class="btn"/>
        </form>
      <a href="#">Forget Password?</a><a href="register.jsp">Sign Up<a/>
     <div>
    </body>
</html>
