package com.vladwelt.monitor;
import java.util.List;

public interface Proccess {
    public boolean isDirectoryProccess();
    public String nameProccess();
    public String proccesId();
    public String useMemory();
    public List<Atributo> getAtributos();
}
