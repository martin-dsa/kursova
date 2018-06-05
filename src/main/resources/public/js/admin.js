var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.admin = [];
    $http.get('/api/admin').then(function (response) {
        $scope.admin = response.data;
        console.log(response);
    });

    $scope.department = [];
    this.setOptions = function (sel) {
        console.log('set')
        $http.get('/api/department').then(function (response) {
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
        let surname = document.getElementById("cr_surname").value;
        let middlename = document.getElementById("cr_middleName").value;
        let position = document.getElementById("cr_position").value;
        console.log(position);
        let department = document.getElementById("cr_dep");
        let dep = department.options[department.selectedIndex].value;


        $http.get('/api/admin/insert?name=' + name + '&surname=' + surname
            + '&middleName=' + middlename + '&position=' + position + '&department=' + dep).then(function (response) {
            window.location.reload();
        });
    };

    this.update = function () {
        let name = document.getElementById("upd_name").value;
        let surname = document.getElementById("upd_surname").value;
        let middlename = document.getElementById("upd_middleName").value;
        let position = document.getElementById("upd_position").value;
        console.log(position);
        let department = document.getElementById("upd_dep");
        let dep = department.options[department.selectedIndex].value;


        $http.get('/api/admin/update?id=' + id + '&name=' + name + '&surname=' + surname
            + '&middleName=' + middlename + '&position=' + position + '&department=' + dep).then(function (response) {
            window.location.reload();
        });
    };

    this.delete = function () {
        $http.get('/api/admin/delete?id=' + id).then(function (response) {
            window.location.reload();
        });
    };
});