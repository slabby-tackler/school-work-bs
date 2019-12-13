<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class MessageReply extends Model
{
    use SoftDeletes;
	
	protected $dates = ['deleted_at'];
	
	public function message () {
		return $this->hasOne('App\Message', 'id', 'child_id');
	}
    public function message_parent () {
		return $this->hasOne('App\Message', 'id', 'parent_id');
	}
}
