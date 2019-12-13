@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Messages</div>
                
                <div class="panel-body">
                {{Form::open(array('url'=>'message', 'method'=>'post'))}}
                    
                    
                    <label>Message Seller:</label>
                    {{Form::textarea('message', '', array("class"=>"form-control"))}}
                    
                    {{Form::submit('Submit', array("class"=>"btn btn-primary"))}}
                </div>
			 <br>
            </div>
        </div>
    </div>
</div>
@endsection
