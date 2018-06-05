let app = angular.module("coursework", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.sortType = 'agreement.name';
    $scope.sortReverse = false;

    $scope.entries = [];
    $http.get('/api/agreement_groups').then(function (response) {
        $scope.entries = response.data;
    });
    this.del_entry = function del(id) {
        $http.get('/api/agreement_groups/del?id=' + id).then(function (response) {
            window.location.reload();
            window.alert('Групу угоди було успішно видалено!');
        });
    };

    this.start_insert_entry = function add() {
        $http.get('/api/agreements').then(function (response) {
            let data = response.data;
            data.sort(function (a, b) {
                return a.id - b.id;
            });
            let selector = document.getElementById("Agreement");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });

        $http.get('/api/projects').then(function (response) {
            let data = response.data;
            data.sort(function (a, b) {
                return a.id - b.id;
            });
            let selector = document.getElementById("Project");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                selector.add(option);
            }
        });
    };

    this.insert_entry = function add() {
        let agreementIndex = document.getElementById("Agreement").selectedIndex;
        let agreementId = document.getElementById("Agreement").options[agreementIndex].value;
        let projectIndex = document.getElementById("Project").selectedIndex;
        let projectId = document.getElementById("Project").options[projectIndex].value;

        $http.get('/api/agreement_groups/insert?id_agreement=' + agreementId + '&id_project=' + projectId).then(function (response) {
            window.location.reload();
            window.alert('Групу угоди було успішно додано!');
        });

    };
    let thisId;

    this.start_update_entry = function upd(id, agreementId, projectId) {
        thisId = id;
        let agreementIndex;
        $http.get('/api/agreements').then(function (response) {
            let data = response.data;
            data.sort(function (a, b) {
                return a.id - b.id;
            });
            let selector = document.getElementById("AgreementUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if (data[i].id === agreementId) {
                    agreementIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("AgreementUPD").selectedIndex = agreementIndex;
        });
        let projectIndex;
        $http.get('/api/projects').then(function (response) {
            let data = response.data;
            data.sort(function (a, b) {
                return a.id - b.id;
            });
            let selector = document.getElementById("ProjectUPD");
            $(selector).empty();
            for (let i = 0; i < data.length; i++) {
                let option = document.createElement("option");
                option.text = data[i].name;
                option.value = data[i].id;
                if (data[i].id === projectId) {
                    projectIndex = i;

                }
                selector.add(option);
            }

            document.getElementById("ProjectUPD").selectedIndex = projectIndex;
        });
    };

    this.update_entry = function upd() {
        let agreementIndex = document.getElementById("AgreementUPD").selectedIndex;
        let agreementId = document.getElementById("AgreementUPD").options[agreementIndex].value;
        let projectIndex = document.getElementById("ProjectUPD").selectedIndex;
        let projectId = document.getElementById("ProjectUPD").options[projectIndex].value;

        $http.get('/api/agreement_groups/update?id=' + thisId + '&id_agreement=' + agreementId + '&id_project=' + projectId).then(function (response) {
            window.location.reload();
        });
    };

    this.changeSort = function changeSort(column) {
        if ($scope.sortType === column) $scope.sortReverse = !$scope.sortReverse;
        else $scope.sortReverse = false;
        $scope.sortType = column;
    }
});


