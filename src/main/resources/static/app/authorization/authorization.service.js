(function () {
    'use strict';

    angular
        .module('bankApp')
        .service('AuthorizationService', AuthorizationService);

    AuthorizationService.$inject = ['$http'];

    function AuthorizationService() {
        return {

        }
    }


})();