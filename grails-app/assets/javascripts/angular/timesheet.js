angular.module('loki.controllers')
  .controller('TimesheetController', [
    '$scope', '$log', '$location', '$rootScope', '$http', 'growl',
    'ProjectRepository', 'CustomerRepository', 'QuoteRepository',
    function($scope, $log, $location, $rootScope, $http, growl,
             ProjectRepository, CustomerRepository, QuoteRepository) {

      $scope.projects = ProjectRepository.list();

      ProjectRepository.list().$promise.then(function (lista) {
        var selectedProjects = [];

        angular.forEach(lista, function(value, key) {
          var oneProject = {
            data: value
          }

          selectedProjects.push(oneProject);
        });


        $scope.timesheet = {
          selectedProjects: selectedProjects
        };

      })

      $scope.addProject = function () {
        var newProject = {
          data: $scope.timesheet.newProject
        }
        $scope.timesheet.selectedProjects.push(newProject);
      }

      $scope.refreshProjects = function() {

      }


    }
  ]);





