(function() {

    var DashBoardController =  function()
    {
        var vm = this;

        vm.test = "test";
    };
    angular.module('cdstore').controller('dashboardController', [DashBoardController]);
}());