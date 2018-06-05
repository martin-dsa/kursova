let app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.department = [];
    $http.get('/api/department').then(function (response) {
        $scope.department = response.data;
        console.log(response);
    });

    let id;

    this.setId = function (a) {
        id = a;
        console.log(id);
    };

    this.create = function () {
        let name = document.getElementById("cr_name").value;

        $http.get('/api/department/insert?name=' + name).then(function (response) {
            window.location.reload();
        });
    };

    this.update = function () {
        let name = document.getElementById("upd_name").value;

        $http.get('/api/department/update?id=' + id + '&name=' + name).then(function (response) {
            window.location.reload();
        });
    };

    this.delete = function () {
        $http.get('/api/department/delete?id=' + id ).then(function (response) {
            window.location.reload();
        });
    };


});