<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;
use App\ReportReasons;

class ReportReasonsController extends Controller
{
	public function destroy($id){
		ReportReasons::destroy($id);
		return redirect('/admin');
	}
	public function store(Request $request){
		$ReportReasons = new ReportReasons();
		$ReportReasons -> name = $request -> get('Name');
		$ReportReasons -> save();
		return redirect('/admin');
	}
}
