var banSys = angular.module("banSys", ['ngRoute']);

banSys.config(function($routeProvider, $locationProvider){
    
	$routeProvider
    .when("/extratos",{templateUrl:'view/extrato.html', controller:'extratoController'})
    .when("/dados-contas",{templateUrl:'view/consulta-conta.html', controller:'contaController'})
    .when("/transferencias",{templateUrl:'view/transferencia.html', controller:'contaController'})
    .when("/depositos",{templateUrl:'view/deposito.html', controller:'depositoController'})
    .when("/emprestimos",{templateUrl:'view/emprestimo.html', controller:'8888888'})
    
    .when("/novas-contas",{templateUrl:'view/add-conta.html', controller:'contaController'})
    .when("/edits-contas",{templateUrl:'view/edit-conta.html', controller:'contaController'})
   
    .when("/novo-func",{templateUrl:'view/add-func.html', controller:'funcController'})
    .when("/dado-func",{templateUrl:'view/consulta-func.html', controller:'funcController'})
    .when("/edit-func",{templateUrl:'view/edit-func.html', controller:'funcController'})
    
    .when("/novo-cliente",{templateUrl:'view/add-cliente.html', controller:'clienteController'})
    .when("/dado-cliente",{templateUrl:'view/consulta-cliente.html', controller:'clienteController'})
    .when("/edit-cliente",{templateUrl:'view/edit-cliente.html', controller:'clienteController'})
    
    .when("/nova-agencia",{templateUrl:'view/add-agencia.html', controller:'agenciaController'})
    .when("/dado-agencia",{templateUrl:'view/consulta-agencia.html', controller:'agenciaController'})
    .when("/edit-agencia",{templateUrl:'view/edit-agencia.html', controller:'agenciaController'})
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    .otherwise({redirectTo:'/'});
	
	  // enable html5Mode for pushstate ('#'-less URLs)
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
	
}); 