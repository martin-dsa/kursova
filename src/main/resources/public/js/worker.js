var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.flight = [];
    $http.get('/api/worker').then(function (response) {
        $scope.flight = response.data;
        console.log(response);
    });

});