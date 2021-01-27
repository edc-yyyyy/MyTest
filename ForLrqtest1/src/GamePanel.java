import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	BufferedImage bg;
	JButton btn1,btn2;

	Fire f=new Fire();
	Hero h=new Hero();
	Ep e=new Ep();
	ArrayList <Ep>list=new ArrayList<Ep>();
	ArrayList <Fire>flist=new ArrayList<Fire>();
	 public void action() {
		 new Thread() {
		public void run()
		{
			while(true)
			{
				epEnter();
				epMove();
				shoot();
				fmove();
				shootep();
				try {
					Thread.sleep(50);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				repaint();
			}
		}	
		 }.start();
	 }
	 private void fmove() {
			// TODO Auto-generated method stub
			for(int i=0;i<flist.size();i++)
			{
				Fire f=flist.get(i);
				f.move();
			}
		}

	int finde=0;
	 
	public void shoot() {
			// TODO Auto-generated method stub
		finde++;
		if(finde>=10) {
		Fire f1=new Fire(h.x+15,h.y);
			flist.add(f1);
		finde=0;
		}
		
		}
int index=0;
protected void epEnter() {
		// TODO Auto-generated method stub
	index++;
	if(index>=10) {
	Ep e=new Ep();
	 list.add(e);
	index=0;
	}
	}

protected void epMove() {
	// TODO Auto-generated method stub
for(int i=0;i<list.size();i++)
{
	Ep e=list.get(i);
	e.move();
}
 
}
public GamePanel(GameFrame f)
{
btn1=new JButton("生气的小罗");
btn2=new JButton("开心的小罗");	
 this.setBackground(Color.pink);
// this.add(btn1);
 //this.add(btn2);
 btn1.addActionListener(this);
 btn2.addActionListener(this);
 

		 bg=App.getImg("/img/背景.jpg");   
MouseAdapter adapeter=new MouseAdapter() {
	   @Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		 
		int mx=e.getX();
		int my=e.getY();
		h.mouseMoved(mx, my);
		repaint();
	}
	  
 };
 addMouseListener(adapeter);
 addMouseMotionListener(adapeter);
}
public void actionPerformed(ActionEvent arg0)
{
	 
  JButton t=(JButton)arg0.getSource();
  if(t==btn1)
  {
	  f.angre();
	  finde++;
		if(finde>=10) {
		Fire f1=new Fire(h.x+15,h.y);
			flist.add(f1);
		finde=0;
		}
	 
 
  }
  if(t==btn2)
  {
	  f.happy();
	  finde++;
		if(finde>=10) {
		Fire f1=new Fire(h.x+15,h.y);
			flist.add(f1);
		finde=0;
		}
		 
  }
  
}
public void shootep()
{
	for(int i=0;i<flist.size();i++)
	{
		Fire f=flist.get(i);
		bang(f);
	}
}
private void bang(Fire f) {
	// TODO Auto-generated method stub
	for(int i=0;i<list.size();i++)
	{
		Ep e=list.get(i);
		if(e.shootBy(f))
		{
			list.remove(e);
			flist.remove(f);
		}
	}
}
@Override
public void paint(Graphics g) {
	// TODO Auto-generated method stub
	super.paint(g);
	 
	g.drawImage(bg, 0, 0,512,768,null);
    g.drawImage(h.img, h.x, h.y,h.w,h.h,null);
   for(int i=0;i<list.size();i++)
   {
	 Ep e=list.get(i);
    g.drawImage(e.img, e.x, e.y,e.w,e.h,null);

   }
   for(int i=0;i<flist.size();i++)
   {
	Fire f=flist.get(i);
    g.drawImage(f.img, f.x, f.y,f.w,f.h,null);

   }
   

}



}
