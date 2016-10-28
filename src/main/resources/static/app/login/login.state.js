(function() {
    'use strict';

    angular
        .module('bankApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
       $urlRouterProvider.otherwise('/login');
       $stateProvider.state('login', {
            url: '/login',
            parent: 'app',
            views: {
                'content@': {
                           templateUrl: 'app/login/login.html',
                           controller: 'LoginController'
                    }
                },
                                         resolve: {
                                              authorize: ['AuthorizationService',
                                              function (AuthorizationService) {
                                                  return AuthorizationService.authorize();
                                              }]
                                         }
            });
       }

})();
