package com.vladwelt.monitor;

import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class DetalleProceso extends Activity {
	
	public static final String direccion = "/proc/" ;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView= new TextView(this);
		setContentView(textView);
		DirectoryProccess proceso;
		Intent intent = this.getIntent();
		if (intent != null){
			Bundle b = intent.getExtras();
			String datos = b.getString("id");
			proceso = new DirectoryProccess(direccion+datos);
			textView.setText(proceso.proccesId());
			List<Atributo> atributos = proceso.getAtributos();
			for (Atributo atributo : atributos) {
				textView.append("\n");
				textView.append(atributo.getKey() + " : " + atributo.getValue());
			}
			//textView.append("\n"+proceso.nameProccess());
			//textView.append("\n"+proceso.useMemory());
			
		}
		else{
			Log.d("Tag", "La actividad no se ha llamado mediante un intent.");
		}
	}
}
