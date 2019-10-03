banSys.controller("agenciaController", function($scope, $http, $routeParams) {

	$scope.listaAgencia = [];
	$scope.agencia= {};
	var url = 'rest/agencias/';

	$scope.listarAgencia = function() {
		$http({
			method : 'GET',
			url : url
		}).then(function(response) {
			$scope.listaAgencia = response.data;
		}, function(response) {
			console.log('error no metodo listar agencia');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.salvarAgencia = function() {
		$http({
			method : 'POST',
			url : url,
			data : $scope.agencia
		}).then(function(response) {
			console.log('Agencia salva com sucesso.');
		}, function(response) {
			console.log('Erro ao salvar metodo salvarAgencia ');
		});
	};
	
	$scope.deleteAgencia = function(id) {

		$http({
			method : 'DELETE',
			url : url + id
		}).then(function(response) {
			console.log('Excluido com Sucesso metodo deleteAgencia')
			$scope.listaAgencia.splice(id, 1);
			$scope.listaAgencia();
		}, function(response) {
			console.log('error do deleteAgencia');
			console.log(response.data);
			console.log(response.status);
		});
	};
});