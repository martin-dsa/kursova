var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.admin = [];
    $http.get('/api/admin').then(function (response) {
        $scope.admin = response.data;
        console.log(response);
    });

    $scope.brigade = [];
    $http.get('/api/brigade').then(function (response) {
        $scope.brigade = response.data;
        console.log(response);
    });

    $scope.worker = [];
    $http.get('/api/worker').then(function (response) {
        $scope.worker = response.data;
        console.log(response);
    });


    $scope.cancelledFlight = [];
    $http.get('/api/cancelledFlight').then(function (response) {
        $scope.cancelledFlight = response.data;
        console.log(response);
    });

    $scope.delayedFlight = [];
    $http.get('/api/delayedFlight').then(function (response) {
        $scope.delayedFlight = response.data;
        console.log(response);
    });

    $scope.department = [];
    $http.get('/api/department').then(function (response) {
        $scope.department = response.data;
        console.log(response);
    });
    $scope.dep = $scope.department[1];
    $scope.flight = [];
    $http.get('/api/flight').then(function (response) {
        $scope.flight = response.data;
        console.log(response);
    });
    $scope.medicalExam = [];
    $http.get('/api/medicalExam').then(function (response) {
        $scope.medicalExam = response.data;
        console.log(response);
    });

    $scope.passenger = [];
    $http.get('/api/passenger').then(function (response) {
        $scope.passenger = response.data;
        console.log(response);
    });
    $scope.passengerHasSchedule = [];
    $http.get('/api/passengerHasSchedule').then(function (response) {
        $scope.passengerHasSchedule = response.data;
        console.log(response);
    });
    $scope.plane = [];
    $http.get('/api/plane').then(function (response) {
        $scope.plane = response.data;
        console.log(response);
    });
    $scope.planeHasFlight = [];
    $http.get('/api/planeHasFlight').then(function (response) {
        $scope.planeHasFlight = response.data;
        console.log(response);
    });
    $scope.returnedTicket = [];
    $http.get('/api/returnedTicket').then(function (response) {
        $scope.returnedTicket = response.data;
        console.log(response);
    });
    $scope.schedule = [];
    $http.get('/api/schedule').then(function (response) {
        $scope.schedule = response.data;
        console.log(response);
    });
    $scope.seats = [];
    $http.get('/api/seats').then(function (response) {
        $scope.seats = response.data;
        console.log(response);
    });
    $scope.seatsHasSchedule = [];
    $http.get('/api/seatsHasSchedule').then(function (response) {
        $scope.seatsHasSchedule = response.data;
        console.log(response);
    });
    $scope.vehicleInspection = [];
    $http.get('/api/vehicleInspection').then(function (response) {
        $scope.vehicleInspection = response.data;
        console.log(response);
    });


});
