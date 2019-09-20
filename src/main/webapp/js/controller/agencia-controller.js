banSys.controller("agenciaController", function($scope, $http) {

	$scope.listaAgencia = [];
	$scope.agencia= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaAgencia = function() {
		$http({
			method : 'GET',
			url : urlApi + 'agencias/'
		}).then(function(response) {
			$scope.listaAgencia = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarAgencia = function() {
		var metodo = 'POST';

		if ($scope.agencia.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'agencias/',
			data : $scope.agencia
		}).then(function(response) {
			$scope.listaAgencia.push(response.data);
			$scope.listaAgencia();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteConta = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'agencias/' + id
		}).then(function(response) {
			$scope.listaAgencia.splice(id, 1);
			$scope.listaAgencia();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarAgencia = function(agencia) {
		$scope.agencia = angular.copy(agencia);
	}

	$scope.cancelarAlteracaoAgencia = function(agencia) {
		$scope.agencia = {};
	};

});