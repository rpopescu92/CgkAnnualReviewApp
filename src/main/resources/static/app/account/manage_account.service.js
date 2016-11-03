(function(){
    'use strict';

    angular.module('bankApp')
            .service('ManageAccountService', ManageAccountService);


     ManageAccountService.$inject = ['$http'];
     function ManageAccountService($http) {
            return {
                createNewAccount: createNewAccount,
                getAccounts: getAccounts
            }


            function createNewAccount(data){
                return $http({
                      url:'api/bank-accounts',
                      data: data,
                      method: 'POST'
                });
            }

            function getAccounts(options) {
                return $http({
                    url:'api/bank-accounts?page='+options.page+'&limit='+options.limit+'&order='+options.order,
                    method: 'GET'
                });
            }
     }
})();