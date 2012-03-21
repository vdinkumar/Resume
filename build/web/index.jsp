<%-- 
    Document   : index
    Created on : Mar 15, 2012, 10:10:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Sample CKEditor Site</title>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
        <script type="text/javascript">
	window.onload = function()
	{
		CKEDITOR.replace( 'editor1' );
	};
</script>
</head>
<body>
	<form method="post">
		<p>
			My Editor:<br />
			<textarea id="editor1" name="editor1">&lt;p&gt;Initial value.&lt;/p&gt;</textarea>
			
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>
</body>
</html>
