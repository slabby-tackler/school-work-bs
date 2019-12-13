<?php

namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Http\Requests;
use App\Http\Controllers\BookController;
use Illuminate\Support\Facades\Auth;
use App\Offer;
use App\Book;
use App\User;
use App\ReportedReason;
use App\ReportedOffers;
use App\OfferType;
use App\Qualities;

class OfferController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $offers = Offer::all();
		    
		$data['offers'] = $offers;
        
        return view ('offer/offers', $data);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $offer_types = OfferType::all();
	   $qualities = Qualities::all();
        
        $quality_array = array();
	   $offer_type_array = array();

	   foreach($qualities as $quality) {
		   $quality_array[$quality->id] = $quality->name;
	   }

	   foreach($offer_types as $type) {
		   $offer_type_array[$type->id] = $type->name;
	   }
  
   	   $data['offer_type_array'] = $offer_type_array;
   	   $data['quality_array'] = $quality_array;
   	   
   	   return view('offer.offer_new', $data);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $book_id = $request->get ('book-id');
        
        if ($book_id == 0) {
        	$book = BookController::store ($request);
   	   } else {
   	   	$book = Book::find ($book_id);
   	   }
   	   
   	   $offer = new Offer ();
   	   $offer->users_id = Auth::user()->id;
   	   $offer->books_id = $book->id;
   	   $offer->qualities_id = $request-> get ('quality');
   	   $offer->price = $request->get ('price');
   	   $offer->offer_types_id = $request->get ('type');
   	   $offer->save ();
   	   
   	   return redirect('/offer');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $offer = Offer::find($id);
		$seller = User::find($offer->users_id);
		$report_reasons = ReportedReason::all();
		
		$reason_list=array();
		
		foreach($report_reasons as $reason){
		   $reason_list[$reason->id] = $reason->name;
	   	}
		
        	$data['offer'] = $offer;
		$data['seller'] = $seller->username;
		$data['report_list'] = array_reverse($reason_list);
        
        return view('offer/offer_show', $data);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $offer = Offer::find($id);
        $offer_types = OfferType::all();
	   $qualities = Qualities::all();
        
        $quality_array = array();
	   $offer_type_array = array();

	   foreach($qualities as $quality) {
		   $quality_array[$quality->id] = $quality->name;
	   }

	   foreach($offer_types as $type) {
		   $offer_type_array[$type->id] = $type->name;
	   }
  
   	   $data['offer_type_array'] = $offer_type_array;
   	   $data['quality_array'] = $quality_array;
        $data['offer'] = $offer;
        
        return view('offer/offer_edit', $data);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $offer_types_id = $request->get('type');
        $price =  $request->get('price');
        $quality = $request->get('quality');

        Offer::where('id', $id)->update(array(
            'offer_types_id' => $offer_types_id,
            'price' =>  $price,
            'qualities_id' => $quality
        ));
		
		return redirect('/offer');
    }
    public function flagged(Request $request)
    {
	$report = new ReportedOffers ();
		$reported_reason = $request->get('reasons');
		$report->offers_id = $request->get('offer-id');
		$report->report_reasons_id = $reported_reason;
		if($reported_reason==3){
			$report->other= $request->get('other');
		}
		$report->save ();

		return redirect()->back();
    }
	public function reinstate($id)
	{
		$reported = ReportedOffers::where('offers_id', '=', $id)->first();
		
		$reported->delete();
		
		return redirect('/admin');
	}
	
	public function remove($id) {
		$offer = Offer::find($id);
		$reported = ReportedOffers::where('offers_id', '=', $id)->first();
		
		$offer->delete();
		$reported->delete();
		
		return redirect('/admin');
	}



    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
