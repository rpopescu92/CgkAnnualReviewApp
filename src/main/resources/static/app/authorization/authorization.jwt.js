(function () {
    'use strict';

    angular
        .module('bankApp')
        .service('AuthServerProvider', AuthServerProvider);

        AuthServerProvider.$inject = ['$http', '$sessionStorage'];

        function AuthServerProvider($http, $sessionStorage) {
            return {
                getToken: getToken,
                login: login,
                logout: logout
            }

            function getToken() {
                return $sessionStorage.authenticationToken;
            }

            function login(credentials) {
                var data = {
                    user_name: credentials.userName,
                    password:  credentials.password
                }

                return $http.post('/api/authenticate', data)
                            .then(function(data) {
                                var bearerToken = headers('Authorization');
                                if(angular.isDefined(bearerToken) && bearerToken.slice(0,7) === 'Bearer') {
                                    var jwt = bearerToken.slice(7, bearerToken.length);
                                    $sessionStorage.authenticationToken = jwt;

                                    return jwt;
                                }
                            });


            }

            function logout() {
                delete $sessionStorage.authenticationToken;
            }
        }

})();