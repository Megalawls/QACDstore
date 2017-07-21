"use strict";

(function () {

    angular.module('cdstore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("getCD", {
            url: "/getCD",
            templateUrl: "app/feature/CD/get-CD/get-CD.html"
        }).state("addCD", {
            url: "/addCD",
            templateUrl: "app/feature/CD/add-CD/add-CD.html"
        })
    });
}());