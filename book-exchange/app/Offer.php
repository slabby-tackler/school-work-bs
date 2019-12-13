<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\ReportedOffers;
use App\Qualities;

class Offer extends Model
{
	use SoftDeletes;
	
	protected $dates = ['deleted_at'];
	
	public function book () {
		return $this->hasOne('App\Book', 'id', 'books_id');
	}

	public function isReported () {
		$reported = ReportedOffers::where('offers_id', '=', $this->id)->first();
		
		if(!empty($reported))
			$isReport = true;
		else
			$isReport = false;

		return $isReport;
	}
	
	public function getQuality() {
		$quality = Qualities::find($this->qualities_id);
		
		return $quality->name;
	}
}
