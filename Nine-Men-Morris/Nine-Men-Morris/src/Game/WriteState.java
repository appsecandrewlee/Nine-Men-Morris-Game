package Game;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class WriteState {

    private String path;
    //../project/Project_playerClass_design/src/game
    private boolean append_to_file = false;

    public WriteState(String textFile){
        path = textFile;
    }

    public WriteState(String filepath, boolean append_value){
        path = filepath;
        append_to_file = append_value;
    }
    public void Writing(String textState) throws IOException{
        FileWriter Write = new FileWriter(path, append_to_file);
        PrintWriter printWrite = new PrintWriter(Write);

        printWrite.printf("%s" + "%n", textState);
        printWrite.close();
    }
}
