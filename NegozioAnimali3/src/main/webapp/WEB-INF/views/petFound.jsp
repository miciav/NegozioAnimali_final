<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Pet found</title>
</head>
<body>

<jsp:include page="menu.jsp" />


<c:if test="${pet == null}" >
<h1>Pet not found in the database
</h1>
</c:if>

<c:if test="${pet != null}" >
<c:out value="____________________________________" />
<br/>
<c:out value="Pet name: ${pet.getNome()}" />
<br/>
<c:out value="Pet name: ${pet.getDataNascita()}" />
<br/>
<c:out value="____________________________________" />
<br/>
</c:if>


</body>
</html> 