<html>
<head>
  <title>Home</title>
  <meta name="layout" content="mainLayout"/>

  <style>
  .form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #555;
    font-size: 18px;
    font-weight: 400;
    display: block;
}

.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
}
.login-message { margin: 20px; text-align: center; color: #ff6666;}
.btn-google { background-color: #d34836; color: white;}
</style>
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
        	<oauth:connect provider="google" id="google-connect-link" class="btn btn-lg btn-google btn-block">Sign in with Google</oauth:connect>	

            <h1 class="text-center login-title">Or sign in with username and password</h1>
            <div class="account-wall">
                <form class="form-signin" action='${postUrl}' method='POST' autocomplete='off'>
	                <input type="text" class="form-control" placeholder="Username" name="j_username" required autofocus>
	                <input type="password" class="form-control" placeholder="Password" name="j_password" required>

        			<g:if test='${flash.message}'>
						<div class='login-message'>${flash.message}</div>
					</g:if>

	                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
