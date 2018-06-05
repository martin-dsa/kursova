var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.flight = [];
    $http.get('/api/flight').then(function (response) {
        $scope.flight = response.data;
        console.log(response);
    });

    let id;

    $scope.setId = function (a) {
        id = a;
        console.log(id);
    };

    $scope.create = function () {
        let st_point = document.getElementById("cr_st_point").value;
        let fn_point = document.getElementById("cr_fn_point").value;
        let tr_point = document.getElementById("cr_tr_point").value;
        let tck_price = document.getElementById("cr_tkt_price").value;
        let type = document.getElementById("cr_type").value;
        let time = document.getElementById("cr_time").value;
        console.log(tck_price);

        $http.get('/api/flight/insert?startingPoint=' + st_point + '&finalPoint=' + fn_point +
            '&transferPoint=' + tr_point + '&ticketPrice=' + tck_price + '&type=' + type + '&time=' + time).then(function (response) {
            window.location.reload();
        });
    };

    $scope.update = function () {
        let st_point = document.getElementById("upd_st_point").value;
        let fn_point = document.getElementById("upd_fn_point").value;
        let tr_point = document.getElementById("upd_tr_point").value;
        let tck_price = document.getElementById("upd_tkt_price").value;
        let type = document.getElementById("upd_type").value;
        let time = document.getElementById("upd_time").value;

        $http.get('/api/flight/insert?id=' + id + '&startingPoint=' + st_point + '&finalPoint=' + fn_point +
            '&transferPoint=' + tr_point + '&ticketPrice=' + tck_price + '&type=' + type + '&time=' + time).then(function (response) {
            window.location.reload();
        });
    };

    $scope.delete = function () {
        $http.get('/api/flight/delete?id=' + id).then(function (response) {
            window.location.reload();
        });
    };
});