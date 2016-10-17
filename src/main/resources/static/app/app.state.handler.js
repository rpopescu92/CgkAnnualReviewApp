(function () {
    'use strict';

    angular
        .module('bankApp')
        .factory('stateHandler', stateHandler);

    stateHandler.$inject = ['$rootScope', '$state', '$sessionStorage', '$window', 'AuthorizationServiceorizationService', 'Principal', 'VERSION'];

    function stateHandler($rootScope, $state, $sessionStorage, $window, AuthorizationService, Principal, VERSION) {
        return {
            initialize: initialize
        };

        function initialize() {
            $rootScope.VERSION = VERSION;

            var stateChangeStart = $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams, fromState) {
                $rootScope.toState = toState;
                $rootScope.toStateParams = toStateParams;
                $rootScope.fromState = fromState;

                if (toState.external) {
                    event.preventDefault();
                    $window.open(toState.url, '_self');
                }

                if (Principal.isIdentityResolved()) {
                    AuthorizationService.AuthorizationServiceorize();
                }

            });

            var stateChangeSuccess = $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
                var titleKey = 'CegekaApp';

                if (toState.data.pageTitle) {
                    titleKey = toState.data.pageTitle;
                }
                $window.document.title = titleKey;
            });

            $rootScope.$on('$destroy', function () {
                if (angular.isDefined(stateChangeStart) && stateChangeStart !== null) {
                    stateChangeStart();
                }
                if (angular.isDefined(stateChangeSuccess) && stateChangeSuccess !== null) {
                    stateChangeSuccess();
                }
            });
        }
    }

})();