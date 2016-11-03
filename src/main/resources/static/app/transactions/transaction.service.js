(function() {

    'use strict';

    angular
        .module('bankApp')
        .service('TransactionsService', TransactionsService);

    TransactionsService.$inject = ['$http'];

    function TransactionsService($http) {
        return {
            createTransaction: createTransaction
        }

        function createTransaction(transaction) {
            return $http({
                url: '/api/transactions',
                data: transaction,
                method: 'POST'
            });
        }
    }

})();