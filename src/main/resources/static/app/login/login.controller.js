(function(){
    'use strict';

    angular.module('bankApp')
        .controller('LoginController', LoginController);


    LoginController.$inject = ['$scope', 'AuthorizationService', '$state', '$mdDialog'];

    function LoginController($scope, AuthorizationService,$state, $mdDialog) {
        var vm = this;

        $scope.user = null;
        $scope.password = null;
        $scope.login = login;
        $scope.register = register;
        $scope.register = register;

        $scope.authenticationError = false;

        function login() {
            $scope.authenticationError = false;
            AuthorizationService.login({
                user: $scope.user,
                password: $scope.password
            }).then(function() {
                $scope.authenticationError = false;

                if($state.current.name === 'login') {
                    console.log('go to home');
                    $state.go('home');
                }
                $scope.$emit('authenticationSuccess');

                if(AuthorizationService.getPreviousState()) {
                    var previousState = AuthorizationService.getPreviousState();
                    AuthorizationService.resetPreviousState();
                    $state.go(previousState.name, previousState.params);
                }
            }).catch(function(){
                $scope.authenticationError = true;
            });
            console.log($scope.user+","+$scope.password);
        }

        function register() {
            $mdDialog.show({
                templateUrl: '/app/register/register.html',
                controller: 'RegisterController'
            });
        }

    }


})();