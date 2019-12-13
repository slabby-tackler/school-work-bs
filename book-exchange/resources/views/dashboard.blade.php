@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Messages</div>
                <div class="panel-body">
                    
                    @forelse ($messages as $message)
					<div class="clickable showable" data-object="message" data-id="{{$message->id}}">
                        <div class="row">
                            <div class="col-md-10">
                                <div class="col-md-5">
                                    <strong>From User: </strong>{{$message->username}}
                                    <br>
                                    <strong>Message:</strong> {{$message->message}}
                                </div>
                            </div>
                        </div>
                        <hr/>
                    </div>
                    @empty
                        You have no unread Messages.
                    @endforelse
                </div>
            </div>
        </div>
    </div>
	<div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Books</div>
                <div class="panel-body">
				@forelse ($offers as $offer)
					<p class="clickable showable" data-object="offer" data-id="{{$offer->id}}">
						@if (!$offer->isReported())
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
	<div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-danger">
                <div class="panel-heading">Reported Offers</div>
                <div class="panel-body">
				@forelse ($reported_offers as $reported)
					<p class="clickable showable" data-object="offer" data-id="{{$reported->offer->id}}">
						@if ($offer->isReported())
						<strong>isbn:</strong> {{$reported->offer->book->isbn}}
						<br>
						<strong>title:</strong> {{$reported->offer->book->title}}
						<br>
						<strong>price:</strong> ${{$reported->offer->price}}
						@endif
					</p>
                    @empty
                        No reported offers
                    @endforelse
				<br>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
