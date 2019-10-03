banSys.controller("funcController", function($scope, $http, $routeParams) {

	$scope.listaFunc = [];
	$scope.Func= {};
	var url = 'rest/funcionarios/';

	$scope.listarFunc = function() {
		$http({
			method : 'GET',
			url : url
		}).then(function(response) {
			$scope.listaFunc = response.data;
			console.log('Metodo listarFunc sucesso');
		}, function(response) {
			console.log('error metodo listarFunc');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarFunc = function() {

		$http({
			method : 'POST',
			url : url,
			data : $scope.Func
		}).then(function(response) {
			console.log('Salvo com sucesso metodo salvarFunc');
			$scope.listaFunc.push(response.data);
			$scope.listarFunc();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteFunc = function(id) {

		$http({
			method : 'DELETE',
			url : url + id
		}).then(function(response) {
			console.log('Deletado com Sucesso');
			$scope.listaFunc.splice(id, 1);
			$scope.listarFunc();
		}, function(response) {
			console.log('error do delete');
			console.log(response.data);
			console.log(response.status);
		});
	};
});