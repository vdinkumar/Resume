
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="jquery-ui-1.8.18.custom/development-bundle/themes/base/jquery.ui.all.css">
	<script src="jquery-ui-1.8.18.custom/development-bundle/jquery-1.7.1.js" type="text/javascript"></script>
	<script src="jquery-ui-1.8.18.custom/development-bundle/ui/jquery.ui.core.js" type="text/javascript"></script>
	<script src="jquery-ui-1.8.18.custom/development-bundle/ui/jquery.ui.widget.js" type="text/javascript"></script>
	<script src="jquery-ui-1.8.18.custom/development-bundle/ui/jquery.ui.datepicker.js" type="text/javascript"></script>
       <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
	<script type="text/javascript">
	$(function() {
		$( "#datepicker" ).datepicker({
			//showOn: "button",
			//buttonImage: "images/calendar.gif",
			//buttonImageOnly: true,
                        changeYear: true,
			changeMonth:true,
			yearRange: "1960:1991",
                        dateFormat: "dd/mm/yy"


		});
	});
        
    $(document).ready(function(){
        
        
        $('#checkavailability').click(function(){
            
            check();
      /*  $.ajax({
            
            type: "post",
            url: "checkavailability",
            data: "username="+$('#username').val(),
            success:  function(msg){
                
        $('#status').html(msg);
                
                    }
            
            
            
            
            
            
        });*/
            
            
        });
        
        
        
        
        
        
        
    });
    
   
        
        function check(){
            $.ajax({
            
            type: "post",
            url: "checkavailability",
            data: "username="+$('#username').val(),
            success:  function(msg){
                
                if(msg=="yes")
        $('#status').html("Username is available");
           else
                $('#status').html("Sorry!Username is already taken");
                
                    }
            
            
            
            
            
            
        });
        }
        
        
        
        
        
        
        
	</script>
    </head>
    <body style="background-color:#049cdb">

        <%
        if(request.getAttribute("message")!=null)
        {
            out.println("<div class='alert alert-info'>"+request.getAttribute("message")+"</div>");
        }
 %>

        <div class="container" >
            <h1>Please fill in the following details</h1>
        <div class="well form-vertical">
            <form action="register" method="post" name="register">
           
            <label>Name*</label>
            <input type="text" name="name" style="height:30px" class="input-xlarge"/>

            <label>Date Of Birth*</label>
            <input type="text" name="DOB" id="datepicker" style="height:30px" autocomplete="off"/>

            <label>Address*</label>
            <textarea name="address" row="25" cols="35"></textarea>

            <label>Mobile*</label>
            <input type="text" name="mobile" style="height:30px" maxlength="12"/>

            <label>Email*</label>
            <input type="text" name="email" style="height:30px" />


            <label>Specialization*</label>
            <select name="specialization_id">

                <option value="1">Developer</option>
                <option value="2">Sales</option>

            </select>

            <label>Work experience*</label>
            <input type="text" name="work_experience" style="height:30px"/>


            <label>Username*</label>
            <input id="username" type="text" name="username"  style="height:30px" autocomplete="off"/>
            <a href="#" id="checkavailability">Check Availability</a>
            <div id="status"></div>
            
            <label>Password*</label>
            <input type="password" name="password" style="height:30px"/>
            
            <label>Confirm password*</label>
            <input type="password" name="confirmPassword" style="height:30px"/>
            <br/>
            <input type="submit" class="btn" value="SUBMIT" />

        </form>
        </div>
        </div>


    </body>
</html>
