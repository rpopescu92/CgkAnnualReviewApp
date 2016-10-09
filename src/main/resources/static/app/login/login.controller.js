(function(){
    'use strict';

    angular.module('bankApp')
        .controller('LoginController', LoginController);


    LoginController.$inject = ['$scope', 'AuthorizationService'];

    //TODO use AuthorizationService
    function LoginController($scope, AuthorizationService){
        var vm = this;

        $scope.user = null;
        $scope.password = null;
        $scope.login = login;

        init();

        function init() {
            //TODO check authorization

        }

        function login() {
            console.log($scope.user+","+$scope.password);
        }

    }


})();