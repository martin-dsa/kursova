 var app = angular.module("airport", []);

    app.controller("AppCtrl", function ($scope, $http) {
        $scope.returnedTicket = [];
        $http.get('/api/returnedTicket').then(function (response) {
            $scope.returnedTicket = response.data;
            console.log(response);
        });});