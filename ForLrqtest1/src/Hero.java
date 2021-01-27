import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Hero  extends Fly {
	

public Hero()
{
	//img=App.getImg("/img/Ó¢ÐÛ»ú.png");

	img=App.getImg("/img/Ó¢ÐÛ»ú.png");
	x=200;
	y=600;
	w=img.getWidth();
	h=img.getHeight();
}
public void mouseMoved(int mx,int my) {
	// TODO Auto-generated method stub	 
	x=mx;
	y=my;
}
 
}
