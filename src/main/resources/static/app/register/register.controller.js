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

           function register() {
                console.log($scope.username+ $scope.birthday);
                var data = {
                    username : $scope.username,
                    lastName: $scope.lastName,
                    firstName: $scope.firstName,
                    birthday: $scope.birthday,
                    password: $scope.password
                };
                RegisterService.register(data);

           }
    }
})();