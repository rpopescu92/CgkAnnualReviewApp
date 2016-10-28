(function(){
    'use strict';

    angular.module('bankApp')
            .service('RegisterService',RegisterService);

    RegisterService.$inject = ['$http'];

    function RegisterService($http) {
        return {
            register: register

        }
        function register(data){
            return $http({
                url: '/register',
                data: data,
                method: 'POST'
            });
        }
       }
})();