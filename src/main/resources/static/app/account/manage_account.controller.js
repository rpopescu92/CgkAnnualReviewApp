(function(){
    'use strict';

    angular.module('bankApp')
            .controller('ManageAccountController', ManageAccountController);

     ManageAccountController.$inject = ['$scope', '$state', '$mdDialog', 'ManageAccountService'];
     function ManageAccountController($scope, $state, $mdDialog, ManageAccountService) {
        $scope.currencies = ['RON', 'EUR', 'GBP'];
        $scope.accountTypes = ['CURRENT', 'SAVINGS', 'DEPOSIT'];
        $scope.closeDialog = closeDialog;
        $scope.createNewAccount = createNewAccount;

        $scope.bankAccounts = null

        $scope.initialAmount = null;
        $scope.currency = null;
        $scope.accountType = null;
        $scope.createAccountErrorMessage = null;


        function closeDialog()  {
            $mdDialog.hide();
        }

        function createNewAccount() {
            var data = {
                  initialAmount: $scope.initialAmount,
                  currency: $scope.currency,
                  accountType: $scope.accountType

            };
            ManageAccountService.createNewAccount(data)
                    .then(function(response){
                        if(response.status == 200){
                            $mdDialog.hide();
                        }
                    },
                     function(error){
                        if(error.status == 400) {
                            $scope.createAccountErrorMessage = "Cannot save current account data";
                      }
             });
        }

        function getBankAccounts() {

            ManageAccountService.getAccounts()
                .then(function(response){
                    if(response.status == 200){

                    }
                },
                function(error){
                    if(error.status == 400){

                    }
                });

        };

     }


})();