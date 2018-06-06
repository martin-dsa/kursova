var app = angular.module("airport", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.schedule = [];
    $http.get('/api/schedule').then(function (response) {
        $scope.schedule = response.data;
        console.log(response);
    });
    let id;
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


    this.setId = function (a) {
        id = a;
        console.log(id);
    };

    this.create = function () {
        let department = document.getElementById("cr_flight");
        let name = department.options[department.selectedIndex].value;
        let nmrrep = document.getElementById("cr_cr_day_of_dep").value;
        let q = document.getElementById("cr_time_of_dep").value;
        let w = document.getElementById("cr_day_of_arr").value;
        let e = document.getElementById("cr_time_of_arr").value;
        let r = document.getElementById("cr_num_of_unused").value;
        let t = document.getElementById("cr_type").value;
        let y = document.getElementById("cr_num_of_tick").value;


        $http.get('/api/passenger/insert?flight=' + name + '&dayOfDeparture=' + nmrrep + '&timeOfDeparture=' +
            q + '&dayOfArrive=' + w + '&timeOfArrive=' + e+'&numberOfUnusedSeats='+r+'&planeType='+t+'&numberOfSoldTickets'+y).then(function (response) {
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