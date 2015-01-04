<style type="text/css">
  table td.edit-in-line input {
    width: 30px;
    padding: 0;
    margin: 0;
    border: 0;
  }

  table th.days, table td.days {
    width: 30px;
  }
</style>

<div ng-controller="TimesheetController">

  <h3>TimeSheet <small>From {{ dateRange[0] | dateFormat:'MMMM D' }} to {{ dateRange[dateRange.length-1] | dateFormat:'MMMM D' }}</small></h3>
  <div><button ng-click="moveDays(-15)">previous</button> <button ng-click="moveDays(15)">next</button></div>

  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Project</th>
        <th ng-repeat="num in dateRange" ng-class="dayColor(num)">{{num.format("DD")}}</th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="project in timesheet.projects">
        <td>
          {{project.name}}
        </td>
        <td ng-repeat="date in dateRange" class="days edit-in-line" ng-class="dayColor(date)">
          <input type="number" ng-model="project.days[ date.format('YYYYMMDD') ]" ng-change="saveHours(date, project)" class="form-control" min="0" max="24" />
        </td>
      </tr>
    </tbody>
    <tfoot>
      <tr>
        <th>Total</th>
        <td ng-repeat="date in dateRange" class="days" ng-class="dayColor(date)">
          {{ columnTotal(date) }}
         </td>
      </tr>
    </tfoot>
  </table>

  <button type="button" class="btn btn-primary" ng-click="saveChanges()">Save changes</button>

  <hr/>
  <div class="form-inline" >
    <select class="form-control" ng-model="newProject" ng-options="project.name for project in projects"></select>
    <button type="button" class="btn btn-primary" ng-disabled="newProject == null" ng-click="addProject()  ">Add Project</button>
  </div>
</div>