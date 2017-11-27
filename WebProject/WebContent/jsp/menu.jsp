<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<c:if test="${ empty user }">
	<jsp:forward page="/jsp/home.jsp"></jsp:forward>
</c:if>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  	<ul class="navbar-nav mr-auto">
	  <li class="nav-item" onmouseover="menu_over(this);" onmouseout="menu_out(this);" >
	    <a id="menu1" class="nav-link" href="${ contextPath }/jsp/subscribe.jsp">Subscribe<span class="sr-only">(current)</span></a>
	  </li>
	  <li class="nav-item dropdown">
	  	<a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
		    About Team
		</a>
	  	<div class="dropdown-menu dropdown-menu" aria-labelledby="bd-versions">
		     	<button id="menu2-1" type="button" class="dropdown-item" onclick="location.href='${ contextPath}/jsp/schedule.jsp' ">Schedule</button>
		     	<button id="menu2-1" type="button" class="dropdown-item" onclick="location.href='${ contextPath}/jsp/rosters.jsp' ">Rosters</button>
	     		<button id="menu2-1" type="button" class="dropdown-item">Info</button>
	   	</div>
	   </li>
	  <li class="nav-item dropdown">
	  	<a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    About Game
		</a>
	  	<div class="dropdown-menu dropdown-menu" aria-labelledby="bd-versions">
		     	<button type="button" class="dropdown-item">Score</button>
		     	<button type="button" class="dropdown-item">Starting Lineup</button>
	     		<button type="button" class="dropdown-item">Highlights</button>
	   	</div>
	   </li>
	  <li class="nav-item dropdown">
	  	<a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    About Player
		</a>
	  	<div class="dropdown-menu dropdown-menu" aria-labelledby="bd-versions">
		     	<button type="button" class="dropdown-item">Info</button>
	     		<button type="button" class="dropdown-item">Stats</button>
	   	</div>
	   </li>
	</ul>
    
	    <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
	    <li class="nav-item dropdown">
	      <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    	${ user.name } 님
	      </a>
	      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
	      	<form action="${ contextPath }/logout.do" method="post">
	      		<button type="submit" class="dropdown-item">Sign out</button>
	      	</form>
	      </div>
	    </li>
	    </ul> 
  </div>
</nav>

