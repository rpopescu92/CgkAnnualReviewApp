(function () {
    'use strict';

    angular
        .module('bankApp')
        .controller('TransactionsController',TransactionsController);

    TransactionsController.$inject = ['$scope', 'TransactionsService'];

    function TransactionsController($scope, TransactionsService) {

        $scope.transactions = [];
        init();

        function init(){
            TransactionsService.getLastTransaction()
                    .then(function(data){
                        $scope.transactions = data.data;
                    });
            TransactionsService.getCurrentMonth()
                        .then(function (data) {
                            console.log(data);
                        });

        };
    }

})();