var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.passenger = [];
    $http.get('/api/passenger').then(function (response) {
        $scope.passenger = response.data;
        console.log(response);
    });
    let id;



    this.setId = function (a) {
        id = a;
        console.log(id);
    };

    this.create = function () {
        let name = document.getElementById("cr_name").value;
        let nmrrep = document.getElementById("cr_surname").value;
        let q = document.getElementById("cr_middleName").value;
        let w = document.getElementById("cr_age").value;
        let e;
        if (document.getElementById("cr_male").checked)
            e = document.getElementById("cr_male").value;
        else
            e = document.getElementById("cr_female").value;


        $http.get('/api/passenger/insert?name=' + name + '&surname=' + nmrrep + '&middleName=' +
            q + '&age=' + w + '&gender=' + e).then(function (response) {
            window.location.reload();
        });
    };

    this.update = function () {
        let name = document.getElementById("upd_name").value;
        let nmrrep = document.getElementById("upd_surname").value;
        let q = document.getElementById("upd_middleName").value;
        let w = document.getElementById("upd_age").value;
        let e;
        if (document.getElementById("upd_male").checked)
            e = document.getElementById("upd_male").value;
        else
            e = document.getElementById("upd_female").value;


        $http.get('/api/passenger/update?id=' + id + '&name=' + name + '&surname=' + nmrrep + '&middleName=' +
            q + '&age=' + w + '&gender=' + e).then(function (response) {
            window.location.reload();
        });

    };

    this.delete = function () {
        $http.get('/api/passenger/delete?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

});