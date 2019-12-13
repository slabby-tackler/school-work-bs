@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('correspondance.resource_email.resource_original')
	@include('correspondance.resource_email.resource_revised')
	@include('correspondance.resource_email.resource_notes')
@stop
