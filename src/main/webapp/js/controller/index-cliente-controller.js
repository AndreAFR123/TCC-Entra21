banSys.controller("index-clienteController", function($scope, $http) {

	$scope.listaIndex_cliente = [];
	$scope.index_cliente= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaindex_cliente = function() {
		$http({
			method : 'GET',
			url : urlApi + 'index-clientes/'
		}).then(function(response) {
			$scope.listaIndex_cliente = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarIndex_cliente = function() {
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
	$scope.deleteIndex_cliente = function(id) {

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
	$scope.alterarIndex_cliente = function(index_cliente) {
		$scope.index_cliente = angular.copy(index-cliente);
	}

	$scope.cancelarAlteracaoIndex_cliente = function(index_cliente) {
		$scope.index_cliente = {};
	};

});