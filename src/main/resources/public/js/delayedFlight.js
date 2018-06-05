var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.delayedFlight = [];
    $http.get('/api/delayedFlight').then(function (response) {
        $scope.delayedFlight = response.data;
        console.log(response);
    });});