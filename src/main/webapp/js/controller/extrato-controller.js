banSys.controller("extratoController", function($scope, $http) {

	$scope.listaExtrato = [];
	$scope.extrato= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaExtrato = function() {
		$http({
			method : 'GET',
			url : urlApi + 'extratos/'
		}).then(function(response) {
			$scope.listaExtrato = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarExtrato = function() {
		var metodo = 'POST';

		if ($scope.extrato.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'extratos/',
			data : $scope.extrato
		}).then(function(response) {
			$scope.listaExtrato.push(response.data);
			$scope.listaExtrato();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteExtrato = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'extratos/' + id
		}).then(function(response) {
			$scope.listaExtrato.splice(id, 1);
			$scope.listaExtrato();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarExtrato = function(extrato) {
		$scope.extrato = angular.copy(extrato);
	}

	$scope.cancelarAlteracaoExtrato = function(extrato) {
		$scope.extrato = {};
	};

});