@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Welcome</div>

                <div class="panel-body">	
				{{Form::open(array('url'=>'offer', 'method'=>'post', 'files'=>'true'))}}
					{{Form::hidden('book-id', 0)}}
					{{Form::hidden('offer', true)}}
					
					<label>ISBN: </label>
					{{Form::text('isbn', '', array("class"=>"form-control"))}}
					
					<label>Title:</label>
					{{Form::text('name', '', array("class"=>"form-control"))}}
					
					<label>Author:</label>
					{{Form::text('author', '', array("class"=>"form-control"))}}
					
					<label>Version:</label>
					{{Form::text('version', '', array("class"=>"form-control"))}}
					
					<label>Offer Type</label>
                    {{Form::select('type', $offer_type_array, '1', array('class' => 'form-control'))}}
                    
                    <label>Quality</label>
					{{Form::select('quality', $quality_array, '1', array('class' => 'form-control'))}}
					
					<label>Price:</label>
					${{Form::text('price', '', array("class"=>"form-control offer-price", "placeholder"=>"0.00"))}}
					<br>
                    {{Form::file('image')}}
                    
					<br>
					{{Form::submit('Submit', array("class"=>"btn btn-primary"))}}
					<a class="btn btn-default" href="/offer">Cancel</a>
				{{Form::close()}}
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
