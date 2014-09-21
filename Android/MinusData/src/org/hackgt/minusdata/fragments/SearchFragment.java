package org.hackgt.minusdata.fragments;

import org.hackgt.minusdata.MainActivity;
import org.hackgt.minusdata.R;
import org.hackgt.minusdata.constants.Constants;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchFragment extends Fragment {

	public SearchFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
          
        Bundle bundle = getActivity().getIntent().getExtras();
        
        
   		
        if(bundle!=null && bundle.getBoolean("STARTED_BY_RECEIVER")==true) //) && bundle.getString("type").equals("Search")){
        {
        	TextView replyBody = (TextView) rootView.findViewById(R.id.edit_message);
        	replyBody.setText(bundle.getString("MSG_BODY"));
        	
        }
        
        return rootView;
    }
    
  
    
   
    
}
