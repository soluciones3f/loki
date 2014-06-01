<div ng-controller="CreateQuoteController">

  <h3>New Quote</h3>

  <form role="form">

    <div class="form-group row" >
      <label class="col-md-6">
        <span>Customer: </span>
        <ui-select ng-model="customer.selected"
                   theme="bootstrap"
                   ng-disabled="disabled"
                   reset-search-input="false">
          <ui-select-match placeholder="Enter a customer name...">{{$select.selected.name}}</ui-select-match>
          <ui-select-choices repeat="customer in customers track by $index"
                             refresh="refreshCustomers($select.search)"
                             refresh-delay="0">
            <div ng-bind-html="customer.name | highlight: $select.search"></div>
          </ui-select-choices>
        </ui-select>
      </label>

    </div>
    <div class="row">
      <small>{{customer.selected}}</small>
    </div>

  </form>

</div>