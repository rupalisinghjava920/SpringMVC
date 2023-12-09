<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="/WEB-INF/resources/component/all_link.jsp" %>
<body>
  
  <%@include file="/WEB-INF/resources/component/navbar.jsp" %>
    <div class="container-fluid p-0 m-0">
       <img alt="notes_img" src="<c:url value="/WEB-INF/resources/img/nts.png"/>" 
       witdh="100%" height="800vh">
    </div> 
  
</body>
</html>