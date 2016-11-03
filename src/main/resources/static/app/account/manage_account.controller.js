(function(){
    'use strict';

    angular.module('bankApp')
            .controller('ManageAccountController', ManageAccountController);

     ManageAccountController.$inject = ['$scope', '$state','$rootScope', '$mdDialog', 'ManageAccountService'];
     function ManageAccountController($scope, $state,$rootScope, $mdDialog, ManageAccountService) {

        var vm = this;
        $scope.bankAccounts = null

        $scope.initialAmount = null;
        $scope.currency = null;
        $scope.accountType = null;
        $scope.createAccountErrorMessage = null;
        $scope.selected = [];

        $scope.getBankAccounts = getBankAccounts;
        $scope.reorder = reorder;
        $scope.deleteBankAccount = deleteBankAccount;


        $scope.query = {
            order: 'accountNumber',
            limit: 5,
            page: 1
        };

        getBankAccounts($scope.query.page);

        function deleteBankAccount(id) {
            ManageAccountService.deleteBankAccount(id)
                .then(function (data) {
                     $scope.query.page = 1;
                     $scope.getBankAccounts($scope.query.page);
                });
        }

        function reorder(data) {
            $scope.query.order = data;
            getBankAccounts($scope.query.page);
        }

        $rootScope.$on('load-bank-accounts', function(event,data) {
            vm.getBankAccounts();
        });

        function getBankAccounts(page) {
            $scope.query.page = page;
            ManageAccountService.getAccounts($scope.query)
                .then(function(response){
                    console.log(response);
                    if(response.status == 200){
                        $scope.bankAccounts = response.data.content;
                        $scope.total = response.data.totalElements;
                    }
                },
                function(error){
                    if(error.status == 400){

                    }
                });

        };

     }
})();