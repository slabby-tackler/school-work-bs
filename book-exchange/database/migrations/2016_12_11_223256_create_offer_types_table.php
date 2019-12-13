<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateOfferTypesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('offer_types', function (Blueprint $table) {
        	$table->increments('id');        	
		$table->string('name');
        	$table->timestamps();
        	$table->softDeletes();	    
        });

  	DB::table('offer_types')->insert(array(
		array('name' => 'Sell'),
		array('name' => 'Trade'),
		array('name' => 'Buy')
  	));

    }
	
    /**
     * Reverse the migrations.
     *
     * @return void
     */
     public function down()
     {
	 Schema::drop ('offer_types');
     }
}
