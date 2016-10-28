(function(){
    'use strict';

    angular.module('bankApp')
            .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['AuthorizationService','$scope', 'RegisterService'];

    function RegisterController(AuthorizationService, $scope, RegisterService) {
           $scope.register = register;
           $scope.username = null;
           $scope.lastName= null;
           $scope.firstName = null;
           $scope.birthday = null;
           $scope.password = null;
           $scope.showDuplicateUserErrorMessage = false;

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
    }
})();