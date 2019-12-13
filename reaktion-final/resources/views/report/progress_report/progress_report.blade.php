@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('report.progress_report.progress_original')
	@include('report.progress_report.progress_revised')
	@include('report.progress_report.progress_notes')
@stop
