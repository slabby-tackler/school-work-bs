@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('correspondance.bad_news_letter.bad_news_original')
	@include('correspondance.bad_news_letter.bad_news_revised')
	@include('correspondance.bad_news_letter.bad_news_notes')
@stop
