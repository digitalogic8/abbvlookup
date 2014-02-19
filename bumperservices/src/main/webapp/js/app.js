var phonecatApp = angular.module('eubumperapp', [
  'ngRoute', 'eubumperControllers','eubumperServices'
]);
 
phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/registerUser', {
        templateUrl: 'registeruser.jsp',
        controller: 'registerUserCtrl'
      }).when('/login', {
          templateUrl: 'login.jsp',
          controller: 'loginCtrl'
        }).
      when('/displayabbv/:abbv', {
        templateUrl: 'displayabbv.jsp',
        controller: 'displayAbbvCtrl'
      }).when('/userprofile/:username', {
          templateUrl: 'userprofile.jsp',
          controller: 'displayUserProfileCtrl'
        }).
      when('/main', {
          templateUrl: 'main.jsp',
          controller: 'mainCtrl'
        }).
      otherwise({
        redirectTo: '/main'
      });
  }]);