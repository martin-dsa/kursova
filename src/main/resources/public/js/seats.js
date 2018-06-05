var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.seats = [];
    $http.get('/api/seats').then(function (response) {
        $scope.seats = response.data;
        console.log(response);
    });});