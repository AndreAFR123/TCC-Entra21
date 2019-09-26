var banSys = angular.module("banSys", ['ngRoute']);

banSys.config(function($routeProvider, $locationProvider){
    
	$routeProvider
    .when("/extratos",{templateUrl:'view/extrato.html', controller:'extratoController'})
    .when("/dados-contas",{templateUrl:'view/consulta-conta.html', controller:'contaController'})
    .when("/transferencias",{templateUrl:'view/transferencia.html', controller:'contaController'})
    .when("/depositos",{templateUrl:'view/deposito.html', controller:'depositoController'})
    
    
    
    
    
    
    
    .otherwise({redirectTo:'/'});
	
	  // enable html5Mode for pushstate ('#'-less URLs)
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
	
}); 