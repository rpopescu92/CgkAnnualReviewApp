(function(){
    'use strict';

    angular.module('bankApp')
            .controller('ManageAccountController', ManageAccountController);

     ManageAccountController.$inject = ['$scope', '$state', '$mdDialog']
     function ManageAccountController($scope, $state, $mdDialog) {
        $scope.currencies = ['RON', 'EUR', 'GBP'];
        $scope.closeDialog = closeDialog;



        function closeDialog()  {
            $mdDialog.hide();
        }

     }


})();