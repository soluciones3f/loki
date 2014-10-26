angular.module('loki.controllers')
  .controller('TimesheetController', [
    '$scope', 'ProjectRepository', 'timesheetRepository',
    function($scope, ProjectRepository, timesheetRepository) {

      // Init scope data
      $scope.timesheet = timesheetRepository.list({from: '20141001', to: '20141014'});
      $scope.projects = ProjectRepository.list();

      // Some functions in scope to easy the programmimg
      $scope.saveChanges = function() {
        console.log("Saving changes", $scope.timesheet.projects[0].days[0], $scope.timesheet);
      }

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





