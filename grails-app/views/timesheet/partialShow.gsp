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
        <th ng-repeat="num in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ]">{{num}}</th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="project in timesheet.selectedProjects">
        <td>
          {{project.data.name}}
        </td>
        <td ng-repeat="num in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ]" class="days edit-in-line">
          <input type="number" class="form-control" min="0" max="24" />
        </td>
      </tr>
    </tbody>
  </table>

  <div class="form-inline" >
    <div class="form-group col-md-8">
      <span class="col-md-3">Add project</span>
      <ui-select ng-model="timesheet.newProject"
                 theme="bootstrap"
                 ng-disabled="disabled"
                 reset-search-input="false">
        <ui-select-match placeholder="Project">{{$select.selected.name}}</ui-select-match>
        <ui-select-choices repeat="project in projects track by $index"
                           refresh="refreshProjects($select.search)"
                           refresh-delay="0">
          <div ng-bind-html="project.name | highlight: $select.search"></div>
        </ui-select-choices>
      </ui-select>
    <button type="button" class="btn btn-primary" ng-click="addProject()">Confirm</button>
    </div>
  </div>



</div>