banSys.controller("funcVisualizarController", function ($scope, $http, $routeParams) {

	var url = 'rest/funcionarios/';
	$scope.funcVisualizar = {};
	
    $http.get(url + $routeParams.id).then(function (response) {
        $scope.funcVisualizar = response.data;
    }, function (response) {
        console.log('error - funcVisualizarController');
    });
    
    
    $scope.editarFunc = function() {
		$http({
			method : 'PUT',
			url : url,
			data : $scope.funcVisualizar
		}).then(function(response) {
			console.log('salvar - editarFunc');
		}, function(response) {
			console.log('error - editarFunc');
		});
	};
	
});