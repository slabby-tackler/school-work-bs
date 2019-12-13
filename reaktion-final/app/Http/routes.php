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

Route::group(['middleware' => ['web']], function() {
	// Landing Page
	Route::get('/', 'IndexController@index');
	
	// Correspondance
	Route::get('/correspondance', 'CorrespondanceController@index');
	Route::get('/correspondance/inquiry', 'CorrespondanceController@inquiry');
	Route::get('/correspondance/bad', 'CorrespondanceController@badNews');
	Route::get('/correspondance/instructional', 'CorrespondanceController@instructional');
	Route::get('/correspondance/proposal', 'CorrespondanceController@proposal');
	Route::get('/correspondance/resource', 'CorrespondanceController@resourceEmail');
	Route::get('/correspondance/complaint', 'CorrespondanceController@complaint');
	
	// Report
	Route::get('/report', 'ReportController@index');
	Route::get('/report/formal', 'ReportController@formal');
	Route::get('/report/incident', 'ReportController@incident');
	Route::get('/report/progress', 'ReportController@progress');
	
	// Pamphlet
	Route::get('/pamphlet', 'PamphletController@index');
	Route::get('/pamphlet/flier', 'PamphletController@flier');
	Route::get('/pamphlet/brochure', 'PamphletController@brochure');
	Route::get('/pamphlet/social', 'PamphletController@social');
	Route::get('/pamphlet/infographic', 'PamphletController@infographic');
});
