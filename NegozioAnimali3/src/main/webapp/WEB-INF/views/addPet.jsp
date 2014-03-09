<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add a pet</title>
</head>
<body>

<jsp:include page="menu.jsp" />


<h1> Add a new pet</h1>

   <h2>Please enter information about the pet</h2>
    <form action="addPet" method="POST">
        <label>Add pet name: 
        	<input type="text" name="Nome" id="nome" />
        </label><br />
		<label>Add pet name:
		<input type="text" name="Date" id="birthdate" />
        </label><br />
        <input type="submit" value="Submit" name="submit" />
    </form>

</body>
</html>