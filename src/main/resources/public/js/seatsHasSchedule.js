var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.seatsHasSchedule = [];
    $http.get('/api/seatsHasSchedule').then(function (response) {
        $scope.seatsHasSchedule = response.data;
        console.log(response);
    });});