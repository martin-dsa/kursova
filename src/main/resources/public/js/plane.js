var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.plane = [];
    $http.get('/api/plane').then(function (response) {
        $scope.plane = response.data;
        console.log(response);
    });
    let id;

    this.setId = function (a) {
        id = a;
        console.log(id);
    };

    this.create = function () {
        let name = document.getElementById("cr_name").value;
        let nmrrep = document.getElementById("cr_num_of_rep").value;
        let q = document.getElementById("cr_age").value;
        let w = document.getElementById("cr_num_of_fl").value;
        let e = document.getElementById("cr_status").value;
        let r = document.getElementById("cr_num_of_seats").value;
        let t = document.getElementById("cr_time").value;

        $http.get('/api/plane/insert?name=' + name + '&numberOfRepairs=' + nmrrep + '&age=' +
            q + '&numberOfFlights=' + w + '&status=' + e + '&numberOfSeats=' + r + '&timeOfArrive=' + t).then(function (response) {
            window.location.reload();
        });
    };

    this.update = function () {
        let name = document.getElementById("upd_name").value;
        let nmrrep = document.getElementById("upd_num_of_rep").value;
        let q = document.getElementById("upd_age").value;
        let w = document.getElementById("upd_num_of_fl").value;
        let e = document.getElementById("upd_status").value;
        let r = document.getElementById("upd_num_of_seats").value;
        let t = document.getElementById("upd_time").value;

        $http.get('/api/plane/update?id=' + id + '&name=' + name + '&numberOfRepairs=' + nmrrep + '&age=' +
            q + '&numberOfFlights=' + w + '&status=' + e + '&numberOfSeats=' + r + '&timeOfArrive=' + t).then(function (response) {
            window.location.reload();
        });

    };

    this.delete = function () {
        $http.get('/api/plane/delete?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

});