
banSys.controller("clienteController", function($scope, $http) {

	$scope.listaCliente = [];
	$scope.cliente= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaCliente = function() {
		$http({
			method : 'GET',
			url : urlApi + 'clientes/'
		}).then(function(response) {
			$scope.listaCliente = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.esconderImagem = function(){
		document.getElementById('img-fundo').style.display = "none";
		
	}
	$scope.salvarCliente = function() {
		var metodo = 'POST';

		if ($scope.cliente.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'clientes/',
			data : $scope.cliente
		}).then(function(response) {
			$scope.listaCliente.push(response.data);
			$scope.listaCliente();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteCliente = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'clientes/' + id
		}).then(function(response) {
			$scope.listaCliente.splice(id, 1);
			$scope.listaCliente();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarCliente = function(cliente) {
		$scope.cliente = angular.copy(cliente);
	}

	$scope.cancelarAlteracaoCliente = function(cliente) {
		$scope.cliente = {};
	};

});