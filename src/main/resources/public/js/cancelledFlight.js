var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.cancelledFlight = [];
    $http.get('/api/cancelledFlight').then(function (response) {
        $scope.cancelledFlight = response.data;
        console.log(response);
    });

    this.setOptions = function (sel) {
        console.log('set')
        $http.get('/api/flight').then(function (response) {
            let data = response.data;
            let selector = document.getElementById(sel);
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });
    };

    let id;

    this.setId = function (a) {
        id = a;
        console.log(id);
    };

    this.create = function () {
        let name = document.getElementById("cr_name").value;



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