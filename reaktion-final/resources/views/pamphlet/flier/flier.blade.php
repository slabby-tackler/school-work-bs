@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('pamphlet.flier.flier_original')
	@include('pamphlet.flier.flier_revised')
	@include('pamphlet.flier.flier_notes')
@stop
