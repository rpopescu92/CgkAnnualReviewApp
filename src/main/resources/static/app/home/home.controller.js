(function() {
    'use strict';

    angular
        .module('bankApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$state', 'AuthorizationService','Account', 'Principal', '$mdDialog'];

    function HomeController($scope, $state, AuthorizationService, Account, Principal, $mdDialog) {
        $scope.currentUser = currentUser;
        $scope.account = null;
        $scope.createNewAccount = createNewAccount;
        $scope.createTransaction = createTransaction

        function createTransaction() {
            $mdDialog.show({
                     templateUrl: '/app/transactions/create_transaction.html',
                     controller: 'CreateTransactionController'
                            });
        }

        function currentUser(){
            return Account.getAccount();
        }
        function getAccount() {
                    Principal.identity().then(function (account) {
                        vm.account = account;
                        vm.isAuthenticated = Principal.isAuthenticated;
                    });
          }


         function createNewAccount() {
            $mdDialog.show({
                     templateUrl: '/app/account/create_account.html',
                     controller: 'AccountController'
                            });
         }

    }

})();