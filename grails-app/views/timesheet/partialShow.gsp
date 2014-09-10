<style type="text/css">
  table.edit-in-line input {
    width: 30px;
    padding: 0;
    margin: 0;
    border: 0;
  }
</style>

<div ng-controller="CreateQuoteController">

  <h3>TimeSheet</h3>

  <table class="table table-bordered table-striped edit-in-line">
    <thead>
      <tr>
        <th>Project</th>
        <th ng-repeat="num in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ]">{{num}}</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Select for list of projects</td>
        <td ng-repeat="num in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ]">
          <input type="number" min="0" max="24" />
        </td>
      </tr>
    </tbody>
  </table>

</div>