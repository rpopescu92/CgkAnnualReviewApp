/**
 *
 * @description [To be completed]
 */
(function () {
    "use strict"; // jshint ignore:line

    angular
        .module('FormsModule', []);

    angular
        .module('FormsModule')
        .controller('FormsController', ['$scope', function ($scope) {

            $scope.myModel = {
                email: null,
                password: null,
                checkbox: false,
                message: null,
                angularOk: true
            };

            $scope.submitForm = function (form) {
                if (form.$valid) {
                    console.log('Form is valid, do smth');
                } else {
                    console.log('Form is invalid', form);
                }
            };

        }]);

})();
