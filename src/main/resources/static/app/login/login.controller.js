(function(){
    'use strict';

    angular.module('bankApp')
        .controller('LoginController', LoginController);


    LoginController.$inject = ['$scope', 'AuthorizationService', '$state'];

    //TODO use AuthorizationService
    function LoginController($scope, AuthorizationService,$state){
        var vm = this;

        $scope.user = null;
        $scope.password = null;
        $scope.login = login;

        $scope.authenticationError = false;

        function login() {
            $scope.authenticationError = false;
            event.preventDefault();
            AuthorizationService.login({
                user: $scope.user,
                password: $scope.password
            }).then(function() {
                $scope.authenticationError = false;

                if($state.current.name === 'login') {
                    $state.go('home');
                }
                $scope.$broadcast('authenticationSuccess');

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

    }


})();