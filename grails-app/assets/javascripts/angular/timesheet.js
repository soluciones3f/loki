angular.module('loki.controllers')
  .controller('TimesheetController', [
    '$scope', '$log', '$location', '$rootScope', '$http', 'growl', 'uiGridConstants',
    'CustomerRepository', 'QuoteRepository',
    function($scope, $log, $location, $rootScope, $http, growl, uiGridConstants,
             CustomerRepository, QuoteRepository) {

      $scope.customers = ProjectsRepository.list();

      $scope.refreshProjects = function() {

      }


    }
  ]);





