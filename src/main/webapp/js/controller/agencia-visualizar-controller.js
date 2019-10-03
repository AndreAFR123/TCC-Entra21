banSys.controller("agenciaVisualizarController", function ($scope, $http, $routeParams) {

	var url = 'rest/agencias/';
	$scope.agenciaVisualizar = {};
	
    $http.get(url + $routeParams.id).then(function (response) {
        $scope.agenciaVisualizar = response.data;
    }, function (response) {
        console.log('error - agenciaVisualizarController');
    });
    
    
    $scope.editarAgencia = function() {
		$http({
			method : 'PUT',
			url : url,
			data : $scope.agenciaVisualizar
		}).then(function(response) {
			console.log('salvar - editarAgencia');
		}, function(response) {
			console.log('error - editarAgencia');
		});
	};
	
});