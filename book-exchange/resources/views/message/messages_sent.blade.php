@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Messages Sent - Click to View</div>
                    <div class="panel-body">
                        @forelse ($messages as $message)
                        <p class="clickable showable" data-object="message" data-id="{{$message->id}}">
                            <strong>To User:</strong> {{$message->user->username}}
                            <br>
                            <strong>Message:</strong> {{$message->message}}
                            <br>
                            <!----<a class="btn btn-default" href="">Reply</a>----->
                        </p>
                        <hr/>
                        @empty
                            No Messages
                            <hr/>
                        @endforelse
                    </div>
            </div>
        </div>
    </div>
</div>
@endsection
