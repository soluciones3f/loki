angular.module('loki.controllers')
  .controller('TimesheetController', [
    '$scope', 'ProjectRepository', 'timesheetRepository', 'dateRange',
    function($scope, ProjectRepository, timesheetRepository, dateRange) {

      // Init scope data
      $scope.projects = ProjectRepository.list();

      // expand date range here, because ng-repeat does not plays well with array of objects
      $scope.timesheet = timesheetRepository.list({from: '20141001', to: '20141014'});
      $scope.timesheet.$promise.then(function(timesheet) {
        $scope.dateRange = dateRange(timesheet.from, timesheet.to);
      });

      // Some functions in scope to easy the programmimg
      $scope.saveChanges = function() {
        console.log("Saving changes", $scope.timesheet.projects[0].days[0], $scope.timesheet);
      }

      $scope.movePreviousWeek = function() {
        var first = moment($scope.timesheet.from, "YYYYMMDD").add(-2, "week");
        var last = moment(first).add(+2, "week");

        // expand date range here, because ng-repeat does not plays well with array of objects
        $scope.timesheet = timesheetRepository.list({from: first.format("YYYYMMDD"), to: last.format("YYYYMMDD")});
        $scope.timesheet.$promise.then(function(timesheet) {
          $scope.dateRange = dateRange(timesheet.from, timesheet.to);
        });
      }

      $scope.moveNextWeek = function() {
        var first = moment($scope.timesheet.from, "YYYYMMDD").add(+2, "week");
        var last = moment(first).add(+2, "week");

        // expand date range here, because ng-repeat does not plays well with array of objects
        $scope.timesheet = timesheetRepository.list({from: first.format("YYYYMMDD"), to: last.format("YYYYMMDD")});
        $scope.timesheet.$promise.then(function(timesheet) {
          $scope.dateRange = dateRange(timesheet.from, timesheet.to);
        });
      }

      $scope.addProject = function () {
        // it should only add a new project if it not already in the list
        var found = $scope.timesheet.projects.some( function(it) { return it.id == $scope.newProject.id } );
        if(!found) {

          var project = { 
            id: $scope.newProject.id,
            days:[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          }
          
          $scope.timesheet.projects.push( project );
          
        }
        $scope.newProject = null;
      }

      $scope.refreshProjects = function() {

      }


    }
  ]);





