<!DOCTYPE html>
<html>
	@include('layouts.head')
	<body>
		@include('layouts.header')
		@include('layouts.nav')
		<div class="nav-divide"></div>
		@include($sec . '.secondary_nav')
		<div class="background-outer">
			<div class="container">
				<div id="main-content">
					@yield('content')
				</div>
			</div>
		</div>
		@include('layouts.footer')
	</body>
</html>
