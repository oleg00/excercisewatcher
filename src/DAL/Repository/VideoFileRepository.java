package DAL.Repository;

import java.util.ArrayList;
import DAL.Model.VideoFile;
import DAL.Model.VideoFileFormatType;
import DAL.SQLClient.SQLClient;
import DAL.SQLClient.SQLClientSettings;
import Util.Exception.DbException;

/**
 * Implementing Repository<VideoFile>.
 */
public class VideoFileRepository implements IRepository<VideoFile> {

    private SQLClient _sqlClient;

    public VideoFileRepository() throws DbException {
        _sqlClient = new SQLClient(SQLClientSettings.DbPath);
    }

    @Override
    public ArrayList<VideoFile> GetAll() throws DbException {

        var videos = new ArrayList<VideoFile>();
        var rs = _sqlClient.ExecuteSelect(SQLClientSettings.SelectVideoFilesQuery);

        try {
            while (rs.next()) {
                var videoFile = new VideoFile(rs.getInt("size"), VideoFileFormatType.values()[rs.getInt("formatType")],
                        rs.getInt("duration"), rs.getString("fileURI"));
                videos.add(videoFile);
            }
        } catch (Exception e) {
        }

        return videos;
    }

    @Override
    public VideoFile Get(int id) throws DbException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean Add(VideoFile entity) throws DbException {
        return _sqlClient.InsertVideoFile(entity);
    }

    @Override
    public boolean Update(VideoFile entity) throws DbException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Delete(int id) throws DbException {
        // TODO Auto-generated method stub
        return false;
    }

}
