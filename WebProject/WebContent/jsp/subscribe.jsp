<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
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
function change_image(e)
{
	var team = e.innerHTML; 
	var steam = document.getElementById('selected-team');
	steam.value = team;
	
	var image = document.getElementById('logo');
	image.setAttribute('src',"${contextPath}/image/" + team + " logo.jpg");
	
	document.getElementById('sb-button').disabled = false;
}
</script>


</head>
<body>
	<%@ include file="menu.jsp" %>

<% 
	List<String> teams = new ArrayList<String>();
	teams.add("Boston Celtics");
	teams.add("Brooklyn Nets");
	teams.add("New York Knicks");
	teams.add("Philadelphia 76ers");
	teams.add("Toronto Raptors");
	teams.add("Chicago Bulls");
	teams.add("Cleveland Cavaliers");
	teams.add("Detroit Pistons");
	teams.add("Indiana Pacers");
	teams.add("Milwaukee Bucks");
	teams.add("Charlotte Hornets");
	teams.add("Miami Heat");
	teams.add("Washington Wizards");
	teams.add("Denver Nuggets");
	teams.add("Minnesota Timberwolves");
	teams.add("Oklahoma City Thunder");
	teams.add("Portland Trail Blazers");
	teams.add("Utah Jazz");
	teams.add("Golden State Warriors");
	teams.add("Los Angeles Clippers");
	teams.add("Los Angeles Lakers");
	teams.add("Phoenix Suns");
	teams.add("Sacramento Kings");
	teams.add("Dallas Mavericks");
	teams.add("Houston Rockets");
	teams.add("Memphis Grizzlies");
	teams.add("New Orleans Pelicans");
	teams.add("San Antonio Spurs");
	teams.add("Orlando Magic");
	teams.add("Atlanta Hawks");
%>

<div style="border:1px soild; float:left; width:35%">
	<div class="list-group" style="max-height: 900px; overflow-y: scroll;">
		<c:forEach var="team" items="<%= teams %>">
			<a class="list-group-item list-group-item-action" onclick="change_image(this);">${ team }</a>
		</c:forEach>
	</div>
</div>
<div style="border:1px soild; float:left; width:65%">
	<img id="logo" src="${ contextPath }/image/NBA logo.jpg" width="100%">
	<br>
	<div align="center">
		<form action="${ contextPath }/updateTeam.do" method="post">
			<br>
			<input type="text" class="form-control form-control-lg" id="selected-team" aria-describedby="emailHelp" placeholder="Select team" name="teamName" style="text-align: center;" readonly="readonly">
			<br><br>
			<button type="submit" id="sb-button" class="btn btn-primary btn-lg" disabled="disabled">Subscribe</button>
		</form>	
	</div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>