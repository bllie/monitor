package com.vladwelt.monitor;
 
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class Monito extends Activity {

	TextView textView;
	Monitor mon;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView= new TextView(this);
		setContentView(textView);
		mon = new Monitor();
		mon.explorar();
		leerFicheroMemoriaInterna();
		
	}
	
	private void leerFicheroMemoriaInterna(){
		DirectoryProccess proceso;
		for(int i=0;i<mon.size();i++){
			proceso = mon.get(i);
			try{
			textView.append(proceso.proccesId()+"  "+proceso.nameProccess()+"  "+proceso.useMemory()+"\n");
			}catch(Exception ex){
				
			}
		}
	}
	
}
