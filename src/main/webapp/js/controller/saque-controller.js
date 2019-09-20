banSys.controller("saqueController", function($scope, $http) {

	$scope.listaSaque = [];
	$scope.saque= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaSaque = function() {
		$http({
			method : 'GET',
			url : urlApi + 'saques/'
		}).then(function(response) {
			$scope.listaSaque = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarSaque = function() {
		var metodo = 'POST';

		if ($scope.saque.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'saques/',
			data : $scope.saque
		}).then(function(response) {
			$scope.listaSaque.push(response.data);
			$scope.listaSaque();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteSaque = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'saques/' + id
		}).then(function(response) {
			$scope.listaSaque.splice(id, 1);
			$scope.listaSaque();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarSaque = function(saque) {
		$scope.saque = angular.copy(saque);
	}

	$scope.cancelarAlteracaoSaque = function(saque) {
		$scope.saque = {};
	};

});