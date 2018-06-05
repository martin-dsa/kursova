var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.planeHasFlight = [];
    $http.get('/api/planeHasFlight').then(function (response) {
        $scope.planeHasFlight = response.data;
        console.log(response);
    });});