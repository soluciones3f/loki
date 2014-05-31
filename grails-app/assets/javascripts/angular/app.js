'use strict';

moment.lang('es');

// Declare app level module which depends on filters, and services
angular.module('loki',
    [
      'ngRoute', 'chieffancypants.loadingBar', 'ngAnimate',
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
        $routeProvider.otherwise({
          redirectTo: '/quote/create'
        });
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

