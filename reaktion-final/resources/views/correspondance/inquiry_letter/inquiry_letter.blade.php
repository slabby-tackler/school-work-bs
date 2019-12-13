@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('correspondance.inquiry_letter.inquiry_original')
	@include('correspondance.inquiry_letter.inquiry_revised')
	@include('correspondance.inquiry_letter.inquiry_notes')
@stop
