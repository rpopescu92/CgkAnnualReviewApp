(function () {
    'use strict';

    angular
        .module('bankApp')
        .controller('TransactionsController',TransactionsController);

    TransactionsController.$inject = ['$scope', 'TransactionsService', '$rootScope'];

    function TransactionsController($scope, TransactionsService, $rootScope) {
        var vm = this;
        $scope.transactions = [];
        vm.init = init;
        init();

        function init(){
            TransactionsService.getLastTransaction()
                    .then(function(data){
                        $scope.transactions = data.data;
                    });
        };

        $rootScope.$on('refresh-data', function() {
            vm.init();
        });
    }

})();