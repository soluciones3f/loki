<div ng-controller="WorkDetailReportController">
  	<h3>Work Detail</h3>
  	<p>Worked hours by all users in the specified date range.</p>

  	<fieldet>
  		<legend>Date range</legend>
		<div class="form-group">
	    	<label for="dateFrom">From</label>
	    	<input type="date" class="form-control" id="dateFrom" placeholder="Enter from date" ng-model="range.from">
	  	</div>
		<div class="form-group">
	    	<label for="dateTo">To</label>
	    	<input type="date" class="form-control" id="dateTo" placeholder="Enter to date" ng-model="range.to">
	  	</div>
  	</fieldet>

  	<table class="table">
  		<thead>
  			<tr><th>Fecha</th><th>Horas</th><th>Alias</th><th>Id Proyecto</th><th>Proyecto</th></tr>
  		</thead>
  		<tbody>
  			<tr ng-repeat="item in workdata">
  				<td>{{ item.date }}</td>
  				<td>{{ item.hours }}</td>
  				<td>{{ item.username }}</td>
  				<td>{{ item.project.id }}</td>
  				<td>{{ item.project.name }}</td>
  			</tr>
  		</tbody>
  	</table>
</div>