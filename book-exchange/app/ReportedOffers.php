<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use Log;
use App\ReportReasons;

class ReportedOffers extends Model
{
    use SoftDeletes;
    
    protected $dates = ['deleted_at'];
    
    public function offer() {
    	return $this->hasOne('App\Offer', 'id', 'offers_id');
    }
    
    public function getReason() {
    	Log::debug('This:\n');
    	Log::debug($this);
    	$reason = ReportReasons::find($this->report_reasons_id);
    	Log::debug('reason:\n');
    	Log::debug($reason);
    	
    	return $reason->name;
    }
}
