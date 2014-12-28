'use strict';

moment.lang('es');

// Declare app level module which depends on filters, and services
var app = angular.module('loki',
    [
      'ngRoute', 'chieffancypants.loadingBar', 'ngAnimate', 'ngSanitize', 'ui.select', 'angular-growl',
      'loki.filters',
      'loki.services',
      'loki.directives',
      'loki.controllers',
      'loki.services'
    ])

  .constant('GlobalConstants', {
    dummy: { value: 1 }
  })

  .config(
    ['$routeProvider',
      function($routeProvider) {
        $routeProvider.when('/quote/create', {
          title: 'New Quote',
          templateUrl: 'quote/partialCreate'
        });
        $routeProvider.when('/quote/show/:id', {
          title: 'Quote',
          templateUrl: 'quote/partialShow'
        });
        $routeProvider.when('/timesheet', {
          title: 'TimeSheet',
          templateUrl: 'timesheet/partialShow'
        });
        $routeProvider.otherwise({
          redirectTo: '/quote/create'
        });
    }]
  )

  .config(
    ['growlProvider', function (growlProvider) {
      growlProvider.globalTimeToLive(3000);
    }]
  )

  .run(
    ['$location', '$rootScope',
      function($location, $rootScope) {
        $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
          if (current.$$route)
            $rootScope.title = current.$$route.title;

        })
      }
    ]
  )
;

app.config(['uiSelectConfig', function(uiSelectConfig) {
  console.log("uiSelectConfig", uiSelectConfig);
  uiSelectConfig.theme = 'bootstrap';
}]);

/**
 * AngularJS default filter with the following expression:
 * "person in people | filter: {name: $select.search, age: $select.search}"
 * performs a AND between 'name: $select.search' and 'age: $select.search'.
 * We want to perform a OR.
 */
app.filter('propsFilter', function() {
  return function(items, props) {
    var out = [];

    if (angular.isArray(items)) {
      items.forEach(function(item) {
        var itemMatches = false;

        var keys = Object.keys(props);
        for (var i = 0; i < keys.length; i++) {
          var prop = keys[i];
          var text = props[prop].toLowerCase();
          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
            itemMatches = true;
            break;
          }
        }

        if (itemMatches) {
          out.push(item);
        }
      });
    } else {
      // Let the output be the input untouched
      out = items;
    }

    return out;
  }
});

