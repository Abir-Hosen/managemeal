var app = angular.module("myApp", ['ui.router', 'ngMaterial', 'ngMessages', 'ngResource']);


/*     =========== ALL ABOUT AUTHENTICATION ==========  */
app.controller("loginCtrl", function($scope, $http, $log){
	$log.debug("Login Page Controller called!");
	$scope.name = "Login Page Controller called!";
});

app.controller("signupCtrl", function($scope, $http, $log){
	$log.debug("Sign Up Page Controller called!");
	$scope.name = "Sign Up Page Controller called!";
});
/*     =========== ALL ABOUT AUTHENTICATION DONE ==========  */