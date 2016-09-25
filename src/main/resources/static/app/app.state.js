(function(){
       'use strict';

       angular.module('bankApp',[])
               .config(stateConfig);

       stateConfig.$inject = ['$stateProvider'];

       function stateConfig($stateProvider){
            $stateProvider.state('app',{
                abstract: true,
                views: {
                    'navbar@' : {
                           templateUrl: 'navbar/navbar.html',
                           controller: 'NavbarController',
                           controllerAs: 'vm'
                    }
                }

            });
       }

})();
