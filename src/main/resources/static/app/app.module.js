(function(){
    angular.module('bankApp', ['ui.router', 'ngMaterial', 'ngStorage', 'ngCacheBuster', 'md.data.table','chart.js']).run(stateInitializer);
    stateInitializer.$inject = ['stateHandler'];

        function stateInitializer(stateHandler) {
            stateHandler.initialize();
        }
})();