<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;

class PamphletController extends Controller
{
	public function index () {
		return redirect('/pamphlet/flier');
	}
	
	public function flier () {
		$data['sec'] = 'pamphlet';
		
		return view ('pamphlet.flier.flier', $data);
	}
	
	public function brochure () {
		$data['sec'] = 'pamphlet';
		
		return view ('pamphlet.brochure.brochure', $data);
	}
	
	public function social () {
		$data['sec'] = 'pamphlet';
		
		return view ('pamphlet.social_media.social_media', $data);
	}
	
	public function infographic () {
		$data['sec'] = 'pamphlet';
		
		return view ('pamphlet.infographic.infographic', $data);
	}
}
