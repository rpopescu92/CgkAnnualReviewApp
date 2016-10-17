(function () {
    'use strict';

    angular
        .module('bankApp')
        .service('AuthorizationService', AuthorizationService);

    AuthorizationService.$inject = ['$http','$rootScope','$state', 'Principal','$sessionStorage', '$q', 'AuthServerProvider'];

    function AuthorizationService($http, $rootScope, $state, Principal, $sessionStorage, $q, AuthServerProvider) {
        return {
            authorize: authorize,
            getPreviousState: getPreviousState,
            resetPreviousState: resetPreviousState,
            storePreviousState: storePreviousState,
            loginWithToken: loginWithToken,
            login: login,
            logout: logout
        };

        function authorize(force) {
            Principal.identity(force).then(authThen);

            function authThen() {
                var isAuthenticated = Principal.isAuthenticated();

                if(isAuthenticated && ($rootScope.toState.name === 'login' || $rootScope.toState.name === 'register')) {
                    $state.go('home');
                }

                if(isAuthenticated && !$rootScope.fromState.name && getPreviousState()) {
                    var previousState = getPreviousState();
                    resetPreviousState();
                    $state.go(previousState.name, previousState.params);
                }
                storePreviousState($rootScope.toState.name, $rootScope.toStateParams);
                $state.go('login');
            }

        }
            function resetPreviousState() {
                delete $sessionStorage.previousState;
            }

            function getPreviousState() {
                return $sessionStorage.previousState;
            }
            function storePreviousState(previousStateName, previousStateParams) {
                 $sessionStorage.previousState = {"name": previousStateName, "params": previousStateParams};
            }

            function loginWithToken(jwt) {
                return AuthServerProvider.loginWithToken(jwt);
            }

            function login(credentials, callback) {
                 var cb = callback || angular.noop;
                 var deferred = $q.defer();
                 AuthServerProvider.login(credentials)
                                .then(loginThen)
                                .catch(function(err) {
                                    this.logout();
                                    deferred.reject(err);
                                  return cb(err);
                                }.bind(this));
                  function loginThen(data) {
                    Principal.identity(true).then(function (account) {
                        deferred.resolve(data);
                    });
                    return cb();
                  }
                  return deferred.promise;
            }

            function logout() {
                AuthServerProvider.logout();
                Principal.authenticate(null);
            }
        }
})();