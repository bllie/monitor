package com.vladwelt.monitor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class Monitor extends Activity {
	
	public static final String TIME_IN_STATE_PATH =
	        "/proc/25833/status";
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView= new TextView(this);
		//textView.setText("Toca y arrastra (Un dedo solamente!!!)");
		leerFicheroMemoriaInterna();
		setContentView(textView);
		
	}
	
	private void leerFicheroMemoriaInterna()
	{
	    InputStreamReader ir=null;
	    BufferedReader br=null;
	    InputStream is=null;
	    
	    try
	    {
	        is = new FileInputStream(TIME_IN_STATE_PATH);
            ir = new InputStreamReader(is);
            br = new BufferedReader(ir);
	        String texto = br.readLine();
	        while(texto!=null)
	        {
	            textView.append(texto);
	            texto=br.readLine();
	        }
	    }
	    catch (Exception ex)
	    {
	        Log.e("ivan", "error"+ex);
	    }
	    finally
	    {
	        try {
	                if(ir!=null)
	                    ir.close();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
