var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.medicalExam = [];
    $http.get('/api/medicalExam').then(function (response) {
        $scope.medicalExam = response.data;
        console.log(response);
    });});