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
                      url:'api/accounts',
                      data: data,
                      method: 'POST'
                });
            }

            function getAccounts(data) {
                return $http({
                    url:'api/accounts',
                    data: data,
                    method: 'GET'
                });
            }
     }
})();