(function () {

    'use strict';

    angular
        .module('bankApp')
        .controller('ChartsController', ChartsController);

    ChartsController.$inject = ['$scope'];

    function ChartsController($scope) {
        $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
        $scope.data = [23,33,414,55,232,551,5324];

    }


})();