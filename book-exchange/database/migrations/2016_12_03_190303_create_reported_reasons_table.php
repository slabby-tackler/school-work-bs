<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateReportedReasonsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('reported_reasons', function (Blueprint $table) {
        	$table->increments('id');
        	$table->string('name');
		$table->timestamps();
        	$table->softDeletes();
        });
	DB::table('reported_reasons')->insert(array(
		array('name' => 'Other'),
		array('name' => 'Inappropriate content'),
		array('name' => 'Not a real offer'),
		array('name' => 'Not a real book')
	));
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::drop('reported_reasons');
    }
}
