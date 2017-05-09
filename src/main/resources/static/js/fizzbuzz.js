    var app = angular.module('fizzBuzzApp', []);
    app.controller('fizzBuzzController', function ($scope, $http, $interval, $timeout) {

        $scope.submitFizzBuzz = function () {
            var fbArray = $scope.fbModel.split("\n");
            var fbData = [];
            for (var i = 0; i < fbArray.length; i++) {
                var tmp = fbArray[i].trim().split(" ");
                var fbDividers = [];
                for (var j = 0; j < tmp.length - 1; j++) {
                    fbDividers.push(tmp[j].trim());
                }
                fbData.push({
                    dividers: fbDividers,
                    counter: tmp[tmp.length - 1].trim()
                });
            }
            var result = $http.post('/fizzBuzz', fbData);
            result.success(function (data, status, headers, config) {
                $scope.res = data;
            });
            result.error(function (data, status, headers, config) {
                alert("failure message: " + JSON.stringify({data: data}));
            });
        }
    });

    app.directive("fbValidator", function () {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function ($scope, $ele, $attrs, ctrl) {
                ctrl.$parsers.unshift(function (value) {
                    if (value) {
                        var fbArray = value.split("\n");
                        var regexp = new RegExp("^([1-9]|1[0-9]|20) ([1-9]|1[0-9]|20) ([1-9][0-9]|100)$");
                        var valid;
                        for (var i = 0; i < fbArray.length; i++) {
                            valid = regexp.test(fbArray[i].trim());
                            if (!valid) break;
                        }
                        var testCasesInRange = (fbArray.length <= 20);
                        ctrl.$setValidity('fbInvalid', valid);
                        ctrl.$setValidity('fbTestCasesOutOfRange', testCasesInRange);
                    }
                    return valid && testCasesInRange ? value : undefined;
                });

            }
        }
    });