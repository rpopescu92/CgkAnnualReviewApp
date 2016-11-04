(function () {

    'use strict';

    angular
        .module('bankApp')
        .controller('ChartsController', ChartsController);

    ChartsController.$inject = ['$scope','TransactionsService'];

    function ChartsController($scope, TransactionsService) {
        $scope.labels = [];
        $scope.data = [];

        init();

        function init() {
            TransactionsService.getMonths()
                .then(function (data) {
                    $scope.labels = data.data;
                });
            TransactionsService.getAllAmounts()
                .then(function (data) {
                    $scope.data = data.data;
                });

        }

    }


})();