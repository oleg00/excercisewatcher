package Util.IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File IO Util Class to work with files. Contains Write method
 */
public class FileUtil {
    
  /**
   * Static Write To File Method using FileWriter
   * @param filePath - absolute/local path to File
   * @param msg - string text to write
   * @param isAppendMode - append mode
   */
    public static void WriteToFile(String filePath, String msg, boolean isAppendMode) {
        try (var fileWriter = new FileWriter(filePath, isAppendMode)) {
            fileWriter.write(msg);
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

}
