<!doctype html>
<html lang="en" ng-app="eubumperapp">
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.11/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.11/angular-route.js"></script>
  <script src="js/app.js"></script>
  <script src="js/controllers.js"></script>
</head>
<body>
 
  <div ng-view>
  	<div ng-include src="header.jsp"></div>
<% if(request.getRemoteUser() == null) { %>
<!-- Not Logged In -->

LOGIN ERROR
<form action="j_security_check" method=post>
    <p><strong>Please Enter Your User Name: </strong>
    <input type="text" name="j_username" size="25">
    <p><p><strong>Please Enter Your Password: </strong>
    <input type="password" size="15" name="j_password">
    <p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

<%} else { %>
<!--  Redirect to index.html-->
<%}%>
	<div ng-include src="footer.jsp"></div>
  
  </div>
 
</body>
</html>

