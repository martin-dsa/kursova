var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.vehicleInspection = [];
    $http.get('/api/vehicleInspection').then(function (response) {
        $scope.vehicleInspection = response.data;
        console.log(response);
    });});