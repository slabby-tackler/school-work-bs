@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Welcome</div>

                <div class="panel-body">	
				{{Form::open(array('url'=>'offer/' . $offer->id, 'method'=>'put', 'files'=>'true'))}}
					{{Form::hidden('book-id', 0)}}
					{{Form::hidden('offer', true)}}

					
					<label>ISBN: </label>
					{{Form::text('isbn', $offer->book->isbn, array("class"=>"form-control", "disabled"))}}
					
					<label>Title:</label>
					{{Form::text('name', $offer->book->title, array("class"=>"form-control", "disabled"))}}
					
					<label>Author:</label>
					{{Form::text('author', $offer->book->author, array("class"=>"form-control", "disabled"))}}
					
					<label>Version:</label>
					{{Form::text('version', $offer->book->version, array("class"=>"form-control", "disabled"))}}
					
					<label>Offer Type</label>
                    {{Form::select('type', $offer_type_array, $offer->offer_types_id, array('class' => 'form-control'))}}
                    
                    <label>Quality</label>
					{{Form::select('quality', $quality_array, $offer->qualities_id, array('class' => 'form-control'))}}
					
					<label>Price:</label>
					${{Form::text('price', $offer->price, array("class"=>"form-control offer-price"))}}
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
