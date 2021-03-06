package com.vladwelt.monitor;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Monito extends ListActivity {

	ArrayList<HashMap<String,String>> Eventos;
	Monitor mon;
	String[] from=new String[] {"id_proc","Nombre","Desc"};
	int[] to=new int[]{R.id.id_proc,R.id.nombre,R.id.desc1};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);
		mon = new Monitor();
		mon.explorar();
		cargarElementos();
	}
	
	public void cargarElementos(){
		Eventos = new ArrayList<HashMap<String, String>>();
		DirectoryProccess proceso;
	    for(int i=0;i<mon.size();i++){
	        HashMap<String,String> datosProceso=new HashMap<String, String>();
	        proceso = mon.get(i);
	      
	        datosProceso.put("id_proc", proceso.proccesId().toString());
	        datosProceso.put("Nombre", proceso.nameProccess().toString());
	        datosProceso.put("Desc", proceso.useMemory());
	        datosProceso.put("id", String.valueOf(i+1));
	 
	        Eventos.add(datosProceso);
	    }
	    SimpleAdapter ListadoAdapter=new SimpleAdapter(this, Eventos, R.layout.row, from, to);
	    setListAdapter(ListadoAdapter);
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Bundle b = new Bundle();
        b.putString("id",Eventos.get(position).get("id_proc") );
        b.putString("Nombre",Eventos.get(position).get("Nombre") );
        Intent intent = new Intent(this,DetalleProceso.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}
