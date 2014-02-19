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
		<div ng-include src="header.jsp"></div>

		<form action="lookUpService">
			<input type="text" name="abbv" size="25"> <input
				type="button" value="Lookup" />
		</form>

		<ul>
			<li>name</li>
			<li>company</li>
			<li>other codes owned</li>
			<li>website</li>
		</ul>



		<div ng-include src="footer.jsp"></div>

	</div>

</body>
</html>

