<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List all pets</title>
</head>
<body>

<jsp:include page="menu.jsp" />


<c:if test="${petList.size() == 0}" >
<h1>No pets in the database
</h1>
</c:if>


<table>
  <c:forEach items="${petList}" var="item">
	<td><c:out value="____________________________________" /></td>
    <tr>
      <td><c:out value="Pet name: ${item.nome}" /></td>
    </tr>
    <tr>
      <td><c:out value="Pet birth date: ${item.dataNascita}" /></td>
    </tr>
  	<tr>
      <td><c:out value="____________________________________" /></td>
	
    </tr>
  </c:forEach>
</table>

 

</body>
</html>