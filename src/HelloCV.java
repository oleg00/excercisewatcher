import java.util.Locale;
import java.util.ResourceBundle;

import org.opencv.core.*;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoWriter;


public class HelloCV {
    public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat frame = new Mat(480,640,CvType.CV_8UC3,Scalar.all(127)); 

        System.out.println(frame.size());

        int fourcc = VideoWriter.fourcc('m', 'p','4','v');
        VideoWriter writer = new VideoWriter("test3.mp4", fourcc, 20, frame.size(), true);
        if (!writer.isOpened()) {
            System.out.println("bummer!");
            return;
        }
        for (int i=0; i<100; i++) {
            Mat f = frame.clone();
            Imgproc.putText(f, ("frame" + i), new Point(100,100), Core.BORDER_CONSTANT, 2, new Scalar(200,0,0),3);
            writer.write(f);
        }
        writer.release();
    }
}
