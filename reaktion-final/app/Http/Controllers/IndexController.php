<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;

class IndexController extends Controller
{
	public function index () {
		$data['sec'] = 'layouts';
		
		return view('welcome', $data);
	}
}
