@extends('layouts.app')

@section('content')
	<div class="container">
	    <div class="row">
		   <div class="col-md-10 col-md-offset-1">
		       <div class="panel panel-default">
		           <div class="panel-heading">Reports</div>

		           <div class="panel-body">
		               @forelse($reported_offers as $reported)
						<p class="clickable showable" data-object="offer" data-id="{{$reported->offer->id}}">
							<strong>isbn:</strong> {{$reported->offer->book->isbn}}
							<br>
							<strong>title:</strong> {{$reported->offer->book->title}}
							<br>
							<strong>price:</strong> ${{$reported->offer->price}}
							<br>
							<strong>reason:</strong> {{$reported->getReason()}}
						</p>
			        	@empty
			            	No current reports
			        	@endforelse
					<br>
		           </div>
				 <br>
		       </div>
		   </div>
	    </div>
	    
	    <div class="row">
		   <div class="col-md-10 col-md-offset-1">
		       <div class="panel panel-default">
		           <div class="panel-heading">
		           	<div class="row">
		           		<div class="col-md-11">
		           			Qualities
	           			</div>
	           			<div class="col-md-1">
	           				<span class="glyphicon glyphicon-plus admin-add" data-toggle= "modal" data-target= "#qualities_modal"></span>
           				</div>
      				</div>
 				</div>
		           <div class="panel-collapse">
		               <table class="table table-responsive table-condensed">
		               	<thead>
		               		<th class="name-column">name</th>
		               		<th></th>
	               		</thead>
				@foreach($qualities as $type)
	               		<tr>
	               			<td>{{$type -> name}}</td>
	               			<td>{{Form::open(array('url' => '/qualities/'.$type -> id, 'method' => 'delete'))}}<span class="glyphicon glyphicon-remove admin-delete"></span>{{Form::close()}}
               			</tr> @endforeach
          			</table>
		           </div>
		       </div>
		   </div>
	    </div>
	    
	    <div class="row">
		   <div class="col-md-10 col-md-offset-1">
		       <div class="panel panel-default">
		           <div class="panel-heading">
		           	<div class="row">
		           		<div class="col-md-11">
		           			Offer Types
	           			</div>
	           			<div class="col-md-1">
	           				<span class="glyphicon glyphicon-plus admin-add" data-toggle= "modal" data-target= "#offer_type_modal"></span>
           				</div>
      				</div>
 				</div>
		           <div class="panel-collapse">
		               <table class="table table-responsive table-condensed">
		               	<thead>
		               		<th class="name-column">name</th>
		               		<th></th>
	               		</thead>
				@foreach($offer_types as $type)
	               		<tr>
	               			<td>{{$type -> name}}</td>
	               			<td>{{Form::open(array('url' => '/offertype/'.$type -> id, 'method' => 'delete'))}}<span class="glyphicon glyphicon-remove admin-delete"></span>{{Form::close()}}
               			</tr> @endforeach
          			</table>
		           </div>
		       </div>
		   </div>
	    </div>
	
	<div class="row">
		   <div class="col-md-10 col-md-offset-1">
		       <div class="panel panel-default">
		           <div class="panel-heading">
		           	<div class="row">
		           		<div class="col-md-11">
		           			Report Reasons
	           			</div>
	           			<div class="col-md-1">
	           				<span class="glyphicon glyphicon-plus admin-add" data-toggle= "modal" data-target= "#report_reasons_modal"></span>
           				</div>
      				</div>
 				</div>
		           <div class="panel-collapse">
		               <table class="table table-responsive table-condensed">
		               	<thead>
		               		<th class="name-column">name</th>
		               		<th></th>
	               		</thead>
				@foreach($report_reasons as $type)
	               		<tr>
	               			<td>{{$type -> name}}</td>
	               			<td>{{Form::open(array('url' => '/reportreasons/'.$type -> id, 'method' => 'delete'))}}<span class="glyphicon glyphicon-remove admin-delete"></span>{{Form::close()}}
               			</tr> @endforeach
          			</table>
		           </div>
		       </div>
		   </div>
	    </div>
<div class="modal fade" tabindex="-1" role="dialog" id= "qualities_modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">New Quality</h4>
      </div>
      <div class="modal-body">
        {{Form::open(array('url'=>'qualities', 'method'=>'post'))}}
		<label>Name: </label>
		{{Form::text('Name', '', array("class"=>"form-control"))}}	
      </div>
      <div class="modal-footer">
	{{Form::submit('Submit', array("class"=>"btn btn-primary"))}}
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	{{Form::close()}} 
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" tabindex="-1" role="dialog" id= "offer_type_modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">New Offer Type</h4>
      </div>
      <div class="modal-body">
        {{Form::open(array('url'=>'offertype', 'method'=>'post'))}}
		<label>Name: </label>
		{{Form::text('Name', '', array("class"=>"form-control"))}}	
      </div>
      <div class="modal-footer">
	{{Form::submit('Submit', array("class"=>"btn btn-primary"))}}
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	{{Form::close()}} 
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" tabindex="-1" role="dialog" id= "report_reasons_modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">New Reason for Reporting</h4>
      </div>
      <div class="modal-body">
        {{Form::open(array('url'=>'reportreasons', 'method'=>'post'))}}
		<label>Name: </label>
		{{Form::text('Name', '', array("class"=>"form-control"))}}	
      </div>
      <div class="modal-footer">
	{{Form::submit('Submit', array("class"=>"btn btn-primary"))}}
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	{{Form::close()}} 
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
@endsection
