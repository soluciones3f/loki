// Defino cómo serán los controladores
angular.module(
  'loki.controllers',
  []
);

angular.module('loki.controllers')
  .controller('CreateQuoteController', [
    '$scope', '$log', '$location', '$rootScope', '$http', 'growl',
    'CustomerRepository', 'QuoteRepository',
    function($scope, $log, $location, $rootScope, $http, growl,
      CustomerRepository, QuoteRepository) {

      // filling the fields
      $scope.customers = CustomerRepository.list();

      // preparing the model
      $scope.quote = {};
      $scope.quote.customer = {};

      var config = {};

      $scope.$watch('quote.customer', function(newValue, oldValue) {
          if (newValue !== oldValue) {
            growl.success(newValue.name + " selected.", config);
            $log.debug('quote.customer new ', newValue);
            $log.debug('quote.customer old ', oldValue);
          }
        }
      );

      $scope.submit = function() {
        $log.debug("quote", $scope.quoteForm);
        if ($scope.quoteForm.$valid) {
          $log.debug("quote is valid");

          var fnSuccess = function() {
            $log.debug("fnSucess");
          }

          var fnError = function() {
            $log.debug("fnError");
          }

          QuoteRepository.save($scope.quote, fnSuccess, fnError)

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
