// Defino cómo serán los controladores
angular.module(
  'loki.controllers',
  []
);

angular.module('loki.controllers')
  .controller('CreateQuoteController', [
    '$scope', '$log', '$location', '$rootScope', '$http',
    function($scope, $log, $location, $rootScope, $http) {


      $scope.customer = {};
      $scope.customers = [];
      $scope.refreshCustomers = function(address) {
        // Loads all the first time
        if ($scope.customers.length == 0) {
          var params = {address: address, sensor: false};
          return $http.get(
            'customer.json',
            {params: params}
          ).then(function (response) {
              $scope.customers = response.data
            });
        }
      };
    }
  ])


  .controller('NavBarController', [
    '$scope', '$log', '$location', '$rootScope',
    function($scope, $log, $location, $rootScope) {
      $scope.getClass = function(path) {
        var cur_path = $location.path().substr(0, path.length);
        if (cur_path == path) {
          if($location.path().substr(0).length > 1 && path.length == 1 )
            return "";
          else
            return "active";
        } else {
          return "";
        }
      }

      $scope.extra = {};
      $rootScope.$on("$locationChangeSuccess", function(event, next, current) {
        $scope.extra.link = next;
      });
    }
  ])

;
