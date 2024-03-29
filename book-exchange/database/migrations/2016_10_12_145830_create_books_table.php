<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateBooksTable extends Migration
{
	/**
	* Run the migrations.
	*
	* @return void
	*/
	public function up()
	{
		Schema::create ('books', function (Blueprint $table) {
			$table->increments ('id');
			$table->string ('title');
			$table->string ('isbn');
			$table->string ('version');
			$table->string ('author');
			$table->timestamps();
			$table->softDeletes();
		}); 
	}

	/**
	* Reverse the migrations.
	*
	* @return void
	*/
	public function down()
	{
		Schema::drop ('books');
	}
}
