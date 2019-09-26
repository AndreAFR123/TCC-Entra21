var banSys = angular.module("banSys", ['ngRoute']);

banSys.config(function($routeProvider, $locationProvider){
    
	$routeProvider
    .when("/extratos",{templateUrl:'view/extrato.html', controller:'extratoController'})    
    
    
    
    
    
    
    
    .otherwise({redirectTo:'/'});
	
	  // enable html5Mode for pushstate ('#'-less URLs)
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
	
}); 