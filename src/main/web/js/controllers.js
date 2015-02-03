var demoDataModule = angular.module('demoDataModule', []);

demoDataModule.controller('showDataController', function ($scope, $rootScope, $http) {

    $rootScope.dataVisible = true;
    $rootScope.columns = ['id', 'char', 'varchar', 'date(yyyy-mm-dd)'];
    $rootScope.showAddButton = false;
    $rootScope.showSaveButton = false;
    $rootScope.baseUrl = 'http://localhost:8080/demo-data';

    $http.get($rootScope.baseUrl + '/show').
        success(function (data) {
            angular.forEach(data, function (row) {
                row.selected = false;
            });
            $rootScope.rows = data;
        });

});

demoDataModule.controller('buttonClickHandler', function ($http, $scope, $rootScope) {
    function getAllData() {
        $http.get($rootScope.baseUrl + '/show').
            success(function (data) {
                angular.forEach(data, function (row) {
                    row.selected = false;
                });
                $rootScope.rows = data;
            });
    };

    $scope.deleteRows = function deleteRows() {
        var list = $rootScope.rows;
        angular.forEach(list, function (record) {
            if (record.selected) {
                $http.delete($rootScope.baseUrl + '/delete/' + record.id);
            }
        });
        getAllData();
    };

    $scope.refresh = function refresh() {
        getAllData();
    };

    $scope.edit = function edit() {
        var selected = 0, position = 0, index = 0;
        var list = $rootScope.rows;
        angular.forEach(list, function (record) {
            if (record.selected) {
                selected++;
                position = index;
            }
            index++;
        });

        if (selected > 1) {
            alert('please select just one row to be edited');
        } else {
            $rootScope.dataVisible = false;
            if (selected == 0) {
                $rootScope.showAddButton = true;
                $rootScope.editLine = null;
            } else {
                $rootScope.editLine = $rootScope.rows[position];
                $rootScope.showSaveButton = true;
            }
            $scope.$apply();
        }
    };


});

demoDataModule.controller('updateDataController', function ($scope, $http, $rootScope) {

    $http.defaults.headers.post["Content-Type"] = "application/json";
    $http.defaults.headers.put["Content-Type"] = "application/json";

    function getAllData() {
        $http.get($rootScope.baseUrl + '/show').
            success(function (data) {
                angular.forEach(data, function (row) {
                    row.selected = false;
                });
                $rootScope.rows = data;
            });
    };

    $scope.add = function (editLine) {
        $http.post($rootScope.baseUrl + '/add', {obj: editLine}).success(function () {
            getAllData();
            cancel();
        });
    };

    $scope.save = function (editLine) {
        $http.put($rootScope.baseUrl + '/update', {obj: editLine}).success(function(){
            getAllData();
            cancel();
        });
    };

    $scope.cancel = function () {
        cancel();
    };

    function cancel() {
        $rootScope.showAddButton = false;
        $rootScope.showSaveButton = false;
        $rootScope.dataVisible = true;
        getAllData();
    }
});

