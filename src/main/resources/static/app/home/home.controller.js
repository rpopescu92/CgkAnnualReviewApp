(function() {
    'use strict';

    angular
        .module('bankApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$state', 'AuthorizationService','Account'];

    function HomeController($scope, $state, AuthorizationService, Account) {
        $scope.message = 'Home Controller';

        $scope.logout = logout;
        $scope.currentUser = currentUser;

        init();

        function init() {
            //TODO check AuthorizationService
//            $state.go('loginState');
        }

        function logout() {
            AuthorizationService.logout();
        }

        function currentUser(){
            return Account.getAccount();
        }

    }

})();