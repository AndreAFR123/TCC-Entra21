banSys.controller("index-funcionarioController", function($scope, $http) {

	$scope.listaindex-funcionario = [];
	$scope.index-funcionario= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaIndex-funcionario = function() {
		$http({
			method : 'GET',
			url : urlApi + 'index-funcionarios/'
		}).then(function(response) {
			$scope.listaIndex-funcionario = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarIndex-funcionario = function() {
		var metodo = 'POST';

		if ($scope.index-funcionario.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'index-funcionarios/',
			data : $scope.index-funcionario
		}).then(function(response) {
			$scope.listaIndex-funcionario.push(response.data);
			$scope.listaIndex-funcionario();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteIndex-funcionario = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'index-funcionario/' + id
		}).then(function(response) {
			$scope.listaIndex-funcionario.splice(id, 1);
			$scope.listaIndex-funcionario();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarIndex-funcionario = function(index-funcionario) {
		$scope.index-funcionario = angular.copy(index-funcionario);
	}

	$scope.cancelarAlteracaoIndex-funcionario = function(index-funcionario) {
		$scope.index-funcionario = {};
	};

});