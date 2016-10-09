(function() {
    'use strict';

    angular
        .module('bankApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$state', 'AuthorizationService'];

    function HomeController($scope, $state, AuthorizationService) {
        $scope.message = 'Home Controller';

        init();

        function init() {
            //TODO check AuthorizationService
            $state.go('loginState');
        }

    }

})();