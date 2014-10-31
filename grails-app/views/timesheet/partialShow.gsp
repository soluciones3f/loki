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

  <h3>TimeSheet</h3>

  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Project</th>
        <th ng-repeat="num in dateRange">{{num.format("DD")}}</th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="project in timesheet.projects">
        <td>
          {{project.id | name:projects}}
        </td>
        <td ng-repeat="hours in project.days track by $index" class="days edit-in-line">
          <input type="number" ng-model="project.days[$index]" class="form-control" min="0" max="24" />
        </td>
      </tr>
    </tbody>
  </table>

  <button type="button" class="btn btn-primary" ng-click="saveChanges()">Save changes</button>

  <hr/>
  <div class="form-inline" >
    <select class="form-control" ng-model="newProject" ng-options="project.name for project in projects"></select>
    <button type="button" class="btn btn-primary" ng-disabled="newProject == null" ng-click="addProject()  ">Add Project</button>
  </div>
</div>