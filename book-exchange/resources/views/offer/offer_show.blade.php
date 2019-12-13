@extends('layouts.app')

@section('content')
<div class="modal fade report-offer" tabindex="-1" role="dialog" aria-labelledby="reportOffer" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
		<div class="modal-header">
        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        	<h4 class="modal-title" id="gridModalLabel">Report Offer</h4>
      	</div>
			<div class="col-md-offset-1">
				<br>
				<div class="row">
					<div class="col-md-6">
						{{Form::open(array('url'=>'flagged', 'method'=>'post'))}}
                        		{{Form::hidden('offer-id', $offer->id)}}
						{{Form::select('reasons',$report_list,1,array())}}
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-10">
						<label>Other</label>{{Form::text('other', null, array("class"=>"form-control"))}}
						<br>
						{{Form::submit('Report', array("class"=>"btn btn-primary"))}}
						{{Form::close()}}
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</div>
				<br>
			</div>
		</div>
    </div>
  </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Welcome</div>

                <div class="panel-body">
                    <div class="col-md-10">
                        Offer Information
					</div>
                    <br>
					<br>
				        
                    <div class="col-md-3">
                        <img style="border: 1px solid #000;" src="{{URL::asset('images/no-image.jpg')}}" alt="No-image" height="200" width="160">
                    </div>
                    <div class="col-md-5">
                        <br>
                        <br>
                        <div>
                            <label>ISBN:</label>
                            <span>{{$offer->book->isbn}}</span>
                        </div>

                        <div>
                            <label>Title:</label>
                            <span>{{$offer->book->title}}</span>
                        </div>

                        <div>
                            <label>Price:</label>
                            <span>${{$offer->price}}</span>
                        </div>

                        <div>
                            <label>Quality:</label>
                            <span>{{$offer->getQuality()}}</span>
                        </div>
                    </div>    
		
   		    @if(Auth::user()->id != $offer->users_id)
			    <div class="col-md-3">
					<br>
					@if(Auth::user()->user_types_id != 2)
						@if(!$offer->isReported())
							<button class="btn btn-outline-danger" data-toggle="modal" data-target=".report-offer">Report</button>
						@else
							<button type="button" class="btn btn-outline-danger disabled" style="color:black;background-color:firebrick;">Reported</button>
						@endif
					@else
						@if($offer->isReported())
							<a href="/offer/{{$offer->id}}/reinstate" class="btn btn-primary">reinstate</a>
							<a href="/offer/{{$offer->id}}/remove" class="btn btn-default">remove</a>
						@endif
					@endif
					<br>
			    </div>	
		    @endif
                    
                    <div class="col-md-10">
                    	@if(!$offer->isReported())
		                   @if(Auth::user()->id != $offer->users_id)
		                   <hr/>
		                   <div>
		                       <label>Seller Username:</label>
		                       <span><strong>{{$seller}}</strong></span>
		                   </div>
		                   

		                   <div>
		                   {{Form::open(array('url'=>'message', 'method'=>'post'))}}
		                       {{Form::hidden('user-id', $offer->users_id)}}
		                       {{Form::hidden('offer-id', $offer->id)}}
		                       {{Form::hidden('offer', '1')}}
								{{Form::hidden('reply', false)}}
							
		                       <br>
		                       <label>Message Seller:</label> {{Form::textarea('message', null, array("class"=>"form-control"))}}
		                       <br>
		                       {{Form::submit('Submit', array("class"=>"btn btn-primary"))}}
							{{Form::close()}}
		                   </div>
		                   @else
		                       <br>
		                       <a href="/offer/{{$offer->id}}/edit" class="btn btn-primary">Edit</a>
		                   @endif
	                   @endif
				</div>
                </div>
				<br>
            </div>
        </div>
    </div>
</div>
@endsection
