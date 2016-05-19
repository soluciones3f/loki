<div class="col-md-offset-4 col-md-8 shadow-background"></div>
<div ng-controller="WorkDetailReportController">
  <div class="row">
    <div class="col-md-4">
      <h3>Work Detail</h3>
      <p>Worked hours by all users in the specified date range.</p>

      <fieldset>
        <legend>Date range</legend>
        <div class="form-group">
          <label for="dateFrom">From</label>
          <input type="date" class="form-control" id="dateFrom" placeholder="Enter from date" ng-model="range.from">
        </div>
        <div class="form-group">
          <label for="dateTo">To</label>
          <input type="date" class="form-control" id="dateTo" placeholder="Enter to date" ng-model="range.to">
        </div>
      </fieldset>

      <fieldset>
        <legend>View</legend>
        <div class="btn-group">
          <label>
            <input type="radio" name="options" autocomplete="off" ng-model="selectedView" value="raw"> Raw Data
          </label>
          <label>
            <input type="radio" name="options" autocomplete="off" ng-model="selectedView" value="project"> by Project
          </label>
        </div>
      </fieldset>

      <button class="btn btn-primary" type="button" loki-export="workdata">Export Raw Data to Excel</button>
    </div>

    <div class="col-md-8" ng-show="workdata.length">
      <table class="table" ng-show="selectedView == 'raw'">
        <thead>
          <tr><th>Fecha</th><th>Alias</th><th>Proyecto</th><th>Horas</th></tr>
        </thead>
        <tbody>
          <tr ng-repeat="item in workdata">
            <td>{{ item.date.format("LL") }}</td>
            <td>{{ item.username }}</td>
            <td>{{ item.project.name }}</td>
            <td>{{ item.hours }}</td>
          </tr>
        </tbody>
      </table>

      <table class="table" ng-show="selectedView == 'project'">
        <thead>
          <tr><th>Proyecto</th><th class="text-right">Horas</th></tr>
        </thead>
        <tbody>
          <tr ng-repeat="item in projects">
            <td>{{ item.name }}</td>
            <td class="text-right">{{ item.total }}</td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>
</div>
