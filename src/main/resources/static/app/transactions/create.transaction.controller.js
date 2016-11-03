(function () {
    'use strict';

    angular
        .module('bankApp')
        .controller('CreateTransactionController', CreateTransactionController);

    CreateTransactionController.$inject = ['$scope', 'TransactionsService', '$mdDialog', 'ManageAccountService'];

    function CreateTransactionController($scope, TransactionsService, $mdDialog, ManageAccountService) {
        $scope.transaction = {};
        $scope.send = send;
        $scope.hide = hide;
        $scope.accounts = [];
        $scope.selectedAccountBalance = null;

        init();

        function init() {
            ManageAccountService.getAccountNames()
                .then(function (data) {
                    console.log(data);
                    $scope.accounts = data.data;
                });
        }

        $scope.$watch('transaction', function() {
            console.log('changed');
            $scope.accounts.map(function (item) {
                if(item.accountName === $scope.transaction.sendAccount) {
                    $scope.selectedAccountBalance = item.balance;
                }
            })
        });

        function send() {
            console.log($scope.transaction);
            TransactionsService.createTransaction($scope.transaction)
                .then(function (data) {

                });
        }

        function hide() {
            $mdDialog.hide();
        }
    }

})();