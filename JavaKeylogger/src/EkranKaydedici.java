import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;


public class EkranKaydedici {
	
	int ss = 0;
	
	public void ScreenShot() throws Exception
	{
	    Robot robot = new Robot();
	    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    ImageIO.write(screenShot, "JPG", new File("d:\\Sounds\\"+(ss)+".jpg"));
	    System.out.println(ss+".jpg");
	    ss++;
	}
}
