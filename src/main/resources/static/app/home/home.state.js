(function() {
    'use strict';

    angular
        .module('bankApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider, $urlRouterProvider) {
       $urlRouterProvider.otherwise('/home');
       $stateProvider.state('homeState', {
            url: '/home',
            parent: 'app',
            views: {
                'content@': {
                           templateUrl: 'app/home/home.html',
                           controller: 'HomeController'
                    }
                }
            });
       }

})();
