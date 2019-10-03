banSys.controller("clienteController", function($scope, $http) {
	var url = 'rest/clientes/'
	$scope.listaCliente = [];
	$scope.cliente = {};

	$scope.listarCliente = function() {
		$http({
			method : 'GET',
			url : url
		}).then(function(response) {
			$scope.listaCliente = response.data;
		}, function(response) {
			console.log('error no metodo listarCliente');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.salvarCliente = function() {
		$http({
			method : 'POST',
			url : url,
			data : $scope.cliente
		}).then(function(response) {
			console.log('Cliente salvo com sucesso.');
		}, function(response) {
			console.log('Erro ao salvar metodo salvarCliente ');
		});
	};

	$scope.deleteCliente = function(id) {
		$http({
			method : 'DELETE',
			url : url + id
		}).then(function(response) {
			console.log('Excluido com Sucesso metodo deleteCliente')
			$scope.listaCliente.splice(id, 1);
			$scope.listaCliente();
		}, function(response) {
			console.log('error do deleteCliente');
			console.log(response.data);
			console.log(response.status);
		});
	};

});
