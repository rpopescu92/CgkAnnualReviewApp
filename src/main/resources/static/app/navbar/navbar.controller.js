(function(){
    'use strict';

    angular.module('bankApp')
            .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', '$state', 'AuthorizationService', 'Principal'];

    function NavbarController($scope, $state, AuthorizationService, Principal) {
        var vm = this;

        $scope.logout = logout;
        $scope.isAuthenticated = false;

        vm.init = init;

        init();

        function init() {
            $scope.isAuthenticated = Principal.isAuthenticated();
        }

        function logout() {
            AuthorizationService.logout();
            $state.go('login');
        }
    }


})();