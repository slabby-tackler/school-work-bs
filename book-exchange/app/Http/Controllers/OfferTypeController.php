<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;
use App\OfferType;

class OfferTypeController extends Controller
{
	public function destroy($id){
		OfferType::destroy($id);
		return redirect('/admin');
	}
	public function store(Request $request){
		$OfferType = new OfferType();
		$OfferType -> name = $request -> get('Name');
		$OfferType -> save();
		return redirect('/admin');
	}
}
