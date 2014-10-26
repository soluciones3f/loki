angular.module('loki.controllers')
  .controller('TimesheetController', [
    '$scope', 'ProjectRepository', 'timesheetRepository',
    function($scope, ProjectRepository, timesheetRepository) {
      $scope.timesheet = timesheetRepository.list({from: '20141001', to: '20141014'});

      $scope.projects = ProjectRepository.list();

      // it used to be a way a fake way to populate the timesheet
      /*
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
      */

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





