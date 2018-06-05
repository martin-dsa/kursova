var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.passengerHasSchedule = [];
    $http.get('/api/passengerHasSchedule').then(function (response) {
        $scope.passengerHasSchedule = response.data;
        console.log(response);
    });});