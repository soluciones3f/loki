'use strict';
/* Filters */

angular.module('loki.filters', [])

/**
 * Replaces true for arrowUp; false for arrowDown
 */
.filter('arrow', arrowFilter)

/**
 * Format a date (or string representation of a date) as a human readable date.
 */
.filter('dateFormat', dateFormatFilter)

/**
 * Replace a Project id by its Project name
 */
.filter("name", function() {
  return function toNameFilter(id, source) { 
    // I should use someting like underscore to avoid NIH syndrome
    var found = null;
    source.some(function(it) {
      if( it.id == id ) {
        found = it;
        return true;
      }

      return false;
    });

    if(found != null) return found.name;
    return "Undefined";
  };
})

;


/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//                               //
// FILTERS                       //
//                               //
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////


dateFormatFilter.$inject = ['$log'];
function dateFormatFilter($log) {
  return function(date, format) {
    format = format || 'L';
    if(date) {
      var datetime = moment(date);
      return datetime.format(format);
    } else {
      return "Unknown " + date;
    }
  };
}

function arrowFilter() {
  return function(value) {
    if(value) return "\u25B2";
    return "\u25BC";
  };
}



