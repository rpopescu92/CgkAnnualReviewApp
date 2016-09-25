(function(){
    'use strict';

    angular.module('bankApp',[])
            .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope'];

    function NavbarController($scope){
        $scope.message = "This is a navbar";
    }
})();