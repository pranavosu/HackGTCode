package org.hackgt.minusdata.fragments;

import org.hackgt.minusdata.MainActivity;
import org.hackgt.minusdata.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchFragment extends Fragment {

	public SearchFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
          
        Bundle bundle = getActivity().getIntent().getExtras();
        
        MainActivity activity = (MainActivity) getActivity();
   		
        if(bundle!=null && bundle.getBoolean("STARTED_BY_RECEIVER")==true){    
        	TextView replyBody = (TextView) rootView.findViewById(R.id.edit_message);
        	replyBody.setOverScrollMode(TextView.OVER_SCROLL_IF_CONTENT_SCROLLS);
        	replyBody.setText(bundle.getString("MSG_BODY"));
        	
        }
        
        return rootView;
    }
    
  
    
    }
    

