<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class ModifyUsersTableAddUserType extends Migration
{
	/**
	* Run the migrations.
	*
	* @return void
	*/
	public function up()
	{
		Schema::table('users', function(Blueprint $table) {
			$table->integer('user_types_id');
		});
		
		DB::table('users')->insert(array(
			'email' => 'admin@textbookswap.com',
			'username' => 'super_admin',
			'password' => bcrypt('superadminpassword'),
			'user_types_id' => 2,
			'active' => 1
		));
	}

	/**
	* Reverse the migrations.
	*
	* @return void
	*/
	public function down()
	{
		Schema::table('users', function(Blueprint $table) {
			$table->dropColumn('user_types_id');
		});
	}
}
