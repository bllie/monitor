import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Top {

    private final File fileDirectory;

    public Top(String pathDirectory) {
        this.fileDirectory = new File(pathDirectory);
    }

    public List<Proccess> loadProccess() {
        List<Proccess> result = new ArrayList<Proccess>();
        DirectoryProccess auxDirectory;
        if (!fileDirectory.exists()) {
            return result;
        }
        File[] files = fileDirectory.listFiles();
        for (File fileDir : files) {
            auxDirectory = new DirectoryProccess(fileDir.getPath());
            if (auxDirectory.isDirectoryProccess()) {
                result.add(auxDirectory);
            }
        }
        return result;
    }

    public String render() {
        StringBuilder res = new StringBuilder();
        res.append("PROC-PROCCESS\n");
        res.append(" PID    MEM COMMAND\n");
        List<Proccess> proccesses = loadProccess();
        for (Proccess proccess : proccesses) {
            res.append(String.format("%4s %6s %s%n", 
                    proccess.proccesId(),
                    proccess.useMemory(),
                    proccess.nameProccess()));
        }
        return res.toString();
    }
}
