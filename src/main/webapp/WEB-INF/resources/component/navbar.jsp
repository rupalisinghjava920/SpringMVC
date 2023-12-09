    <!-- Start navbar -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>   
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
         <a class="navbar-brand" href="#"><i class="fa-solid fa-book"></i>Enotes</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" 
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                    aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
            </button>

       <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                 <a class="nav-link" href="home"><i class="fa-solid fa-home"></i>Home</a>
              </li>
            <c:if test="${not empty studentObj}">
              <li class="nav-item">
                  <a class=  "nav-link" href="${pageContext.request.contextPath}/addNotes">Add Notes</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/viewNotes">View Notes</a>
               </li>
            </c:if>
          </ul>
       <form class="d-flex">
       
           <c:if test="${empty studentObj }">
              <a href="login" class="btn btn-light me-2" type="submit">Login</a>
              <a href="register" class="btn btn-light me-2" type="submit">Register</a>
           </c:if> 
           
           <c:if test="${not empty studentObj }">
              <a href="#" class="btn btn-light me-2" type="submit"><i class="fa-solid fa-user"></i>${studentObj.fullname}</a>
              <a href="logout" class="btn btn-light me-2" 
                      type="submit">Logout</a>
           </c:if> 
           
       </form>
   </div>
</nav>
