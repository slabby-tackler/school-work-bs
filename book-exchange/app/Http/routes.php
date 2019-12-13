<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

Route::group(['middleware'=>'web'], function () {
	// splash page
	Route::get('/', 'HomeController@splash');

	// Authentication Routes...
	Route::get('login', 'Auth\AuthController@showLoginForm');
	Route::post('login', 'Auth\AuthController@authenticate');
	Route::get('logout', 'Auth\AuthController@logout');

	// Registration Routes...
	Route::get('register', 'Auth\AuthController@showRegistrationForm');
	Route::post('register', 'Auth\AuthController@register');
});

Route::group(['middleware'=>['web', 'auth']], function () {
	// user dashboard
	Route::get('/dashboard', 'DashboardController@index');

	// offers
	Route::get('offer/new', 'OfferController@create');
	Route::get('offer', 'OfferController@index');
	Route::post('/offer', 'OfferController@store');
	Route::get('offer/{id}', 'OfferController@show');
	Route::get('offer/{id}/edit', 'OfferController@edit');
	Route::put('offer/{id}', 'OfferController@update');
	Route::post('flagged', array('uses' => 'OfferController@flagged'));
	
	// messages
	Route::get('message/new', function(){return view("message/messages_new");});
	Route::get('message', 'MessageController@index');
	Route::post('/message', 'MessageController@store');
	Route::get('message/sent', 'MessageController@show_sent');
	Route::get('message/{id}', 'MessageController@show');
	
	// admin
	Route::get('/admin', 'AdminController@index');
	Route::get('/offer/{id}/reinstate', 'OfferController@reinstate');
	Route::get('/offer/{id}/remove', 'OfferController@remove');
	Route::post('/offertype', 'OfferTypeController@store');
	Route::delete('/offertype/{id}', 'OfferTypeController@destroy');
	Route::post('/qualities', 'QualitiesController@store');
	Route::delete('/qualities/{id}', 'QualitiesController@destroy');
	Route::post('/reportreasons', 'ReportReasonsController@store');
	Route::delete('/reportreasons/{id}', 'ReportReasonsController@destroy');
	
});
