import java.util.Locale;
import java.util.ResourceBundle;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class HelloCV {
    public static void main(String[] args){
        System.out.println("Локаль по замовчанню: " + Locale.getDefault());
        Locale.setDefault(new Locale("uk", "UA"));
        System.out.println("Локаль по замовчанню: " + Locale.getDefault());
        ResourceBundle resBundle =
                ResourceBundle.getBundle("resources/ResourceBundle", Locale.getDefault());
        System.out.printf(resBundle.getString("start_camera"));
        
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        // System.out.println("mat = " + mat.dump());
    }
}
