<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateQualitiesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('qualities', function (Blueprint $table) {
        	$table->increments('id');         	
		$table->string('name');       	
        	$table->timestamps();
        	$table->softDeletes();	 	    
        });

  	DB::table('qualities')->insert(array(
		array('name' => 'New'),
		array('name' => 'Lightly Used'),
		array('name' => 'Moderately Used'),
		array('name' => 'Heavily Used')
	));
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
     public function down()
     {
	 Schema::drop ('qualities');
     }
}
