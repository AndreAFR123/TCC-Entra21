banSys.controller("contaVisualizarController", function ($scope, $http, $routeParams) {

	var url = 'rest/contas/';
	$scope.contaVisualizar = {};
	
    $http.get(url + $routeParams.id).then(function (response) {
        $scope.contaVisualizar = response.data;
    }, function (response) {
        console.log('error - contaVisualizarController');
    });
    
    
    $scope.editarConta = function() {
		$http({
			method : 'PUT',
			url : url,
			data : $scope.contaVisualizar
		}).then(function(response) {
			console.log('salvar - editarConta');
		}, function(response) {
			console.log('error - editarConta');
		});
	};
	
});