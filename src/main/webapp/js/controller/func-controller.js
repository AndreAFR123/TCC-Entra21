banSys.controller("funcController", function($scope, $http) {

	$scope.listaFunc = [];
	$scope.Func= {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaFunc = function() {
		$http({
			method : 'GET',
			url : urlApi + 'funcionarios/'
		}).then(function(response) {
			$scope.listaFunc = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarFunc = function() {
		var metodo = 'POST';

		if ($scope.func.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'funcionarios/',
			data : $scope.func
		}).then(function(response) {
			$scope.listaFunc.push(response.data);
			$scope.listaFunc();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteFunc = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'funcionarios/' + id
		}).then(function(response) {
			$scope.listaFunc.splice(id, 1);
			$scope.listaFunc();
		}, function(response) {
			console.log('error do delete');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarFunc = function(func) {
		$scope.func = angular.copy(func);
	}

	$scope.cancelarAlteracaoFunc = function(func) {
		$scope.func = {};
	};	

});