banSys.controller("depositoController", function($scope, $http) {

	$scope.listaDeposito = [];
	$scope.deposito= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaDeposito = function() {
		$http({
			method : 'GET',
			url : urlApi + 'depositos/'
		}).then(function(response) {
			$scope.listaDeposito = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarDeposito = function() {
		var metodo = 'POST';

		if ($scope.deposito.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'depositos/',
			data : $scope.depositos
		}).then(function(response) {
			$scope.listaDeposito.push(response.data);
			$scope.listaDeposito();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteDeposito = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'depositos/' + id
		}).then(function(response) {
			$scope.listaDeposito.splice(id, 1);
			$scope.listaDeposito();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarDeposito = function(deposito) {
		$scope.deposito = angular.copy(deposito);
	}

	$scope.cancelarAlteracaoDeposito = function(deposito) {
		$scope.deposito = {};
	};

});