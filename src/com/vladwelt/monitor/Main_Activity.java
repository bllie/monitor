package com.vladwelt.monitor;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main_Activity extends ListActivity {

	String[] activitys={"Monito","CPU","MEMORIA" };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, 
        					android.R.layout.simple_list_item_1, activitys));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	String nombre= activitys[position];
    	try{
    		Class clazz= Class.forName("com.vladwelt.monitor." + nombre);
    		Intent intent= new Intent(this, clazz);
    		startActivity(intent);
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }
    
}
