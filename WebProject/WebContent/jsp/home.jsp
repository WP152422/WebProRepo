<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="${ contextPath }/css/vegas.min.css">
</head>
<body>
<c:if test="${ !empty user }">
<jsp:forward page="/jsp/subscribe.jsp"></jsp:forward>
</c:if>

<button type="button" class="btn btn-light" data-toggle="modal" data-target="#signinModal" style="position: fixed; margin-left position:absolute; right: 120px; top: 10px">Sign In</button>
<button type="button" class="btn btn-light" data-toggle="modal" data-target="#signupModal" style="position: fixed; margin-left position:absolute; right: 20px; top: 10px">Sign Up</button>



<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<script src="${ contextPath }/js/vegas.min.js"></script>

<c:if test="${ !empty error }">
	<script>
		var myModal = $("#myModal");
		myModal.find(".modal-title").text("Login Error");
		myModal.find(".modal-body").text("${ error }");
		myModal.modal();
	</script>
</c:if>

<script>
$("#example, body").vegas({
    slides: [
        { src: "${ contextPath }/image/image1.jpg" },
        { src: "${ contextPath }/image/image2.jpg" },
        { src: "${ contextPath }/image/image3.jpg" }
    ]
});
</script>



</body>
</html>


