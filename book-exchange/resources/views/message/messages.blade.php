@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Messages - Click on Message to Reply</div>

                <div class="panel-body">

                    @forelse ($messages as $message)
                    
						@if (!empty($message->message_reply_has_parent))
							<strong>From User:</strong> {{$message->message_reply_has_parent->message_parent->user->username}}
							<br>
							<strong>Message:</strong> {{$message->message_reply_has_parent->message_parent->message}}
							<br>
                            <strong>Has Replies</strong>
						    <hr/>
						
                        @else
                            <p class="clickable showable" data-object="message" data-id="{{$message->id}}">
                            <strong>From User:</strong> {{$message->user->username}}
							<br>
							<strong>Message:</strong> {{$message->message}}
                            <br>
                            </p>
                            <hr/>
                        @endif
						
					@empty
						You have no Messages.
                    @endforelse
                    <a class="btn btn-default" href="message/sent">Sent Msgs</a>
                </div>
			 <br>
            </div>
        </div>
    </div>
</div>
@endsection
