<div ng-controller="CreateQuoteController">

  <h3>New Quote</h3>
  <div>

    <label class="control-label">
      <span>Customer: </span><small>{{customer.selected}}</small>
      <ui-select ng-model="customer.selected"
                 theme="bootstrap"
                 ng-disabled="disabled"
                 reset-search-input="false"
                 style="width: 300px;">
        <ui-select-match placeholder="Enter a customer name...">{{$select.selected.name}}</ui-select-match>
        <ui-select-choices repeat="customer in customers track by $index"
                           refresh="refreshCustomers($select.search)"
                           refresh-delay="0">
          <div ng-bind-html="customer.name | highlight: $select.search"></div>
        </ui-select-choices>
      </ui-select>
    </label>
  </div>

</div>