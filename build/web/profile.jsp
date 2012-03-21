<%-- 
    Document   : profile
    Created on : Mar 17, 2012, 10:02:07 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
          <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
          <script src="jquery-ui-1.8.18.custom/development-bundle/jquery-1.7.1.js" type="text/javascript"></script>
          <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
          <script type="text/javascript">
              
              $(document).ready(function(){
                  
                  <%
                  if(request.getParameter("editor1")==null)
                  out.print("$('#editor').hide()");
                  %>
                  
                  $('#resume').click(function(){
                      
                  $('#editor').slideToggle("slow");
                      
                      
                  });
                  
    /*  $('#saveajax').click(function(){
            
            $('#status').html("Saving....");
       $.ajax({
            
            type: "post",
            url: "resumeupdate",
            data: "editor1="+$('#editor1').val(),
            success:  function(msg){
                
        $('#status').html(msg);
                
                    }
            
            
            
            
            
            
        });
                  
                  
                  
              });*/
              });
              
              
          </script>

    </head>
    <body>
        <div class="offset11"><a href="logout" class="btn" >Logout</a></div>
        <h1>Profile Data</h1> 
        <jsp:useBean id="p" class="model.profilebean" scope="request"/>
        <table class="table table-bordered table-striped">
        <tr><td>Name</td><td><jsp:getProperty property="name" name="p"/></td></tr>
        <tr><td>Date of Birth</td><td><jsp:getProperty property="DOB" name="p"/></td></tr>
        <tr><td>Address</td><td><jsp:getProperty property="address" name="p"/></td></tr>
       <tr><td> Mobile</td><td><jsp:getProperty property="mobile" name="p"/></td></tr>
        <tr><td>Email</td><td><jsp:getProperty property="email" name="p"/></td></tr>
        <tr><td>Specialization ID</td><td><jsp:getProperty property="specialization_id" name="p"/></td></tr>
        <tr><td>Work experience</td><td><jsp:getProperty property="work_experience" name="p"/></td></tr>
        </table>
        
        <a href="#" id="resume">Resume</a>
        <div id="editor">
            <form method="post" action="resumeupdate">
        <textarea id="editor1" name="editor1"><jsp:getProperty property="resume" name="p"/></textarea>
          <script type="text/javascript">
				CKEDITOR.replace( 'editor1',
                            
                    {toolbar : 'Mytoolbar'}    
                    );
	 </script>
        
            </form>
         <div id="status"></div>
         </div>
    </body>
</html>
