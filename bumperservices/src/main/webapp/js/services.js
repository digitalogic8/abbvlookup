var phonecatServices = angular.module('eubumperServices', ['ngResource']);
 
phonecatServices.factory('User', ['$resource',
  function($resource){
    return $resource('services/user/registerUser', {}, {
      save: {method:'GET', params:'user', isArray:false}
    });
  }]);