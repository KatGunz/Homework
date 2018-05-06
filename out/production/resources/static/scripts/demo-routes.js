var app = angular.module("demo-app", ["ui.bootstrap", "ngRoute", "ngResource"]);
app.config(function($httpProvider) {
    //initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
   }
});
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "../html/employeeView.html",
        controller: 'employeeCtrl'
    })
    .when("/login" {
        templateUrl : "../html/loginView.html",
        controller: 'loginCtrl'
    })
});
//defines the controllers located in other files
require('./Controllers/employeeController.js');
