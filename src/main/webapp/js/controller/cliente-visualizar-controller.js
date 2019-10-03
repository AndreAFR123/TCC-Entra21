banSys.controller("clienteVisualizarController", function ($scope, $http, $routeParams) {

	var url = 'rest/clientes/';
	$scope.bancoVisualizar = {};
	
    $http.get(url + $routeParams.id).then(function (response) {
        $scope.clienteVisualizar = response.data;
    }, function (response) {
        console.log('error - clienteVisualizarController');
    });
    
    
    $scope.editarCliente = function() {
		$http({
			method : 'PUT',
			url : url,
			data : $scope.clienteVisualizar
		}).then(function(response) {
			console.log('salvar - editarCliente');
		}, function(response) {
			console.log('error - editarCliente');
		});
	};
	
});