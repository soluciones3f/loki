<g:applyLayout name="customMain">
<!DOCTYPE html>
<html>
<head>
  <g:layoutHead/>
  <!-- it required bootstrap, so be careful when you change the layout -->
  <asset:stylesheet src="dashboard"/>
</head>
<body>

  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="#">Overview</a></li>
        <li><a href="#">New Quote</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="">Customers</a></li>
      </ul>
    </div>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <g:layoutBody/>
    </div>
    <!-- END -->
  </div>

</body>
</html>
</g:applyLayout>
