<style type="text/css">
  table.edit-in-line input {
    width: 30px;
    padding: 0;
    margin: 0;
    border: 0;
  }
</style>

<div ng-controller="TimesheetController">

  <h3>TimeSheet</h3>

  <table class="table table-bordered table-striped edit-in-line">
    <thead>
      <tr>
        <th>Project</th>
        <th ng-repeat="num in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ]">{{num}}</th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="project in timesheet.selectedProjects">
        <td>

          <ui-select ng-model="project.data"
                     theme="bootstrap"
                     ng-disabled="disabled"
                     reset-search-input="false">
            <ui-select-match placeholder="Project">{{$select.selected.name}}</ui-select-match>
            <ui-select-choices repeat="project in projects track by $index"
                               refresh="refreshProjects($select.search)"
                               refresh-delay="0">
              <div ng-bind-html="project.name | highlight: $select.search"></div>
          </ui-select-choices>


        </td>
        <td ng-repeat="num in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ]">
          <input type="number" min="0" max="24" />
        </td>
      </tr>
    </tbody>
  </table>

</div>