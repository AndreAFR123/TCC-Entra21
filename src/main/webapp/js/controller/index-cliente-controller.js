banSys.controller("index-clienteController", function($scope, $http) {

	$scope.listaIndex-cliente = [];
	$scope.index-cliente= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaindex-cliente = function() {
		$http({
			method : 'GET',
			url : urlApi + 'index-clientes/'
		}).then(function(response) {
			$scope.listaIndex-cliente = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarIndex-cliente = function() {
		var metodo = 'POST';

		if ($scope.index-cliente.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'index-clientes/',
			data : $scope.index-cliente
		}).then(function(response) {
			$scope.listaIndex-cliente.push(response.data);
			$scope.listaIndex-cliente();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteIndex-cliente = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'index-cliente/' + id
		}).then(function(response) {
			$scope.listaIndex-cliente.splice(id, 1);
			$scope.listaIndex-cliente();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarIndex-cliente = function(index-cliente) {
		$scope.index-cliente = angular.copy(index-cliente);
	}

	$scope.cancelarAlteracaoIndex-cliente = function(index-cliente) {
		$scope.index-cliente = {};
	};

});