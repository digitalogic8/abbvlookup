var phonecatControllers = angular.module('eubumperControllers', []);
 
phonecatApp.controller('registerUserCtrl', ['$scope', 'User', '$location', function($scope, User, $location) {
//   Do initializing things here
	
//
	 $scope.registerUser = function(user) {
	      message = User.save(user, function(message) {
	    	  if(message.status == "OK"){
	    	      $location.path("login"); // path not hash
	    	  } else {
	    		  $scope.message = message.message;
	    	  }
	      });

	    };
  }]);
phonecatApp.controller('loginCtrl', ['$scope', 'User', function($scope, User) {
//  Do initializing things here
	
//
	 $scope.registerUser = function(user) {
	      message = User.save(user, function(message) {
	    	  if(message.status == "OK"){
	    	      $location.path("login"); // path not hash
	    	  } else {
		      alert(message.status + " " + message.message);
	    	  }
	      });

	    };
 }]);
 
phonecatControllers.controller('displayAbbvCtrl', ['$scope', '$routeParams',
                                            function($scope, $routeParams) {
//                                              $scope.phoneId = $routeParams.phoneId;
                                            }]);
phonecatControllers.controller('mainCtrl', ['$scope', '$routeParams',
  function($scope, $routeParams) {
//    $scope.phoneId = $routeParams.phoneId;
  }]);