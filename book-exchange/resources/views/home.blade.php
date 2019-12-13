<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">

	    <title>TextBook Swap</title>

	    <!-- Fonts -->
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" integrity="sha384-XdYbMnZ/QjLh6iI4ogqCTaIjrFk87ip+ekIjefZch0Y+PvJ8CDYtEs1ipDmPorQ+" crossorigin="anonymous">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700">

	    <!-- Styles -->
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	    <link href="{{ URL('css/home_page.css') }}" rel="stylesheet">
	</head>
	<body id="app-layout">
		<div id="home-div">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-6">
						<span class="title">Textbook </span><img src="{{ URL::asset('images/textbook_swap_logo.png')}}" class="logo" /><span class="title"> Swap</span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-5 col-md-offset-6 login-buttons">
						Textbook swap is your <strong><em>#1</em></strong> spot for buying, selling, and trading textbooks with fellow students and colleagues.
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-5 col-md-offset-6 text-right login-buttons">
						@if (Auth::guest())
                        	<a href="{{ url('/login') }}" class="btn btn-primary home-button">Login</a>
							<a href="{{ url('/register') }}" class="btn btn-default home-button">Register</a>
                   		@else
							<a href="/dashboard" class="btn btn-primary">Dashboard</a>
						@endif
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
