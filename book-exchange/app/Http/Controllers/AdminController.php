<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;
use App\OfferType;
use App\Qualities;
use App\ReportReasons;
use App\Offer;
use App\ReportedOffers;

class AdminController extends Controller
{
	public function index () {
		$reported_offers = ReportedOffers::all();
		$offer_types = OfferType::all();
		$qualities = Qualities::all();
		$report_reasons = ReportReasons::all();
		
		$data['offer_types'] = $offer_types;
		$data['qualities'] = $qualities;
		$data['report_reasons'] = $report_reasons;
		$data['reported_offers'] = $reported_offers;
				
		return view('admin.index', $data);
	}
}
