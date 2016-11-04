(function() {

    'use strict';

    angular
        .module('bankApp')
        .service('TransactionsService', TransactionsService);

    TransactionsService.$inject = ['$http'];

    function TransactionsService($http) {
        return {
            createTransaction: createTransaction,
            getLastTransaction: getLastTransaction,
            getCurrentMonth: getCurrentMonth,
            getMonths: getMonths,
            getAllAmounts: getAllAmounts
        }

        function getAllAmounts() {
            return $http({
                url: '/api/transactions/yearly',
                method: 'GET'
            });
        }

        function getMonths() {
            return $http({
                url: '/api/transactions/months',
                method: 'GET'
            });
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

        function getCurrentMonth() {
            return $http({
                url: '/api/transactions/current-month',
                method: 'GET'
            });
        }
    }

})();