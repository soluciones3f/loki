angular.module('loki.controllers')
  .controller('TimesheetController', [
    '$scope', 'ProjectRepository', 'timesheetRepository', 'dateRange',
    function($scope, ProjectRepository, timesheetRepository, dateRange) {

      // Init scope data
      $scope.projects = ProjectRepository.list();
      _loadTimesheet( moment().startOf('week') );

      // CSS class for each day category
      $scope.dayColor = function(date) {
        var day = date.day();
        if(day == 0) return "sunday, weekend";
        if(day == 6) return "saturday, weekend";
        return "weekday";
      }

      // total worked hours per day
      $scope.columnTotal = function(date) {
        return $scope.timesheet.projects.reduce(function(carry, item) {
          var hours = item.days[date.format("YYYYMMDD")] || 0;
          return carry + hours;
        }, 0);
      }

      // send the new value to the server
      $scope.saveHours = function(date, project) {
        timesheetRepository.saveHour( $.param({ 
                  idProject: project.id, 
                  date: date.format("YYYYMMDD"),
                  hours: project.days[date.format("YYYYMMDD")]
        }) )
      }

      // Some functions in scope to easy the programmimg
      $scope.saveChanges = function() {
        console.log("Saving changes", $scope.timesheet.projects[0].days[0], $scope.timesheet);
      }

      $scope.moveDays = function(offset) {
        var first = moment($scope.timesheet.from, "YYYYMMDD").add(offset, "days");
        _loadTimesheet(first);
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

      function _loadTimesheet(first) {
        var last = moment(first).add(14, "days");

        // expand date range here, because ng-repeat does not plays well with array of objects
        var resource = timesheetRepository.list({from: first.format("YYYYMMDD"), to: last.format("YYYYMMDD")});
        resource.$promise.then(function(timesheet) {
          $scope.dateRange = dateRange(timesheet.from, timesheet.to);
          $scope.timesheet = resource;
        });

        return resource;
      }

    }
  ]);





