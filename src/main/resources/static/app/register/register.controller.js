(function(){
    'use strict';

    angular.module('bankApp')
            .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['AuthorizationService','$scope', 'RegisterService', '$mdDialog'];

    function RegisterController(AuthorizationService, $scope, RegisterService, $mdDialog) {
           $scope.register = register;
           $scope.username = null;
           $scope.lastName= null;
           $scope.firstName = null;
           $scope.birthday = null;
           $scope.password = null;
           $scope.showDuplicateUserErrorMessage = false;
           $scope.closeDialog = closeDialog;

           function register() {
                $scope.showDuplicateUserErrorMessage = false;
                var data = {
                    firstName: $scope.firstName,
                    lastName: $scope.lastName,
                    userName : $scope.username,
                    password: $scope.password,
                    birthday: $scope.birthday
                };
                RegisterService.register(data)
                    .then(function (response) {
                        if(data.status == 200) {
                            //success
                        }
                    }, function (error) {
                        if(error.status == 400) {
                            $scope.showDuplicateUserErrorMessage = true;
                        }
                    });
           }

           function closeDialog() {
                $mdDialog.hide();
           }
    }
})();