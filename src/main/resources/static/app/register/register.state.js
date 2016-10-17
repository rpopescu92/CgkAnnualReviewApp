(function(){
    'use strict';

    angular.module('bankApp')
            .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/register');
        $stateProvider.state('register',{
                url: '/register',
                parent: 'app',
                views: {
                       'content@': {
                            templateUrl: 'app/register/register.html',
                            controller: 'RegisterController'
                       }
                }
        });
    }
})();
