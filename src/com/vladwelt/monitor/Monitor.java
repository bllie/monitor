package com.vladwelt.monitor;

import java.io.File;
import java.util.ArrayList;

public class Monitor {
	
	public static final String direccion = "/proc" ;
	File archivo;
	ArrayList<DirectoryProccess> Dp;
	
	public Monitor() {
		archivo = new File(direccion);
		Dp = new ArrayList<DirectoryProccess>();
	}
	
	public void explorar(){
		File[] files = archivo.listFiles();
		for (int i = 0; i < files.length; i++){
        	File file = files[i];
        	if (file.isDirectory()){
        		if(file.getName().matches("^[0-9]+")){
        			Dp.add(new DirectoryProccess(file.getAbsolutePath()));
        		}
        	}
        }
	}
	
	public DirectoryProccess get(int i){
		return Dp.get(i);
	}
	public int size(){
		return Dp.size();
	}
}
