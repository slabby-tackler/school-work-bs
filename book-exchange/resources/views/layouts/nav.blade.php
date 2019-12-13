<nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">

                <!-- Collapsed Hamburger -->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#app-navbar-collapse">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <!-- Branding Image -->
                <a class="navbar-brand" href="/">
                    <img src="{{ URL::asset('/images/textbook_swap_logo.png') }}" alt="Textbook Swap" />
                </a>
            </div>

            <div class="collapse navbar-collapse" id="app-navbar-collapse">
                
                <!-- Left Side Of Navbar -->
                <ul class="nav navbar-nav">
                	@if(!Auth::guest())
			        <li><a href="/dashboard">Dashboard</a></li>
			        <li><a href="/offer">Offers</a></li>
			        <li><a href="/message">Inbox</a></li>
			        @if(Auth::user()->user_types_id ==2)
				        <li><a href="/admin">Administration</a></li>
			        @endif
		          @endif
                </ul>

                <!-- Right Side Of Navbar -->
                <ul class="nav navbar-nav navbar-right">
                	@if(!Auth::guest())
	                    <li><a href="/logout">Logout {{Auth::user()->email}}</a></li>
                    @endif
                </ul>
            </div>
        </div>
    </nav>
