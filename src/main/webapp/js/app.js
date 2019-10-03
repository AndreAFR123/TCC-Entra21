var banSys = angular.module("banSys", ['ngRoute']);

banSys.config(function($routeProvider, $locationProvider){
    
	$routeProvider
    .when("/extratos",{templateUrl:'view/extrato.html', controller:'contaController'})
    .when("/dados-contas",{templateUrl:'view/consulta-conta.html', controller:'contaController'})
    .when("/transferencias",{templateUrl:'view/transferencia.html', controller:'contaController'})
    .when("/depositos",{templateUrl:'view/deposito.html', controller:'contaController'})
    .when("/emprestimos",{templateUrl:'view/emprestimo.html', controller:'contaController'})
    
    .when("/nova-conta",{templateUrl:'view/add-conta.html', controller:'contaController'})
    .when("/dado-conta",{templateUrl:'view/consulta-conta.html', controller:'contaController'})
    .when("/edit-conta",{templateUrl:'view/edit-conta.html', controller:'contaVisualizarController'})
    .when("/visualizar-conta/:id",{templateUrl:'view/view-conta.html', controller:'contaVisualizarController'})
   
    .when("/novo-func",{templateUrl:'view/add-func.html', controller:'funcController'})
    .when("/dado-func",{templateUrl:'view/consulta-func.html', controller:'funcController'})
    .when("/edit-func/:id",{templateUrl:'view/edit-func.html', controller:'funcVisualizarController'})
    .when("/visualizar-func/:id",{templateUrl:'view/view-func.html', controller:'funcVisualizarController'})
    
    .when("/novo-cliente",{templateUrl:'view/add-cliente.html', controller:'clienteController'})
    .when("/dado-cliente",{templateUrl:'view/consulta-cliente.html', controller:'clienteController'})
    .when("/edit-cliente/:id",{templateUrl:'view/edit-cliente.html', controller:'clienteVisualizarController'})
    .when("/visualizar-cliente/:id",{templateUrl:'view/view-cliente.html', controller:'clienteVisualizarController'})
    
    .when("/nova-agencia",{templateUrl:'view/add-agencia.html', controller:'agenciaController'})
    .when("/dado-agencia",{templateUrl:'view/consulta-agencia.html', controller:'agenciaController'})
    .when("/edit-agencia/:id",{templateUrl:'view/edit-agencia.html', controller:'agenciaVisualizarController'})
    .when("/visualizar-agencia/:id",{templateUrl:'view/view-agencia.html', controller:'agenciaVisualizarController'})
    
    .when("/novo-banco",{templateUrl:'view/add-banco.html', controller:'bancoController'})
    .when("/dado-banco",{templateUrl:'view/consulta-banco.html', controller:'bancoController'})
    .when("/edit-banco/:id",{templateUrl:'view/edit-banco.html', controller:'bancoVisualizarController'})
    .when("/visualizar-banco/:id",{templateUrl:'view/view-banco.html', controller:'bancoVisualizarController'})
    
    .when("/",{templateUrl:'view/inicio.html', controller:'mainController'})
        
     
        
    .otherwise({redirectTo:'/'});
	
	// enable html5Mode for pushstate ('#'-less URLs)
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
	
}); 