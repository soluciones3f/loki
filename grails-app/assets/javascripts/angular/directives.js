'use strict';

/* Directives */
angular.module('loki.directives', ["loki.services"])

/**
 * dummy directive
 */
  .directive("dummyDirective", ["$injector", "$log", function($injector, $log) {
    return {
      // require: "ngModel",
      restrict: "A",
      // transclude: true,

      link: function(scope, element, attrs) {
        $log.debug("log", scope, element, attrs);

      }
    }
  }])

;

