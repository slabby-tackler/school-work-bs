@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('pamphlet.brochure.brochure_original')
	@include('pamphlet.brochure.brochure_revised')
	@include('pamphlet.brochure.brochure_notes')
@stop
