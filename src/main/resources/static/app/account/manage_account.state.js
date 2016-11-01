(function(){
    'use strict';

    angular.module('bankApp')
            .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/bank_account');
        $stateProvider.state('bank_account',{
                url: '/bank_account',
                parent: 'app',
                views: {
                       'content@': {
                            templateUrl: 'app/account/manage_account.html',
                            controller: 'ManageAccountController'
                       }
                }
        });
    }
})();