package tsp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    
    public static final String PATH_REPO = "src/tsp/resources";
    public static final String EXTENSIONS = ".tsp";

    public static List<String> getAllFileNames() {
        List<String> filesNames = new ArrayList<>();
        File[] files = finder(PATH_REPO);
        if(files != null) {         
            for (File file : files) {
                filesNames.add(file.getName());
            }
        } 
        return filesNames;
    }
    
    private static File[] finder( String dirName){
        File dir = new File(dirName);
        return dir.listFiles((File dir1, String filename) -> filename.endsWith(EXTENSIONS));
    }
    
    public static File getFileWithName(String name){
        File file = new File(PATH_REPO + "/" + name);
        return file;
    }
    
}
