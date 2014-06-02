<div ng-controller="CreateQuoteController">

  <h3>New Quote</h3>

  <form novalidate role="form" name="quoteForm" ng-submit="submit()">
    <fieldset>

    <div class="form-group row" >
      <label class="col-md-6">
        <span class="control-label">Customer </span>
        <ui-select ng-model="quote.customer"
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
      <div class="col-md-6">
        <small>{{quote.customer}}</small>
      </div>
    </div>

    <div class="form-group row">
      <div class="col-md-12">
        <label class="control-label col-md-2" for="inputDescription">Description</label>
        <input type="text" class="form-control col-md-10" id="inputDescription" name="description">
      </div>

      <div class="col-md-12">
        <label class="control-label col-md-2" for="inputAmount">Amount</label>
        <input type="text" class="form-control col-md-4" id="inputAmount" name="amount">

        <label class="control-label col-md-2" for="inputCurrency">Currency</label>
        <g:currencySelect class="form-control col-md-4" id="inputCurrency" name="currency" />
      </div>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>

    </fieldset>
  </form>

</div>