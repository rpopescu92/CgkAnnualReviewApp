(function() {
    'use strict';

    angular
        .module('bankApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$state', 'AuthorizationService','Account', 'Principal'];

    function HomeController($scope, $state, AuthorizationService, Account, Principal) {
        $scope.message = 'Home Controller';

        $scope.logout = logout;
        $scope.currentUser = currentUser;
        $scope.account = null;

        init();

        function init() {
            //TODO check AuthorizationService
//            $state.go('loginState');
        }

        function logout() {
            AuthorizationService.logout();
            $state.go('login');
        }

        function currentUser(){
            return Account.getAccount();
        }
        function getAccount() {
                    Principal.identity().then(function (account) {
                        vm.account = account;
                        vm.isAuthenticated = Principal.isAuthenticated;
                    });
          }

         function seeAllBalance() {

          }

    }

})();