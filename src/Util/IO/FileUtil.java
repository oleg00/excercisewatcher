package Util.IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    
    public static void WriteToFile(String filePath, String msg, boolean isAppendMode) {
        try (var fileWriter = new FileWriter(filePath, isAppendMode)) {
            fileWriter.write(msg);
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

}
