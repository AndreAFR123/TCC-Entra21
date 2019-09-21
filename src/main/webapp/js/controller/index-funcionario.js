banSys.controller("index-funcionarioController", function($scope, $http) {

	$scope.listaindex_funcionario = [];
	$scope.index_funcionario= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaIndex_funcionario = function() {
		$http({
			method : 'GET',
			url : urlApi + 'index-funcionarios/'
		}).then(function(response) {
			$scope.listaIndex_funcionario = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarIndex_funcionario = function() {
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
	$scope.deleteIndex_funcionario = function(id) {

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
	$scope.alterarIndex_funcionario = function(index_funcionario) {
		$scope.index_funcionario = angular.copy(index-funcionario);
	}

	$scope.cancelarAlteracaoIndex_funcionario = function(index_funcionario) {
		$scope.index_funcionario = {};
	};

});