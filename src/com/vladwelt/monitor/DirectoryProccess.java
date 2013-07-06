import java.io.File;
import java.util.List;

public class DirectoryProccess implements Proccess {

    private File file;
    private ScannerKeyValue scanner ;

    public DirectoryProccess(String name) {
        this.file = new File(name);
        scanner = new ScannerKeyValue(new File(this.file,"status"));
    }

    @Override
    public boolean isDirectoryProccess() {
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return false;
        }
        if (!file.getName().matches("([0-9])+")) {
            return false;
        }
        return true;
    }

    @Override
    public String nameProccess() {
        return scanner.getAtributo("Name");
    }

    @Override
    public String proccesId() {
        return scanner.getAtributo("Pid");
    }

    @Override
    public String useMemory() {
        ScannerStatm scanner = new ScannerStatm(this.file);
        return scanner.getValue(5);
    }
    @Override
    public List<Atributo> getAtributos() {
        List<Atributo> res = scanner.getAtributos();
        return res;
    }
}
