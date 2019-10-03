banSys.controller("bancoController", function($scope, $http, $routeParams) {

	var url = 'rest/bancos/';
	$scope.banco = {};
	$scope.listaBanco = [];

	$scope.salvarBanco = function() {
		$http({
			method : 'POST',
			url : url,
			data : $scope.banco
		}).then(function(response) {
			console.log('Banco salvo com sucesso.');
		}, function(response) {
			console.log('Erro ao salvar metodo salvarBanco ');
		});
	};
	
	
	$scope.listarBanco = function() {
		$http({
			method : 'GET',
			url : url
		}).then(function(response) {
			$scope.listaBanco = response.data;
		}, function(response) {
			console.log('error no metodo listarBanco');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteBanco = function(id) {
        $http({
            method : 'DELETE',
            url : url + id
        }).then(function(response) {
            console.log('Excluido com Sucesso metodo deleteBanco')
            $scope.listaBanco.splice(id, 1);
            $scope.listaBanco();
        }, function(response) {
            console.log('error do deleteBanco');
            console.log(response.data);
            console.log(response.status);
        });
    };

});