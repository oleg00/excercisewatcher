package Util.Logging;

import Util.IO.FileUtil;

/**
 * Implementation of the File Logging.
 */
public class FileLogger implements ILogger {

    @Override
    public void Log(String msg) {
        FileUtil.WriteToFile(FileLoggerSettings.LogPath, msg, FileLoggerSettings.IsAppendMode);        
    }

}
