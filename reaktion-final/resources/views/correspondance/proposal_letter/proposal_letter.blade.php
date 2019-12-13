@extends('layouts.layout')
@section('content')
	@include('layouts.toggle_btns')
	@include('correspondance.proposal_letter.proposal_original')
	@include('correspondance.proposal_letter.proposal_revised')
	@include('correspondance.proposal_letter.proposal_notes')
@stop
