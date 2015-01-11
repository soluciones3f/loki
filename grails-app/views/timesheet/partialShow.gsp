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

  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Project</th>
        <th ng-repeat="num in dateRange" ng-class="dayColor(num)">{{num.format("DD")}}</th>
        <th class="days">Sum</th>
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
        <td>
          {{rowTotal(project)}}
        </td>
      </tr>
    </tbody>
    <tfoot>
      <tr>
        <th>Total</th>
        <td ng-repeat="date in dateRange" class="days" ng-class="dayColor(date)">
          {{ columnTotal(date) }}
         </td>
         <td>&nbsp;</td>
      </tr>
      <tr>
        <th>
          <div class="form-inline" >
            <select class="form-control" style="width: 50%" ng-model="newProject" ng-options="project.name for project in projects"></select>
            <button type="button" class="btn btn-primary" ng-disabled="newProject == null" ng-click="addProject()  ">Add Project</button>
          </div>
        </th>
        <th colspan="{{dateRange.length}}">
          <button type="button" class="btn btn-default btn-xs" ng-click="moveDays(-15)">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Prev
          </button>
          <button type="button" class="btn btn-default btn-xs pull-right" ng-click="moveDays(15)">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> Next
          </button>
        </th>
      </tr>
    </tfoot>
  </table>

  <button type="button" class="btn btn-success pull-right" ng-click="saveChanges()">Force Save</button>


</div>