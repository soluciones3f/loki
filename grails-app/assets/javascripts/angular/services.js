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
      suggest: {method: 'GET', url: 'customer/search?term=:term&page=:page', params: {term:'@term', page:'@page'} },
      get: {method: 'GET', url: 'customer/get/:id', params: {term:'@id'} }
    });
  })

;

