@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('report.formal_report.formal_original')
	@include('report.formal_report.formal_revised')
	@include('report.formal_report.formal_notes')
@stop
