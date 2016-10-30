(function(){
    'use strict';

    angular.module('bankApp')
            .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/account');
        $stateProvider.state('account',{
                url: '/account',
                parent: 'app',
                views: {
                       'content@': {
                            templateUrl: 'app/account/account.html',
                            controller: 'AccountController'
                       }
                }
        });
    }
})();