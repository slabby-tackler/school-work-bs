<?php

namespace App\Http\Controllers;

use App\Http\Requests;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Message;
use App\MessageReply;
use App\User;

class MessageController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $id = Auth::user()->id; 
        $messages = Message::where('to_users_id',$id)
                    ->orderBy('messages.created_at', 'desc')
                    ->get();
        
        $arr = array();
        
        foreach($messages as $message){
            if(!empty($message->message_reply_has_parent)){
                if(!in_array($message->message_reply_has_parent->parent_id, $arr))
                    array_push($arr, $message->message_reply_has_parent->parent_id);
            } else 
                array_push($arr, $message->id);
        }
        
        $new_messages = Message::whereIn('id', $arr)
            ->orderBy('messages.updated_at', 'desc')
            ->get();
        
        $data['messages'] = $new_messages;
        
        return view ('message/messages', $data);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public static function store(Request $request)
    {   
        $message = new Message ();
        $message->from_users_id = Auth::user()->id;
        $message->to_users_id = $request->get('user-id');
        $message->message = $request->get('message');
        $message->offer_id = $request->get('offer-id');
        $message->is_read = 0;
        $message->save();
        
		
		if(!empty($request->get('parent_msg'))){
			$child_id = $message->id;
        	$reply = MessageReplyController::store ($request, $child_id);
            Message::find($request->get('parent_msg'))
                ->touch();
		}
        
        if(is_null($request->get('offer')))
            return redirect('/message');
        
        return redirect('/offer');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $message = Message::find($id);
        $from_user = User::find($message->from_users_id);
		//$message_replies = Message::where('parent_id', $message->id);
        
        Message::where('id', $id)-> update(array(
            'is_read' => 1
        ));
            
        //$data['message_replies']
        $data['message'] = $message;
        $data['from_user'] = $from_user;
        
        return view('message/message_show' , $data);
    }
    
    public function show_sent()
    {
        $id = Auth::user()->id; 
        $messages = Message::where('from_users_id',$id)
                    ->orderBy('messages.created_at', 'desc')
                    ->get();
        
        $data['messages'] = $messages;
        
        return view ('message/messages_sent', $data);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
