
public class Fire extends Fly {
 
String path="/img/z.png";
	public Fire(int hx,int hy)
{
   img=App.getImg(path);
	w=img.getWidth();
	h=img.getHeight();
	x=hx;
	y=hy;
	System.out.println(path); 
		
	 
}
	public Fire()
	{
		
		 
	}

public void move() {
	// TODO Auto-generated method stub
	y-=10;
}
public void angre( ) {
	// TODO Auto-generated method stub
	String pa="/img/z.png";
	path=pa; 
	 
}
public void happy( ) {
	// TODO Auto-generated method stub
	String pa="/img/zd.png";
	path=pa;
}
}
