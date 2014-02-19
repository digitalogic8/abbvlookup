<!doctype html>
<html lang="en" ng-app="eubumperapp">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.11/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.11/angular-route.js"></script>
<script src="js/app.js"></script>
<script src="js/controllers.js"></script>
</head>
<body>

	<div ng-view>
		<div ng-include src="../header.jsp"></div>

		<ul>
			<li>change name</li>
			<li>change email</li>
			<li>change password</li>
			<li>change phone number</li>
			<li>change billing information</li>
			<li>change company information</li>
			<li>change what users can see about who owns this abbv</li>
		</ul>



		<div ng-include src="../footer.jsp"></div>

	</div>

</body>
</html>



