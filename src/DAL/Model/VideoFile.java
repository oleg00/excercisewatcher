package DAL.Model;

import Util.Exception.FileException;
import Util.Exception.LoggingException;

public class VideoFile {
   
    private int _id;
    private int _size;
    private VideoFileFormatType _formatType;
    private int _duration;
    private String _fileUri;

    public int GetId() {
        return _id;
    }

    public void SetId(int value) {
        _id = value;
    }

    public int GetSize() {
        return _size;
    }

    public void SetSize(int size) throws LoggingException {
        if (size < 0)
            throw new FileException("VideoFile.SetSize(int size): size < 0");

        _size = size;
    }

    public VideoFileFormatType GetFormatType() {
        return _formatType;
    }

    public void SetFormatType(VideoFileFormatType formatType) {
        _formatType = formatType;
    }

    public int GetDuration() {
        return _duration;
    }

    public void SetDuration(int duration) throws LoggingException {
        if (duration < 0)
            throw new FileException("VideoFile.SetSize(int size): size < 0");

        _duration = duration;
    }

    public String GetFileUri() {
        return _fileUri;
    }

    public void SetFileUri(String value) {
        _fileUri = value;
    }

}

