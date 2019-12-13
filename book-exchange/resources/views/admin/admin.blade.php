@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-danger">
			    <div class="panel-heading">Reported Offers</div>
			    <div class="panel-body">
						@forelse ($offers as $offer)
						<p class="clickable showable" data-object="offer" data-id="{{$offer->id}}">
							@if ($offer->flagged == 1)
							<strong>isbn:</strong> {{$offer->book->isbn}}
							<br>
							<strong>title:</strong> {{$offer->book->title}}
							<br>
							<strong>price:</strong> ${{$offer->price}}
							@endif
						</p>
			        @empty
			            No current offers
			        @endforelse
					<br>
			    </div>
			</div>
		</div>
    </div>
</div>
@endsection
