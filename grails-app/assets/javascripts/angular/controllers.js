// Defino cómo serán los controladores
angular.module(
  'loki.controllers',
  []
);

angular.module('loki.controllers')
  .controller('CreateQuoteController', [
    '$scope', '$log', '$location', '$rootScope',
    function($scope, $log, $location, $rootScope) {
      $scope.customers =
        [
          { name: 'Name', email: 'e@e.tv', VAT: '123', address: 'Beverly' },
          { name: 'Amigo', email: 'p@p.tv', VAT: '321', address: 'Palo Alto' }
        ];

      $scope.customer = {};

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
