banSys.controller("bancoController", function($scope, $http) {

	$scope.listaBanco = [];
	$scope.banco= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaBanco = function() {
		$http({
			method : 'GET',
			url : urlApi + 'bancos/'
		}).then(function(response) {
			$scope.listaBanco = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarBanco = function() {
		var metodo = 'POST';

		if ($scope.banco.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'bancos/',
			data : $scope.banco
		}).then(function(response) {
			$scope.listaBanco.push(response.data);
			$scope.listaBanco();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteBanco = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'bancos/' + id
		}).then(function(response) {
			$scope.listaBanco.splice(id, 1);
			$scope.listaBanco();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarBanco = function(banco) {
		$scope.banco = angular.copy(banco);
	}

	$scope.cancelarAlteracaoBanco = function(banco) {
		$scope.banco = {};
	};

});