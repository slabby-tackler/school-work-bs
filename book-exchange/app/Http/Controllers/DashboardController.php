<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Requests;
use App\Http\Controllers\BookController;
use Illuminate\Support\Facades\Auth;
use App\Offer;
use App\User;
use App\Book;
use App\Message;
use App\ReportedOffers;
use Log;

class DashboardController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $user = User::find(Auth::user()->id);
        Log::debug($user);
        $offers = Offer::where('users_id', '=', $user->id)->get();
        $offer_ids = Offer::where('users_id', '=', $user->id)->get(array('id'))->toarray();
        
        $reported_offers = ReportedOffers::whereIn('id', $offer_ids)->get();
        
        $count = 0;
        
        $messages = Message::where('to_users_id', '=', $user->id)
            ->where('is_read', '=', 0)
            ->join('users', 'users.id', '=', 'from_users_id')
            ->select('messages.*','users.username')
            ->get();
        
        
        $data['offers'] = $offers;
        $data['reported_offers'] = $reported_offers;
        $data['messages'] = $messages;
        
        return view ('/dashboard', $data);
    }

}
