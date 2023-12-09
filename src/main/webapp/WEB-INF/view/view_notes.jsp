<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body>
  
  <%@include file="/WEB-INF/resources/component/navbar.jsp" %>
    <div class="container-fluid p-2">
      <h4 class="text-center">View All Notes</h4>
       <c:if test="${not empty msg }">
           <p class="fs-5 fw-bold text-sucess text-center">${msg }</p>
           <c:remove var="msg"/>
         </c:if>
         <div class="row">
           <c:forEach items="${list}" var="notes">
           <div class="col-md-10 offset-md-1 mt-2">
             <div class="card">
               <div class="card-body">
                 <div class="text-center">
                  <img alt="notes_img" src="<c:url value="/WEB-INF/resources/img  "/>" 
                       witdh="50%" height="50vh">  
                </div>
                  <p>${notes.title}</p>
                  <p>${notes.description}</p>
                  <p>Publish Date :${notes.date}</p>
                  
                  <div class="text-center">
                     <a href="editNotes?id=${notes.id}" class="btn btn-primary btn-sm">Edit</a>
                     <a href="deleteNotes?id=${notes.id}" class="btn btn-danger btn-sm">Delete</a>
                  </div>
            </div>
          </div>
        </div>
     </c:forEach>  
  <!--  <div class="col-md-10 offset-md-1 mt-2">
          <div class="card">
            <div class="card-body">
              <div class="text-center">
                 <img alt="notes_img" src="<c:url value="/WEB-INF/resources/img  "/>" 
                       witdh="50%" height="50vh">  
               </div>
                  <p>What is Python ?</p>
                  <p>Python is programming Langauage</p>
                  <p>Publish Date :2023-12-07</p>
                  
                  <div class="text-center">
                     <a href="editNotes" class="btn btn-primary btn-sm">Edit</a>
                     <a href="editNotes" class="btn btn-danger btn-sm">Delete</a>
                  </div>
            </div>
          </div>
        </div> -->
        
      </div>
    </div> 

</body>
</html>