import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ep extends Fly {
	BufferedImage img;
	int x,y,w,h;
 int sp;
	public Ep()
	{ 
		Random r=new Random();
		int index=r.nextInt(3)+1;
		img=App.getImg("/img/a"+index+".png");
		w=img.getWidth();
		h=img.getHeight();
	  x=r.nextInt(512-w);
	  y=-h;
	 sp=index;
	  
	}

	public void move() {
		// TODO Auto-generated method stub
		y+=sp;
	}

	public boolean shootBy(Fire f) {
		// TODO Auto-generated method stub
		boolean hit=x<=f.x+f.w&&
				   x>=f.x-w&&
		           y<=f.y+f.h&&
		           y>=f.y-h;
		return hit;
	}


	
	 
}
