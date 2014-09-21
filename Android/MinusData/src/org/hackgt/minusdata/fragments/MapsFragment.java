package org.hackgt.minusdata.fragments;

import org.hackgt.minusdata.MainActivity;
import org.hackgt.minusdata.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MapsFragment extends Fragment implements OnItemSelectedListener{

	public MapsFragment(){}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.maps_fragment, container, false);
          
        Bundle bundle = getActivity().getIntent().getExtras();
        
        Spinner spinner = (Spinner) rootView.findViewById(R.id.dtype_spinner);
     // Create an ArrayAdapter using the string array and a default spinner layout
     ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
             R.array.directions_arr, android.R.layout.simple_spinner_item);
     // Specify the layout to use when the list of choices appears
     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     // Apply the adapter to the spinner
     spinner.setAdapter(adapter);
     MainActivity activity = (MainActivity)getActivity();
     
        if(bundle!=null && bundle.getBoolean("STARTED_BY_RECEIVER")==true ){//&& activity.getTypeOfRequest().equals("Search")){
        	
        	
//        	Log.d("MAPSSEARCH", bundle.getString("MSG_BODY"));
        	
        	String directionString = bundle.getString("MSG_BODY");
        	String[] directions = directionString.split("\n");
        	
        	ListView listView = (ListView) rootView.findViewById(R.id.list);
        	ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, directions);
        	
        	 // Assign adapter to ListView
            listView.setAdapter(listAdapter); 
          
//        	TextView replyBody = (TextView) getView().findViewById(R.id.edit_message);
//        	replyBody.setText(bundle.getString("MSG_BODY"));
        	
        }
        
        return rootView;
    }
    
	
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        	//parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
