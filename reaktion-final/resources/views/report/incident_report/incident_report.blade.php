@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('report.incident_report.incident_original')
	@include('report.incident_report.incident_revised')
	@include('report.incident_report.incident_notes')
@stop
