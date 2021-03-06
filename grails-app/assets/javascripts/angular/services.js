'use strict';

/* Services */
angular.module('loki.services', ['ngResource'])
  .factory("codeListStringRepository", ['$resource', function($resource) {
    return $resource('', {}, {
    });
  }])
/**
 * Customer informaction
 */
  .factory("CustomerRepository",  ['$resource', function($resource) {
    return $resource('', {}, {
      list: {method: 'GET', url: 'customer.json', params: {filter: '@filter'}, isArray: true},
      get: {method: 'GET', url: 'customer/show/:id.json', params: {id: '@id'} }
    });
  }])

  .factory("ProjectRepository",  ['$resource', function($resource) {
    return $resource('', {}, {
      list: {method: 'GET', url: 'project.json', params: {filter: '@filter'}, isArray: true},
      get: {method: 'GET', url: 'project/show/:id.json', params: {id: '@id'} }
    });
  }])

  .factory("QuoteRepository",  ['$resource', function($resource) {
    return $resource('', {}, {
      save: {method: 'POST', url: 'api/quoteAPI/save', params: {}}
    });
  }])

  .factory("timesheetRepository",  ['$resource', function($resource) {
    return $resource('', {}, {
      list: { method: 'GET', url: 'timesheet/list.json' },
      saveHour: { method: 'POST', url: 'timesheet/saveHour', headers: {'Content-Type': 'application/x-www-form-urlencoded'} }
    });
  }])

  .factory("ReportRepository", ['$http', '$q', function($http, $q) {
    return {
      work: function(from, to) { 
        // Only do request if from and to are valid
        if(!from || !to) {
          var deferred = $q.defer();
          deferred.resolve( { data: [] } );
          return deferred.promise;
        };
        
        return $http
          .get('api/reportAPI/work', { params: {from: from, to: to}  })
          .then(function(response) {
            return response.data.map(function(item) { item.date = moment(item.date); return item; })
          });
      }
    }
  }])

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

