(function () {

    'use strict';

    angular
        .module('bankApp')
        .controller('ChartsController', ChartsController);

    ChartsController.$inject = ['$scope','$rootScope', 'TransactionsService'];

    function ChartsController($scope, $rootScope, TransactionsService) {
        var vm = this;

        $scope.labels = [];
        $scope.data = [];
        vm.init = init;
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

        $rootScope.$on('refresh-data', function() {
            vm.init();
        });

    }


})();