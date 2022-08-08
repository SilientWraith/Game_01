package MAIN;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ENTITY.main_Player;
import Tile.tile_manager;

public class GameFrame extends JPanel implements Runnable{
	
	// SCREEN SETTINGS	
	
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48x48 tile 
	final int maxScreenColumn = 24;
	final int maxScreenRow = 18;
	final int screenWidth = tileSize * maxScreenColumn; // 1152 pixels
	final int screenHeight = tileSize * maxScreenRow; // 864 pixels
	
	// FPS
	int FPS = 60;
	
	tile_manager TILE_MANAGER = new tile_manager(this);
	KeyLogger keyJ = new KeyLogger();
	Thread GameThread;   // a thread is something that you can start and stop keeps your program running until you stop it
	main_Player MAIN_PLAYER = new main_Player(this,keyJ);
	
	// set players default position
	
	
	
	
	public GameFrame() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyJ);
		this.setFocusable(true); // this makes the gamepanel to focus on received key input
	}

	public void startGameThread() {
			GameThread = new Thread(this);
			GameThread.start(); // gonna automatically call the run method
	}

	@Override
	public void run() { // creates a game loop
		
		double drawInterval = 1000000000/FPS; // 0.01666 seconds per frame
		double nextDrawTime = System.nanoTime() + drawInterval; // time when screen will get updated
		
		while(GameThread != null) {
			
			//long current_Time = System.nanoTime(); // returns the current value of the running time in nanoseconds
			//System.out.println("current time: ",current_Time);
			
			//System.out.println("The game loop is currently running");
			
			// 1 UPDATE: update information such as character position  these are things the game loops does
			UPDATE();
			// 2 DRAW: draw the screen with the updated information these are things the game loops does
			repaint();
			
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000; // this is to convert it to miliseconds since "sleep" only accepts that
				
				if(remainingTime < 0) { // this isn't really needed for a little 2D game
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime); // sleep pauses the game loop
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		
	}

	public void UPDATE() {
		
		MAIN_PLAYER.UPDATE();
		
	}	
	public void paintComponent(Graphics g) { // this is 2 DRAW: draws the updated information 
		
		super.paintComponent(g); // super means parent class of JPanel 
		
		Graphics2D g2 = (Graphics2D)g;
		
		TILE_MANAGER.draw(g2);
		
		MAIN_PLAYER.draw(g2);
		
		
		g2.dispose(); // saves memory
		
	}
	

}
