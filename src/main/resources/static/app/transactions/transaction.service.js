(function() {

    'use strict';

    angular
        .module('bankApp')
        .service('TransactionsService', TransactionsService);

    TransactionsService.$inject = ['$http'];

    function TransactionsService($http) {
        return {
            createTransaction: createTransaction,
            getLastTransaction: getLastTransaction
        }

        function createTransaction(transaction) {
            return $http({
                url: '/api/transactions',
                data: transaction,
                method: 'POST'
            });
        };

        function getLastTransaction() {
            return $http({
                url: '/api/transactions',
                method: 'GET'
            });
        }
    }

})();