(function(){
    'use strict';

    angular.module('bankApp')
            .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope','$rootScope',  '$state', 'AuthorizationService', 'Principal'];

    function NavbarController($scope, $rootScope, $state, AuthorizationService, Principal) {
        var vm = this;

        $scope.logout = logout;
        $scope.isAuthenticated = false;

        vm.init = init;

        init();

        $rootScope.$on('authenticationSuccess', function(event, data) {
            $scope.isAuthenticated = true;
        });

        function init() {
            $scope.isAuthenticated = Principal.isAuthenticated();
        }

        function logout() {
            AuthorizationService.logout();
            $scope.isAuthenticated = false;
            $state.go('login');
        }
    }


})();