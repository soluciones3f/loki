// Defino cómo serán los controladores
angular.module(
  'loki.controllers',
  []
);

angular.module('loki.controllers')
  .controller('CreateQuoteController', [
    '$scope', '$log', '$location', '$rootScope', '$http',
    'Customer',
    function($scope, $log, $location, $rootScope, $http,
      Customer) {

      // filling the fields
      $scope.customers = Customer.list();

      // preparing the model
      $scope.quote = {};
      $scope.quote.customer = {};

      $scope.$watch('quote.customer', function(newValue, oldValue) {
          $log.debug('quote.customer new ', newValue)
          $log.debug('quote.customer old ', oldValue)
        }
      );

      $scope.submit = function() {
        $log.debug("quote", $scope.quoteForm);
        if ($scope.quoteForm.$valid) {
          $log.debug("quote is valid");
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
