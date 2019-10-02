banSys.controller("bancoVisualizarController", function ($scope, $http, $routeParams) {

	var url = 'rest/bancos/';
	$scope.bancoVisualizar = {};
	
    $http.get(url + $routeParams.id).then(function (response) {
        $scope.bancoVisualizar = response.data;
    }, function (response) {
        console.log('error - bancoVisualizarController');
    });
    
    
    $scope.editarBanco = function() {
		$http({
			method : 'PUT',
			url : url,
			data : $scope.bancoVisualizar
		}).then(function(response) {
			console.log('salvar - editarBanco');
		}, function(response) {
			console.log('error - editarBanco');
		});
	};
	
});