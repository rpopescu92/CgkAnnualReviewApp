(function(){
    'use strict';

    angular.module('bankApp')
            .service('ManageAccountService', ManageAccountService);


     ManageAccountService.$inject = ['$http'];
     function ManageAccountService($http) {
            return {
                createNewAccount: createNewAccount
            }


            function createNewAccount(data){
                return $http({
                      url:'api/accounts',
                      data: data,
                      method: 'POST'
                });
            }
     }
})();