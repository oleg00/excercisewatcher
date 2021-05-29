package controllers;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;

import openCVutils.*;
import resources.Localization;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ImageView currentFrame;

    @FXML
    private Button cameraToggle;

    private VideoCapture capture = new VideoCapture();
	private ScheduledExecutorService timer;
    private boolean cameraActive = false;
    private static int cameraId = 0;
	private VideoWriter videoWriter;

	private ResourceBundle resBundle = ResourceBundle.getBundle("resources/ResourceBundle", Localization.currentLocale);

	void updateLocale() {
		this.resBundle = ResourceBundle.getBundle("resources/ResourceBundle", Localization.currentLocale);
		cameraToggle.setText(this.cameraActive ? resBundle.getString("stop_camera") : resBundle.getString("start_camera"));
	}

    @FXML
    void initialize() {
		updateLocale();
    }

    @FXML
    void onStartCamera(ActionEvent event) {
        if (!this.cameraActive)
        {
            // start the video capture
            this.capture.open(cameraId);
            
            // is the video stream available?
            if (this.capture.isOpened())
            {
                this.cameraActive = true;
                
                // grab a frame every 33 ms (30 frames/sec)
                Runnable frameGrabber = () -> {
                    // effectively grab and process a single frame
                    Mat frame = grabFrame();
                    // convert and show the frame
                    Image imageToShow = Utils.mat2Image(frame);
                    updateImageView(currentFrame, imageToShow);
                };
                
                this.timer = Executors.newSingleThreadScheduledExecutor();
                this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
                
                // update the button content
                this.cameraToggle.setText(resBundle.getString("stop_camera"));
            }
            else
            {
                // log the error
                System.err.println("Impossible to open the camera connection...");
            }
        }
        else
        {
            // the camera is not active at this point
            this.cameraActive = false;
            // update again the button content
			this.cameraToggle.setText(resBundle.getString("start_camera"));
            
            // stop the timer
            this.stopAcquisition();
        }
    }

    /**
	 * Get a frame from the opened video stream (if any)
	 *
	 * @return the {@link Mat} to show
	 */
	private Mat grabFrame()
	{
		// init everything
		Mat frame = new Mat();
		
		// check if the capture is open
		if (this.capture.isOpened())
		{
			try
			{
				// read the current frame
				this.capture.read(frame);
				
				if (Objects.isNull(videoWriter)) createVideoWriter(frame);
				videoWriter.write(frame);

				// // if the frame is not empty, process it
				if (!frame.empty())
				{
                    // TODO: BL
					// Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
				}
				
			}
			catch (Exception e)
			{
				// log the error
				System.err.println("Exception during the image elaboration: " + e);
			}
		}
		
		return frame;
	}

	private void createVideoWriter(Mat frame) {
		String filename = "videos/" + (new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")).format(new Date()) + ".avi";
		
        int fourcc = VideoWriter.fourcc('h','2','6','4');
        videoWriter = new VideoWriter(filename, fourcc, 25, frame.size(), true);
	}
	
	/**
	 * Stop the acquisition from the camera and release all the resources
	 */
	private void stopAcquisition()
	{
		if (this.timer!=null && !this.timer.isShutdown())
		{
			try
			{
				// stop the timer
				this.timer.shutdown();
				this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
			}
			catch (InterruptedException e)
			{
				// log any exception
				System.err.println("Exception in stopping the frame capture, trying to release the camera now... " + e);
			}
		}
		
		if (this.capture.isOpened())
		{
			// release the camera
			this.capture.release();

			updateImageView(currentFrame, null);
		}

		if (videoWriter.isOpened()) videoWriter.release();
	}
	
	/**
	 * Update the {@link ImageView} in the JavaFX main thread
	 * 
	 * @param view
	 *            the {@link ImageView} to update
	 * @param image
	 *            the {@link Image} to show
	 */
	private void updateImageView(ImageView view, Image image)
	{
		Utils.onFXThread(view.imageProperty(), image);
	}
	
	/**
	 * On application close, stop the acquisition from the camera
	 */
	protected void setClosed()
	{
		this.stopAcquisition();
	}
}
