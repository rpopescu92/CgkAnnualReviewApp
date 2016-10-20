(function(){
    'use strict';

    angular.module('bankApp')
            .service('RegisterService',RegisterService);

    RegisterService.$inject = ['$http'];

    function RegisterService($http) {
        return {
            register: register;

        }
        function register(data){
            console.log(data.firstName);
            return $http.post("/api/users/register")
                        .then(function(data){
                            console.log("post register");
                        });
        }
       }
})();