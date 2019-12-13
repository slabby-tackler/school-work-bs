@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Offers</div>
                <div class="panel-body">
				@forelse ($offers as $offer)
					@if($offer->isReported())
						@continue
					@endif
					<div class="clickable showable" data-object="offer" data-id="{{$offer->id}}">
                         	<div class="row">
                          	  <div class="col-md-10">
		                           <div class="col-md-2">
		                               <img style="border: 1px solid #000;" src="{{URL::asset('images/no-image.jpg')}}" alt="No-image" height="100" width="80" />     
		                           </div>
		                           <div class="col-md-5">
		                               <strong>isbn:</strong> {{$offer->book->isbn}}
		                               <br>
		                               <strong>title:</strong> {{$offer->book->title}}
		                               <br>
		                               <strong>price:</strong> ${{$offer->price}}
		                               <br>
		                               <strong>quality:</strong> {{$offer->getQuality()}}
		                           </div>
                            	  </div>
                        	     </div>
                        		<hr/>
                    	</div>
				@empty
					No current offers
				@endforelse
				<br><br>
				<div class="row">
					<div class="col-md-1 col-md-offset-10">
						<a href="offer/new" class="btn btn-primary">new offer</a>
					</div>
				</div>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
