package Tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import MAIN.GameFrame;

public class tile_manager {
	
	GameFrame graph;
	Tiles[] TILES;
	
	public tile_manager(GameFrame graph) {
		
		this.graph = graph;
		
		TILES = new Tiles[10]; // this means we are gonna create 10 different kind of tiles
		
		getTileImage();
	}
	
	public void getTileImage() {
		
		try {
			
			TILES[0] = new Tiles();
			TILES[0].IMAGE = ImageIO.read(getClass().getResourceAsStream("/Grass_Block01.png"));
			
			TILES[1] = new Tiles();
			TILES[1].IMAGE = ImageIO.read(getClass().getResourceAsStream("/Wall_01.png")); // this puts the image into a buffer image
			
			TILES[2] = new Tiles();
			TILES[2].IMAGE = ImageIO.read(getClass().getResourceAsStream("/Water_01.png"));
			
		
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void draw(Graphics2D g2) {
		
	g2.drawImage(TILES[0].IMAGE, 0, 0, graph.tileSize, graph.tileSize, null);	
		
	}

}
