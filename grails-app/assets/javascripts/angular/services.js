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
  .factory("CustomerRepository", function($resource) {
    return $resource('', {}, {
      list: {method: 'GET', url: 'customer.json', params: {filter: '@filter'}, isArray: true},
      get: {method: 'GET', url: 'customer/show/:id.json', params: {id: '@id'} }
    });
  })

  .factory("ProjectRepository", function($resource) {
    return $resource('', {}, {
      list: {method: 'GET', url: 'project.json', params: {filter: '@filter'}, isArray: true},
      get: {method: 'GET', url: 'project/show/:id.json', params: {id: '@id'} }
    });
  })

  .factory("QuoteRepository", function($resource) {
    return $resource('', {}, {
      save: {method: 'POST', url: 'api/quoteAPI/save', params: {}}
    });
  })

  .factory("timesheetRepository", function($resource) {
    return $resource('', {}, {
      list: { method: 'GET', url: 'timesheet/list.json' },
    });
  })

  /**
   * Given a from,to dates, creates a array of dates
   */
  .factory("dateRange", function() {
    return function dateRangeFunction(from, to) {
      // Have to check for this, because sometimes, sometimes it is undefined
      var result = [];
      if(from  && to) {
        var date = moment(from, "YYYYMMDD");
        var end = moment(to, "YYYYMMDD").add(1, "day");

        while(date.isBefore(end, "day")) {
          result.push(date);
          date = moment(date).add(1, "day")
        }
      }

      return result;
    }
  })
;

