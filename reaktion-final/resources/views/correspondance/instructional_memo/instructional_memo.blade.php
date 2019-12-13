@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('correspondance.instructional_memo.instructional_original')
	@include('correspondance.instructional_memo.instructional_revised')
	@include('correspondance.instructional_memo.instructional_notes')
@stop
