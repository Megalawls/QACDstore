"use strict";

(function () {

    angular.module("cdstore").service("CDDal", ["dal", cdDal]);

    function cdDal (dal) {

        this.getcds = function () {
            return dal.http.GET("rest/cdstore/json");
        };

        this.savecd = function (CDToSave) {
            return dal.http.POST("rest/cdstore/json", CDToSave);
        };

        this.updatecd = function (CDToUpdate) {
            return dal.http.PUT("rest/cdstore/json/", CDToUpdate);
        };

        this.deletecd = function (CDToDelete) {
            return dal.http.DELETE("rest/cdstore/json/", CDToDelete);
        };

    }
}());
