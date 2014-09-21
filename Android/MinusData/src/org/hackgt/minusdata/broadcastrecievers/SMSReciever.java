package org.hackgt.minusdata.broadcastrecievers;

import org.hackgt.minusdata.MainActivity;
import org.hackgt.minusdata.constants.Constants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from = null;
            
            
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    
                    String messagePayload = "";
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        Log.d("FROM",msg_from);
                        
                        String msgBody = msgs[i].getMessageBody();
                        Log.d("BODY",msgBody);
                        
                        if(msgBody!=null)
                        	messagePayload += msgBody;
                    }
                    
                    
                    if(msg_from.equals(Constants.mobileNo)){
                    
	                    Intent i = new Intent();
	                    i.setClassName("org.hackgt.minusdata", "org.hackgt.minusdata.MainActivity");
	                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                    i.putExtra("MSG_BODY", messagePayload);
	                    i.putExtra("STARTED_BY_RECEIVER", true);
	                    context.startActivity(i);
                	
                    }
                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
	}

}
