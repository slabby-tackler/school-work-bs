<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;

class ReportController extends Controller
{
	public function index () {
		return redirect('/report/formal');
	}
	
	public function formal () {
		$data['sec'] = 'report';
		
		return view ('report.formal_report.formal_report', $data);
	}
	
	public function incident () {
		$data['sec'] = 'report';
		
		return view ('report.incident_report.incident_report', $data);
	}
	
	public function progress () {
		$data['sec'] = 'report';
		
		return view ('report.progress_report.progress_report', $data);
	}
	
}
