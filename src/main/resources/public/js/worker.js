var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.worker = [];
    $http.get('/api/worker').then(function (response) {
        $scope.worker = response.data;
        console.log(response);
    });

});