'use strict';

/* Services */
angular.module('loki.services', ['ngResource'])
  .factory("codeListStringRepository", function($resource) {
    return $resource('', {}, {
    });
  })
/**
 * Customer informaction
 */
  .factory("Customer", function($resource) {
    return $resource('', {}, {
      list: {method: 'GET', url: 'customer.json', params: {filter: '@filter'}, isArray: true},
      get: {method: 'GET', url: 'customer/show/:id.json', params: {id: '@id'} }
    });
  })

;

