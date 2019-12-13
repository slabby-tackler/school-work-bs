<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;

class CorrespondanceController extends Controller
{
	public function index () {
		return redirect('/correspondance/inquiry');
	}
	
	public function inquiry () {
		$data['sec'] = 'correspondance';
		
		return view ('correspondance.inquiry_letter.inquiry_letter', $data);
	}
	
	public function badNews () {
		$data['sec'] = 'correspondance';
		
		return view ('correspondance.bad_news_letter.bad_news_letter', $data);
	}
	
	public function instructional () {
		$data['sec'] = 'correspondance';
		
		return view ('correspondance.instructional_memo.instructional_memo', $data);
	}
	
	public function proposal () {
		$data['sec'] = 'correspondance';
		
		return view ('correspondance.proposal_letter.proposal_letter', $data);
	}
	
	public function resourceEmail () {
		$data['sec'] = 'correspondance';
		
		return view ('correspondance.resource_email.resource_email', $data);
	}
	
	public function complaint () {
		$data['sec'] = 'correspondance';
		
		return view ('correspondance.complaint_letter.complaint_letter', $data);
	}
}
