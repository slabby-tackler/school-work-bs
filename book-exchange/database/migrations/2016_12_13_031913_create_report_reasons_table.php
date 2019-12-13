<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateReportReasonsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('report_reasons', function (Blueprint $table) {
        	$table->increments('id');        	
		$table->string('name');
        	$table->timestamps();
        	$table->softDeletes();	    
        });

  	DB::table('report_reasons')->insert(array(
		array('name' => 'Offensive Language'),
		array('name' => 'Missleading'),
		array('name' => 'Fake offer')
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
