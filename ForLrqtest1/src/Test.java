
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
GameFrame f= new GameFrame();
GamePanel p= new GamePanel(f);
p.action();
 f.add(p); 
f.setVisible(true);
	}

}
