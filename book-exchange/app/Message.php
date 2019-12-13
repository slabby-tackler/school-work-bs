<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Message extends Model
{
    use SoftDeletes;
	
	protected $dates = ['deleted_at'];

	public function message_reply () {
		return $this->hasMany('App\MessageReply', 'parent_id','id');
	}
		public function user(){
        return $this->hasOne('App\User', 'id', 'from_users_id');
    }
	
	public function message_reply_has_parent () {
		return $this->hasOne('App\MessageReply', 'child_id','id');
	}
    

}
