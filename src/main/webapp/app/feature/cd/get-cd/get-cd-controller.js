(function() {

    var GetcdController =  function(CDDal)
    {
        var vm = this;
        vm.test = "test";

        function init() {
            CDDal.getcds().then(function (results) {
                vm.CDs  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cdstore').controller('getcdController', ['CDDal', GetcdController]);
}());