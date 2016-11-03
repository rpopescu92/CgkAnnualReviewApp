(function () {
    'use strict';

    angular
        .module('bankApp')
        .controller('AccountController', AccountController);

    AccountController.$inject = ['$scope', 'ManageAccountService', '$rootScope','$mdDialog'];

    function AccountController($scope, ManageAccountService, $rootScope, $mdDialog) {
        $scope.closeDialog = closeDialog;
        $scope.create = create;
        $scope.currencies = ['RON', 'EUR', 'GBP'];
        $scope.accountTypes = ['CURRENT', 'SAVINGS', 'DEPOSIT'];

        function closeDialog() {
            $mdDialog.hide();
        }

        function create() {
            var data = {
                              initialAmount: $scope.initialAmount,
                              currency: $scope.currency,
                              accountType: $scope.accountType

                        };
                        ManageAccountService.createNewAccount(data)
                                .then(function(response){
                                    if(response.status == 200){
                                        $rootScope.$emit('load-bank-accounts');
                                        $mdDialog.hide();
                                    }
                                },
                                 function(error){
                                    if(error.status == 400) {
                                        $scope.createAccountErrorMessage = "Cannot save current account data. Please try again later!";
                                  }
                         });
        }

    }


})();