<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;
use App\Qualities;

class QualitiesController extends Controller
{
	public function destroy($id){
		Qualities::destroy($id);
		return redirect('/admin');
	}
	public function store(Request $request){
		$Qualities = new Qualities();
		$Qualities -> name = $request -> get('Name');
		$Qualities -> save();
		return redirect('/admin');
	}
}
