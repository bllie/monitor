
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerKeyValue {
    private File file;
    List<Atributo> atributos;
    public ScannerKeyValue(File file) {
        this.file = file;
        atributos = new ArrayList<Atributo>();
        parser();
    }
    private void parser() {
        try {
            Scanner scanner = new Scanner(this.file);
            String key,value;String[] line;
            while (scanner.hasNext()) {
                line = scanner.nextLine().split(":");
                key = line[0].trim();
                value = line[1].trim();
                atributos.add(new Atributo(key, value));
            }
        } catch (FileNotFoundException ex) {
        }
    }
    
    public List<Atributo> getAtributos() {
        return atributos;
    }

    public String getAtributo(String name) {
        for (Atributo atributo : atributos) {
            if(name.equals(atributo.getKey())) {
                return atributo.getValue();
            }
        }
        return null;
    }
}
