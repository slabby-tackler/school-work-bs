<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateOffersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('offers', function (Blueprint $table) {
        	$table->increments('id');
        	$table->integer('users_id');
        	$table->integer('books_id');
        	$table->integer('offer_types_id');
			//$table->integer('quality');
        	$table->decimal('price', 10, 2)->nullable();
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
        Schema::drop('offers');
    }
}
