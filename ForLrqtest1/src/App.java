import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//ͼƬ������
public class App {

	
	public static BufferedImage getImg(String path)
{
	try {
		BufferedImage img=ImageIO.read(App.class.getResource(path));
	 return img;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}



}
