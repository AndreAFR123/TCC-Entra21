banSys.controller("contaController", function($scope, $http) {

	var url = 'rest/contas/'
	$scope.listaConta = [];
	$scope.conta = {};

	$scope.listarConta = function() {
		$http({
			method : 'GET',
			url : url
		}).then(function(response) {
			$scope.listaConta = response.data;
		}, function(response) {
			console.log('error no metodo listarConta');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.salvarConta = function() {
		$http({
			method : 'POST',
			url : url,
			data : $scope.conta
		}).then(function(response) {
			console.log('Conta salvo com sucesso.');
		}, function(response) {
			console.log('Erro ao salvar metodo salvarConta ');
		});
	};

	$scope.deleteConta = function(id) {
		$http({
			method : 'DELETE',
			url : url + id
		}).then(function(response) {
			console.log('Excluido com Sucesso metodo deleteConta')
			$scope.listaConta.splice(id, 1);
			$scope.listarConta();
		}, function(response) {
			console.log('error do deleteConta');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.transferenciaConta = function() {
		$http(
				{
					method : 'PUT',
					url : url + $scope.conta.idConta + '/'
							+ $scope.conta.saldo_conta + '/'
							+ $scope.conta.saldo_conta + '/'
							+ $scope.conta.num_conta
				}).then(function(response) {
			$scope.listaConta.push(response.data);

		}, function(response) {
			console.log('error da transferencia');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.emprestimoConta = function() {
		$http(
				{
					method : 'PUT',
					url : url + $scope.conta.idConta + '/'
							+ $scope.conta.saldo_conta + '/'
							+ $scope.conta.emprestimo_conta
				}).then(function(response) {
			$scope.listaConta.push(response.data);
		}, function(response) {
			console.log('error do emprestimo');
			console.log(response.data);
			console.log(response.status);
		});
	};
	$scope.saqueConta = function() {
		$http(
				{
					method : 'PUT',
					url : url + 'saque/' + $scope.conta.idConta + '/'
							+ $scope.conta.saldo_conta
				}).then(function(response) {
			$scope.listaConta.push(response.data);
			$scope.listarConta();
		}, function(response) {
			console.log('error do saque');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.depositoConta = function() {
		$http(
				{
					method : 'PUT',
					url : url + 'deposito/' + $scope.conta.idConta + '/'
							+ $scope.conta.saldo_conta
				}).then(function(response) {
			$scope.listaConta = response.data;
		}, function(response) {
			console.log('error do deposito');
			console.log(response.data);
			console.log(response.status);
		});
	};

});