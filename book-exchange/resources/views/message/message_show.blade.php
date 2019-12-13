@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Message</div>

                <div class="panel-body">
                    <label>Message From: </label> {{$message->user->username}}
                    <div >
                        {{$message->message}}
                    </div>
                    <br>
                    
					@foreach ($message->message_reply as $message_reply)
					<div class="clickable showable" data-object="message" data-id="{{$message->id}}">
                        <div class="row">
                            <div class="col-md-10">
                                <div class="col-md-5">
                                    <strong>From: </strong> {{$message_reply->message->user->username}}
                                    <br>
                                    <strong>Message:</strong> {{$message_reply->message->message}}
                                </div>
                            </div>
                        </div>
                        <hr/>
                    </div>
                    @endforeach	

                    {{Form::open(array('url'=>'message', 'method'=>'post'))}}
                    {{Form::hidden('user-id', $message->from_users_id)}}
                    {{Form::hidden('parent_msg', $message->id)}}
                    {{Form::hidden('offer-id', $message->offer_id)}}

					<label>Reply:</label>
                    {{Form::textarea('message', "", array("class"=>"form-control", "rows"=>"5"))}}
                    <br>
                    {{Form::submit('Reply', array("class"=>"btn btn-primary"))}}
                </div>
	            <br>
            </div>
        </div>
    </div>
</div>
@endsection
