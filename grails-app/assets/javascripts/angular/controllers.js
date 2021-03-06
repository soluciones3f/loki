// First an empty array, the other, add to this array
// if not, angular will reset the list
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

  .controller('WorkDetailReportController', ['$scope','ReportRepository', function($scope, ReportRepository) {

    var from = moment().subtract(1, "month").startOf("month").format("YYYY-MM-DD");
    var to = moment().subtract(1, "month").endOf("month").format("YYYY-MM-DD");

    $scope.range = { from: from, to: to };
    $scope.selectedView = "raw"

    $scope.$watchCollection("range", function(newValue, oldValue) {
      ReportRepository.work($scope.range.from, $scope.range.to)
        .then(function(response) { 
          $scope.workdata = response 

          // Adapt workdata for project view.
          $scope.projects = response.reduce(function(previous, current) {
            var data = previous[current.project.name];
            if( data == null) 
              data = { name: current.project.name, total: 0, items: [] };

            data.total = data.total + current.hours;
            data.items.push(current);

            previous[current.project.name] = data;
            return previous;
          }, {});
        });
      });

  }]);

;
