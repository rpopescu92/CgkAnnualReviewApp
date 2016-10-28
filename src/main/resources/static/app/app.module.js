(function(){
    angular.module('bankApp', ['ui.router', 'ngMaterial', 'ngStorage', 'ngCacheBuster']).run(stateInitializer);
    stateInitializer.$inject = ['stateHandler'];

        function stateInitializer(stateHandler) {
            stateHandler.initialize();
        }
})();