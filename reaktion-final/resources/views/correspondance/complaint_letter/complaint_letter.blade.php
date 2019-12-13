@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('correspondance.complaint_letter.complaint_original')
	@include('correspondance.complaint_letter.complaint_revised')
	@include('correspondance.complaint_letter.complaint_notes')
@stop
