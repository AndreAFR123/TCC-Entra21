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
			console.log('Metodo listarBanco sucesso');
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
            $scope.listarBanco();
        }, function(response) {
            console.log('error do deleteBanco');
            console.log(response.data);
            console.log(response.status);
        });
    };
    $scope.transferenciaConta = function() {
		$http({
			method : 'PUT',
			url : urlApi +  $scope.conta.idConta + '/' +  $scope.conta.saldo_conta + '/' +  $scope.conta.saldo + '/' +   $scope.conta.num_conta
		}).then(function(response) {
			$scope.listaConta.push(response.data);
			
		}, function(response) {
			console.log('error da transferencia');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.emprestimoConta = function() {
		$http({
			method : 'PUT',
			url : urlApi + 'contas/' + $scope.conta.idConta + '/' + $scope.conta.saldo_conta + '/' + $scope.conta.emprestimo_conta 
		}).then(function(response) {
			$scope.listaConta.push(response.data);
		}, function(response) {
			console.log('error do emprestimo');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.saqueConta = function() {
		$http({
			method : 'PUT',
			url : urlApi + 'contas/saque/' + $scope.conta.idConta + '/' + $scope.conta.saldo_conta 
		}).then(function(response) {
			$scope.listaConta.push(response.data);
			$scope.listaConta();
		}, function(response) {
			console.log('error do saque');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.depositoConta = function() {
		$http({
			method : 'PUT',
			url : urlApi + 'contas/deposito/' + $scope.conta.idConta + '/' + $scope.conta.saldo_conta
		}).then(function(response) {
			$scope.listaConta = response.data;
		}, function(response) {
			console.log('error do deposito');
			console.log(response.data);
			console.log(response.status);
		});
	};
});

