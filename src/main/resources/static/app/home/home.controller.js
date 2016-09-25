(function() {
    'use strict';

    angular
        .module('bankApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope'];

    function HomeController($scope) {
        $scope.message = 'Home Controller';

    }

})();