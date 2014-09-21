package org.hackgt.minusdata.fragments;

import org.hackgt.minusdata.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StockFragment extends Fragment {
	public StockFragment(){}
	    
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	        View rootView = inflater.inflate(R.layout.stock_fragment, container, false);
	          
	        Bundle bundle = getActivity().getIntent().getExtras();
	        
	//        if(bundle!=null && bundle.getBoolean("STARTED_BY_RECEIVER")==true){
	//        	
	//        	TextView replyBody = (TextView) getView().findViewById(R.id.edit_message);
	//        	replyBody.setText(bundle.getString("MSG_BODY"));
	//        	
	//        }
	        
	        return rootView;
	    }
}
