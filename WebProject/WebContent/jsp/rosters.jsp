<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.dimigo.api.API" %>
<%@ page import="org.dimigo.vo.UserVO" %>
<%@ page import="java.util.Map" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Insert title here</title>
<script>
function menu_over(e) {
	e.setAttribute("class", "nav-item active");
}
function menu_out(e) {
	e.setAttribute("class", "nav-item");
}
</script>
<%
	Map<String, String> roaster = API.parseRosters( ((UserVO)session.getAttribute("user")).getTeamName());
	String pg = roaster.get("PG").substring(0, roaster.get("PG").length() -1);
	String sg = roaster.get("SG").substring(0, roaster.get("SG").length() -1);
	String pf = roaster.get("PF").substring(0, roaster.get("PF").length() -1);
	String sf = roaster.get("SF").substring(0, roaster.get("SF").length() -1);
	String c = roaster.get("C").substring(0, roaster.get("C").length() -1);
	String coaches = roaster.get("coaches").substring(0, roaster.get("coaches").length() -1);
%>

</head>
<body>
	<%@ include file="menu.jsp" %>

<div style="margin-left: 50px; margin-top: 50px;">
<h1>Point Guard : <%= pg %></h1>
<br>
<h1>Shooting Guard : <%= sg %></h1>
<br>
<h1>Center : <%= c %></h1>
<br>
<h1>Small Forward : <%= sf %></h1>
<br>
<h1>Power Forward : <%= pf %></h1>
<br>
<h1>Coach : <%= coaches %></h1>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>