package MAIN;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame screen = new JFrame();
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setSize(720,560);
		screen.setResizable(false);
		screen.setTitle("My First 2D Game");
	
		GameFrame gameFrame = new GameFrame();
		screen.add(gameFrame);
		
		screen.pack(); // causes this window to be sized to fit the "preferred size"
		
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
		
		gameFrame.startGameThread();
		
		
	}

}
