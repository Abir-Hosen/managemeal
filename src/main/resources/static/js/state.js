app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise("/");
	$stateProvider
	.state("home", {
		url: '/',
		views: {
			'main': {
				templateUrl: 'templates/home.html'
			}
		}
	})
	.state("meal", {
		url: '/meal',
		views: {
			'main': {
				templateUrl: 'templates/meal.html'
			}
		}
	})
	.state("hostelMember", {
		url: '/hostel-member',
		views: {
			'main': {
				templateUrl: 'templates/hostel-member.html'
			}
		}
	})
	.state("viewLastMealStudent", {
		url: '/view-last-meal-student',
		views: {
			'main': {
				templateUrl: 'templates/home.html'
			}
		}
	})
	.state("viewMyAllMeal", {
		url: '/view-my-all-meal',
		views: {
			'main': {
				templateUrl: 'templates/home.html'
			}
		}
	})
	.state("reviewLastMeal", {
		url: '/review-last-meal',
		views: {
			'main': {
				templateUrl: 'templates/home.html'
			}
		}
	})
	.state("wooly", {
		url: '*path',
		views: {
			'main': {
				templateUrl: 'templates/home.html'
			}
		}
	});
}]);

app.controller('addMealController', ['$scope', '$mdDialog', '$apiurl', function($scope, $mdDialog, $apiurl){
	'use strict';
	this.cancel = $mdDialog.cancel;
	function success(response){
		$mdDialog.hide(response);
	}
	this.addItem = function () {
		$apiurl.dailyMeal.save($scope.meal, success);
	};
	
}]);
app.controller('updateMealController', ['$scope', '$mdDialog', '$apiurl', 'item', function($scope, $mdDialog, $apiurl, item){
	'use strict';
	this.cancel = $mdDialog.cancel;
	$scope.meal = item;
	function success(response){
		$mdDialog.hide(response);
	}
	this.updateItem = function () {
		$apiurl.dailyMeal.update($scope.meal, success);
	};
	
}]);
app.controller('deleteMealController', ['$scope', '$mdDialog', '$apiurl', 'item', function($scope, $mdDialog, $apiurl, item){
	'use strict';
	this.cancel = $mdDialog.cancel;
	function success(response){
		$mdDialog.hide(response);
	}
	this.deleteEntity = function () {
		$apiurl.dailyMeal.remove({id: item.id}, success);
	};
	
}]);


app.controller('addHostelMemberController', ['$scope', '$mdDialog', '$apiurl', function($scope, $mdDialog, $apiurl){
	'use strict';
	this.cancel = $mdDialog.cancel;
	function success(response){
		$mdDialog.hide(response);
	}
	this.addItem = function () {
		$apiurl.users.save($scope.member, success);
	};
	
}]);
app.controller('deleteHostelMemberController', ['$scope', '$mdDialog', '$apiurl', 'item', function($scope, $mdDialog, $apiurl, item){
	'use strict';
	this.cancel = $mdDialog.cancel;
	function success(response){
		$mdDialog.hide(response);
	}
	this.deleteEntity = function () {
		$apiurl.users.remove({id: item.id}, success);
	};
	
}]);

app.controller('memberCtrl', ['$scope', '$mdDialog', '$apiurl', function($scope, $mdDialog, $apiurl){
	console.log("Member Controller!");
	$scope.session_id=id;
	
	$scope.addMeal =  function(){
	    $mdDialog.show({
	      clickOutsideToClose: true,
	      controller: 'addMealController',
	      controllerAs: 'ctrl',
	      focusOnOpen: false,
	      templateUrl: 'templates/add-meal.html',
	    }).then($scope.getMealResponse);
	};
	$scope.updateMeal =  function(event){
	    $mdDialog.show({
	      clickOutsideToClose: true,
	      controller: 'updateMealController',
	      controllerAs: 'ctrl',
	      locals:{ item : event },
	      focusOnOpen: false,
	      templateUrl: 'templates/update-meal.html',
	    }).then($scope.getMealResponse);
	};
	$scope.deleteMeal =  function(event){
	    $mdDialog.show({
	      clickOutsideToClose: true,
	      controller: 'deleteMealController',
	      controllerAs: 'ctrl',
	      locals:{ item : event },
	      focusOnOpen: false,
	      templateUrl: 'templates/delete.html',
	    }).then($scope.getMealResponse);
	};
	$scope.query = {
		filter: '',
		limit: '400',
		page: 1,
		order: 'id'
	};
	function successMeal(response) {
		$scope.meals = response;
	}
	$scope.getMealResponse = function () {
		$scope.promise = $apiurl.dailyMeal.get($scope.query, successMeal).$promise;
	};
	$scope.getMealResponse();
	
	//
	
	$scope.addHostelMember=  function(){
	    $mdDialog.show({
	      clickOutsideToClose: true,
	      controller: 'addHostelMemberController',
	      controllerAs: 'ctrl',
	      focusOnOpen: false,
	      templateUrl: 'templates/add-hostel-member.html',
	    }).then($scope.getHostelMemberResponse);
	};
	$scope.deleteHostelMember =  function(event){
	    $mdDialog.show({
	      clickOutsideToClose: true,
	      controller: 'deleteHostelMemberController',
	      controllerAs: 'ctrl',
	      locals:{ item : event },
	      focusOnOpen: false,
	      templateUrl: 'templates/delete.html',
	    }).then($scope.getHostelMemberResponse);
	};
	$scope.query = {
		filter: '',
		limit: '400',
		page: 1,
		order: 'id'
	};
	function successHostelMember(response) {
		$scope.users = response;
	}
	$scope.getHostelMemberResponse = function () {
		$scope.promise = $apiurl.users.get($scope.query, successHostelMember).$promise;
	};
	$scope.getHostelMemberResponse();
	

}]);











