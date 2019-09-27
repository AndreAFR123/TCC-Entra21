banSys.controller("contaController", function($scope, $http) {

	$scope.listaConta = [];
	$scope.conta = {};
	var urlApi = 'localhost:8080/TCC-Entra21/rest/';

	$scope.listaConta = function() {
		$http({
			method : 'GET',
			url : urlApi + 'contas/'
		}).then(function(response) {
			$scope.listaConta = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarConta = function() {
		var metodo = 'POST';

		if ($scope.conta.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'contas/',
			data : $scope.conta
		}).then(function(response) {
			$scope.listaConta.push(response.data);
			$scope.listaConta();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.deleteConta = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'contas/' + id + '/'
		}).then(function(response) {
			$scope.listaConta.splice(id, 1);
			$scope.listaConta();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.alterarConta = function(conta) {
		$scope.conta = angular.copy(conta);
	}

	$scope.cancelarAlteracaoConta = function(conta) {
		$scope.conta = {};
	};
	
	$scope.transferenciaConta = function() {
		$http({
			method : 'PUT',
			url : urlApi + 'contas/'+ id + '/' + saldo_conta + '/' + saldo + '/' +  num + '/'
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
			url : urlApi + 'contas/' + id + '/' + saldo_conta + '/' + emprestimo_conta + '/'
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
			url : urlApi + 'contas/saque/' + id + '/' + saldo_conta + '/'
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
			url : urlApi + 'contas/deposito/' + id + '/' + saldo_conta + '/'
		}).then(function(response) {
			$scope.listaConta = response.data;
		}, function(response) {
			console.log('error do deposito');
			console.log(response.data);
			console.log(response.status);
		});
	};
});