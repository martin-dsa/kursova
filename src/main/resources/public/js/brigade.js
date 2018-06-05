var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.brigade = [];
    $http.get('/api/brigade').then(function (response) {
        $scope.brigade = response.data;
        console.log(response);
    });
});